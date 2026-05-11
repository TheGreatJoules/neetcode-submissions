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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs1(result, root);
        return String.join(",", result);
    }

    private void dfs1(List<String> result, TreeNode node) {
        if (node == null) {
            result.add("$");
            return;
        }
        result.add(Integer.toString(node.val));
        dfs1(result, node.left);
        dfs1(result, node.right);
    }

    private int index;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        index = 0;
        return dfs2(values);
    }

    private TreeNode dfs2(String[] values) {
        if (values[index].equals("$")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(values[index]));
        index++;
        node.left = dfs2(values);
        node.right = dfs2(values);
        return node;
    }
}


















