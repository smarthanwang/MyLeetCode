package leetcode.solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import leetcode.common.TreeNode;
import leetcode.util.TreeUtil;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RightSideView {

    // 层次遍历 取最右节点
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> level = new LinkedList<>();
        level.add(root);
        while (!level.isEmpty()) {
            result.add(level.getLast().val);
            int size = level.size();
            while (size-- > 0) {
                TreeNode node = level.poll();
                if (node.left != null) {
                    level.add(node.left);
                }
                if (node.right != null) {
                    level.add(node.right);
                }
            }
        }
        return result;
    }

    // 右子树优先深度遍历，取第一个节点
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int depth, List<Integer> result) {
        if (root != null) {
            if (result.size() < depth + 1) {
                result.add(root.val);
            }
            dfs(root.right, depth + 1, result);
            dfs(root.left, depth + 1, result);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.createTree(new int[]{4, 2, 6, 1, 3, 5, 7});
        TreeUtil.levelOrderTraversal(treeNode);
        System.out.println();
        RightSideView rightSideView = new RightSideView();
        System.out.println(rightSideView.rightSideView(treeNode));
        System.out.println(rightSideView.rightSideViewDFS(treeNode));
    }
}
