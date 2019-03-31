package bambooSwords.BfsDfsTree;

/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        sumOfLeftLeaves(root, false);
        return sum;
    }
    public void sumOfLeftLeaves(TreeNode t, boolean isLeft){
        if (t == null) return;
        if (t.left == null && t.right == null && isLeft){
            sum = sum + t.val;
        }
        sumOfLeftLeaves(t.left, true);
        sumOfLeftLeaves(t.right, false);
    }
}
