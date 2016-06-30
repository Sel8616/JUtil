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

import cn.sel.jutil.application.TripleMap;
import org.junit.Test;

public class Test_TripleMap
{
    @Test
    public void run()
    {
        TripleMap<String, Integer, Double> sid = new TripleMap<>();
        sid.put("pi", 1, 3.14);
        sid.put("e", 2, 2.71828182846);
        System.out.println("Value of <pi,1> =" + sid.get("pi", 1));
        System.out.println("Value of <pi,2> =" + sid.get("pi", 2));
        System.out.println("Value of <pi,3> =" + sid.get("pi", 3));
        System.out.println("Value of <pi,null> =" + sid.get("pi", null));
        System.out.println("Value of <e,1> =" + sid.get("e", 1));
        System.out.println("Value of <e,2> =" + sid.get("e", 2));
        System.out.println("Value of <e,3> =" + sid.get("e", 3));
        System.out.println("Value of <e,null> =" + sid.get("e", null));
        sid.put(null, 1, 0.618);
        sid.put("nonnull", null, 0.618);
        System.out.println("Value of <null,1> =" + sid.get(null, 1));
        System.out.println("Value of <null,1> =" + sid.get("null", 1));
        System.out.println("Value of <nonnull,null> =" + sid.get("nonnull", null));
        System.out.println("Value of <nonnull,null> =" + sid.get("nonnull", null));
    }
}