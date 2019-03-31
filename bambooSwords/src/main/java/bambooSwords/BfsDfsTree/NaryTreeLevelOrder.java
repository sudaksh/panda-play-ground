package bambooSwords.BfsDfsTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
public class NaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        res.add(new ArrayList());
        int nums = 1;
        while (!queue.isEmpty()){
            Node c = queue.poll();
            nums--;
            for (Node n : c.children){
                queue.add(n);
            }
            res.get(res.size() - 1).add(c.val);
            if (nums == 0 && !queue.isEmpty()){
                res.add(new ArrayList<>());
                nums = queue.size();
            }
        }
        return res;
    }

}
