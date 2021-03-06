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

import cn.sel.jutil.constant.CharacterParity;
import cn.sel.jutil.lang.JText;
import org.junit.Assert;
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
        boolean bool = JText.isNullOrEmpty("JText");
        System.out.println(bool);
        Assert.assertEquals(false, bool);
        System.out.println("----------------------------------------------------------------");
        System.out.println("isNullOrEmpty(null)");
        bool = JText.isNullOrEmpty(null);
        System.out.println(bool);
        Assert.assertEquals(true, bool);
        System.out.println("----------------------------------------------------------------");
        System.out.println("getParity(\"JUtil\")");
        CharacterParity parity = JText.getParity("JUtil");
        System.out.println(parity);
        Assert.assertEquals(CharacterParity.ODD, parity);
        System.out.println("----------------------------------------------------------------");
        System.out.println("getPrefix(\"cn.sel.jutil\",7)");
        String prefix = JText.getPrefix("cn.sel.jutil", 7);
        System.out.println(prefix);
        Assert.assertEquals("cn.sel.", prefix);
        System.out.println("----------------------------------------------------------------");
        System.out.println("getPostfix(\"hello_world\",5)");
        String postfix = JText.getPostfix("hello_world", 5);
        System.out.println(postfix);
        Assert.assertEquals("world", postfix);
    }
}