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
        dfs(result, root);
        return String.join(",", result);
    }

    private void dfs(List<String> result, TreeNode node) {
        if (node == null) {
            result.add("$");
            return;
        }
        result.add(Integer.toString(node.val));
        dfs(result, node.left);
        dfs(result, node.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] index = {0};
        return dfs2(values, index);
    }

    private TreeNode dfs2(String[] values, int[] index) {
        if (values[index[0]].equals("$")) {
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;
        node.left = dfs2(values, index);
        node.right = dfs2(values, index);
        return node;
    }
}


















