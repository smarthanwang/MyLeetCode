package leetcode.solution.linkedlist;

import leetcode.common.ListNode;
import leetcode.util.LinkedListUtil;

/**
 *请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *      输入: 1->2
 *      输出: false
 *
 * 示例 2:
 *      输入: 1->2->2->1
 *      输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 */

public class PalindromeList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ListNode s1 = head;
        ListNode s2 = head.next;
        while (s2 != null && s2.next != null) {
            s1 = s1.next;
            s2 = s2.next.next;
        }

        ListNode head2 = s1.next;

        ListNode pre = null;
        ListNode post = null;
        while (head2.next != null){
            post = head2.next;
            head2.next = pre;
            pre = head2;
            head2 = post;
        }
        head2.next = pre;

        while (head2 != null){
            if (head.val == head2.val){
                head2 = head2.next;
                head = head.next;
            }else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode list = LinkedListUtil.transferArrayToList(new int[]{1, 1, 3, 2, 2, 3, 1, 1});
        LinkedListUtil.printList(list);
        PalindromeList palindromeList = new PalindromeList();
        System.out.println(palindromeList.isPalindrome(list));
    }
}
