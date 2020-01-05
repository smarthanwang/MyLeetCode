package leetcode.solution.tree;

import java.util.LinkedList;
import java.util.List;
import leetcode.common.Node;

public class NAryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> result = new LinkedList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(Node root, List<Integer> result) {
        if (root != null) {
            for (Node node : root.children) {
                traversal(node, result);
            }
            result.add(root.val);
        }
    }

    //TODO traversal by loop
}
