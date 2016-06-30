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

import java.util.Calendar;
import java.util.Date;

public class Comparator
{
    /**
     * @param date1 {@link Date} object
     * @param date2 {@link Date} object
     *
     * @return How many year(s) is it from date1 to date2.
     */
    public static int compareYear(@NonNull Date date1, @NonNull Date date2)
    {
        return (int)compare(date1, date2, Calendar.YEAR);
    }

    /**
     * @param date1 {@link Date} object
     * @param date2 {@link Date} object
     *
     * @return How many month(s) is it from date1 to date2.
     */
    public static int compareMonth(@NonNull Date date1, @NonNull Date date2)
    {
        return (int)compare(date1, date2, Calendar.MONTH);
    }

    /**
     * @param date1 {@link Date} object
     * @param date2 {@link Date} object
     *
     * @return How many day(s) is it from date1 to date2.
     */
    public static int compareDay(@NonNull Date date1, @NonNull Date date2)
    {
        return (int)compare(date1, date2, Calendar.DATE);
    }

    /**
     * @param date1 {@link Date} object
     * @param date2 {@link Date} object
     *
     * @return How many hour(s) is it from date1 to date2.
     */
    public static int compareHour(@NonNull Date date1, @NonNull Date date2)
    {
        return (int)compare(date1, date2, Calendar.HOUR_OF_DAY);
    }

    /**
     * @param date1 {@link Date} object
     * @param date2 {@link Date} object
     *
     * @return How many minute(s) is it from date1 to date2.
     */
    public static int compareMinute(@NonNull Date date1, @NonNull Date date2)
    {
        return (int)compare(date1, date2, Calendar.MINUTE);
    }

    /**
     * @param date1 {@link Date} object
     * @param date2 {@link Date} object
     *
     * @return How many second(s) is it from date1 to date2.
     */
    public static int compareSecond(@NonNull Date date1, @NonNull Date date2)
    {
        return (int)compare(date1, date2, Calendar.SECOND);
    }

    /**
     * @param date1 {@link Date} object
     * @param date2 {@link Date} object
     *
     * @return How many millisecond(s) is it from date1 to date2.
     */
    public static long compareMilliSecond(@NonNull Date date1, @NonNull Date date2)
    {
        return compare(date1, date2, Calendar.MILLISECOND);
    }

    /**
     * @param cal1 {@link Calendar} object
     * @param cal2 {@link Calendar} object
     *
     * @return How many year(s) is it from cal1 to cal2.
     */
    public static int compareYear(@NonNull Calendar cal1, @NonNull Calendar cal2)
    {
        return (int)compare(cal1, cal2, Calendar.YEAR);
    }

    /**
     * @param cal1 {@link Calendar} object
     * @param cal2 {@link Calendar} object
     *
     * @return How many month(s) is it from cal1 to cal2.
     */
    public static int compareMonth(@NonNull Calendar cal1, @NonNull Calendar cal2)
    {
        return (int)compare(cal1, cal2, Calendar.MONTH);
    }

    /**
     * @param cal1 {@link Calendar} object
     * @param cal2 {@link Calendar} object
     *
     * @return How many day(s) is it from cal1 to cal2.
     */
    public static int compareDay(@NonNull Calendar cal1, @NonNull Calendar cal2)
    {
        return (int)compare(cal1, cal2, Calendar.DATE);
    }

    /**
     * @param cal1 {@link Calendar} object
     * @param cal2 {@link Calendar} object
     *
     * @return How many hour(s) is it from cal1 to cal2.
     */
    public static int compareHour(@NonNull Calendar cal1, @NonNull Calendar cal2)
    {
        return (int)compare(cal1, cal2, Calendar.HOUR_OF_DAY);
    }

    /**
     * @param cal1 {@link Calendar} object
     * @param cal2 {@link Calendar} object
     *
     * @return How many minute(s) is it from cal1 to cal2.
     */
    public static int compareMinute(@NonNull Calendar cal1, @NonNull Calendar cal2)
    {
        return (int)compare(cal1, cal2, Calendar.MINUTE);
    }

    /**
     * @param cal1 {@link Calendar} object
     * @param cal2 {@link Calendar} object
     *
     * @return How many second(s) is it from cal1 to cal2.
     */
    public static int compareSecond(@NonNull Calendar cal1, @NonNull Calendar cal2)
    {
        return (int)compare(cal1, cal2, Calendar.SECOND);
    }

    /**
     * @param cal1 {@link Calendar} object
     * @param cal2 {@link Calendar} object
     *
     * @return How many millisecond(s) is it from cal1 to cal2.
     */
    public static long compareMilliSecond(@NonNull Calendar cal1, @NonNull Calendar cal2)
    {
        return compare(cal1, cal2, Calendar.MILLISECOND);
    }

    /**
     * @param date1     {@link Calendar} object
     * @param date2     {@link Calendar} object
     * @param precision One of {@link Calendar#YEAR}/{@link Calendar#MONTH}/{@link Calendar#DATE}/{@link Calendar#HOUR_OF_DAY}/{@link Calendar#MINUTE}/{@link Calendar#SECOND}/{@link Calendar#MILLISECOND}
     *
     * @return TimeSpan from date1 to date2.
     */
    private static long compare(@NonNull Date date1, @NonNull Date date2, int precision)
    {
        if(date1 == null || date2 == null)
        {
            throw new IllegalArgumentException("The arguments must not be null!");
        }
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return compare(cal1, cal2, precision);
    }

    /**
     * @param cal1      {@link Calendar} object
     * @param cal2      {@link Calendar} object
     * @param precision One of {@link Calendar#YEAR}/{@link Calendar#MONTH}/{@link Calendar#DATE}/{@link Calendar#HOUR_OF_DAY}/{@link Calendar#MINUTE}/{@link Calendar#SECOND}/{@link Calendar#MILLISECOND}
     *
     * @return TimeSpan from cal1 to cal2.
     */
    private static long compare(@NonNull Calendar cal1, @NonNull Calendar cal2, int precision)
    {
        if(cal1 == null || cal2 == null)
        {
            throw new IllegalArgumentException("The arguments must not be null!");
        }
        int years = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
        long milliseconds = cal2.getTimeInMillis() - cal1.getTimeInMillis();
        switch(precision)
        {
            case Calendar.YEAR:
                return years;
            case Calendar.MONTH:
                return years * 12 + cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);
            case Calendar.DATE:
                return milliseconds / 86400000;
            case Calendar.HOUR_OF_DAY:
                return milliseconds / 3600000;
            case Calendar.MINUTE:
                return milliseconds / 60000;
            case Calendar.SECOND:
                return milliseconds / 1000;
            case Calendar.MILLISECOND:
                return milliseconds;
        }
        throw new IllegalArgumentException("Invalid precision for calendar/datetime comparison!");
    }
}