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
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) {
            return;
        }
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        dfs(node.left, result, level+1);
        dfs(node.right, result, level+1);
    }
}
