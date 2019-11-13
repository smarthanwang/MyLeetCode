package leetcode.solution.linkedlist;

import leetcode.common.ListNode;
import leetcode.util.LinkedListUtil;

public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k <= 1){
            return head;
        }

        int i = 1;
        ListNode curr = head;
        ListNode preHead = new ListNode(0);
        while (i <= k && curr != null) {
            ListNode nextNode = curr.next;
            curr.next = preHead.next;
            preHead.next = curr;
            curr = nextNode;
            i++;
        }

        if (i <= k) {
            curr = preHead.next;
            preHead.next = null;
            while (curr != null) {
                ListNode nextNode = curr.next;
                curr.next = preHead.next;
                preHead.next = curr;
                curr = nextNode;
            }
        } else {
            head.next = reverseKGroup(curr, k);
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtil.createList(6, 10);
        LinkedListUtil.printList(list);
        LinkedListUtil.printList(reverseKGroup(list, 6));
    }

}
