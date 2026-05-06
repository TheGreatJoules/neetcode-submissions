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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(TreeNode root, List<List<Integer>> result, List<Integer> current, int level) {
        if (root == null) {
            return;
        }
        if (result.size() < level+1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, result, current, level + 1);
        dfs(root.right, result, current, level + 1);
        // result.get(level).add(root.val);
    }
}
