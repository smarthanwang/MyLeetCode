package leetcode.solution.linkedlist;

import leetcode.common.ListNode;
import leetcode.util.LinkedListUtil;

public class SwapNodesInPairs {

    public static ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode rest = swapPairsRecursion(head.next.next);
        ListNode pHead = head.next;
        pHead.next = head;
        head.next = rest;
        return pHead;
    }

    public static ListNode swapPairsLoop(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode pHead = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null){
            ListNode a = curr;
            ListNode b = curr.next;
            curr = curr.next.next;
            b.next = a;
            a.next = curr == null || curr.next == null ? curr : curr.next;
        }
        return pHead;
    }


    public static void main(String[] args) {
        ListNode list = LinkedListUtil.createList(10, 8);
        LinkedListUtil.printList(list);
        list = swapPairsRecursion(list);
        LinkedListUtil.printList(list);
        LinkedListUtil.printList(swapPairsLoop(list));
    }
}
