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

import cn.sel.jutil.annotation.note.NonNull;
import cn.sel.jutil.annotation.note.Nullable;
import cn.sel.jutil.calendar.DateTime;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

public class JStringer
{
    protected static final String UNSUPPORTED_CLASS = "Unsupported class!";

    //region String -> Primitive Types
    public static int string2int(String string)
    {
        return Integer.parseInt(string);
    }

    public static short string2short(String string)
    {
        return Short.parseShort(string);
    }

    public static long string2long(String string)
    {
        return Long.parseLong(string);
    }

    public static float string2float(String string)
    {
        return Float.parseFloat(string);
    }

    public static double string2double(String string)
    {
        return Double.parseDouble(string);
    }

    public static boolean string2boolean(String string)
    {
        return Boolean.parseBoolean(string);
    }
    //endregion

    //region String -> Wrapper Types
    public static Integer string2Integer(String string)
    {
        return Integer.valueOf(string);
    }

    public static Short string2Short(String string)
    {
        return Short.valueOf(string);
    }

    public static Long string2Long(String string)
    {
        return Long.valueOf(string);
    }

    public static Float string2Float(String string)
    {
        return Float.valueOf(string);
    }

    public static Double string2Double(String string)
    {
        return Double.valueOf(string);
    }

    public static Boolean string2Boolean(String string)
    {
        return Boolean.valueOf(string);
    }

    @SuppressWarnings("unchecked")
    public static <T> T string2Object(String string, Class<T> clazz)
    {
        if(String.class.equals(clazz))
        {
            return (T)string;
        }
        if(JText.isNullOrEmpty(string))
        {
            return null;
        }
        if(int.class.equals(clazz) || Integer.class.equals(clazz))
        {
            return (T)Integer.valueOf(string);
        }
        if(boolean.class.equals(clazz) || Boolean.class.equals(clazz))
        {
            return (T)Boolean.valueOf(string);
        }
        if(short.class.equals(clazz) || Short.class.equals(clazz))
        {
            return (T)Short.valueOf(string);
        }
        if(long.class.equals(clazz) || Long.class.equals(clazz))
        {
            return (T)Long.valueOf(string);
        }
        if(float.class.equals(clazz) || Float.class.equals(clazz))
        {
            return (T)Float.valueOf(string);
        }
        if(double.class.equals(clazz) || Double.class.equals(clazz))
        {
            return (T)Double.valueOf(string);
        }
        throw new IllegalArgumentException(UNSUPPORTED_CLASS);
    }

    @NonNull
    public static Object stringArray2ObjectArray(@NonNull String[] array, Class<?> clazz)
    {
        int length = array.length;
        if(String[].class.equals(clazz))
        {
            return Arrays.copyOf(array, length);
        }
        if(int[].class.equals(clazz))
        {
            int[] result = new int[length];
            for(int j = 0; j < length; j++)
            {
                result[j] = Integer.parseInt(array[j]);
            }
            return result;
        }
        if(Integer[].class.equals(clazz))
        {
            Integer[] result = new Integer[length];
            for(int j = 0; j < length; j++)
            {
                result[j] = Integer.valueOf(array[j]);
            }
            return result;
        }
        if(short[].class.equals(clazz))
        {
            short[] result = new short[length];
            for(int j = 0; j < length; j++)
            {
                result[j] = Short.parseShort(array[j]);
            }
            return result;
        }
        if(Short[].class.equals(clazz))
        {
            Short[] result = new Short[length];
            for(int j = 0; j < length; j++)
            {
                result[j] = Short.valueOf(array[j]);
            }
            return result;
        }
        if(long[].class.equals(clazz))
        {
            long[] result = new long[length];
            for(int j = 0; j < length; j++)
            {
                result[j] = Long.parseLong(array[j]);
            }
            return result;
        }
        if(Long[].class.equals(clazz))
        {
            Long[] result = new Long[length];
            for(int j = 0; j < length; j++)
            {
                result[j] = Long.valueOf(array[j]);
            }
            return result;
        }
        if(float[].class.equals(clazz))
        {
            float[] result = new float[length];
            for(int j = 0; j < length; j++)
            {
                result[j] = Float.parseFloat(array[j]);
            }
            return result;
        }
        if(Float[].class.equals(clazz))
        {
            Float[] result = new Float[length];
            for(int j = 0; j < length; j++)
            {
                result[j] = Float.valueOf(array[j]);
            }
            return result;
        }
        if(double[].class.equals(clazz))
        {
            double[] result = new double[length];
            for(int j = 0; j < length; j++)
            {
                result[j] = Double.parseDouble(array[j]);
            }
            return result;
        }
        if(Double[].class.equals(clazz))
        {
            Double[] result = new Double[length];
            for(int j = 0; j < length; j++)
            {
                result[j] = Double.valueOf(array[j]);
            }
            return result;
        }
        if(boolean[].class.equals(clazz))
        {
            boolean[] result = new boolean[length];
            for(int j = 0; j < length; j++)
            {
                result[j] = Boolean.parseBoolean(array[j]);
            }
            return result;
        }
        if(Boolean[].class.equals(clazz))
        {
            Boolean[] result = new Boolean[length];
            for(int j = 0; j < length; j++)
            {
                result[j] = Boolean.valueOf(array[j]);
            }
            return result;
        }
        throw new IllegalArgumentException(UNSUPPORTED_CLASS);
    }
    //endregion

    //region Array -> String
    @Nullable
    public static String array2String(@Nullable Object[] array)
    {
        return array2String(array, null, Locale.getDefault());
    }

    @Nullable
    public static String array2String(@Nullable Object[] array, @Nullable String dateTimePattern)
    {
        return array2String(array, dateTimePattern, Locale.getDefault());
    }

