/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode h1 = new ListNode(-1);
        h1.next = l1;
        ListNode h2 = new ListNode(-1);
        h2.next = l2;
        ListNode r = new ListNode(-1);
        ListNode t = r;
        ListNode t1 = l1;
        ListNode t2 = l2;
        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                t.next = t1;
                t = t1;
                t1 = t1.next;
            } else {
                t.next = t2;
                t = t2;
                t2 = t2.next;
            }
        }
        while (t1 != null) {
            t.next = t1;
            t = t1;
            t1 = t1.next;
        }
        while(t2 != null) {
            t.next = t2;
            t = t2;
            t2 = t2.next;
        }
        return r.next;
    }
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        if (lists.size() == 1) return lists.get(0);
        int mid = (lists.size() - 1) / 2;
        ListNode l1 = mergeKLists(lists.subList(0, mid+1));
        ListNode l2 = mergeKLists(lists.subList(mid+1, lists.size()));
        return mergeTwoLists(l1, l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> lists1 = Arrays.asList(lists);
        return mergeKLists(lists1);
        
    }
}