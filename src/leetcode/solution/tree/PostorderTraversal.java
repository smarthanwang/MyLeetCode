package leetcode.solution.tree;

import java.util.LinkedList;
import java.util.List;
import leetcode.common.TreeNode;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PostorderTraversal {

    private void traversal(TreeNode root, List<Integer> result){
        if (root != null){
            traversal(root.left, result);
            traversal(root.right, result);
            result.add(root.val);
        }
    }
    //TODO  finish post order traversal by loop
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        traversal(root, result);
        return result;
    }

    public List<Integer> postorderTraversalLoop(TreeNode root) {
        List<Integer> result = new LinkedList<>();



        return result;
    }
}
