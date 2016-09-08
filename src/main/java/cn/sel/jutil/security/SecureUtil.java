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
package cn.sel.jutil.security;

import cn.sel.jutil.lang.JText;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Locale;

public class SecureUtil
{
    private static SecretKey AES_KEY;
    static
    {
        try
        {
            KeyGenerator keyGenerator;
            keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            keyGenerator.init(128, secureRandom);
            AES_KEY = keyGenerator.generateKey();
        } catch(NoSuchAlgorithmException e)
        {
            throw new IllegalStateException("Failed to generate AES key!", e);
        }
    }
    public static String getMD5_32(String src)
    {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes());
            byte tmp[] = md.digest();
            char chars[] = new char[16 * 2];
            int k = 0;
            for(int i = 0; i < 16; i++)
            {
                byte byte0 = tmp[i];
                chars[k++] = hexDigits[byte0 >>> 4 & 0xf];
                chars[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(chars);
        } catch(NoSuchAlgorithmException ignored)
        {
        }
        return null;
    }

    public static String getMD5_16(String src)
    {
        String md5_32 = getMD5_32(src);
        if(md5_32 != null && md5_32.length() == 32)
        {
            String md5_16 = md5_32.substring(8, 24);
            if(md5_16.length() == 16)
            {
                return md5_16;
            }
        }
        return null;
    }

    public static String encryptWithAES(String string)
    {
        try
        {
            Cipher cp = Cipher.getInstance("AES");
            cp.init(Cipher.ENCRYPT_MODE, AES_KEY);
            byte[] ccc = cp.doFinal(string.getBytes());
            return parseByte2HexStr(ccc);
        } catch(Exception e)
        {
            throw new IllegalStateException("Encryption Failed!", e);
        }
    }

    public static String decryptAES(String string)
    {
        if(JText.isNullOrEmpty(string))
        {
            return null;
        }
        if(AES_KEY == null)
        {
            return null;
        }
        try
        {
            Cipher cp = Cipher.getInstance("AES");
            cp.init(Cipher.DECRYPT_MODE, AES_KEY);
            byte[] bytes = parseHexStr2Byte(string);
            if(bytes != null)
            {
                return new String(cp.doFinal(bytes));
            }
        } catch(Exception e)
        {
            throw new IllegalStateException("Decryption Failed!", e);
        }
        return null;
    }

    public static String encryptBASE64(String string)
    {
        if(JText.isNullOrEmpty(string))
        {
            return null;
        }
        return Base64.getEncoder().encodeToString(string.getBytes());
    }

    public static String decryptBASE64(String string)
    {
        if(JText.isNullOrEmpty(string))
        {
            return null;
        }
        return new String(Base64.getDecoder().decode(string.getBytes()));
    }

    private static String parseByte2HexStr(byte buf[])
    {
        StringBuilder sb = new StringBuilder(buf.length / 16);
        for(byte element : buf)
        {
            String hex = Integer.toHexString(element & 0xFF);
            if(hex.length() == 1)
            {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase(Locale.SIMPLIFIED_CHINESE));
        }
        return sb.toString();
    }

    private static byte[] parseHexStr2Byte(String hexStr)
    {
        if(hexStr.length() < 1)
        {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for(int i = 0; i < hexStr.length() / 2; i++)
        {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte)(high * 16 + low);
        }
        return result;
    }
}