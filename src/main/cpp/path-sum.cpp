/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool hasPathSum(TreeNode* root, int sum) {
        if (root == NULL) {
            return false;
        }
        return dfs(root, sum);
    }
    bool dfs(TreeNode* root, int sum) {
        if (root -> left == NULL && root -> right == NULL) {
            return root -> val == sum;
        }
        if (root -> left != NULL && dfs(root -> left, sum - root -> val)) {
            return true;
        }
        if (root -> right != NULL && dfs(root -> right, sum - root -> val)) {
            return true;
        }
        return false;
    }
};