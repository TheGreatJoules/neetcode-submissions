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
    Map<Integer, List<Pair<Integer, Integer>>> map;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new TreeMap<>();
        dfs(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Pair<Integer, Integer>> list : map.values()) {
            List<Integer> current = new ArrayList<>();
            Collections.sort(list, (a, b) -> a.getKey() - b.getKey());
            for (Pair<Integer, Integer> pair : list) {
                current.add(pair.getValue());
            }
            result.add(current);
        }
        return result;
    }
    private void dfs(TreeNode node, int row, int col) {
        if (node == null) {
            return;
        }
        map.computeIfAbsent(col, v -> new ArrayList<>()).add(new Pair<>(row, node.val));
        dfs(node.left, row+1, col-1);
        dfs(node.right, row+1, col+1);
    }
}