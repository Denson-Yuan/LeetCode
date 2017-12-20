package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Same tree
 */
public class LC100 {
    public static void main(String[] args) {
        String[] s1 = {"1", "2", "3", "null", "5", "6"};
        TreeNode p = TreeNode.buildTreeFromArray(s1);
        TreeNode.printTree(p);

        String[] s2 = {"1", "2", "3", "null", "5", "6"};
        TreeNode q = TreeNode.buildTreeFromArray(s2);
        TreeNode.printTree(q);

        System.out.println(new LC100().isSameTree(p, q));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pq = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();
        pq.offer(p);
        qq.offer(q);
        TreeNode pcur, qcur;
        while (!pq.isEmpty()) {
            pcur = pq.poll();
            if (pcur != null) {
                pq.offer(pcur.left);
                pq.offer(pcur.right);
            }
            qcur = qq.poll();
            if (qcur != null) {
                qq.offer(qcur.left);
                qq.offer(qcur.right);
            }
            if (pcur == null && qcur != null || pcur != null && qcur == null || pcur != null && qcur != null && pcur.val != qcur.val)
                return false;
        }
        while (!qq.isEmpty()) {
            qcur = qq.poll();
            if (qcur != null)
                return false;
        }
        return true;
    }
}
