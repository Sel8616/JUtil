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

import cn.sel.jutil.lang.JObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Test_JObject
{
    @Test
    public void run()
    {
        System.out.println();
        System.out.println("< JObject >");
        System.out.println("================================================================");
        System.out.println("Include? new Integer[]{1, 2, 3, 4, 5}, 1?");
        boolean include1 = JObject.include(1, new Integer[]{1, 2, 3, 4, 5});
        System.out.println(include1);
        Assert.assertEquals(true, include1);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Include? new String[]{\"abc\", \"xyz\"}, \"aaa\")");
        boolean include2 = JObject.include("aaa", new String[]{"abc", "xyz"});
        System.out.println(include2);
        Assert.assertEquals(false, include2);
        System.out.println("----------------------------------------------------------------");
        System.out.println("joinArray(new String[]{\"aa\", \"bb\"}, new String[]{\"cc\", \"dd\"}, new String[]{\"ee\"})");
        System.out.println(Arrays.toString(JObject.joinArray(new String[]{"aa", "bb"}, new String[]{
                "cc", "dd"
        }, new String[]{"ee"})));
        System.out.println("----------------------------------------------------------------");
        System.out.println("joinArray(new String[]{\"aa\", \"bb\"}, new String[]{\"cc\", \"dd\"}, new String[]{\"ee\"})");
        System.out.println(Arrays.toString(JObject.joinArray(new Integer[]{1, 2}, new Integer[]{3, 4}, new Integer[]{
                5
        })));
        System.out.println("----------------------------------------------------------------");
        System.out.println("joinArray(new Boolean[]{true, false}, new Boolean[]{true, true}, new Boolean[]{false})");
        System.out.println(Arrays.toString(JObject.joinArray(new Boolean[]{true, false}, new Boolean[]{
                true, true
        }, new Boolean[]{false})));
    }
}