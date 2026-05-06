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
    int counter = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || counter >= k) {
            return -1;
        }
        int left = kthSmallest(root.left, k);
        if (counter++ == k-1) {
            return root.val;
        }
        int right = kthSmallest(root.right, k);
        return left != -1 ? left : right;
    }
}
