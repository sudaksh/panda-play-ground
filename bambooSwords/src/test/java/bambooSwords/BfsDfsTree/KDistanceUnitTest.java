package bambooSwords.BfsDfsTree;

import org.junit.Test;

public class KDistanceUnitTest {

    @Test
    public void test(){
        AllNodesDistanceKinBinaryTree tree = new AllNodesDistanceKinBinaryTree();
        TreeNode root = new TreeNode(0);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        root.left = one;
        one.left = three;
        one.right = two;
        tree.distanceK(root, two, 1);
    }
}
