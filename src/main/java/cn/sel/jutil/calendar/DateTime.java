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
import cn.sel.jutil.lang.JText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class DateTime
{
    public static boolean isValidPattern(@NonNull String datePattern)
    {
        try
        {
            new SimpleDateFormat(datePattern, Locale.getDefault());
            return true;
        } catch(Exception ignored)
        {
        }
        return false;
    }

    public static Date fromString(@NonNull String string, @NonNull String pattern)
            throws ParseException
    {
        return fromString(string, pattern, null);
    }

    public static Date fromString(@Nullable String string, @NonNull String pattern, @Nullable Locale locale)
            throws ParseException
    {
        if(JText.isNullOrEmpty(string))
        {
            return null;
        }
        Objects.requireNonNull(pattern, "The format pattern must not be null!");
        return getParsingFormat(pattern, locale).parse(string);
    }

    public static String toString(@NonNull Date date)
    {
        Objects.requireNonNull(date);
        return getStringerFormat(null, Locale.getDefault()).format(date);
    }

    public static String toString(@NonNull Date date, @Nullable String pattern)
    {
        Objects.requireNonNull(date);
        return getStringerFormat(pattern, Locale.getDefault()).format(date);
    }

    public static String toString(@NonNull Date date, @Nullable Locale locale)
    {
        Objects.requireNonNull(date);
        return getStringerFormat(null, locale).format(date);
    }

    public static String toString(@NonNull Date date, @Nullable String pattern, @Nullable Locale locale)
    {
        Objects.requireNonNull(date);
        return getStringerFormat(pattern, locale).format(date);
    }

    @NonNull
    public static SimpleDateFormat getParsingFormat(@NonNull String pattern, @Nullable Locale locale)
    {
        return new SimpleDateFormat(pattern, locale == null ? Locale.getDefault() : locale);
    }

    @NonNull
    public static SimpleDateFormat getStringerFormat(@Nullable String pattern, @Nullable Locale locale)
    {
        return new SimpleDateFormat(JText.isNullOrEmpty(pattern) ? "yyyy-MM-dd HH:mm:ss.SSS" : pattern,
                locale == null ? Locale.getDefault() : locale);
    }
}