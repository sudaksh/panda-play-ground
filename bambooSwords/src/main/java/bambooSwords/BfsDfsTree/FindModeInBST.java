package bambooSwords.BfsDfsTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a binary search tree (BST) with duplicates, find all the mode(s)
(the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.


For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2


return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class FindModeInBST {
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> valToFre = new HashMap<>();
        valToFre.put(root.val, 0);
        TreeNode max = new TreeNode(0);
        findMode(root, valToFre, max);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : valToFre.entrySet()){
            if (e.getValue() == max.val){
                res.add(e.getKey());
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }

    public void findMode(TreeNode root, Map<Integer, Integer> valToFre, TreeNode max){
        if (root == null) return;
        if (valToFre.containsKey(root.val)){
            int fre = valToFre.get(root.val) + 1;
            valToFre.put(root.val, fre);
            max.val = Math.max(max.val, fre);
        } else {
            valToFre.put(root.val, 1);
        }
        findMode(root.left, valToFre, max);
        findMode(root.right, valToFre, max);
    }
}
