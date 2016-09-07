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
package cn.sel.jutil.lang;

import java.math.BigDecimal;

public class JNumeric
{
    public static boolean between(Number number, double minValue, double maxValue)
    {
        Class<? extends Number> clazz = number.getClass();
        double doubleValue = number.doubleValue();
        return doubleValue >= minValue && doubleValue <= maxValue;
    }

    public static boolean isByte(Number number)
    {
        return between(number, Byte.MIN_VALUE, Byte.MAX_VALUE) && isInt(number);
    }

    public static boolean isShort(Number number)
    {
        return between(number, Short.MIN_VALUE, Short.MAX_VALUE) && isInt(number);
    }

    public static boolean isInteger(Number number)
    {
        return between(number, Integer.MIN_VALUE, Integer.MAX_VALUE) && isInt(number);
    }

    public static boolean isLong(Number number)
    {
        return between(number, Long.MIN_VALUE, Long.MAX_VALUE) && isInt(number);
    }

    public static boolean isFloat(Number number)
    {
        return between(number, -Float.MAX_VALUE, Float.MAX_VALUE) && isDecimal(number);
    }

    public static boolean isDouble(Number number)
    {
        return between(number, -Double.MAX_VALUE, Double.MAX_VALUE) && isDecimal(number);
    }

    public static boolean isInt(Number number)
    {
        return new BigDecimal(number.toString()).scale() == 0;
    }

    public static boolean isDecimal(Number number)
    {
        return !isInt(number);
    }
}