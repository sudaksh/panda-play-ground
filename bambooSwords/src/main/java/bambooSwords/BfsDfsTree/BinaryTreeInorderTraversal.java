package bambooSwords.BfsDfsTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
 */
public class BinaryTreeInorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root;
        while (n != null){
            stack.push(n);
            n = n.left;
        }

        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null){
                n = cur.right;
                while (n != null){
                    stack.push(n);
                    n = n.left;
                }
            }
        }
        return res;
    }

    public List<Integer> inorderTraversalII(TreeNode root) {
        if (root == null) return res;
        inorderTraversalII(root.left);
        res.add(root.val);
        inorderTraversalII(root.right);
        return res;
    }
}
