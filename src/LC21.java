/**
 * Merge Two Sorted Lists
 * 合并有序链表
 */
public class LC21 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(7);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(6);
        ListNode b4 = new ListNode(8);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;

        ListNode ta1 = a1;
        System.out.print("before a1:");
        while (ta1 != null) {
            System.out.print(ta1.val+" ");
            ta1 = ta1.next;
        }
        ListNode tb1 = b1;
        System.out.print("\nbefore b1:");
        while (tb1 != null) {
            System.out.print(tb1.val+" ");
            tb1 = tb1.next;
        }

        ListNode r = new LC21().mergeTwoLists(a1, b1);
        System.out.print("\nr:");
        while (r != null) {
            System.out.print(r.val+" ");
            r = r.next;
        }

        ListNode ta2 = a1;
        System.out.print("\nafter a1:");
        while (ta2 != null) {
            System.out.print(ta2.val+" ");
            ta2 = ta2.next;
        }

        ListNode tb2 = b1;
        System.out.print("\nafter b1:");
        while (tb2 != null) {
            System.out.print(tb2.val+" ");
            tb2 = tb2.next;
        }
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
