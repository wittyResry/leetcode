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
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* h = new ListNode(-1);
        h -> next = head;
        ListNode* tr = h;
        for (; tr -> next != NULL; tr = tr -> next) {
            while (tr -> next -> next != NULL) {
                int val1 = tr -> next -> val;
                int val2 = tr -> next -> next -> val;
                if (val1 == val2) {
                    tr -> next = tr -> next -> next;
                } else {
                    break;
                }
            }
        }
        return h -> next;
    }
};