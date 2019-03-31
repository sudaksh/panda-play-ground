package bambooSwords.BfsDfsTree;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        findLeaves(root1, l1);
        findLeaves(root2, l2);
        return ListUtils.isEqualList(l1, l2);
    }

    public void findLeaves(TreeNode n, List<Integer> l){
        if (n == null) return;
        if (n.left == null && n.right == null){
            l.add(n.val);
        }
        findLeaves(n.left, l);
        findLeaves(n.right, l);
    }
}
