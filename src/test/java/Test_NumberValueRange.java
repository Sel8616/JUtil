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

import org.junit.Test;

public class Test_NumberValueRange
{
    @Test
    public void name()
            throws Exception
    {
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
        //
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
        //
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        //
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        //
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);
        //
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        //
        System.out.println();
        System.out.println(Double.MAX_VALUE / Long.MAX_VALUE);
    }
}
