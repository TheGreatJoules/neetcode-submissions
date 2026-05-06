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
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int p = 1, i = 0; p < preorder.length; p++) {
            TreeNode parent = null;
            while (!stack.isEmpty() && stack.peek().val == inorder[i] && i==i++) {
                parent = stack.pop();
            }
            TreeNode candidate = new TreeNode(preorder[p]);
            if (!stack.isEmpty() && parent == null) {
                parent = stack.peek();
                parent.left = candidate;
            } else {
                parent.right = candidate;
            }
            stack.push(candidate);
        }
        return root;
    }
}
