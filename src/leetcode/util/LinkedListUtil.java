package leetcode.util;

import leetcode.common.ListNode;

import java.util.Random;

public class LinkedListUtil {

    public static ListNode simpleList = createList(10, 10);

    public static ListNode createList(int length, int maxVal) {
        Random random = new Random(47);
        ListNode head = new ListNode(random.nextInt(maxVal));
        ListNode ptr = head;
        for (int i = 1; i < length; i++) {
            ptr.next = new ListNode(random.nextInt(maxVal));
            ptr = ptr.next;
        }
        return head;
    }

    public static ListNode transferArrayToList(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode head = new ListNode(array[0]);
        int length = array.length;
        ListNode ptr = head;
        for (int i = 1; i < length; i++) {
            ptr.next = new ListNode(array[i]);
            ptr = ptr.next;
        }
        return head;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverseListRecursion(head);
        //return reverseListLoop(head);
    }

    private static ListNode reverseListLoop(ListNode head) {
        ListNode pre = null;
        ListNode ptr = head;
        while (ptr!= null) {
            ListNode next = ptr.next;
            ptr.next = pre;
            pre = ptr;
            ptr = next;
        }
        return pre;
    }

    private static ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }

    public static ListNode findMidNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head.next;
        while (tail != null && tail.next != null) {
            head = head.next;
            tail = tail.next.next;
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
        ListNode listNode = createList(6, 9);
        System.out.println(findMidNode(listNode).val);

        printList(listNode);
        printList(reverseList(listNode));

    }

}
