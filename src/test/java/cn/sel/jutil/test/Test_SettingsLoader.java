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
package cn.sel.jutil.test;import cn.sel.jutil.annotation.note.NonNull;
import cn.sel.jutil.application.SettingsLoader;
import org.junit.Test;

import java.util.Properties;

public class Test_SettingsLoader
{
    @Test
    public void run()
    {
        SettingsLoader settingsLoader;
        //Load from ".properties"
        settingsLoader = new SettingsLoader()
        {
            String item1, item2;

            @Override
            public void read(@NonNull final Properties properties)
            {
                item1 = properties.getProperty("item1");
                item2 = properties.getProperty("item2");
            }

            @Override
            public boolean check()
            {
                System.out.println("item1=" + item1);
                System.out.println("item2=" + item2);
                return item1.equals("hello") && item2.equals("world");
            }
        };
        settingsLoader.load("settings.properties");
        System.out.println();
        settingsLoader.load(getClass(), "settings.properties");
        System.out.println();
        settingsLoader.load(Test_SettingsLoader.class, "settings.properties");
        System.out.println();
        settingsLoader.load(getClass().getClassLoader(), "settings.properties");
        System.out.println();
        settingsLoader.load(Test_SettingsLoader.class.getClassLoader(), "settings.properties");
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        //Load from ".txt"
        settingsLoader = new SettingsLoader()
        {
            String item1, item2;

            @Override
            public void read(@NonNull final Properties properties)
            {
                item1 = properties.getProperty("item1");
                item2 = properties.getProperty("item2");
            }

            @Override
            public boolean check()
            {
                System.out.println("item1=" + item1);
                System.out.println("item2=" + item2);
                return item1.equals("foo") && item2.equals("bar");
            }
        };
        settingsLoader.load("settings.txt");
        System.out.println();
        settingsLoader.load(getClass(), "settings.txt");
        System.out.println();
        settingsLoader.load(Test_SettingsLoader.class, "settings.txt");
        System.out.println();
        settingsLoader.load(getClass().getClassLoader(), "settings.txt");
        System.out.println();
        settingsLoader.load(Test_SettingsLoader.class.getClassLoader(), "settings.txt");
        System.out.println();
    }
}