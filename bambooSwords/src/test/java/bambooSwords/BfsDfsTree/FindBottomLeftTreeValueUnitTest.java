package bambooSwords.BfsDfsTree;

import org.junit.Test;

import java.util.Stack;

public class FindBottomLeftTreeValueUnitTest {

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        FindBottomLeftTreeValue findBottomLeftTreeValue = new FindBottomLeftTreeValue();
        findBottomLeftTreeValue.findBottomLeftValue(root);
    }

    @Test
    public void testStack(){
        Stack<TreeNode> stack = new Stack<>();
        stack.add(null);
        System.out.println(stack.size());
    }
}
