package leetcode.solution.linkedlist;

import leetcode.common.ListNode;
import leetcode.util.LinkedListUtil;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *      给定一个链表: 1->2->3->4->5, 和 n = 2.
 *      当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 *      给定的 n 保证是有效的。
 *
 * 进阶：
 *      你能尝试使用一趟扫描实现
 */

public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null && n > 0){
            p1 = p1.next;
            n --;
        }
        if (n > 0){
            return head;
        } else if (p1 == null){
            return head.next;
        }

        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p2.next != null){
            p2.next = p2.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtil.createList(5, 10);
        LinkedListUtil.printList(list);
        LinkedListUtil.printList(removeNthFromEnd(list, 1));
    }
}
