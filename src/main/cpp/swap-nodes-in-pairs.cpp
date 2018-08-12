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
    ListNode* swapPairs(ListNode* head) {
        ListNode*t = new ListNode(-1);
        t -> next = head;
        if (head == NULL || head -> next == NULL) return head;
        ListNode*ret = head -> next;
        while ( t != NULL && t -> next != NULL && t -> next -> next != NULL) {
            ListNode*nxt1 = t -> next;
            ListNode*nxt2 = t -> next -> next;
            ListNode*nxt3 = t -> next -> next -> next;
            nxt1 -> next = nxt3;
            nxt2 -> next = nxt1;
            t -> next = nxt2;
            t = nxt1;
         }
         return ret;
    }
};