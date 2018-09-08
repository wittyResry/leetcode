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
 * @since 2018/09/09
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        int split = 0;
        while (split < preorder.length && preorder[0] != inorder[split]) {
            ++split;
        }
        if (split >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (split > 0) {
            int[] preLeftTree = new int[split];
            int[] inLeftTree = new int[split];
            System.arraycopy(preorder, 1, preLeftTree, 0, split);
            System.arraycopy(inorder, 0, inLeftTree, 0, split);
            root.left = buildTree(preLeftTree, inLeftTree);
        }
        if (preorder.length - split - 1 > 0) {
            int[] preRightTree = new int[preorder.length - split - 1];
            int[] inRightTree = new int[preorder.length - split - 1];
            System.arraycopy(preorder, split + 1, preRightTree, 0, preorder.length - split - 1);
            System.arraycopy(inorder, split + 1, inRightTree, 0, preorder.length - split - 1);
            root.right = buildTree(preRightTree, inRightTree);
        }
        return root;
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
