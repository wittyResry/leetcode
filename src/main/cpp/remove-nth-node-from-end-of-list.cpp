/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        
        ListNode* t = new ListNode(-1);
        t -> next = head;
        ListNode* tr = t;
        int sz = 0;
        for (; tr -> next != NULL; tr = tr -> next) ++sz;
        int del = sz - n;
        tr = t;
        for (; tr != NULL && del > 0; del--, tr = tr -> next);
        tr -> next = tr -> next -> next;
        return t -> next;
    }
};