/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
int a[100005];
int cnt;
class Solution {
public:

    bool isPalindrome(ListNode* head) {
        ListNode* t = new ListNode(-1);
        t -> next = head;
        cnt = 0;
        while(t -> next != NULL) {
            t = t -> next;
            int val = t -> val;
            a[cnt++] = val;
        }
        for (int i = 0; i < cnt; ++i) if (a[i] != a[cnt - i - 1] ) return false;
        return true;
    }
};