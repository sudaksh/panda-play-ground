package bambooSwords.BfsDfsTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 */
public class AllNodesDistanceKinBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;
        if (K == 0) {
            res.add(target.val);
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int shortest = 0;
        int size = 1;

        // root to target
        while (!que.isEmpty()){
            TreeNode cur = que.poll();
            if (cur.val == target.val){
                shortest++;
                break;
            }
            if (cur.left != null) que.add(cur.left);
            if (cur.right != null) que.add(cur.right);
            size--;
            if (size == 0){
                shortest++;
            } else {
                size = que.size();
            }
        }
        if (shortest == 0) return res;
        find(target,  K, res, target.val);
        int dis = K > shortest ? K - shortest : shortest - K;
        find(root, dis, res, target.val);
        return res;
    }

    public void find(TreeNode root, int K, List<Integer> res, int val){
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int size = 1;
        while (!que.isEmpty() && K != 0){
            TreeNode cur = que.poll();
            size --;
            if (cur.left != null && cur.left.val != val) que.add(cur.left);
            if (cur.right != null && cur.right.val != val) que.add(cur.right);
            if (size == 0){
                K--;
                if (K == 0){
                    while (!que.isEmpty()){
                        res.add(que.poll().val);
                    }
                } else {
                    size = que.size();
                }
            }
        }
    }
}
