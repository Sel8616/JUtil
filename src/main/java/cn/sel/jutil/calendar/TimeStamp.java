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

import cn.sel.jutil.annotation.note.Nullable;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;

public class TimeStamp
{
    public static long ms()
    {
        return System.currentTimeMillis();
    }

    public static long unix()
    {
        return System.currentTimeMillis() / 1000;
    }

    public static Date javaDate()
    {
        return new Date();
    }

    public static java.sql.Date sqlDate()
    {
        return new java.sql.Date(System.currentTimeMillis());
    }

    public static Time sqlTime()
    {
        return new Time(System.currentTimeMillis());
    }

    public static Timestamp sqlTimestamp()
    {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String date()
    {
        return text("yyyy-MM-dd");
    }

    public static String timeHour12()
    {
        return text("hh");
    }

    public static String timeHour24()
    {
        return text("HH");
    }

    public static String timeMinute12()
    {
        return text("hh:mm");
    }

    public static String timeMinute24()
    {
        return text("HH:mm");
    }

    public static String timeSecond12()
    {
        return text("hh:mm:ss");
    }

    public static String timeSecond24()
    {
        return text("HH:mm:ss");
    }

    public static String timeFull12()
    {
        return text("hh:mm:ss.SSS");
    }

    public static String timeFull24()
    {
        return text("HH:mm:ss.SSS");
    }

    public static String text()
    {
        return DateTime.getStringerFormat("yyyyMMddHHmmssSSS", Locale.getDefault()).format(new Date());
    }

    public static String text(@Nullable String pattern)
    {
        return DateTime.getStringerFormat(pattern, Locale.getDefault()).format(new Date());
    }

    public static String text(@Nullable Locale locale)
    {
        return DateTime.getStringerFormat(null, locale).format(new Date());
    }

    public static String text(@Nullable String pattern, @Nullable Locale locale)
    {
        return DateTime.getStringerFormat(pattern, locale).format(new Date());
    }
}