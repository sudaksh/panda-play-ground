package bambooSwords.BfsDfsTree;

public class MaximumDepthOfNaryTree {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null || root.children.size() == 0) return 1;
        int max = 0;
        for (Node n : root.children){
            max = Math.max(max, maxDepth(n));
        }
        return max + 1;
    }
}
