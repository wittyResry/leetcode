
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Qingyu Li
 * @since 2018/08/20
 */
public class AddAndSearchWordDataStructureDesign {

    public static final char   DOT = '.';
    Map<Integer, List<String>> g   = new HashMap<>();

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int l = word.length();
        List<String> val = g.computeIfAbsent(l, k -> new ArrayList<>());
        val.add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int l = word.length();
        List<String> val = g.get(l);
        if (val == null) {
            return false;
        }
        for (int i = 0; i < l; ++i) {
            char ch = word.charAt(i);
            if (ch != DOT) {
                val = filter(val, i, ch);
            }
        }
        return val.size() > 0;
    }

    /**
     * filter words
     *
     * @param val
     * @param pos
     * @param ch
     * @return
     */
    private List<String> filter(List<String> val, int pos, char ch) {
        List<String> res = new ArrayList<>();
        for (String s : val) {
            if (s.charAt(pos) == ch) {
                res.add(s);
            }
        }
        return res;
    }
}
