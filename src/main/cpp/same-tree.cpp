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
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if (p == NULL && q == NULL) return true;
        if (p == NULL || q == NULL) return false;
        bool isSameValue = p -> val == q -> val;
        if (!isSameValue) return false;
        bool isSame1 = isSameTree(p -> left, q -> left);
        bool isSame2 = isSameTree(p -> right, q -> right);
        return isSame1 && isSame2;
    }
};