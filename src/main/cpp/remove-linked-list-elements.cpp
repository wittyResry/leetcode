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
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* res = new ListNode(-1);
        res -> next = head;
        ListNode *tmp = res;
        while (tmp -> next != NULL) {
            if (tmp -> next -> val == val) {
                tmp -> next = tmp -> next -> next;//adjust tmp's next
            } else {
                tmp = tmp -> next;// jump to next
            }
        }
        return res -> next;
    }
};