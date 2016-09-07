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

import cn.sel.jutil.application.EntityCompiler;
import org.junit.Test;

import java.lang.reflect.Method;

public class Test_SetterAndGetter
{
    @Test
    public void run()
            throws Exception
    {
        EntityCompiler dCompiler = new EntityCompiler();
        Method createSetter = EntityCompiler.class.getDeclaredMethod("createSetter", String.class, String.class);
        createSetter.setAccessible(true);
        Method createGetter = EntityCompiler.class.getDeclaredMethod("createGetter", String.class, String.class);
        createGetter.setAccessible(true);
        //
        System.out.println(createSetter.invoke(dCompiler, "String", "USER"));
        System.out.println(createSetter.invoke(dCompiler, "String", "user"));
        System.out.println(createSetter.invoke(dCompiler, "String", "User"));
        System.out.println(createSetter.invoke(dCompiler, "String", "uSER"));
        System.out.println(createSetter.invoke(dCompiler, "String", "USer"));
        System.out.println(createSetter.invoke(dCompiler, "String", "usER"));
        System.out.println(createSetter.invoke(dCompiler, "String", "user_Name"));
        System.out.println(createSetter.invoke(dCompiler, "String", "user_name"));
        System.out.println(createSetter.invoke(dCompiler, "String", "user_NAME"));
        System.out.println(createSetter.invoke(dCompiler, "String", "user_NAme"));
        System.out.println(createSetter.invoke(dCompiler, "String", "user_naME"));
        System.out.println(createSetter.invoke(dCompiler, "String", "user_nAME"));
        //
        System.out.println(createGetter.invoke(dCompiler, "String", "USER"));
        System.out.println(createGetter.invoke(dCompiler, "String", "user"));
        System.out.println(createGetter.invoke(dCompiler, "String", "User"));
        System.out.println(createGetter.invoke(dCompiler, "String", "uSER"));
        System.out.println(createGetter.invoke(dCompiler, "String", "USer"));
        System.out.println(createGetter.invoke(dCompiler, "String", "usER"));
        System.out.println(createGetter.invoke(dCompiler, "String", "user_Name"));
        System.out.println(createGetter.invoke(dCompiler, "String", "user_name"));
        System.out.println(createGetter.invoke(dCompiler, "String", "user_NAME"));
        System.out.println(createGetter.invoke(dCompiler, "String", "user_NAme"));
        System.out.println(createGetter.invoke(dCompiler, "String", "user_naME"));
        System.out.println(createGetter.invoke(dCompiler, "String", "user_nAME"));
        //
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "o"));
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "O"));
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "is"));
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "IS"));
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "Is"));
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "iS"));
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "OK"));
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "ok"));
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "Ok"));
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "oK"));
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "isOK"));
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "ISok"));
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "IsOk"));
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "iSoK"));
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "success"));
        System.out.println(createGetter.invoke(dCompiler, "Boolean", "SUCCESS"));
        System.out.println(createGetter.invoke(dCompiler, "boolean", "Success"));
        System.out.println(createGetter.invoke(dCompiler, "boolean", "SUccess"));
        System.out.println(createGetter.invoke(dCompiler, "boolean", "suCCess"));
        System.out.println(createGetter.invoke(dCompiler, "boolean", "sUCCess"));
    }
}