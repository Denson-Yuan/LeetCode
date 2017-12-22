package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Symmetric Tree
 */
public class LC101 {
    public static void main(String[] args) {
        String[] s = {"1", "2", "2", "3", "4", "4"};
        TreeNode root = TreeNode.buildTreeFromArray(s);
        System.out.println(new LC101().isSymmetric1(root));
        System.out.println(new LC101().isSymmetric2(root));
    }

    /**
     * 解法1：递归
     * 将判断一颗树是否自对称转化为判断其左右子树是否对称
     * 进而转化为判断两棵树是否对称
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    /**
     * 判断两棵树是否对称的递归解法：
     * A、B对称等价于
     * A.val==B.val && A.left与B.right对称 && A.right与B.left对称
     */
    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        else if (l == null || r == null || l.val != r.val) return false;
        else return isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }

    /**
     * 解法2：迭代，利用队列
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while (!q.isEmpty()) {
            TreeNode l = q.poll();
            TreeNode r = q.poll();
            if (l == null && r == null) continue;
            if (l == null || r == null || l.val != r.val) return false;
            q.offer(l.left);
            q.offer(r.right);
            q.offer(l.right);
            q.offer(r.left);
        }
        return true;
    }
}
