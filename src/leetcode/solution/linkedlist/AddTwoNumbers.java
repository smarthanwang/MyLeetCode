package leetcode.solution.linkedlist;

import leetcode.common.ListNode;
import leetcode.util.LinkedListUtil;

/**
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head1 = l1;
        int carry = 0;
        while (true) {
            l1.val = l1.val + l2.val + carry;
            carry = l1.val / 10;
            l1.val %= 10;
            if (l1.next == null || l2.next == null) {
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l2.next != null) {
            l1.next = l2.next;
        }

        while (carry > 0) {
            if (l1.next == null) {
                l1.next = new ListNode(carry);
                break;
            } else {
                l1.next.val += carry;
                carry = l1.next.val / 10;
                l1.next.val %= 10;
                l1 = l1.next;
            }
        }

        return head1;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListUtil.createList(1, 10);
        ListNode l2 = LinkedListUtil.createList(1, 10);
        LinkedListUtil.printList(l1);
        LinkedListUtil.printList(l2);
        LinkedListUtil.printList(new AddTwoNumbers().addTwoNumbers(l1, l2));
    }
}
