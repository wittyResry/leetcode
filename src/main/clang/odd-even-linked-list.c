/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
typedef struct ListNode ListNode;
struct ListNode* oddEvenList(struct ListNode* head) {
        ListNode* t = (ListNode *)malloc(1*sizeof(ListNode));
        t->next = head;
        ListNode* link1 = (ListNode *)malloc(1*sizeof(ListNode));
        ListNode* link2 = (ListNode *)malloc(1*sizeof(ListNode));
        link1 -> val = link2 -> val = -1;
        link1 -> next = NULL;
        link2 -> next = NULL;
        ListNode* head1 = link1;
        ListNode* head2 = link2;
        int cnt = 0;
        while (t->next != NULL) {
            if (cnt % 2 == 0) {
                link1->next = t->next;
                link1 = link1->next;
            } else {
                link2->next = t->next;
                link2 = link2->next;
            }
            t = t->next;
            cnt = cnt + 1;
        }
        link1->next = head2->next;
        link2->next = NULL;
        return head1->next;
}