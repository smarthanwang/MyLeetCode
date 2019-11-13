package leetcode.solution.linkedlist;

import java.util.LinkedList;
import leetcode.common.ListNode;
import leetcode.util.LinkedListUtil;

public class ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int reverseLen = n - m + 1;
        if (head == null || head.next == null || reverseLen <= 1) {
            return head;
        }

        ListNode pre = null;
        ListNode curr = head;
        while (--m > 0 && curr != null) {
            pre = curr;
            curr = curr.next;
        }
        if (curr == null){
            return head;
        }

        ListNode tail = curr;

        ListNode h = null;
        while (reverseLen > 0 && curr != null) {
            ListNode next = curr.next;
            curr.next = h;
            h = curr;
            curr = next;
            reverseLen--;
        }

        if (pre != null){
            pre.next = h;
        }else {
            head = h;
        }
        tail.next = curr;
        return head;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtil.createList(6, 20);
        LinkedListUtil.printList(list);
        LinkedListUtil.printList(reverseBetween(list, 2 ,6));
    }
}
