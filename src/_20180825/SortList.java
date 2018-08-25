package _20180825;

/**
 * Created by YotWei on 2018/8/25.
 * <p>
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode splitNode = findSplitNode(head);

        ListNode rightHead = sortList(splitNode.next);
        splitNode.next = null;
        ListNode leftHead = sortList(head);

        return merge(leftHead, rightHead);
    }

    private ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode head = new ListNode(0), pos = head;
        while (leftHead != null && rightHead != null) {
            if (leftHead.val < rightHead.val) {
                pos.next = leftHead;
                leftHead = leftHead.next;
            } else {
                pos.next = rightHead;
                rightHead = rightHead.next;
            }
            pos = pos.next;


        }
        while (leftHead != null) {
            pos.next = leftHead;
            pos = pos.next;
            leftHead = leftHead.next;
        }
        while (rightHead != null) {
            pos.next = rightHead;
            pos = pos.next;
            rightHead = rightHead.next;
        }
        return head.next;
    }

    private ListNode findSplitNode(ListNode h) {
        ListNode hh = h;
        for (; hh != null; ) {
            hh = hh.next;
            if (hh == null) {
                return h;
            }
            hh = hh.next;
            if (hh == null) {
                return h;
            }
            h = h.next;
        }
        return null;
    }

    /*
    public static void main(String[] args) {
        SortList s = new SortList();

        int[] arr = {-5, 5, 7, 2, -1, 34, 45, 21, 32, 1};
        ListNode head = new ListNode(0), h = head;
        for (int i : arr) {
            h.next = new ListNode(i);
            h = h.next;
        }
        ListNode list = head.next;

        show(list);
        show(s.sortList(list));
    }

    private static void show(ListNode lh) {
        for (; lh != null; ) {
            System.out.print(lh.val + " ");
            lh = lh.next;
        }
        System.out.println();
    }
    */

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
