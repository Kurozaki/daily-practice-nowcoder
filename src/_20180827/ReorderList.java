package _20180827;

/**
 * Created by YotWei on 2018/8/25.
 * <p>
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 * <p>
 * You must do this in-place without altering the nodes' values.
 * <p>
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode h = head;

        ListNode splitNode = getSplitNode(head);
        ListNode tail = reverse(splitNode.next);
        splitNode.next = null;
        head = head.next;

        h.next = null;
        for (; tail != null; ) {
            h.next = tail;
            tail = tail.next;
            h = h.next;

            if (head == null)
                continue;
            h.next = head;
            head = head.next;
            h = h.next;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode h = null;
        for (ListNode p; head != null; ) {
            p = head;
            head = head.next;
            p.next = h;
            h = p;
        }
        return h;
    }

    private ListNode getSplitNode(ListNode head) {
        if (head == null)
            return null;
        ListNode h = head, sp = head;
        for (; ; ) {
            h = h.next;
            if (h == null) {
                return sp;
            }

            h = h.next;
            if (h == null) {
                return sp;
            }
            sp = sp.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode head = new ListNode(0), h = head;
        for (int i : arr) {
            h.next = new ListNode(i);
            h = h.next;
        }
        ListNode list = head.next;

        show(list);

        ReorderList reorder = new ReorderList();
        reorder.reorderList(list);

        show(list);
    }

    private static void show(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
