package leetcode.solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import leetcode.common.TreeNode;
import leetcode.util.TreeUtil;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> res = new ArrayList<>(levelSize);
            while (levelSize-- > 0) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(res);
        }
        int i = 0, j = result.size() - 1;
        while (i < j) {
            List<Integer> temp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
            i++;
            j--;
        }
        return result;
    }

    public static void main(String[] args) {
        LevelOrderTraversalII traversalII = new LevelOrderTraversalII();
        TreeNode treeNode = TreeUtil.createTree(new int[]{1, 3, 5, 7, 9, 11, 13});
        TreeUtil.levelOrderTraversal(treeNode);
        System.out.println(traversalII.levelOrderBottom(treeNode));
    }
}
