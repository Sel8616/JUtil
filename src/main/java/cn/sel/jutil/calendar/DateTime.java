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
package cn.sel.jutil.calendar;

import cn.sel.jutil.annotation.note.NonNull;
import cn.sel.jutil.annotation.note.Nullable;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateTime
{
    public static boolean isValidPattern(@NonNull String datePattern)
    {
        try
        {
            new SimpleDateFormat(datePattern, Locale.getDefault());
            return true;
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @NonNull
    public static SimpleDateFormat getParsingFormat(@NonNull String pattern, @Nullable Locale locale)
    {
        return new SimpleDateFormat(pattern, locale == null ? Locale.getDefault() : locale);
    }

    @NonNull
    public static SimpleDateFormat getStringerFormat(@Nullable String pattern, @Nullable Locale locale)
    {
        return new SimpleDateFormat(pattern == null || pattern.isEmpty() ? "yyyy-MM-dd HH:mm:ss.SSS" : pattern, locale == null ? Locale.getDefault() : locale);
    }
}