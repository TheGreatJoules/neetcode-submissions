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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                if (--k == 0) {
                    return current.val;
                }
                current = current.right;
            } else {
                TreeNode temp = current.left;
                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = current;
                    current = current.left;
                } else if (temp.right == current) {
                    temp.right = null;
                    if (--k == 0) {
                        return current.val;
                    }
                    current = current.right;
                }
            }
        }
        return -1;
    }
}
