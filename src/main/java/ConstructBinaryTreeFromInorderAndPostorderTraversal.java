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
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        int split = inorder.length - 1;
        while (split >= 0 && postorder[inorder.length - 1] != inorder[split]) {
            --split;
        }
        if (split < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[inorder.length - 1]);
        if (split > 0) {
            int[] inLeftTree = new int[split];
            int[] postLeftTree = new int[split];
            System.arraycopy(inorder, 0, inLeftTree, 0, split);
            System.arraycopy(postorder, 0, postLeftTree, 0, split);
            root.left = buildTree(inLeftTree, postLeftTree);
        }
        if (inorder.length - 1 - split > 0) {
            int[] inRightTree = new int[inorder.length - 1 - split];
            int[] postRightTree = new int[inorder.length - 1 - split];
            System.arraycopy(inorder, split + 1, inRightTree, 0, inorder.length - 1 - split);
            System.arraycopy(postorder, split, postRightTree, 0, inorder.length - 1 - split);
            root.right = buildTree(inRightTree, postRightTree);
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
