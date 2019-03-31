package bambooSwords.BfsDfsTree;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        StringBuilder sbu = new StringBuilder();
        getString(sbu, t);
        return sbu.toString();
    }
    private void getString(StringBuilder sbu, TreeNode t){
        if (t == null) return;
        sbu.append(t.val);
        if (t.left != null || t.right != null){
            sbu.append("(");
            getString(sbu, t.left);
            sbu.append(")");
            if (t.right != null){
                sbu.append("(");
                getString(sbu, t.right);
                sbu.append(")");
            }
        }
    }
}
