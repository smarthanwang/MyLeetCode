package leetcode.solution.linkedlist;

import leetcode.common.ListNode;
import leetcode.util.LinkedListUtil;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode pHead = new ListNode(0);
        ListNode p = pHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        p.next = l1 == null? l2 : l1;
        return pHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListUtil.transferArrayToList(new int[]{9});
        ListNode l2 = LinkedListUtil.transferArrayToList(new int[]{1, 2, 4, 6, 7, 8, 8});
        LinkedListUtil.printList(mergeTwoLists(l1, l2));
    }
}
