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
    private Map<Integer, List<int[]>> columns;
    private int minCol;
    private int maxCol;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        minCol = Integer.MAX_VALUE;
        maxCol = Integer.MIN_VALUE;
        columns = new HashMap<>();
        if (root == null) {
            return new ArrayList<>();
        }
        dfs(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = minCol; i <= maxCol; i++) {
            if (columns.containsKey(i)) {
                List<int[]> current = columns.get(i);
                Collections.sort(current, (a, b) -> a[0] - b[0]); // sort by row
                List<Integer> columnValues = new ArrayList<>();
                for (int[] c : current) {
                    columnValues.add(c[1]);
                }
                result.add(columnValues);
            }
        }
        return result;
    }

    private void dfs(TreeNode node, int row, int col) {
        if (node == null) {
            return;
        }
        columns.computeIfAbsent(col, v -> new ArrayList<>()).add(new int[] {row, node.val});
        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);
        dfs(node.left, row+1, col-1);
        dfs(node.right, row+1, col+1);
    }
}