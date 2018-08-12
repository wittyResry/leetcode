/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
#include <algorithm>
const int M = 1000005;
int a[M];
int cnt = 0;
struct Node{
    TreeNode* r;
}que[M];
void dfs(TreeNode* r, int &num, int &result, int k) {
    if (r == NULL) {
        return;
    }
    dfs(r -> left, num, result, k);
    if (num < k) {
        num = num + 1;
        if (num == k) {
            result = r -> val;
            return;
        }
    }
    if (num == k) return;
    dfs(r -> right, num, result, k);
}
class Solution {
public:

    int kthSmallest(TreeNode* root, int k) {
        int result = 0;
        int num = 0;
        dfs(root, num, result, k);
        return result;
    }
};