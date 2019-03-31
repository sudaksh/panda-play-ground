package bambooSwords.BfsDfsTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderTraII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int layerSize = 1;
        res.add(new ArrayList<>());
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            layerSize--;
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
            res.get(0).add(cur.val);
            if (layerSize == 0){
                if (!queue.isEmpty()){
                    res.add(0, new ArrayList<>());
                    layerSize = queue.size();
                }
            }
        }
        return res;
    }
}
