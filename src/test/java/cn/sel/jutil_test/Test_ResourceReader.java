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
package cn.sel.jutil_test;

import cn.sel.jutil.application.ResourceReader;
import org.junit.Test;

import java.util.Arrays;

public class Test_ResourceReader
{
    @Test
    public void run()
    {
        System.out.println("--------String--------");
        System.out.println("Charset: Undefined\n" + ResourceReader.readAsString("res.txt"));
        System.out.println("----------------------------------------------------------------");
        System.out.println("Charset: ASCII\n" + ResourceReader.readAsString("res.txt", "ASCII"));
        System.out.println("----------------------------------------------------------------");
        System.out.println("Charset: US-ASCII\n" + ResourceReader.readAsString("res.txt", "US-ASCII"));
        System.out.println("----------------------------------------------------------------");
        System.out.println("Charset: ISO-8859-1\n" + ResourceReader.readAsString("res.txt", "ISO-8859-1"));
        System.out.println("----------------------------------------------------------------");
        System.out.println("Charset: UTF-8\n" + ResourceReader.readAsString("res.txt", "UTF-8"));
        System.out.println("----------------------------------------------------------------");
        System.out.println("Charset: GB2312\n" + ResourceReader.readAsString("res.txt", "GB2312"));
        System.out.println("----------------------------------------------------------------");
        System.out.println("Charset: GBK\n" + ResourceReader.readAsString("res.txt", "GBK"));
        System.out.println("----------------------------------------------------------------");
        System.out.println("--------Array--------");
        System.out.println("LineSeparator: Undefined\n" + Arrays.toString(ResourceReader.readAsArray("res.txt")));
        System.out.println("LineSeparator: \\n\n" + Arrays.toString(ResourceReader.readAsArray("res.txt", "UTF-8", "\n")));
        System.out.println("LineSeparator: \\r\\n" + Arrays.toString(ResourceReader.readAsArray("res.txt", "UTF-8", "\r\n")));
    }
}