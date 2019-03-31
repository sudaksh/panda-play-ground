package bambooSwords.BfsDfsTree;

import java.util.*;

/*
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        TreeNode res = root;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            size--;
            if (cur.right != null) {
                queue.add(cur.right);
            }
            if (cur.left != null) {
                queue.add(cur.left);
            }
            res = cur;
            if (size == 0 && !queue.isEmpty()){
                size = queue.size();
            }
        }
        return res.val;
    }
}
