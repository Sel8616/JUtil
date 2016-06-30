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

import java.util.Arrays;
import java.util.Objects;

public class JObject
{
    public static <T> boolean include(T[] array, T object)
    {
        for(T item : array)
        {
            if(Objects.equals(item, object))
            {
                return true;
            }
        }
        return false;
    }

    @SafeVarargs
    public static <T> T[] joinArray(T[] first, T[]... others)
    {
        int length1 = first.length;
        int totalLength = length1;
        for(T[] array : others)
        {
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = length1;
        for(T[] array : others)
        {
            int length = array.length;
            System.arraycopy(array, 0, result, offset, length);
            offset += length;
        }
        return result;
    }
}