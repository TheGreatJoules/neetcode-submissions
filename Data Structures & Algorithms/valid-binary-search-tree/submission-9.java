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
            Map.Entry<TreeNode, int[]> current = queue.poll();
            TreeNode node = current.getKey();
            int min = current.getValue()[0];
            int max = current.getValue()[1];
            if (node.val <= min || node.val >= max) {
                return false;
            }
            if (node.left != null) {
                queue.offer(new AbstractMap.SimpleEntry<>(node.left, new int[] {min, node.val}));
            }
            if (node.right != null) {
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, new int[] {node.val, max}));
            }
        }
        return true;
    }
}
