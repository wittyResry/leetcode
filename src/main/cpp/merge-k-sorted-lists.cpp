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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode*h = new ListNode(-1);
        ListNode*tmp = h;
        for (;l1 && l2;) {
            if (l1 -> val < l2 -> val) {
                tmp -> next = l1;
                tmp = l1;
                l1 = l1 -> next;
            } else {
                tmp -> next = l2;
                tmp = l2;
                l2 = l2 -> next;
            }
        }
        if (l1) tmp -> next = l1;
        if (l2) tmp -> next = l2;
        return h -> next;
    }
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if (lists.empty()) return NULL;
        if (lists.size() == 1) {
            return lists[0];
        }
        int mid = lists.size() / 2;
        vector<ListNode*> lists1;for (int i = 0; i < mid; ++i) lists1.push_back(lists[i]);
        vector<ListNode*> lists2;for (int i = mid; i < lists.size(); ++i) lists2.push_back(lists[i]);
        ListNode* l1 = mergeKLists(lists1);
        ListNode* l2 = mergeKLists(lists2);
        return mergeTwoLists(l1, l2);
    }
};