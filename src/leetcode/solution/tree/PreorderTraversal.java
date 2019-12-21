package leetcode.solution.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import leetcode.common.TreeNode;
import leetcode.util.TreeUtil;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 */
public class PreorderTraversal {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;
    }

    public List<Integer> preorderTraversalLoop(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtil.createTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        TreeUtil.preorderTraversal(tree);
        PreorderTraversal traversal = new PreorderTraversal();
        System.out.println(traversal.preorderTraversal(tree));
        System.out.println(traversal.preorderTraversalLoop(tree));
    }
}
