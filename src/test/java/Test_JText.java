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

import cn.sel.jutil.lang.JText;
import org.junit.Test;

public class Test_JText
{
    @Test
    public void run()
    {
        System.out.println();
        System.out.println("< JText >");
        System.out.println("================================================================");
        System.out.println("isNullOrEmpty(\"JUtil\")");
        System.out.println(JText.isNullOrEmpty("JText"));
        System.out.println("----------------------------------------------------------------");
        System.out.println("isNullOrEmpty(null)");
        System.out.println(JText.isNullOrEmpty(null));
        System.out.println("----------------------------------------------------------------");
        System.out.println("getParity(\"JUtil\")");
        System.out.println(JText.getParity("JUtil"));
        System.out.println("----------------------------------------------------------------");
        System.out.println("getPrefix(\"cn.sel.jutil\",7)");
        System.out.println(JText.getPrefix("cn.sel.jutil", 7));
        System.out.println("----------------------------------------------------------------");
        System.out.println("getPostfix(\"hello_world\",5)");
        System.out.println(JText.getPostfix("hello_world", 5));
    }
}