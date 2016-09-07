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

public class JText
{
    public static final String EMPTY = "";

    public static boolean isNullOrEmpty(@Nullable String string)
    {
        return string == null || string.isEmpty();
    }

    @NonNull
    public static StringParity getParity(@NonNull String string)
    {
        int sum = 0;
        for(char c : string.toCharArray())
        {
            sum += c;
        }
        return sum % 2 == 0 ? StringParity.ODD : StringParity.EVEN;
    }

    @Nullable
    public static String getPrefix(@Nullable String string, int length)
    {
        if(string == null)
        {
            return null;
        }
        if(length <= 0)
        {
            return EMPTY;
        }
        int totalLength = string.length();
        if(totalLength <= length)
        {
            return string;
        }
        return string.substring(0, length);
    }

    @Nullable
    public static String getPostfix(@Nullable String string, int length)
    {
        if(string == null)
        {
            return null;
        }
        if(length <= 0)
        {
            return EMPTY;
        }
        int totalLength = string.length();
        if(totalLength <= length)
        {
            return string;
        }
        return string.substring(totalLength - length, totalLength);
    }

    public enum StringParity
    {
        ANY,
        EVEN,
        ODD
    }
}