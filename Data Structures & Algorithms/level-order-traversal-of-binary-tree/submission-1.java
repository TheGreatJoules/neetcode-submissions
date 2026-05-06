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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode current = queue.poll();
                if (current != null) {
                    list.add(current.val);
                    queue.offer(current.left);
                    queue.offer(current.right);
                } 
            }
            if (list.size() > 0) {
                result.add(list);
            }
            
        }
        return result;
    }
}
