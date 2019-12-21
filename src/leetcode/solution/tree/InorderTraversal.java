package leetcode.solution.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import leetcode.common.TreeNode;
import leetcode.util.TreeUtil;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 */

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        traversalRecursive(root, result);
        return result;
    }

    private void traversalRecursive(TreeNode root, List<Integer> result) {
        if (root != null) {
            traversalRecursive(root.left, result);
            result.add(root.val);
            traversalRecursive(root.right, result);
        }
    }

    public List<Integer> inorderTraversalLoop(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    public static void main(String[] args) {
        InorderTraversal traversal = new InorderTraversal();
        TreeNode tree = TreeUtil.createTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        TreeUtil.inorderTraversal(tree);
        System.out.println();
        System.out.println(traversal.inorderTraversal(tree));
        System.out.println(traversal.inorderTraversalLoop(tree));
    }

}
