
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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Qingyu Li
 * @since 2018/08/27
 */
public class BinaryTreeLevelOrderTraversalSolve2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<Item> q = new LinkedList<>();
        q.add(new Item(root.val, 0, root));
        for (; !q.isEmpty();) {
            Item tail = q.poll();
            if (tail.getHigh() >= res.size()) {
                res.add(new ArrayList<>());
            }
            List cur = res.get(tail.getHigh());
            cur.add(tail.getVal());
            TreeNode node = tail.node;
            if (node.left != null) {
                q.add(new Item(node.left.val, tail.getHigh() + 1, node.left));
            }
            if (node.right != null) {
                q.add(new Item(node.right.val, tail.getHigh() + 1, node.right));
            }
        }
        return res;
    }

    public static class Item {
        private int      val;
        private int      high;
        private TreeNode node;

        Item(int val, int high, TreeNode node) {
            this.val = val;
            this.high = high;
            this.node = node;
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
         * Getter method for property <tt>high</tt>.
         *
         * @return property value of high
         */
        public int getHigh() {
            return high;
        }

        /**
         * Setter method for property <tt>high</tt>.
         *
         * @param high value to be assigned to property high
         */
        public void setHigh(int high) {
            this.high = high;
        }
    }

    public static class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
