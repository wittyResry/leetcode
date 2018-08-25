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
 * @since 2018/08/25
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        int high = getHigh(root);
        Integer[] v1 = new Integer[1 << high];
        dfs(v1, 1, root);
        rev(root);
        Integer[] v2 = new Integer[1 << high];
        dfs(v2, 1, root);
        for (int i = 0; i < (1 << high); ++i) {
            if (v1[i] == null) {
                if (v2[i] != null) {
                    return false;
                }
            } else if (!v1[i].equals(v2[i])) {
                return false;
            }
        }
        return true;
    }

    private void rev(TreeNode root) {
        if (root == null) {
            return;
        }
        rev(root.left);
        rev(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    private void dfs(Integer[] v1, int idx, TreeNode root) {
        if (root == null) {
            return;
        }
        v1[idx] = root.val;
        dfs(v1, 2 * idx, root.left);
        dfs(v1, 2 * idx + 1, root.right);
    }

    private int getHigh(TreeNode root) {
        return root == null ? 0 : 1 + Integer.max(getHigh(root.left), getHigh(root.right));
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
