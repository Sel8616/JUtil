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

import cn.sel.jutil.application.RandomString;
import cn.sel.jutil.application.RandomString.CharacterCase;
import cn.sel.jutil.lang.JText.StringParity;
import org.junit.Test;

public class Test_RandomString
{
    @Test
    public void run()
    {
        System.out.println();
        System.out.println("< RandomString >");
        System.out.println("================================================================");
        System.out.println("generateWithNumbers(6,EVEN)");
        System.out.println(RandomString.generateWithNumbers(6, StringParity.EVEN));
        System.out.println("----------------------------------------------------------------");
        System.out.println("generateWithNumbers(6,ODD)");
        System.out.println(RandomString.generateWithNumbers(6, StringParity.ODD));
        System.out.println("----------------------------------------------------------------");
        System.out.println("generateWithLetters(7,UPPER,ODD)");
        System.out.println(RandomString.generateWithLetters(7, CharacterCase.UPPER, StringParity.ODD));
        System.out.println("----------------------------------------------------------------");
        System.out.println("generateWithLetters(7,LOWER,EVEN)");
        System.out.println(RandomString.generateWithLetters(7, CharacterCase.LOWER, StringParity.EVEN));
        System.out.println("----------------------------------------------------------------");
        System.out.println("generateWithNumbersAndLetters(8,UPPER,EVEN)");
        System.out.println(RandomString.generateWithNumbersAndLetters(8, CharacterCase.UPPER, StringParity.EVEN));
        System.out.println("----------------------------------------------------------------");
        System.out.println("generateWithNumbersAndLetters(8,LOWER,ODD)");
        System.out.println(RandomString.generateWithNumbersAndLetters(8, CharacterCase.LOWER, StringParity.ODD));
        System.out.println("----------------------------------------------------------------");
        System.out.println("generateWithNumbersAndLetters(10,\"AxByCzD0\",EVEN)");
        System.out.println(RandomString.generate(10, "AxByCzD0", StringParity.EVEN));
        System.out.println("----------------------------------------------------------------");
        System.out.println("generateWithNumbersAndLetters(10,['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'],ODD)");
        System.out.println(RandomString.generate(10, new char[]{
                'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'
        }, StringParity.ODD));
    }
}