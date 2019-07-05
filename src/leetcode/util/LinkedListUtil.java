package leetcode.util;

import leetcode.common.ListNode;

import java.util.Random;

public class LinkedListUtil {

    public static ListNode simpleList = createList(10, 10);

    public static ListNode createList(int length, int maxVal) {
        Random random = new Random(47);
        ListNode head = new ListNode(random.nextInt(maxVal));
        ListNode ptr = head;
        for (int i = 2; i < length; i++) {
            ptr.next = new ListNode(random.nextInt(maxVal));
            ptr = ptr.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        System.out.print("List=[");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("]");
    }

    public static int length(ListNode list) {
        int len = 0;
        while (list != null) {
            len++;
            list = list.next;
        }
        return len;
    }

    public static void main(String args[]) {
        printList(createList(10, 10));
    }

}
