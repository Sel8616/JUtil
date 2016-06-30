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

import cn.sel.jutil.lang.JStringer;
import cn.sel.jutil.lang.JStringer.KVPattern;
import org.junit.Test;

import java.util.*;

public class Test_JStringer
{
    @Test
    public void run()
    {
        System.out.println();
        System.out.println("< JStringer >");
        System.out.println("================================================================");
        int i = JStringer.string2int("12");
        short s = JStringer.string2short("12");
        long l = JStringer.string2long("12");
        float f = JStringer.string2float("12");
        double d = JStringer.string2double("12");
        boolean b = JStringer.string2boolean("true");
        Object ii = JStringer.string2Object("123", int.class);
        Object ss = JStringer.string2Object("123", short.class);
        Object ll = JStringer.string2Object("123", long.class);
        Object ff = JStringer.string2Object("123", float.class);
        Object dd = JStringer.string2Object("123", double.class);
        Object bb = JStringer.string2Object("false", boolean.class);
        Object iii = JStringer.string2Object("123", Integer.class);
        Object sss = JStringer.string2Object("123", Short.class);
        Object lll = JStringer.string2Object("123", Long.class);
        Object fff = JStringer.string2Object("123", Float.class);
        Object ddd = JStringer.string2Object("123", Double.class);
        Object bbb = JStringer.string2Object("true", Boolean.class);
        Object str = JStringer.string2Object("junit", String.class);
        System.out.println("string2int(\"12\")=" + i);
        System.out.println("string2short(\"12\")=" + s);
        System.out.println("string2long(\"12\")=" + l);
        System.out.println("string2float(\"12\")=" + f);
        System.out.println("string2double(\"12\")=" + d);
        System.out.println("string2boolean(\"true\")=" + b);
        System.out.println("string2Object(\"123\", int.class)=" + ii);
        System.out.println("string2Object(\"123\", short.class)=" + ss);
        System.out.println("string2Object(\"123\", long.class)=" + ll);
        System.out.println("string2Object(\"123\", float.class)=" + ff);
        System.out.println("string2Object(\"123\", double.class)=" + dd);
        System.out.println("string2Object(\"false\", boolean.class)=" + bb);
        System.out.println("string2Object(\"123\", Integer.class)=" + iii);
        System.out.println("string2Object(\"123\", Short.class)=" + sss);
        System.out.println("string2Object(\"123\", Long.class)=" + lll);
        System.out.println("string2Object(\"123\", Float.class)=" + fff);
        System.out.println("string2Object(\"123\", Double.class)=" + ddd);
        System.out.println("string2Object(\"true\", Boolean.class)=" + bbb);
        System.out.println("string2Object(\"junit\", String.class)=" + str);
        System.out.println("----------------------------------------------------------------");
        System.out.println("array2String(new Integer[]{1, 2, 3})");
        System.out.println(JStringer.array2String(new Integer[]{1, 2, 3}));
        System.out.println("----------------------------------------------------------------");
        System.out.println("array2String(new Boolean[]{true, false, null})");
        System.out.println(JStringer.array2String(new Boolean[]{true, false, null}));
        System.out.println("----------------------------------------------------------------");
        List<Object> list = new ArrayList<>();
        list.add("hello");
        list.add(12345);
        list.add(123456789);
        list.add(123);
        list.add(12345);
        list.add(1234567890L);
        list.add(9876543210L);
        list.add(3.1416f);
        list.add(3.1415926F);
        list.add(3.14159265358979d);
        list.add(3.14159265358979D);
        list.add(true);
        list.add(false);
        list.add(new Date());
        list.add(Calendar.getInstance());
        System.out.println("list2String()");
        System.out.println(JStringer.list2String(list));
        System.out.println("----------------------------------------------------------------");
        Map<String, Object> map = new HashMap<>();
        map.put("string", "world");
        map.put("int", 12345);
        map.put("Integer", 123456789);
        map.put("short", 123);
        map.put("Short", 12345);
        map.put("long", 1234567890L);
        map.put("Long", 9876543210L);
        map.put("float", 3.1416f);
        map.put("Float", 3.1415926F);
        map.put("double", 3.14159265358979d);
        map.put("Double", 3.14159265358979D);
        map.put("boolean", true);
        map.put("Boolean", false);
        map.put("date", new Date());
        map.put("Calendar", Calendar.getInstance());
        map.put("list", list);
        System.out.println("map2String.MAP_DEFAULT()");
        System.out.println(JStringer.map2String(map, KVPattern.MAP_DEFAULT));
        System.out.println("----------------------------------------------------------------");
        System.out.println("map2String.JSON_LIKE()");
        System.out.println(JStringer.map2String(map, KVPattern.JSON_LIKE));
    }
}