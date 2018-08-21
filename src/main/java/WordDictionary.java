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

/**
 * @author Qingyu Li
 * @since 2018/08/21
 */
public class WordDictionary {

    private static final char DOT = '.';
    MyTrie r = new MyTrie();
    

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] s = word.toCharArray();
        MyTrie tmp = r;
        for (int i = 0; i < s.length; ++i) {
            int idx = s[i] - 'a';
            if (tmp.getR()[idx] == null) {
                tmp.getR()[idx] = new MyTrie();
            }
            tmp = tmp.getR()[idx];
            if (i == s.length - 1) {
                tmp.setVal(tmp.getVal() + 1);
            }
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        MyTrie tmp = r;
        return recurse(tmp, word, 0);
    }

    private boolean recurse(MyTrie tmp, String word, int cur) {
        if (cur == word.length()) {
            return tmp.getVal() > 0;
        }
        if (word.charAt(cur) == DOT) {
            for (int idx = 0; idx < 26; ++idx) {
                if (tmp.getR()[idx] != null && recurse(tmp.getR()[idx], word, cur + 1)) {
                    return true;
                }
            }
        } else {
            int idx = word.charAt(cur) - 'a';
            return tmp.getR()[idx] != null && recurse(tmp.getR()[idx], word, cur + 1);
        }
        return false;
    }

    private class MyTrie {
        private MyTrie[] r   = new MyTrie[26];
        private int      val = 0;

        /**
         * Getter method for property <tt>r</tt>.
         *
         * @return property value of r
         */
        public MyTrie[] getR() {
            return r;
        }

        /**
         * Setter method for property <tt>r</tt>.
         *
         * @param r value to be assigned to property r
         */
        public void setR(MyTrie[] r) {
            this.r = r;
        }

        /**
         * Getter method for property <tt>val</tt>.
         *
         * @return property value of val
         */
        public int getVal() {
            return val;
        }

        /**
         * Setter method for property <tt>val</tt>.
         *
         * @param val value to be assigned to property val
         */
        public void setVal(int val) {
            this.val = val;
        }
    }
}
