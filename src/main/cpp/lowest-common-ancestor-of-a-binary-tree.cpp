/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
map<TreeNode*, TreeNode*>pa;
TreeNode* vec1[100005];int cnt1 = 0;
TreeNode* vec2[100005];int cnt2 = 0;
class Solution {
public:
    void dfs(TreeNode* root, TreeNode* pre) {
        if (root == NULL) return;
        pa[root] = pre;
        dfs(root -> left, root);
        dfs(root -> right, root);
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        dfs(root, root);
        TreeNode* p1 = p;
        if (p == root) return root;
        if (q == root) return root;
        while (p1 != root) {
            vec1[cnt1++] = p1;
            p1 = pa[p1];
        }
        vec1[cnt1++] = p1;
        TreeNode* q1 = q;
        while (q1 != root) {
            vec2[cnt2++] = q1;
            q1 = pa[q1];
        }
        vec2[cnt2++] = q1;
        int i, j;
        for (i = cnt1 -1, j = cnt2 - 1; i >= 0 && j >= 0; i--, j--) {
            if (vec1[i] != vec2[j]) break;
        }
        return vec1[i+1];
    }
};