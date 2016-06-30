/*
 * Copyright 2015-2016 Erlu Shang (sel8616@gmail.com/philshang@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.sel.jutil.application;

import cn.sel.jutil.annotation.note.Nullable;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Referenced: http://guoliangqi.iteye.com/blog/644876(yznxing)
 */
public class ClassScanner
{
    private static final String EXT_CLASS = ".class";
    private static final String PROTOCOL_FILE = "file";
    private static final String PROTOCOL_JAR = "jar";
    private static final ClassLoader CLASS_LOADER = Thread.currentThread().getContextClassLoader();

    public Set<Class<?>> getAnnotatedClasses(@Nullable String packageName, @Nullable Set<Class<?>> filter)
    {
        return getClasses(packageName, filter, 0);
    }

    public Set<Class<?>> getImplementationClasses(@Nullable String packageName, @Nullable Set<Class<?>> filter)
    {
        return getClasses(packageName, filter, 1);
    }

    public Set<Class<?>> getAllClasses(@Nullable String packageName, @Nullable Set<Class<?>> filter)
    {
        return getClasses(packageName, filter, 2);
    }

    /**
     * Find all classes in the specified package.
     *
     * @param packageName Package name.
     *
     * @return A set of all the classes.
     */
    private Set<Class<?>> getClasses(@Nullable String packageName, @Nullable Set<Class<?>> filter, int type)
    {
        if(packageName == null || packageName.isEmpty())
        {
            packageName = "";
        }
        Set<Class<?>> classes = new LinkedHashSet<>();
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs;
        try
        {
            dirs = CLASS_LOADER.getResources(packageDirName);
            while(dirs.hasMoreElements())
            {
                URL url = dirs.nextElement();
                String protocol = url.getProtocol();
                if(PROTOCOL_FILE.equals(protocol))
                {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    scanClassFiles(packageName, filePath, classes, filter, type);
                } else if(PROTOCOL_JAR.equals(protocol))
                {
                    scanJarFiles(packageName, packageDirName, classes, url, filter, type);
                }
            }
        } catch(IOException e)
        {
            e.printStackTrace();
        }
        return classes;
    }

    private void scanClassFiles(String packageName, String packageDirName, Set<Class<?>> classes, Set<Class<?>> filter, int type)
    {
        File dir = new File(packageDirName);
        if(!dir.exists() || !dir.isDirectory())
        {
            return;
        }
        File[] files_dir = dir.listFiles(file->file.isDirectory() || file.getName().endsWith(EXT_CLASS));
        for(File file : files_dir)
        {
            String fileName = file.getName();
            if(file.isDirectory())
            {
                scanClassFiles(packageName.isEmpty() ? fileName : packageName + '.' + fileName, file.getAbsolutePath(), classes, filter, type);
            } else
            {
                String className = fileName.substring(0, fileName.length() - 6);
                tryAddClass(packageName, classes, filter, type, className);
            }
        }
    }

    private void scanJarFiles(String packageName, String packageDirName, Set<Class<?>> classes, URL url, Set<Class<?>> filter, int type)
    {
        JarFile jar;
        try
        {
            jar = ((JarURLConnection)url.openConnection()).getJarFile();
            Enumeration<JarEntry> entries = jar.entries();
            while(entries.hasMoreElements())
            {
                JarEntry entry = entries.nextElement();
                String name = entry.getName();
                if(name.charAt(0) == '/')
                {
                    name = name.substring(1);
                }
                if(name.startsWith(packageDirName))
                {
                    int idx = name.lastIndexOf('/');
                    if(idx != -1)
                    {
                        packageName = name.substring(0, idx).replace('/', '.');
                    }
                    if(idx != -1 && name.endsWith(EXT_CLASS) && !entry.isDirectory())
                    {
                        String className = name.substring(packageName.length() + 1, name.length() - 6);
                        tryAddClass(packageName, classes, filter, type, className);
                    }
                }
            }
        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private void tryAddClass(String packageName, Set<Class<?>> classes, Set<Class<?>> filter, int type, String className)
    {
        try
        {
            Class<?> clazz_found = CLASS_LOADER.loadClass(packageName + '.' + className);
            boolean findingAll = type == 2 || filter == null || filter.isEmpty();
            if(findingAll)
            {
                classes.add(clazz_found);
            } else
            {
                for(Class<?> clazz : filter)
                {
                    boolean findingAnn = type == 0 && isAnnotated(clazz_found, clazz);
                    boolean findingImpl = type == 1 && isImplementation(clazz_found, clazz);
                    if(findingAnn || findingImpl)
                    {
                        classes.add(clazz_found);
                    }
                }
            }
        } catch(Exception | Error e)
        {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private boolean isAnnotated(Class<?> clazz, Class annotationClass)
    {
        return annotationClass.isAnnotation() && clazz.isAnnotationPresent(annotationClass);
    }

    private boolean isImplementation(Class<?> clazz, Class<?> superClass)
    {
        return superClass.isAssignableFrom(clazz);
    }
}