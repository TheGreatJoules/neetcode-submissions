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
    // Preorder for serialization
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                sb.append("#").append(!queue.isEmpty()?",":"");
            } else {
                sb.append(current.val).append(",");
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String[] values = data.split(",");
        if (values[0].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!values[index].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(node.left);
            }
            index++;
            if (!values[index].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }
}
