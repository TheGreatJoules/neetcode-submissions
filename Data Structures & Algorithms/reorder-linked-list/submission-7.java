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
        if (left.next == null) {
            return left;
        }
        if (right.next != null) {
            left = reorderList(left, right.next);
        }
        if (left == null) {
            return null;
        }

        if (left != null && left != right && left.next != right) {
            right.next = left.next;
            left.next = right;
            return right.next;
        }
        return right.next = null;
    }
}
