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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        ListNode result = new ListNode();
        ListNode current = result;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            node = node.next;
            current = current.next;
            if (node != null) {
                minHeap.offer(node);
            }
        }
        return result.next;
    }
}
