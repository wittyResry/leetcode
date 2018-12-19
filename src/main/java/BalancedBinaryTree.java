
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

import java.util.HashMap;
import java.util.Map;

/**
 * @author Qingyu Li
 * @since 2018/12/12
 */
public class BalancedBinaryTree {

    /** 每个节点子树的高度 */
    private static final Map<TreeNode, Integer> h = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        h.clear();
        calc(root);
        return check(root);
    }

    private boolean check(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = h.get(root.left) == null ? 0 : h.get(root.left);
        int r = h.get(root.right) == null ? 0 : h.get(root.right);
        return Math.abs(l - r) <= 1 && check(root.left) && check(root.right);
    }

    private void calc(TreeNode root) {
        if (root.left != null) {
            calc(root.left);
        }
        if (root.right != null) {
            calc(root.right);
        }
        int l = h.get(root.left) == null ? 0 : h.get(root.left);
        int r = h.get(root.right) == null ? 0 : h.get(root.right);
        h.put(root, 1 + Math.max(l, r));
    }

    public static class TreeNode {
        int                         val;
        BalancedBinaryTree.TreeNode left;
        BalancedBinaryTree.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
