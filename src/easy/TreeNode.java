package easy;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue使用时要尽量避免Collection的add()和remove()方法，而是要使用offer()来加入元素，使用poll()来获取并移出元素。
 * 它们的优点是通过返回值可以判断成功与否，add()和remove()方法在失败的时候会抛出异常。 如果要使用前端而不移出该元素，
 * 使用element()或者peek()方法。
 * LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
 * Queue接口窄化了对LinkedList的方法的访问权限（即在方法中的参数类型如果是Queue时，就完全只能访问
 * Queue接口所定义的方法 了，而不能直接访问 LinkedList的非Queue的方法），以使得只有恰当的方法才可以使用。
 * BlockingQueue 继承了Queue接口
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode buildTreeFromArray(String[] nums) {
        if (nums.length == 0) return null;
        TreeNode[] nodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!nums[i].equals("null"))
                nodes[i] = new TreeNode(Integer.parseInt(nums[i]));
            else nodes[i] = null;
        }
        int cur = 0, j = 1;
        while (j < nodes.length) {
            while (nodes[cur] == null) cur++;
            if (j < nodes.length && nodes[j] != null)
                nodes[cur].left = nodes[j];
            if (j + 1 < nodes.length && nodes[j + 1] != null)
                nodes[cur].right = nodes[j + 1];
            j = j + 2;
            cur++;
        }
        return nodes[0];
    }

    public static void printTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode cur;
        while (!q.isEmpty()) {
            cur = q.poll();
            if (cur != null) {
                System.out.print(cur.val + " ");
                q.offer(cur.left);
                q.offer(cur.right);
            } else System.out.print("null ");
        }
        System.out.println();
    }
}
