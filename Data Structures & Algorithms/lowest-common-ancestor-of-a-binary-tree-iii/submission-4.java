/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node ptr1 = p;
        Node ptr2 = q;
        while (ptr1 != ptr2) {
            ptr1 = (ptr1 != null) ? ptr1.parent : p;
            ptr2 = (ptr2 != null) ? ptr2.parent : q;
        }
        return ptr2;
    }
}