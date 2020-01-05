package leetcode.solution.tree;

import java.util.Stack;
import leetcode.common.TreeNode;
import leetcode.util.TreeUtil;

/**
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 * 示例 1：
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：[2,2,2,5,2]
 * 输出：false
 *  
 * 提示：
 *
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/univalued-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        return (root.left == null || root.left.val == root.val && isUnivalTree(root.left))
                   && (root.right == null || root.right.val == root.val && isUnivalTree(root.right));
    }

    public static void main(String[] args) {
        UnivaluedBinaryTree univaluedBinaryTree = new UnivaluedBinaryTree();
        TreeNode treeNode = TreeUtil.createTree(new int[]{1, 1, 1, 1});
        System.out.println(univaluedBinaryTree.isUnivalTree(treeNode));
        treeNode = TreeUtil.createTree(new int[]{1, 1, 1, 1, 1, 1, 1, 3});
        System.out.println(univaluedBinaryTree.isUnivalTree(treeNode));
    }
}
