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
 * @since 2018/08/18
 */
public class ImplementTriePrefixTree {
    private MyTrie r = new MyTrie();

    /** Initialize your data structure here. */
    public ImplementTriePrefixTree() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] s = word.toCharArray();
        MyTrie tmp = r;
        for (int i = 0; i < s.length; ++i) {
            int idx = s[i] - 'a';
            if (tmp.getR()[idx] == null) {
                return false;
            }
            tmp = tmp.getR()[idx];
        }
        return tmp.getVal() > 0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] s = prefix.toCharArray();
        MyTrie tmp = r;
        for (int i = 0; i < s.length; ++i) {
            int idx = s[i] - 'a';
            if (tmp.getR()[idx] == null) {
                return false;
            }
            tmp = tmp.getR()[idx];
        }
        return true;
    }

    private class MyTrie {
        private MyTrie[] r   = new MyTrie[26];
        int            val = 0;

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
