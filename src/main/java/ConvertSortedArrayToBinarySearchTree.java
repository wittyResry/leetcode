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
 * @since 2018/09/08
 */
public class ConvertSortedArrayToBinarySearchTree {
    private static int idx = 0;
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode r = new TreeNode(nums[0]);
        dfs(r, nums, 1);
        //thread unsafe
        idx = 0;
        dfs2(r, nums);
        return r;
    }

    private void dfs(TreeNode r, int[] nums, int i) {
        int idx1 = 2 * i;
        int idx2 = 2 * i + 1;
        if (idx1 - 1 < nums.length) {
            r.left = new TreeNode(nums[idx1 - 1]);
            dfs(r.left, nums, idx1);
        }
        if (idx2 - 1 < nums.length) {
            r.right = new TreeNode(nums[idx2 - 1]);
            dfs(r.right, nums, idx2);
        }
    }

    private void dfs2(TreeNode r, int[] nums) {
        if (r.left != null) {
            dfs2(r.left, nums);
        }
        r.val = nums[idx++];
        if (r.right != null) {
            dfs2(r.right, nums);
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
