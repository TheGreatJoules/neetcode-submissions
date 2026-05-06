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
        if (data == null || data.isEmpty() || data.equals("#")) {
            return null;
        }
        int left = 0;
        int right = data.indexOf(',');
        TreeNode root = new TreeNode(Integer.parseInt(data.substring(left, right)));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            for (int i = 0; i < 2; i++) {
                left = right+1;
                right = data.indexOf(',', left);
                String subWindow = data.substring(left, right > 0 ? right : data.length());
                if (!subWindow.equals("#")) {
                    int value = Integer.parseInt(subWindow);
                    TreeNode child = new TreeNode(value);
                    queue.offer(child);
                    if (i == 0) {
                        parent.left = child;
                    } else {
                        parent.right = child;
                    }
                }

            }       
        }
        return root;
    }
}
