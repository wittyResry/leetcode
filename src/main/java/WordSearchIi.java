
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Qingyu Li
 * @since 2018/08/23
 */
public class WordSearchIi {

    private MyTrie       r  = new MyTrie();
    private Map<String, Integer> mp = new HashMap<>();

    public List<String> findWords(char[][] board, String[] words) {
        //异常输入处理
        if (board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<>();
        }
        for (String word : words) {
            addWord(word);
            Integer t = mp.get(word);
            if (t == null) {
                mp.put(word, 0);
            } else {
                mp.put(word, 1 + mp.get(word));
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                char ch = board[i][j];
                if (r.containChar(ch)) {
                    char tmp = board[i][j];
                    board[i][j] = '.';
                    dfs(0, i, j, r.getMyTrie(ch), board, new StringBuilder().append(ch), res);
                    board[i][j] = tmp;
                }
            }
        }
        Collections.sort(res);
        List<String> uniq = new ArrayList<>();
        for (int i = 0; i < res.size(); ++i) {
            if (i == 0 || !equals(res.get(i), res.get(i - 1))) {
                uniq.add(res.get(i));
            }
        }

        return uniq;
    }

    public static boolean equals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }

    /** Adds a word into the data structure. */
    private void addWord(String word) {
        char[] s = word.toCharArray();
        MyTrie tmp = r;
        for (int i = 0; i < s.length; ++i) {
            int idx = s[i] - 'a';
            if (tmp.getR()[idx] == null) {
                tmp.getR()[idx] = new MyTrie();
            }
            tmp = tmp.getR()[idx];
            tmp.setVal(tmp.getVal() + 1);
            if (i == s.length - 1) {
                tmp.setLeaf(true);
            }
        }
    }

    private void deleteWord(String word) {
        char[] s = word.toCharArray();
        MyTrie tmp = r;
        for (int i = 0; i < s.length; ++i) {
            int idx = s[i] - 'a';
            tmp = tmp.getR()[idx];
            tmp.setVal(tmp.getVal() - 1);
            if (i == s.length - 1 && tmp.getVal() == 0) {
                tmp.setLeaf(false);
            }
        }
    }

    private static final int[] dx = new int[] { 1, 0, -1, 0 };
    private static final int[] dy = new int[] { 0, 1, 0, -1 };

    private void dfs(int deep, int i, int j, MyTrie cur, char[][] board, StringBuilder sb,
                     List<String> res) {
        if (cur.isLeaf()) {
            res.add(sb.toString());
            if (mp.get(sb.toString()) > 0) {
                deleteWord(sb.toString());
                mp.put(sb.toString(), mp.get(sb.toString()) - 1);
            }
        }
        for (int dir = 0; dir < 4; ++dir) {
            int tx = dx[dir] + i;
            int ty = dy[dir] + j;
            if (tx < 0 || ty < 0 || tx >= board.length || ty >= board[0].length) {
                continue;
            }
            if (cur.containChar(board[tx][ty])) {
                sb.append(board[tx][ty]);
                char tmp = board[tx][ty];
                board[tx][ty] = '.';
                dfs(deep + 1, tx, ty, cur.getMyTrie(tmp), board, sb, res);
                board[tx][ty] = tmp;
                sb.delete(sb.length() - 1, sb.length());
            }
        }

    }

    private class MyTrie {
        private MyTrie[] r   = new MyTrie[26];
        private int      val = 0;
        private boolean  leaf;

        private boolean containChar(char ch) {
            if (ch == '.') {
                return false;
            }
            int idx = ch - 'a';
            if (this.getR()[idx] == null) {
                return false;
            }
            if (this.getR()[idx].getVal() == 0) {
                return false;
            }
            return true;
        }

        private MyTrie getMyTrie(char ch) {
            int idx = ch - 'a';
            return this.getR()[idx];
        }

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

        /**
         * Getter method for property <tt>leaf</tt>.
         *
         * @return property value of leaf
         */
        public boolean isLeaf() {
            return leaf;
        }

        /**
         * Setter method for property <tt>leaf</tt>.
         *
         * @param leaf value to be assigned to property leaf
         */
        public void setLeaf(boolean leaf) {
            this.leaf = leaf;
        }
    }
}
