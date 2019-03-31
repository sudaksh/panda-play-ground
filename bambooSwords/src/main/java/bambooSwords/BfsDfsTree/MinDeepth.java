package bambooSwords.BfsDfsTree;

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
 */
public class MinDeepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDepth(root, 1);
    }
    public int minDepth(TreeNode root, int deep) {
        if (root.left == null && root.right == null) return deep;
        if (root.left == null) return minDepth(root.right, deep + 1);
        if (root.right == null) return minDepth(root.left, deep + 1);
        return Math.min(minDepth(root.right, deep + 1), minDepth(root.left, deep + 1));
    }
}
