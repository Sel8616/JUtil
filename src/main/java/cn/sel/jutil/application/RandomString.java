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
package cn.sel.jutil.application;

import cn.sel.jutil.annotation.note.NonNull;
import cn.sel.jutil.annotation.note.Nullable;
import cn.sel.jutil.lang.JText;
import cn.sel.jutil.lang.JText.StringParity;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Random string generator
 */
public class RandomString
{
    private static final String INVALID_LENGTH = "Length of the expected random string must be larger than 0!";
    private static final String INVALID_DIGITS = "Digits for the expected random string must not be null or empty!";

    public enum CharacterCase
    {
        ANY,
        LOWER,
        UPPER
    }

    public static final String LOWER_CHARS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPER_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";

    /**
     * Generate a random string using '0'-'9' with the specifications.
     *
     * @param length       Length of the expected string.
     * @param stringParity {@link StringParity}
     *
     * @return A random string.
     */
    public static String generateWithNumbers(int length, @Nullable StringParity stringParity)
    {
        return generate(length, NUMBERS, stringParity);
    }

    /**
     * Generate a random string using letters with the specifications.
     *
     * @param length        Length of the expected string.
     * @param characterCase {@link CharacterCase}
     * @param stringParity  {@link StringParity}
     *
     * @return A random string.
     */
    public static String generateWithLetters(int length, @Nullable CharacterCase characterCase, @Nullable StringParity stringParity)
    {
        if(characterCase == null)
        {
            characterCase = CharacterCase.ANY;
        }
        if(stringParity == null)
        {
            stringParity = StringParity.ANY;
        }
        String letters = null;
        switch(characterCase)
        {
            case ANY:
                letters = LOWER_CHARS + UPPER_CHARS;
                break;
            case LOWER:
                letters = LOWER_CHARS;
                break;
            case UPPER:
                letters = UPPER_CHARS;
                break;
        }
        return generate(length, letters.toCharArray(), stringParity);
    }

    /**
     * Generate a random string with the specifications.
     *
     * @param length        Length of the expected string.
     * @param characterCase {@link CharacterCase}
     * @param stringParity  {@link StringParity}
     *
     * @return A random string.
     */
    public static String generateWithNumbersAndLetters(int length, @Nullable CharacterCase characterCase, @Nullable StringParity stringParity)
    {
        if(characterCase == null)
        {
            characterCase = CharacterCase.ANY;
        }
        if(stringParity == null)
        {
            stringParity = StringParity.ANY;
        }
        String letters = NUMBERS;
        switch(characterCase)
        {
            case ANY:
                letters += LOWER_CHARS + UPPER_CHARS;
                break;
            case LOWER:
                letters += LOWER_CHARS;
                break;
            case UPPER:
                letters += UPPER_CHARS;
                break;
        }
        return generate(length, letters.toCharArray(), stringParity);
    }

    /**
     * Generate a random string of specified length with specified digits.
     *
     * @param length       Length of the expected string.
     * @param digits       An array which contains all the available characters.
     * @param stringParity {@link StringParity}
     *
     * @return A random string.
     */
    public static String generate(int length, @NonNull String digits, @Nullable StringParity stringParity)
    {
        if(digits == null || digits.length() < 1)
        {
            throw new IllegalArgumentException(INVALID_DIGITS);
        }
        return generate(length, digits.toCharArray(), stringParity);
    }

    /**
     * Generate a random string of specified length with specified digits.
     *
     * @param length       Length of the expected string.
     * @param digits       An array which contains all the available characters.
     * @param stringParity {@link StringParity}
     *
     * @return A random string.
     */
    public static String generate(int length, @NonNull char[] digits, @Nullable StringParity stringParity)
    {
        if(length < 1)
        {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
        if(digits == null || digits.length < 1)
        {
            throw new IllegalArgumentException(INVALID_DIGITS);
        }
        if(stringParity == null)
        {
            stringParity = StringParity.ANY;
        }
        String result;
        Random random = new SecureRandom();
        char[] cs = new char[length];
        do
        {
            for(int i = 0; i < length; i++)
            {
                cs[i] = digits[random.nextInt(digits.length)];
            }
            result = String.valueOf(cs);
        } while(stringParity != StringParity.ANY && JText.getParity(result) != stringParity);
        return result;
    }
}