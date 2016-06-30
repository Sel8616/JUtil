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

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class DateTimeParser
{
    public static Date fromString(@NonNull String string, @NonNull String pattern) throws ParseException
    {
        return fromString(string, pattern, null);
    }

    public static Date fromString(@NonNull String string, @NonNull String pattern, @Nullable Locale locale) throws ParseException
    {
        Objects.requireNonNull(string);
        Objects.requireNonNull(pattern);
        return DateTime.getParsingFormat(pattern, locale).parse(string);
    }
}