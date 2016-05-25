/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
int a[100005];
int deep;
class Solution {
public:
    void dfs(TreeNode* root, int sum, int cursum, vector<vector<int>> &res, int a[], int deep) {
        a[deep++] = root -> val;
        cursum += root -> val;
        if (root -> left == NULL && root -> right == NULL) {
            if (cursum == sum && deep > 0) {
                vector<int> tmp;
                for (int i = 0; i < deep; ++i) tmp.push_back(a[i]);
                res.push_back(tmp);
            }
            return;
        }
        if (root -> left) dfs(root -> left, sum, cursum, res, a, deep);
        if (root -> right) dfs(root -> right, sum, cursum, res, a, deep);
    }
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<vector<int>> res;
        if (root == NULL) return res;
        dfs(root, sum, 0, res, a, 0);
        return res;
    }
};