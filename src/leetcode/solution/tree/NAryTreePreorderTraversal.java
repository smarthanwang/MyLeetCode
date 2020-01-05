package leetcode.solution.tree;

import java.util.LinkedList;
import java.util.List;
import leetcode.common.Node;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NAryTreePreorderTraversal {


    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        traversal(root, result);
        return result;
    }

    private void traversal(Node root, List<Integer> result) {
        if (root != null){
            result.add(root.val);
            for (Node node : root.children){
                traversal(node, result);
            }
        }
    }

    //TODO preorder traversal loop
}
