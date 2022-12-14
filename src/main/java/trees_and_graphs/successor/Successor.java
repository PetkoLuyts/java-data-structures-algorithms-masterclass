package trees_and_graphs.successor;

public class Successor {
    public static TreeNode inorderSucc(TreeNode n) {
        if (n == null) return null;

        if (n.parent == null || n.right != null) {
            return leftMostChild(n.right);
        } else {
            TreeNode q = n;
            TreeNode x = q.parent;

            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }

            return x;
        }
    }

    public static TreeNode leftMostChild(TreeNode n) {
        if (n == null) {
            return null;
        }

        while (n.left != null) {
            n = n.left;
        }

        return n;
    }
}