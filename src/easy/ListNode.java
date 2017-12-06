package easy;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode buildListFromArray(int[] nums) {
        if (nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

