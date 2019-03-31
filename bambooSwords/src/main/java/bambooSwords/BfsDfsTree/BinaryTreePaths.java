package bambooSwords.BfsDfsTree;
/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        StringBuilder sbu = new StringBuilder();
        findPath(root, sbu, res);
        return res;
    }

    public void findPath(TreeNode n, StringBuilder sub, List<String> res){
        if (n == null) return;
        if (n.left == null && n.right == null){
           res.add(sub.toString() + n.val);
           return;
        }
        sub.append(n.val + "->");
        StringBuilder sl = new StringBuilder(sub.toString());
        StringBuilder sr = new StringBuilder(sub.toString());
        findPath(n.left, sl, res);
        findPath(n.right, sr, res);
    }
}
