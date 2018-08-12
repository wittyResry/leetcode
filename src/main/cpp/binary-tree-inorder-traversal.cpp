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
    void dfs(TreeNode* root, vector<int> & vec) {
        if (root == NULL) return;
        if (root -> left) dfs(root -> left, vec);
        vec.push_back(root -> val);
        if (root -> right) dfs(root -> right, vec);
    }
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> st;
        TreeNode*p = root;
        while(p != NULL || !st.empty()) {
            if (p != NULL) {
                st.push(p);
                p = p -> left;
                continue;
            }
            if (!st.empty()) {
                p = st.top();
                st.pop();
                res.push_back(p -> val);
                if (p -> right != NULL) p = p -> right;
                else p = NULL;
            }
        }
        return res;
    }
};