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
import cn.sel.jutil.lang.JText;
import cn.sel.jutil.system.Environment;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Resource reader
 */
public class ResourceReader
{
    @Nullable
    public static String readAsString(String resourceName)
    {
        return readAsString(resourceName, null);
    }

    @Nullable
    public static String readAsString(String resourceName, String charsetName)
    {
        if(JText.isNullOrEmpty(charsetName) || !Charset.isSupported(charsetName))
        {
            charsetName = Charset.defaultCharset().name();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        try
        {
            URL resource = ResourceReader.class.getClassLoader().getResource(resourceName);
            InputStream inputStream;
            if(resource != null)
            {
                inputStream = resource.openStream();
                while((len = inputStream.read(buffer)) != -1)
                {
                    byteArrayOutputStream.write(buffer, 0, len);
                }
                return byteArrayOutputStream.toString(charsetName);
            }
        } catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    public static String[] readAsArray(String resourceName)
    {
        return readAsArray(resourceName, null, null);
    }

    @Nullable
    public static String[] readAsArray(String resourceName, String charsetName)
    {
        return readAsArray(resourceName, charsetName, null);
    }

    @Nullable
    public static String[] readAsArray(String resourceName, String charsetName, String lineSeparator)
    {
        if(JText.isNullOrEmpty(charsetName) || !Charset.isSupported(charsetName))
        {
            charsetName = Charset.defaultCharset().name();
        }
        if(JText.isNullOrEmpty(lineSeparator))
        {
            lineSeparator = Environment.getLineSeparator();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        try
        {
            URL resource = ResourceReader.class.getClassLoader().getResource(resourceName);
            InputStream inputStream;
            if(resource != null)
            {
                inputStream = resource.openStream();
                while((len = inputStream.read(buffer)) != -1)
                {
                    byteArrayOutputStream.write(buffer, 0, len);
                }
                String full = byteArrayOutputStream.toString(charsetName);
                return full.split(lineSeparator);
            }
        } catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}