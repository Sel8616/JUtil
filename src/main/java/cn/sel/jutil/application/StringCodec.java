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
import cn.sel.jutil.lang.JText;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * String encoder and decoder
 */
public class StringCodec
{
    /**
     * Encode a string using the specified charset.
     *
     * @param string  The string to be encoded.
     * @param charset The name of the charset.
     *
     * @return Encoded string.
     *
     * @throws UnsupportedEncodingException
     */
    @NonNull
    public static String encode(String string, String charset)
            throws UnsupportedEncodingException
    {
        byte[] bytes = string.getBytes();
        return JText.isNullOrEmpty(charset) ? new String(bytes) : new String(bytes, charset);
    }

    /**
     * Encode a string using the specified charset.
     *
     * @param string  The string to be encoded.
     * @param charset The charset.
     *
     * @return Encoded string.
     */
    @NonNull
    public static String encode(String string, Charset charset)
    {
        byte[] bytes = string.getBytes();
        return charset == null ? new String(bytes) : new String(bytes, charset);
    }

    /**
     * Decode a string using the specified charset.
     *
     * @param string  The string to be decoded.
     * @param charset The name of the charset.
     *
     * @return Decoded string.
     *
     * @throws UnsupportedEncodingException
     */
    @NonNull
    public static String decode(String string, String charset)
            throws UnsupportedEncodingException
    {
        byte[] bytes = JText.isNullOrEmpty(charset) ? string.getBytes() : string.getBytes(charset);
        return new String(bytes);
    }

    /**
     * Decode a string using the specified charset.
     *
     * @param string  The string to be decoded.
     * @param charset The charset.
     *
     * @return Decoded string.
     */
    @NonNull
    public static String decode(String string, Charset charset)
    {
        byte[] bytes = charset == null ? string.getBytes() : string.getBytes(charset);
        return new String(bytes);
    }
}