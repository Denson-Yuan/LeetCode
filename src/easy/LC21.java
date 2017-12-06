package easy;

/**
 * Merge Two Sorted Lists
 * 合并有序链表
 */
public class LC21 {
    public static void main(String[] args) {
        int[] num1 = {1, 3, 5, 7};
        ListNode a1 = ListNode.buildListFromArray(num1);

        int[] num2 = {2, 3, 6, 8};
        ListNode b1 = ListNode.buildListFromArray(num2);

        System.out.print("before a1:");
        ListNode.printList(a1);

        System.out.print("before b1:");
        ListNode.printList(b1);

        ListNode r = new LC21().mergeTwoLists(a1, b1);
        System.out.print("r:");
        ListNode.printList(r);

        System.out.print("after a1:");
        ListNode.printList(a1);

        System.out.print("after b1:");
        ListNode.printList(b1);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode tmp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if (l1 != null) tmp.next = l1;
        if (l2 != null) tmp.next = l2;
        return head;
    }
}
