package _20180825;

/**
 * Created by YotWei on 2018/8/25.
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode h = head;
        ListNode p = head.next;
        head.next = null;
        for (; p != null; ) {
            ListNode ins = p;
            p = p.next;

            ListNode cursor = h, pre = null;
            while (cursor != null && ins.val > cursor.val) {
                pre = cursor;
                cursor = cursor.next;
            }
            if (pre == null) {
                ins.next = cursor;
                h = ins;
            } else {
                ins.next = cursor;
                pre.next = ins;
            }
        }

        return h;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
    public static void main(String[] args) {
        InsertionSortList s = new InsertionSortList();

        int[] arr = {1, 4, 5, 3, 2, -8, 9, 20, 4};
        ListNode head = new ListNode(0), h = head;
        for (int i : arr) {
            h.next = new ListNode(i);
            h = h.next;
        }
        ListNode list = head.next;

        show(list);
        show(s.insertionSortList(list));
    }

    private static void show(ListNode lh) {
        for (; lh != null; ) {
            System.out.print(lh.val + " ");
            lh = lh.next;
        }
        System.out.println();
    }
    */
}