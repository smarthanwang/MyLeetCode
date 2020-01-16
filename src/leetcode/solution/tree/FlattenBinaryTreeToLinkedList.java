package leetcode.solution.tree;

import java.util.Stack;
import leetcode.common.TreeNode;

/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FlattenBinaryTreeToLinkedList {

    //右-根-左 遍历， post 记录上个遍历的节点
    TreeNode post = new TreeNode(0);
    public void flatten(TreeNode root){
        if (root != null){
            flatten(root.right);
            flatten(root.left);
            root.right = post;
            post = root;
            root.left = null;
        }
    }


    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = new TreeNode(0);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
                node.right = null;
            }
            if (node.left != null) {
                stack.push(node.left);
                node.left = null;
            }
            pre.right = node;
            pre = pre.right;
        }
    }
}
