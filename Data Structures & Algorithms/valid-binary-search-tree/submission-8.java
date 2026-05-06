/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<Map.Entry<TreeNode, int[]>> queue = new LinkedList<>();
        queue.offer(new AbstractMap.SimpleEntry<>(root, new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE}));
        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, int[]> node = queue.poll();
            if (node.getKey().val <= node.getValue()[0] || node.getKey().val >= node.getValue()[1]) {
                return false;
            }
            if (node.getKey().left != null) {
                queue.offer(new AbstractMap.SimpleEntry<>(node.getKey().left, new int[] {node.getValue()[0], node.getKey().val}));
            }
            if (node.getKey().right != null) {
                queue.offer(new AbstractMap.SimpleEntry<>(node.getKey().right, new int[] {node.getKey().val, node.getValue()[1]}));
            }
        }
        return true;
    }
}
