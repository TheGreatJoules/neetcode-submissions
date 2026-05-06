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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode parent = new TreeNode(preorder[0]);
        TreeNode root = parent;
        for (int i = 1, j = 0; i < preorder.length; i++) {
            TreeNode current = new TreeNode(preorder[i]);
            if (parent.val != inorder[j]) {
                parent.left = current;
                current.right = parent;
            } else {
                j++;
                while (parent.right != null && parent.right.val == inorder[j]) {
                    TreeNode temp = parent;
                    parent = parent.right;
                    temp.right = null;
                    j++;
                }
                current.right = parent.right;
                parent.right = current;
            }
            parent = current;
        }
        while (parent.right != null) {
            TreeNode temp = parent.right;
            parent.right = null;
            parent = temp;
        }
        return root;
    }
}
