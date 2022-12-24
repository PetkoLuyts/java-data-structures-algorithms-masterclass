package trees_and_graphs.validate_bst;

public class ValidateBST {
    public static Integer lastPrinted = null;

    public static boolean checkBST(TreeNode node) {
        return checkBST(node, true);
    }

    public static boolean checkBST(TreeNode n, boolean isLeft) {
        if (n == null) {
            return true;
        }

        if (!checkBST(n.left, true)) {
            return false;
        }

        if (lastPrinted != null) {
            if (isLeft) {
                if (n.data < lastPrinted) {
                    return false;
                }
            } else {
                if (n.data <= lastPrinted) {
                    return false;
                }
            }
        }
        lastPrinted = n.data;

        if (!checkBST(n.right, false)) {
            return false;
        }
        return true;
    }
}
