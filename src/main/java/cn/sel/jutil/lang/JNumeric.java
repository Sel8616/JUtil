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

public class JNumeric
{
    public static boolean between(Number num, double minValue, double maxValue)
    {
        Class<? extends Number> clazz = num.getClass();
        if(Byte.class.equals(clazz))
        {
            byte byteValue = num.byteValue();
            return num.byteValue() >= minValue && byteValue <= maxValue;
        } else if(Short.class.equals(clazz))
        {
            short shortValue = num.shortValue();
            return shortValue >= minValue && shortValue <= maxValue;
        } else if(Integer.class.equals(clazz))
        {
            int intValue = num.intValue();
            return intValue >= minValue && intValue <= maxValue;
        } else if(Long.class.equals(clazz))
        {
            long longValue = num.longValue();
            return longValue >= minValue && longValue <= maxValue;
        } else if(Float.class.equals(clazz))
        {
            float floatValue = num.floatValue();
            return floatValue >= minValue && floatValue <= maxValue;
        } else if(Double.class.equals(clazz))
        {
            double doubleValue = num.doubleValue();
            return doubleValue >= minValue && doubleValue <= maxValue;
        } else
        {
            throw new UnsupportedOperationException("Only byte/short/int/long/float/double and their wrapper classes are supported!");
        }
    }

    public static boolean isByte(Number num)
    {
        return between(num, Byte.MIN_VALUE, Byte.MAX_VALUE);
    }

    public static boolean isShort(Number num)
    {
        return between(num, Short.MIN_VALUE, Short.MAX_VALUE);
    }

    public static boolean isInteger(Number num)
    {
        return between(num, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isLong(Number num)
    {
        return between(num, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isFloat(Number num)
    {
        return between(num, Float.MIN_VALUE, Float.MAX_VALUE);
    }

    public static boolean isDouble(Number num)
    {
        return between(num, Double.MIN_VALUE, Double.MAX_VALUE);
    }
}