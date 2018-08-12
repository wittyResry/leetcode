/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
char num[1005];
int a1[1005];
class Solution {
public:
    void dfs(TreeNode *tree, int deep, int a[], vector<string>& res) {
        if (tree == NULL) return;
        a[deep] = tree -> val;
        if (tree -> left == NULL && tree -> right == NULL) {
            a[deep + 1] = -1;
            string s = "";
            for (int i = 0; i < deep + 1; ++i) {
                if (i == deep) {
                    sprintf(num, "%d", a[i]);
                } else {
                    sprintf(num, "%d->", a[i]);
                }
                s += num;
            }
            res.push_back(s);
        }
        if (tree -> left) dfs(tree -> left, deep+1, a, res);
        if (tree -> right) dfs(tree -> right, deep+1, a, res);
    }
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> res;
        dfs(root, 0, a1, res);
        return res;
    }
};