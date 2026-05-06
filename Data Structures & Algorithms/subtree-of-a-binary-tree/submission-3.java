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

public class Solution {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "$#";
        }
        return "$" + root.val + serialize(root.left) + serialize(root.right);
    }

    public int[] z_function(String s, int pivot) {
        int[] z = new int[s.length()];
        for (int i = pivot; i < s.length(); i++) {
            while (i + z[i] < s.length() && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
        }
        return z;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String serialized_root = serialize(root);
        String serialized_subRoot = serialize(subRoot);
        String combined = serialized_subRoot + "|" + serialized_root;

        int[] z_values = z_function(combined, serialized_subRoot.length()+1);
        int sub_len = serialized_subRoot.length();

        for (int i = sub_len + 1; i < combined.length(); i++) {
            if (z_values[i] == sub_len) {
                return true;
            }
        }
        return false;
    }
}