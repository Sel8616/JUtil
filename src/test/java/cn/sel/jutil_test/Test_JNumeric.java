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

import cn.sel.jutil.lang.JNumeric;
import org.junit.Assert;
import org.junit.Test;

public class Test_JNumeric
{
    @Test
    public void run()
    {
        boolean value;
        System.out.println();
        System.out.println("< JNumeric >");
        System.out.println("================================================================");
        System.out.println("isByte(-1)");
        value = JNumeric.isByte(-1);
        System.out.println(value);
        Assert.assertEquals(true, value);
        System.out.println("----------------------------------------------------------------");
        System.out.println("isShort(1048576)");
        value = JNumeric.isShort(1048576);
        System.out.println(value);
        Assert.assertEquals(false, value);
        System.out.println("----------------------------------------------------------------");
        System.out.println("isInteger(3.1415926)");
        value = JNumeric.isInteger(3.1415926);
        System.out.println(value);
        Assert.assertEquals(false, value);
        System.out.println("----------------------------------------------------------------");
        System.out.println("isLong(-1048576)");
        value = JNumeric.isLong(-1048576);
        System.out.println(value);
        Assert.assertEquals(true, value);
        System.out.println("----------------------------------------------------------------");
        System.out.println("isFloat(-0.618)");
        value = JNumeric.isFloat(-0.618);
        System.out.println(value);
        Assert.assertEquals(true, value);
        System.out.println("----------------------------------------------------------------");
        System.out.println("isDouble(0)");
        value = JNumeric.isDouble(0);
        System.out.println(value);
        Assert.assertEquals(false, value);
        System.out.println("----------------------------------------------------------------");
        System.out.println("isDouble(1)");
        value = JNumeric.isDouble(1);
        System.out.println(value);
        Assert.assertEquals(false, value);
        System.out.println("----------------------------------------------------------------");
        System.out.println("isDouble(-3.0)");
        value = JNumeric.isDouble(-3.0);
        System.out.println(value);
        Assert.assertEquals(true, value);
        System.out.println("----------------------------------------------------------------");
        int num = -1;
        System.out.println("between(-1, 0, 100)");
        value = JNumeric.between(num, 0, 100);
        System.out.println(value);
        Assert.assertEquals(false, value);
        System.out.println("----------------------------------------------------------------");
        Integer number = 10;
        System.out.println("between(10, 0, 100)");
        value = JNumeric.between(number, 0, 100);
        System.out.println(value);
        Assert.assertEquals(true, value);
        System.out.println("----------------------------------------------------------------");
        System.out.println("isDecimal(1.1)");
        System.out.println(JNumeric.isDecimal(1.1));
        Assert.assertEquals(true, value);
        System.out.println("----------------------------------------------------------------");
        System.out.println("isDecimal(11)");
        value = JNumeric.isDecimal(11);
        System.out.println(value);
        Assert.assertEquals(false, value);
        System.out.println("----------------------------------------------------------------");
        System.out.println("isInt(1.1)");
        value = JNumeric.isInt(1.1);
        System.out.println(value);
        Assert.assertEquals(false, value);
        System.out.println("----------------------------------------------------------------");
        System.out.println("isInt(11)");
        value = JNumeric.isInt(11);
        System.out.println(value);
        Assert.assertEquals(true, value);
    }
}