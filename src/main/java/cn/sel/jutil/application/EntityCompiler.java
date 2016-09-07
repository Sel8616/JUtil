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

import cn.sel.jutil.lang.JText;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/**
 * Compiler to create entity bean.
 */
public class EntityCompiler
{
    /**
     * Generate a javabean class from the specified info.
     *
     * @param packageName Package name.
     * @param className   Class name.
     * @param fields      Fields(name/type name). The qualified type name is required if the type does not belongs to package {@link java.lang}.
     *
     * @return Class object.(imports/getters/setters/toString)
     */
    public Class<?> compileBeanClass(String packageName, String className, Map<String, String> fields)
    {
        String fullClassName = packageName + '.' + className;
        try
        {
            URL resourceRoot = getClass().getClassLoader().getResource("");
            if(resourceRoot != null)
            {
                String path = resourceRoot.getPath();
                if(!JText.isNullOrEmpty(path))
                {
                    String fileDir = URLDecoder.decode(path, Charset.defaultCharset().name());
                    File file = new File(fileDir);
                    if(file.exists() || file.mkdirs())
                    {
                        String javaText = createSourceCode(packageName, className, fields);
                        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
                        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
                        JavaFileObject javaObject = new JavaStringObject(className, javaText);
                        Iterable<? extends JavaFileObject> source = Collections.singletonList(javaObject);
                        Iterable<String> options = Arrays.asList("-d", fileDir);
                        compiler.getTask(null, fileManager, null, options, null, source).call();
                        fileManager.close();
                        return Class.forName(fullClassName);
                    } else
                    {
                        throw new IOException(String.format("无法创建目录'%s'！", fileDir));
                    }
                }
            }
        } catch(Exception e)
        {
            throw new IllegalStateException(String.format("Failed to compile class '%s'", fullClassName), e);
        }
        return null;
    }

    /**
     * Generate java source code of the specified entity.
     *
     * @param packageName See {@link #compileBeanClass(String, String, Map)}
     * @param className   See {@link #compileBeanClass(String, String, Map)}
     * @param fields      See {@link #compileBeanClass(String, String, Map)}
     *
     * @return Java source code text.
     */
    public String createSourceCode(String packageName, String className, Map<String, String> fields)
    {
        StringBuilder mainBuilder = new StringBuilder();
        mainBuilder.append("package ").append(packageName).append(";\n\n");
        mainBuilder.append("public class ").append(className).append('{').append('\n');
        StringBuilder toStringBuilder = new StringBuilder();
        toStringBuilder.append("return \"").append(className).append("{\"+");
        Iterator<Map.Entry<String, String>> iterator = fields.entrySet().iterator();
        Map.Entry<String, String> fieldInfo;
        if(iterator.hasNext())
        {
            fieldInfo = iterator.next();
            put(mainBuilder, fieldInfo, toStringBuilder);
        }
        while(iterator.hasNext())
        {
            toStringBuilder.append("+','+");
            fieldInfo = iterator.next();
            put(mainBuilder, fieldInfo, toStringBuilder);
        }
        toStringBuilder.append("+'}';");
        mainBuilder.append('\t').append("@Override \n").append('\t').append("public String toString(){").append(toStringBuilder).append("}\n");
        mainBuilder.append('}');
        return mainBuilder.toString();
    }

    /**
     * Generate java source code of the specified field's setter.
     */
    public String createSetter(String fieldType, String fieldName)
    {
        return "public void set" + getPostfix(fieldType, fieldName) + '(' + fieldType + ' ' + fieldName + ')' + '{' + "this." + fieldName + '=' + fieldName + ';' + '}';
    }

    /**
     * Generate java source code of the specified field's getter.
     */
    public String createGetter(String fieldType, String fieldName)
    {
        if(fieldType.equalsIgnoreCase("boolean"))
        {
            return "public " + fieldType + ' ' + getPostfix(fieldType, fieldName) + "()" + '{' + "return this." + fieldName + ';' + '}';
        }
        return "public " + fieldType + " get" + getPostfix(fieldType, fieldName) + "()" + '{' + "return this." + fieldName + ';' + '}';
    }

    /**
     * Get the postfix for setter/getter names.
     */
    public String getPostfix(String fieldType, String fieldName)
    {
        if(fieldName.length() > 1)
        {
            if(!Character.isUpperCase(fieldName.charAt(1)))
            {
                fieldName = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
            }
            if(fieldType.equalsIgnoreCase("boolean") && !fieldName.substring(0, 2).equalsIgnoreCase("is"))
            {
                fieldName = "is" + fieldName;
            }
        }
        return fieldName;
    }

    private void put(StringBuilder stringBuilder, Map.Entry<String, String> fieldInfo, StringBuilder toStringBuilder)
    {
        String fieldName = fieldInfo.getKey();
        String fieldType = fieldInfo.getValue();
        String format = fieldType.equals("String") ? "\"%s='\"+%s+\'\\'\'" : "\"%s=\"+%s";
        toStringBuilder.append(String.format(format, fieldName, fieldName));
        //Field declaration
        stringBuilder.append('\t').append("private ").append(fieldType).append(' ').append(fieldName).append(";\n");
        //setter
        stringBuilder.append('\t').append(createSetter(fieldType, fieldName)).append('\n');
        //Getter
        stringBuilder.append('\t').append(createGetter(fieldType, fieldName)).append('\n');
    }

    private class JavaStringObject extends SimpleJavaFileObject
    {
        private String sourceCode;

        public JavaStringObject(String filename, String sourceCode)
        {
            super(URI.create(filename + ".java"), Kind.SOURCE);
            this.sourceCode = sourceCode;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors)
                throws IOException
        {
            return sourceCode;
        }
    }
}