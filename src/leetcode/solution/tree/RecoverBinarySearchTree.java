package leetcode.solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import leetcode.common.TreeNode;
import leetcode.util.TreeUtil;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * 进阶:
 *
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class RecoverBinarySearchTree {

    // 常数时间
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        traversal(root, nodes);
        TreeNode post = nodes.getLast();
        TreeNode prev = null;
        while (!nodes.isEmpty()) {
            prev = nodes.removeLast();
            if (prev.val > post.val) {
                break;
            }
            post = prev;
        }
        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.removeLast();
            if (cur.val < post.val) {
                break;
            } else {
                prev = cur;
            }
        }

        int val = prev.val;
        prev.val = post.val;
        post.val = val;
    }

    private void traversal(TreeNode root, LinkedList<TreeNode> inOrderNodes) {
        if (root != null) {
            traversal(root.left, inOrderNodes);
            inOrderNodes.offer(root);
            traversal(root.right, inOrderNodes);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.createTree(new int[]{5, 2, 6, 1, 3, 4, 7});
        TreeUtil.inorderTraversal(treeNode);
        System.out.println();
        new RecoverBinarySearchTree().recoverTree(treeNode);
        TreeUtil.inorderTraversal(treeNode);
        System.out.println();
    }
}
