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
package cn.sel.jutil.test;

import cn.sel.jutil.application.TripleMap;
import org.junit.Assert;
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
        Double e1 = sid.get("e", 1);
        System.out.println("Value of <\"e\",1> =" + e1);
        Double e2 = sid.get("e", 2);
        System.out.println("Value of <\"e\",2> =" + e2);
        Double e0 = sid.get("e", 0);
        System.out.println("Value of <\"e\",0> =" + e0);
        Double e_ = sid.get("e", null);
        System.out.println("Value of <\"e\",null> =" + e_);
        Assert.assertEquals(2.71828182846, e1, 0);
        Assert.assertEquals(null, e2);
        Assert.assertEquals(2.718, e0, 0);
        Assert.assertEquals(null, e_);
        System.out.println("================================================================");
        sid.put("pi", 1, 3.14);
        sid.put("pi", 2, 6.28);
        System.out.println("Put(\"pi\", 1, 3.14)");
        System.out.println("Put(\"pi\", 2, 6.28)");
        System.out.println("----------------------------------------------------------------");
        Double p1 = sid.get("pi", 1);
        System.out.println("Value of <\"pi\",1> =" + p1);
        Double p2 = sid.get("pi", 2);
        System.out.println("Value of <\"pi\",2> =" + p2);
        Double p3 = sid.get("pi", 3);
        System.out.println("Value of <\"pi\",3> =" + p3);
        Double p_ = sid.get("pi", null);
        System.out.println("Value of <\"pi\",null> =" + p_);
        Assert.assertEquals(3.14, p1, 0);
        Assert.assertEquals(6.28, p2, 0);
        Assert.assertEquals(null, p3);
        Assert.assertEquals(null, p_);
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
        Double _1 = sid.get(null, 1);
        System.out.println("Value of <null,1> =" + _1);
        Double __ = sid.get(null, null);
        System.out.println("Value of <null,null> =" + __);
        Double n1 = sid.get("null", 1);
        System.out.println("Value of <\"null\",1> =" + n1);
        Double n_ = sid.get("null", null);
        System.out.println("Value of <\"null\",null> =" + n_);
    }
}