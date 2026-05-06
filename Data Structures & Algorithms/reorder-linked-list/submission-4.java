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
        reorderList(head, head.next);
    }

    private ListNode reorderList(ListNode left, ListNode right) {
        // Reaches end of the leftside, pop back
        if (left.next == null) {
            return left;
        }
        ListNode current = left;
        if (right.next != null) {
            current = reorderList(left, right.next);
        }
        if (current == null) {
            return null;
        }
        if (current == right || current.next == right) {
            right.next = null;
            return null;
        }
        right.next = current.next;
        current.next = right;
        return right.next;
    }
}
