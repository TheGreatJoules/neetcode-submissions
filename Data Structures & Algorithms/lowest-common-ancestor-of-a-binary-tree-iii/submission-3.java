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
        int h1 = height(p);
        int h2 = height(q);
        // We want H1 to be bigger
        if (h1 < h2) {
            Node tempNode = q;
            q = p;
            p = tempNode;
            int tempHeight = h1;
            h1 = h2;
            h2 = tempHeight;
        }

        int diff = h1 - h2;
        while (diff > 0) {
            p = p.parent;
            diff--;
        }

        while (p != q) {
            q = q.parent;
            p = p.parent;
        }
        return p;
    }

    private int height(Node node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.parent;
        }
        return h;
    }
}