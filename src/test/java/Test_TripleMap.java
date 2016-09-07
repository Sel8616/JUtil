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
    private String aa;

    @Test
    public void run()
    {
        TripleMap<String, Integer, Double> sid = new TripleMap<>();
        System.out.println("TripleMap<String, Integer, Double>");
        System.out.println("================================================================");
        sid.put("e", 0, 2.718);
        sid.put("e", 1, 2.71828182846);
        System.out.println("Put(\"e\", 0, 2.718)");
        System.out.println("Put(\"e\", 1, 2.71828182846)");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Value of <\"e\",1> =" + sid.get("e", 1));
        System.out.println("Value of <\"e\",2> =" + sid.get("e", 2));
        System.out.println("Value of <\"e\",0> =" + sid.get("e", 0));
        System.out.println("Value of <\"e\",null> =" + sid.get("e", null));
        System.out.println("================================================================");
        sid.put("pi", 1, 3.14);
        sid.put("pi", 2, 6.28);
        System.out.println("Put(\"pi\", 1, 3.14)");
        System.out.println("Put(\"pi\", 2, 6.28)");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Value of <\"pi\",1> =" + sid.get("pi", 1));
        System.out.println("Value of <\"pi\",2> =" + sid.get("pi", 2));
        System.out.println("Value of <\"pi\",3> =" + sid.get("pi", 3));
        System.out.println("Value of <\"pi\",null> =" + sid.get("pi", null));
        System.out.println("================================================================");
        sid.put(null, 1, 0.618);
        sid.put(null, null, -0.618);
        sid.put("null", 1, 1.414);
        sid.put("null", null, -1.414);
        System.out.println("Put(null, 1, 0.618)");
        System.out.println("Put(null, null, -0.618)");
        System.out.println("Put(\"null\", 1, 1.414)");
        System.out.println("Put(\"null\", null, -1.414)");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Value of <null,1> =" + sid.get(null, 1));
        System.out.println("Value of <null,null> =" + sid.get(null, null));
        System.out.println("Value of <\"null\",1> =" + sid.get("null", 1));
        System.out.println("Value of <\"null\",null> =" + sid.get("null", null));
    }
}