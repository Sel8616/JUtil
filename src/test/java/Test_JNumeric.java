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

import cn.sel.jutil.lang.JNumeric;
import org.junit.Test;

public class Test_JNumeric
{
    @Test
    public void run()
    {
        System.out.println();
        System.out.println("< JNumeric >");
        System.out.println("================================================================");
        System.out.println("isByte(-1)");
        System.out.println(JNumeric.isByte(-1));
        System.out.println("----------------------------------------------------------------");
        System.out.println("isShort(1048576)");
        System.out.println(JNumeric.isShort(1048576));
        System.out.println("----------------------------------------------------------------");
        System.out.println("isInteger(3.1415926)");
        System.out.println(JNumeric.isInteger(3.1415926));
        System.out.println("----------------------------------------------------------------");
        System.out.println("isLong(-1048576)");
        System.out.println(JNumeric.isLong(-1048576));
        System.out.println("----------------------------------------------------------------");
        System.out.println("isFloat(-0.618)");
        System.out.println(JNumeric.isFloat(-0.618));
        System.out.println("----------------------------------------------------------------");
        System.out.println("isDouble(1)");
        System.out.println(JNumeric.isDouble(1));
        System.out.println("----------------------------------------------------------------");
        System.out.println("between(-1, 0, 100)");
        System.out.println(JNumeric.between(-1, 0, 100));
        int num = -1;
        System.out.println(JNumeric.between(num, 0, 100));
        Integer number = 10;
        System.out.println(JNumeric.between(number, 0, 100));
    }
}