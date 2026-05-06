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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> cmap = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            TreeNode node = current.getKey();
            int cIndex = current.getValue();
            cmap.computeIfAbsent(cIndex, v -> new ArrayList<>()).add(node.val);
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, cIndex - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, cIndex+1));
            }
        }
        return new ArrayList<>(cmap.values());
    }
}