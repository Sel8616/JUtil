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
package cn.sel.jutil.system;

public class Environment
{
    public static String getOSName()
    {
        return System.getProperty("os.name");
    }

    public static String getOSVersion()
    {
        return System.getProperty("os.version");
    }

    public static String getOSArchitecture()
    {
        return System.getProperty("os.arch");
    }

    public static int getJavaVersion()
    {
        String ver = System.getProperty("java.version");
        if(ver.contains("1.9"))
        {
            return 9;
        } else if(ver.contains("1.8"))
        {
            return 8;
        } else if(ver.contains("1.7"))
        {
            return 7;
        } else if(ver.contains("1.6"))
        {
            return 6;
        } else if(ver.contains("1.5"))
        {
            return 5;
        } else if(ver.contains("1.4"))
        {
            return 4;
        } else if(ver.contains("1.3"))
        {
            return 3;
        } else if(ver.contains("1.2"))
        {
            return 2;
        } else if(ver.contains("1.1"))
        {
            return 1;
        } else
        {
            return 0;
        }
    }

    public static String getJavaHome()
    {
        return System.getProperty("java.home");
    }

    public static String getJavaClassPath()
    {
        return System.getProperty("java.class.path");
    }

    public static String getUserName()
    {
        return System.getProperty("user.name");
    }

    public static String getUserHome()
    {
        return System.getProperty("user.home");
    }

    public static String getUserDir()
    {
        return System.getProperty("user.dir");
    }

    public static String getLineSeparator()
    {
        return System.getProperty("line.separator");
    }

    public static String getFileSeparator()
    {
        return System.getProperty("file.separator");
    }

    public static String getPathSeparator()
    {
        return System.getProperty("path.separator");
    }
}