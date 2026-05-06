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
    int depth;
    public int maxDepth(TreeNode root) {
        depth = 0;
        dfs(root, 0);
        return depth;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            depth = Math.max(depth, level);
            return;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
