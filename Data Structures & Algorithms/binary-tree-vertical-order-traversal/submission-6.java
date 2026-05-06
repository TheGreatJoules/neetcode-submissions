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
        Map<Integer, List<Integer>> cmap = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            TreeNode node = current.getKey();
            int colIndex = current.getValue();
            cmap.computeIfAbsent(colIndex, v -> new ArrayList<>()).add(node.val);
            minCol = Math.min(minCol, colIndex);
            maxCol = Math.max(maxCol, colIndex);
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, colIndex-1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, colIndex+1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = minCol; i <= maxCol; i++) {
            List<Integer> list = cmap.getOrDefault(i, new ArrayList<>());
            List<Integer> currentList = new ArrayList<>();
            for (int val : list) {
                currentList.add(val);
            }
            result.add(currentList);
        }
        return result;
    }
}