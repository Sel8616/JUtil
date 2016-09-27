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
package cn.sel.jutil.test;import cn.sel.jutil.application.EntityCompiler;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Test_EntityCompiler
{
    @Test
    public void run()
            throws Exception
    {
        EntityCompiler compiler = new EntityCompiler();
        Map<String, String> fields = new HashMap<>();
        fields.put("name", "String");
        fields.put("age", "int");
        fields.put("email", "String");
        fields.put("isVip", "boolean");
        String java = compiler.createSourceCode("cn.sel.jutil", "User", fields);
        System.out.println(java);
        Class<?> clazz = compiler.compileBeanClass("cn.sel.jutil", "User", fields);
        System.out.println(clazz);
        if(clazz != null)
        {
            Object object = clazz.newInstance();
            System.out.println(object);
            for(Field field : clazz.getDeclaredFields())
            {
                System.out.println("Field: " + field);
            }
            for(Method method : clazz.getDeclaredMethods())
            {
                System.out.println("Method: " + method);
            }
        }
    }
}