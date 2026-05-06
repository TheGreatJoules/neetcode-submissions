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
        System.out.println("SERIALIZED: " + data);
        int left = 0;
        int right = data.indexOf(',');
        TreeNode root = new TreeNode(Integer.parseInt(data.substring(left, right)));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            // Left Side //
            left = right+1;
            right = data.indexOf(',', left);
            String subWindowL = data.substring(left, right);
            if (!subWindowL.equals("#")) {
                int valueL = Integer.parseInt(subWindowL);
                TreeNode childL = new TreeNode(valueL);
                parent.left = childL;
                queue.offer(childL);
            }
            // Right Side //
            left = right+1;
            right = data.indexOf(',', left);
            String subWindowR = data.substring(left, right > 0 ? right : data.length());
            if (!subWindowR.equals("#")) {
                int valueR = Integer.parseInt(subWindowR);
                TreeNode childR = new TreeNode(valueR);
                parent.right = childR;
                queue.offer(childR);
            }
            
        }
        return root;
    }
}
