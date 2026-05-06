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
    public int maxDepth(TreeNode root) {
        return dfs(root, 0, 0);
    }

    private int dfs(TreeNode root, int level, int max) {
        if (root == null) {
            return level;
        }
        int left = dfs(root.left, level + 1, max);
        int right = dfs(root.right, level + 1, max);
        return Math.max(left, right);
    }
}
