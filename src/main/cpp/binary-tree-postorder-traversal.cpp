/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
const int M = 100005;
int cnt = 0;
int res[M];
class Solution {
public:
    void dfs(TreeNode* root) {
        if (root -> left != NULL) {
            dfs(root -> left);
        }
        if (root -> right != NULL) {
            dfs(root -> right);
        }
        res[cnt++] = root -> val;
    }
    vector<int> postorderTraversal(TreeNode* root) {
        cnt = 0;
        if (root != NULL)
            dfs(root);
        vector<int> vec;
        for (int i = 0; i < cnt; ++i)
            vec.push_back(res[i]);
        return vec; 
    }
};