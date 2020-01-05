package leetcode.solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import leetcode.common.TreeNode;
import leetcode.util.TreeUtil;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> first = new Stack<>();
        Stack<TreeNode> second = new Stack<>();
        first.push(root);
        while (!first.isEmpty() || !second.isEmpty()) {
            List<Integer> res = new ArrayList<>(first.size());
            if (!first.isEmpty()){
                while (!first.isEmpty()) {
                    TreeNode node = first.pop();
                    res.add(node.val);
                    if (node.left != null) {
                        second.push(node.left);
                    }
                    if (node.right != null) {
                        second.push(node.right);
                    }
                }
            }else {
                while (!second.isEmpty()) {
                    TreeNode node = second.pop();
                    res.add(node.val);
                    if (node.right != null) {
                        first.push(node.right);
                    }
                    if (node.left != null) {
                        first.push(node.left);
                    }
                }
            }
            result.add(res);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.createTree(new int[]{1, 2, 3, 4 , 5, 6, 7,8 ,9, 10});
        TreeUtil.levelOrderTraversal(treeNode);
        System.out.println();
        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(treeNode));
    }
}
