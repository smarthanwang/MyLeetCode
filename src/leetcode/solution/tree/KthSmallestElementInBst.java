package leetcode.solution.tree;

import java.util.Stack;
import leetcode.common.TreeNode;
import leetcode.util.TreeUtil;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class KthSmallestElementInBst {

    // 中序遍历第 K 个元素
    public int kthSmallest(TreeNode root, int k) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (--k == 0) {
                return cur.val;
            }
            cur = cur.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        KthSmallestElementInBst bst = new KthSmallestElementInBst();
        TreeNode treeNode = TreeUtil.createTree(new int[]{4, 2, 6, 1, 3, 5, 7});
        TreeUtil.inorderTraversal(treeNode);
        System.out.println();
        System.out.println(bst.kthSmallest(treeNode, 1));
        System.out.println(bst.kthSmallest(treeNode, 2));
        System.out.println(bst.kthSmallest(treeNode, 3));
        System.out.println(bst.kthSmallest(treeNode, 4));
        System.out.println(bst.kthSmallest(treeNode, 5));
        System.out.println(bst.kthSmallest(treeNode, 6));
        System.out.println(bst.kthSmallest(treeNode, 7));
    }

}
