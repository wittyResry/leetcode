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
    ListNode *reverseKGroup(ListNode *head, int k) {
        if (head == NULL) return NULL;
        int len = 1;
        ListNode *a = head;
        while (a -> next != NULL) {
            a = a -> next;
            len = len + 1;
        }
        if (k == 1) return head;
        if (k > len) return head;
        if (k == len) {
            ListNode *pre = head;
            ListNode temp = ListNode(-1);
            ListNode *tmp = &temp;
            tmp -> next = NULL;
            while (true) {
                ListNode *pre_next = pre -> next;
                pre -> next = tmp -> next;
                tmp -> next = pre;
                pre = pre_next;
                if (pre_next == NULL) break;
            }
            return tmp -> next;
        } else {
            ListNode *pre = head;
            ListNode temp = ListNode(-1);
            ListNode *tmp = &temp;
            ListNode *ret = &temp;
            tmp -> next = NULL;
            int cnt = 0;
            while (true) {
                ListNode *pre_next = pre -> next;
                if (cnt % k + (len - 1 - cnt) >= k - 1) {
                    pre -> next = tmp ->next;
                    tmp -> next = pre;
                } else {
                    pre -> next = tmp ->next;
                    tmp -> next = pre;
                    tmp = pre;
                }
                pre = pre_next;
                cnt = cnt + 1;
                if (cnt % k == 0) {
                    while (tmp -> next != NULL) {
                        tmp = tmp -> next;
                    }
                }
                pre = pre_next;
                if (pre_next == NULL) break;
            }
            return ret -> next;
        }
    }
};