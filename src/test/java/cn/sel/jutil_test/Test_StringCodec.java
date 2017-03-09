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

import cn.sel.jutil.application.StringCodec;
import org.junit.Test;

public class Test_StringCodec
{
    @Test
    public void run()
            throws Exception
    {
        String ISO = "ISO-8859-1";
        String UTF = "UTF-8";
        String GBK = "GBK";
        String[] charsets = {ISO, UTF, GBK};
        String[] names = {"ISO", "UTF", "GBK"};
        //
        String string = "hello=你好";
        System.out.println("[Test String]: " + string);
        //
        for(int i = 0; i < charsets.length; i++)
        {
            System.out.println("----------------------------------------------------------------");
            System.out.println("Default --> " + names[i]);
            System.out.println();
            String encode = StringCodec.encode(string, charsets[i]);
            System.out.println("Encoded String:\n\t" + encode);
            System.out.println("Decoded String: ");
            String decode = StringCodec.decode(encode, charsets[i]);
            System.out.println("\t[Default]: " + decode);
            for(int j = 0; j < charsets.length; j++)
            {
                System.out.println("\t[" + names[j] + "]: " + StringCodec.decode(encode, charsets[j]));
            }
        }
    }
}