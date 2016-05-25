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
    ListNode* reverseList(ListNode* head) {
        ListNode* t = new ListNode(-1);
        t -> next = head;
        
        ListNode *tmp = new ListNode(-1);
        tmp -> next = NULL;
        
        while (t -> next != NULL) {
            ListNode *nxt = t -> next -> next;
            t -> next -> next = tmp -> next;
            tmp -> next = t -> next;
            t -> next = nxt;
        }
        return tmp -> next;
    }
};