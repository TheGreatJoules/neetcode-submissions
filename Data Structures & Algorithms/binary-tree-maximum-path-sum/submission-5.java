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
    int result;
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        int maxL = getMax(root.left);
        int maxR = getMax(root.right);
        result = Math.max(result, maxL + maxR + root.val);
        dfs(root.left);
        dfs(root.right);
    }

    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMax(root.left);
        int right = getMax(root.right);
        int current = root.val + Math.max(left, right);
        return Math.max(0, current);
    }

}