    @Nullable
    public static String array2String(@Nullable Object[] array, @Nullable String dateTimePattern, @Nullable Locale locale)
    {
        if(array == null)
        {
            return null;
        }
        SimpleDateFormat simpleDateFormat = DateTime.getStringerFormat(dateTimePattern, locale);
        String result = "[";
        int length = array.length;
        if(length > 0)
        {
            result += getObjectString(array[0], simpleDateFormat);
        }
        for(int i = 1; i < length; i++)
        {
            result += ',' + getObjectString(array[i], simpleDateFormat);
        }
        result += "]";
        return result;
    }
    //endregion

    //region List -> String
    @Nullable
    public static String list2String(@Nullable Collection<?> list)
    {
        return list2String(list, null, Locale.getDefault());
    }

    @Nullable
    public static String list2String(@Nullable Collection<?> list, @Nullable String dateTimePattern)
    {
        return list2String(list, dateTimePattern, Locale.getDefault());
    }

    @Nullable
    public static String list2String(@Nullable Collection<?> list, @Nullable String dateTimePattern, @Nullable Locale locale)
    {
        if(list == null)
        {
            return null;
        }
        Iterator<?> iterator = list.iterator();
        if(!iterator.hasNext())
        {
            return "[]";
        }
        SimpleDateFormat simpleDateFormat = DateTime.getStringerFormat(dateTimePattern, locale);
        StringBuilder stringBuilder = new StringBuilder(list.size() * 10);
        stringBuilder.append('[');
        Object item;
        while(true)
        {
            item = iterator.next();
            stringBuilder.append(getObjectString(item, simpleDateFormat));
            if(iterator.hasNext())
            {
                stringBuilder.append(',');
            } else
            {
                break;
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
    //endregion

    //region Map -> String
    @Nullable
    public static <K, V> String map2String(@Nullable Map<K, V> map)
    {
        return map2String(map, KVPattern.MAP_DEFAULT, null, Locale.getDefault());
    }

    @Nullable
    public static <K, V> String map2String(@Nullable Map<K, V> map, @Nullable KVPattern kvPattern)
    {
        return map2String(map, kvPattern, null, Locale.getDefault());
    }

    @Nullable
    public static <K, V> String map2String(@Nullable Map<K, V> map, @Nullable String dateTimePattern)
    {
        return map2String(map, KVPattern.MAP_DEFAULT, dateTimePattern, Locale.getDefault());
    }

    @Nullable
    public static <K, V> String map2String(@Nullable Map<K, V> map, @Nullable Locale locale)
    {
        return map2String(map, KVPattern.MAP_DEFAULT, null, locale);
    }

    @Nullable
    public static <K, V> String map2String(@Nullable Map<K, V> map, @Nullable KVPattern kvPattern, @Nullable String dateTimePattern)
    {
        return map2String(map, kvPattern, dateTimePattern, Locale.getDefault());
    }

    @Nullable
    public static <K, V> String map2String(@Nullable Map<K, V> map, @Nullable KVPattern kvPattern, @Nullable Locale locale)
    {
        return map2String(map, kvPattern, null, locale);
    }

    @Nullable
    public static <K, V> String map2String(@Nullable Map<K, V> map, @Nullable String dateTimePattern, @Nullable Locale locale)
    {
        return map2String(map, KVPattern.MAP_DEFAULT, dateTimePattern, locale);
    }

    @Nullable
    public static <K, V> String map2String(@Nullable Map<K, V> map, @Nullable KVPattern kvPattern, @Nullable String dateTimePattern, @Nullable Locale locale)
    {
        if(map == null)
        {
            return null;
        }
        Iterator<Entry<K, V>> iterator = map.entrySet().iterator();
        if(!iterator.hasNext())
        {
            return "{}";
        }
        SimpleDateFormat simpleDateFormat = DateTime.getStringerFormat(dateTimePattern, locale);
        StringBuilder stringBuilder = new StringBuilder(map.size() * 10);
        stringBuilder.append('{');
        Entry<K, V> entry;
        while(true)
        {
            entry = iterator.next();
            Object key = entry.getKey();
            Object value = getObjectString(entry.getValue(), simpleDateFormat);
            stringBuilder.append(getKVPairString(key, value, kvPattern));
            if(iterator.hasNext())
            {
                stringBuilder.append(',');
            } else
            {
                break;
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
    //endregion

    @Nullable
    private static String getObjectString(@Nullable Object object, @NonNull SimpleDateFormat simpleDateFormat)
    {
        if(object != null)
        {
            if(object instanceof String)
            {
                return "\"" + object + '"';
            }
            if(object instanceof Date)
            {
                return simpleDateFormat.format(object);
            }
            if(object instanceof Calendar)
            {
                return simpleDateFormat.format(((Calendar)object).getTime());
            }
            if(object instanceof Object[])
            {
                return Arrays.toString((Object[])object);
            }
            if(object instanceof Collection<?>)
            {
                return list2String((Collection<?>)object);
            }
            if(object instanceof Map)
            {
                return map2String((Map)object);
            }
            return String.valueOf(object);
        }
        return null;
    }
    //endregion

    @NonNull
    private static String getKVPairString(Object key, Object value, @Nullable KVPattern kvPattern)
    {
        return String.format(kvPattern == null || kvPattern == KVPattern.MAP_DEFAULT ? "%s=%s" : "\"%s\":%s", key, value);
    }

    public enum KVPattern
    {
        /**
         * key=value
         */
        MAP_DEFAULT,
        /**
         * "key":value
         */
        JSON_LIKE
    }
}