package leetcode.solution.linkedlist;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import leetcode.common.ListNode;
import leetcode.util.LinkedListUtil;

/**
 * 23. 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *   输入:
 *      [
 *          1->4->5,
 *          1->3->4,
 *          2->6
 *          ]
 *   输出: 1->1->2->3->4->4->5->6
 */


public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        TreeSet<ListNode> set = new TreeSet<>((o1, o2) -> o1.val >= o2.val ? 1 : -1);
        for (ListNode list : lists) {
            if (list != null) {
               set.add(list);
            }
        }
        if (set.size() == 0){
            return null;
        }

        ListNode preHead = new ListNode(0);
        ListNode pointer = preHead;

        while (set.size() > 1) {
            ListNode minNode = set.pollFirst();
            if (minNode.next != null) {
                set.add(minNode.next);
            }
            pointer.next = minNode;
            pointer = pointer.next;
        }

        pointer.next = set.first();
        return preHead.next;
    }

    public static void main(String[] args) {

        ListNode a = LinkedListUtil.transferArrayToList(new int[]{1,2,5});
        ListNode b = LinkedListUtil.transferArrayToList(new int[]{1, 2});
        ListNode c = LinkedListUtil.transferArrayToList(new int[]{6, 8, 9, 10});
        LinkedListUtil.printList(mergeKLists(new ListNode[]{a, b, c}));
    }


}
