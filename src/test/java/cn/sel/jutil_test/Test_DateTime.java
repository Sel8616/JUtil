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
package cn.sel.jutil_test;

import cn.sel.jutil.calendar.Comparator;
import cn.sel.jutil.calendar.DateTime;
import cn.sel.jutil.calendar.TimeStamp;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Test_DateTime
{
    @Test
    public void run()
    {
        //region cn.sel.jutil.calendar.DateTime
        System.out.println();
        System.out.println("< TimeStamp >");
        System.out.println("================================================================");
        System.out.println("ms()");
        System.out.println(TimeStamp.ms());
        System.out.println("----------------------------------------------------------------");
        System.out.println("unix()");
        System.out.println(TimeStamp.unix());
        System.out.println("----------------------------------------------------------------");
        System.out.println("text()");
        System.out.println(TimeStamp.text());
        System.out.println("----------------------------------------------------------------");
        System.out.println("text(\"yyyy-MM-dd HH:mm:ss.SSS\")");
        System.out.println(TimeStamp.text("yyyy-MM-dd HH:mm:ss.SSS"));
        System.out.println("----------------------------------------------------------------");
        System.out.println("text(Locale.getDefault())");
        System.out.println(TimeStamp.text(Locale.getDefault()));
        System.out.println("----------------------------------------------------------------");
        System.out.println("text(\"yyyy-MM-dd HH:mm:ss.SSS\", null)");
        System.out.println(TimeStamp.text("yyyy-MM-dd HH:mm:ss.SSS", null));
        System.out.println("----------------------------------------------------------------");
        System.out.println("javaDate()");
        System.out.println(TimeStamp.javaDate());
        System.out.println("----------------------------------------------------------------");
        System.out.println("sqlDate()");
        System.out.println(TimeStamp.sqlDate());
        System.out.println("----------------------------------------------------------------");
        System.out.println("sqlTime()");
        System.out.println(TimeStamp.sqlTime());
        System.out.println("----------------------------------------------------------------");
        System.out.println("date()");
        System.out.println(TimeStamp.date());
        System.out.println("----------------------------------------------------------------");
        System.out.println("timeHour12()");
        System.out.println(TimeStamp.timeHour12());
        System.out.println("----------------------------------------------------------------");
        System.out.println("timeHour24()");
        System.out.println(TimeStamp.timeHour24());
        System.out.println("----------------------------------------------------------------");
        System.out.println("timeMinute12()");
        System.out.println(TimeStamp.timeMinute12());
        System.out.println("----------------------------------------------------------------");
        System.out.println("timeMinute24()");
        System.out.println(TimeStamp.timeMinute24());
        System.out.println("----------------------------------------------------------------");
        System.out.println("timeSecond12()");
        System.out.println(TimeStamp.timeSecond12());
        System.out.println("----------------------------------------------------------------");
        System.out.println("timeSecond24()");
        System.out.println(TimeStamp.timeSecond24());
        System.out.println("----------------------------------------------------------------");
        System.out.println("timeFull12()");
        System.out.println(TimeStamp.timeFull12());
        System.out.println("----------------------------------------------------------------");
        System.out.println("timeFull24()");
        System.out.println(TimeStamp.timeFull24());
        //endregion
        //region cn.sel.jutil.calendar.DateTime
        System.out.println();
        System.out.println("< DateTime >");
        System.out.println("================================================================");
        System.out.println("toString(new date())");
        System.out.println(DateTime.toString(new Date()));
        System.out.println("----------------------------------------------------------------");
        System.out.println("toString(new date(),\"dd/MM/yyyy HH:mm:ss\")");
        System.out.println(DateTime.toString(new Date(), "dd/MM/yyyy HH:mm:ss"));
        System.out.println("----------------------------------------------------------------");
        System.out.println("toString(new date(), Locale.CHINESE)");
        System.out.println(DateTime.toString(new Date(), Locale.CHINESE));
        System.out.println("----------------------------------------------------------------");
        System.out.println("toString(new date(), \"yyyy/MM/dd HH-mm-ss.SSS\", Locale.SIMPLIFIED_CHINESE)");
        System.out.println(DateTime.toString(new Date(), "yyyy/MM/dd HH-mm-ss.SSS", Locale.SIMPLIFIED_CHINESE));
        //endregion
        //region cn.sel.jutil.calendar.DateTime
        System.out.println();
        System.out.println("< DateTime >");
        System.out.println("================================================================");
        try
        {
            System.out.println("fromString(\"2016-02-07\", \"yyyy-MM-dd\")");
            System.out.println(DateTime.fromString("2016-02-07", "yyyy-MM-dd"));
            System.out.println("----------------------------------------------------------------");
            System.out.println("fromString(\"2016-02-07 12:10:30\", \"yyyy-MM-dd HH:mm:ss\")");
            System.out.println(DateTime.fromString("2016-02-07 12:10:30", "yyyy-MM-dd HH:mm:ss"));
            System.out.println("----------------------------------------------------------------");
            System.out.println("fromString(\"2016-02-14\", \"yyyy/MM/dd\", Locale.getDefault())");
            System.out.println(DateTime.fromString("2016-02-14", "yyyy/MM/dd", Locale.getDefault()));
        } catch(ParseException e)
        {
            e.printStackTrace();
        }
        //endregion
        //region cn.sel.jutil.calendar.Comparator
        System.out.println();
        System.out.println("< Calendar.Comparator >");
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.set(2015, Calendar.JUNE, 1, 0, 0, 0);
        cal2.set(2016, Calendar.JULY, 3, 1, 10, 30);
        Date date1 = new Date();
        Date date2 = new Date();
        date1.setTime(cal2.getTimeInMillis());
        date2.setTime(cal1.getTimeInMillis());
        System.out.println("================================================================");
        System.out.println("compareYear(Calendar cal1, Calendar cal2)");
        System.out.println(Comparator.compareYear(cal1, cal2));
        System.out.println("----------------------------------------------------------------");
        System.out.println("compareMonth(Calendar cal1, Calendar cal2)");
        System.out.println(Comparator.compareMonth(cal1, cal2));
        System.out.println("----------------------------------------------------------------");
        System.out.println("compareDay(Calendar cal1, Calendar cal2)");
        System.out.println(Comparator.compareDay(cal1, cal2));
        System.out.println("----------------------------------------------------------------");
        System.out.println("compareHour(Calendar cal1, Calendar cal2)");
        System.out.println(Comparator.compareHour(cal1, cal2));
        System.out.println("----------------------------------------------------------------");
        System.out.println("compareMinute(Calendar cal1, Calendar cal2)");
        System.out.println(Comparator.compareMinute(cal1, cal2));
        System.out.println("----------------------------------------------------------------");
        System.out.println("compareSecond(Calendar cal1, Calendar cal2)");
        System.out.println(Comparator.compareSecond(cal1, cal2));
        System.out.println("----------------------------------------------------------------");
        System.out.println("compareMilliSecond(Calendar cal1, Calendar cal2)");
        System.out.println(Comparator.compareMilliSecond(cal1, cal2));
        System.out.println("----------------------------------------------------------------");
        System.out.println("compareYear(date date1, date date2)");
        System.out.println(Comparator.compareYear(date1, date2));
        System.out.println("----------------------------------------------------------------");
        System.out.println("compareMonth(date date1, date date2)");
        System.out.println(Comparator.compareMonth(date1, date2));
        System.out.println("----------------------------------------------------------------");
        System.out.println("compareDay(date date1, date date2)");
        System.out.println(Comparator.compareDay(date1, date2));
        System.out.println("----------------------------------------------------------------");
        System.out.println("compareHour(date date1, date date2)");
        System.out.println(Comparator.compareHour(date1, date2));
        System.out.println("----------------------------------------------------------------");
        System.out.println("compareMinute(date date1, date date2)");
        System.out.println(Comparator.compareMinute(date1, date2));
        System.out.println("----------------------------------------------------------------");
        System.out.println("compareSecond(date date1, date date2)");
        System.out.println(Comparator.compareSecond(date1, date2));
        System.out.println("----------------------------------------------------------------");
        System.out.println("compareMilliSecond(date date1, date date2)");
        System.out.println(Comparator.compareMilliSecond(date1, date2));
        //endregion
    }
}