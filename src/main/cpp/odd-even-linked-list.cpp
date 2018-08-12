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
    ListNode* oddEvenList(ListNode* head) {
        ListNode* t = new ListNode(-1);
        t->next = head;
        ListNode* link1 = new ListNode(-1);
        ListNode* link2 = new ListNode(-1);
        ListNode* head1 = link1;
        ListNode* head2 = link2;
        int cnt = 0;
        while (t->next != NULL) {
            ListNode* nxt = t->next;
            if (cnt % 2 == 0) {
                link1->next = t->next;
                link1 = link1->next;
            } else {
                link2->next = t->next;
                link2 = link2->next;
            }
            t = nxt;
            cnt = cnt + 1;
        }
        link1->next = head2->next;
        link2->next = NULL;
        return head1->next;
    }
};