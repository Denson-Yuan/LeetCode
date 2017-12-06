package easy;

/**
 * Remove Duplicates from Sorted List
 */
public class LC83 {
    public static void main(String[] args) {
        int[] nums = {1, 1,1,1,3,4,4,5,5,6,6,6,6,6};
        ListNode head = ListNode.buildListFromArray(nums);
        ListNode.printList(head);

        ListNode res = new LC83().deleteDuplicates(head);
        ListNode.printList(res);

    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
                cur = cur.next;
            }
            else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
