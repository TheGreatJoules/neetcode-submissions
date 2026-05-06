/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        reorderList(head, head.next);
    }

    private ListNode reorderList(ListNode left, ListNode current) {
        ListNode temp = left;
        if (current.next != null) {
            temp = reorderList(left, current.next);
        }
        if (temp == null) {
            return null;
        }
        if (temp == current || temp.next == current) {
            current.next = null;
            return null;
        }
        current.next = temp.next;
        temp.next = current;
        return current.next;
    }
}
