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
    private Map<Integer, List<int[]>> cols;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        cols = new TreeMap<>();
        dfs(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (List<int[]> list : cols.values()) {
            Collections.sort(list, (a, b) -> a[0] - b[0]);
            List<Integer> colValues = new ArrayList<>();
            for (int[] p : list) {
                colValues.add(p[1]);
            }
            result.add(colValues);
        }
        return result;
    }

    private void dfs(TreeNode node, int row, int col) {
        if (node == null) {
            return;
        }
        cols.computeIfAbsent(col, v -> new ArrayList<>()).add(new int[]{row, node.val});
        dfs(node.left, row+1, col - 1);
        dfs(node.right, row+1, col + 1);

    }
}