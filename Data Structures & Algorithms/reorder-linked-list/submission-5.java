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
        ListNode current = right.next != null ? reorderList(left, right.next) : left;
        // If even and Im at the last entry
        if (current == null) {
            return null;
        }
        // If im on the the edge case for even or odd, set the last pointer to null
        if (current == right || current.next == right) {
            right.next = null;
            return right.next;
        }

        right.next = current.next;
        current.next = right;
        return right.next;
    }
}
