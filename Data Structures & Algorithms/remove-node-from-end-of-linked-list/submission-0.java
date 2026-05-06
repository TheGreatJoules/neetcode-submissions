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
    private int size;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            size = 0;
            return head;
        }
        head.next = removeNthFromEnd(head.next, n);
        size++;
        if (size == n) {
            return head.next;
        }
        return head;
    }
}
