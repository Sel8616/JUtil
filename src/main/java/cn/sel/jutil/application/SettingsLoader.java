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

import cn.sel.jutil.annotation.note.NonNull;
import cn.sel.jutil.lang.JText;

import java.io.InputStream;
import java.util.Properties;

/**
 * Load settings using {@link Properties}.
 */
public abstract class SettingsLoader
{
    /**
     * Read custom application settings.
     *
     * @param properties A nonnull nonempty {@link Properties} object.
     */
    public abstract void read(@NonNull Properties properties);

    /**
     * Check if everything is ok.
     *
     * @return true=OK/false=The {@link Properties} object is not correct.
     */
    public abstract boolean check();

    public void load(@NonNull String filename)
    {
        load(SettingsLoader.class.getClassLoader(), filename);
    }

    public void load(@NonNull Class clazz, @NonNull String filename)
    {
        if(clazz == null)
        {
            throw new IllegalArgumentException("The parameter 'clazz' must not be null!");
        }
        load(clazz.getClassLoader(), filename);
    }

    public void load(@NonNull ClassLoader classLoader, @NonNull String filename)
    {
        if(classLoader == null)
        {
            throw new IllegalArgumentException("The parameter 'classLoader' must not be null!");
        }
        if(JText.isNullOrEmpty(filename))
        {
            throw new IllegalArgumentException("The parameter 'filename' must not be null or empty!");
        }
        InputStream resourceStream = classLoader.getResourceAsStream(filename);
        if(resourceStream == null)
        {
            throw new IllegalStateException("The specified file is not found!");
        }
        Properties properties = new Properties();
        try
        {
            properties.load(resourceStream);
        } catch(Exception e)
        {
            e.printStackTrace();
            throw new IllegalStateException("Failed to open/read the specified file!");
        }
        if(properties.size() < 1)
        {
            throw new IllegalStateException("The specified file doesn't contain any property!");
        }
        read(properties);
        if(!check())
        {
            throw new IllegalStateException("The specified file contains some errors！");
        }
    }
}