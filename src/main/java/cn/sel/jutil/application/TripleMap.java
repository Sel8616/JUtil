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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A new type of map with 2 keys.
 */
public class TripleMap<K1, K2, V>
{
    private final boolean isFirstKeysNullable;
    private final boolean isSecondKeysNullable;
    private final HashMap<K1, HashMap<K2, V>> MAP;

    public TripleMap()
    {
        this(true, true);
    }

    public TripleMap(boolean isFirstKeysNullable, boolean isSecondKeysNullable)
    {
        this.isFirstKeysNullable = isFirstKeysNullable;
        this.isSecondKeysNullable = isSecondKeysNullable;
        MAP = new HashMap<>();
    }

    public void put(K1 key1, K2 key2, V value)
    {
        if(!isFirstKeysNullable)
        {
            Objects.requireNonNull(key1, "The first KEY could not be null!");
        }
        if(!isSecondKeysNullable)
        {
            Objects.requireNonNull(key2, "The second KEY could not be null!");
        }
        HashMap<K2, V> map = MAP.computeIfAbsent(key1, k->new HashMap<>());
        map.put(key2, value);
    }

    public V get(K1 key1, K2 key2)
    {
        if(!isFirstKeysNullable)
        {
            Objects.requireNonNull(key1, "The first KEY could not be null!");
        }
        if(!isSecondKeysNullable)
        {
            Objects.requireNonNull(key2, "The second KEY could not be null!");
        }
        Map<K2, V> map = MAP.get(key1);
        return map == null ? null : map.get(key2);
    }
}