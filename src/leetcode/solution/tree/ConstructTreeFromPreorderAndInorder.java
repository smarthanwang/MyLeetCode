package leetcode.solution.tree;

import leetcode.common.TreeNode;
import leetcode.util.TreeUtil;

public class ConstructTreeFromPreorderAndInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        if (ps == pe) {
            return new TreeNode(preorder[ps]);
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int i = is;
        while (inorder[i] != preorder[ps]) {
            i++;
        }
        int lenL = i - is;
        root.left = build(preorder, ps + 1, ps + lenL, inorder, is, i - 1);
        root.right = build(preorder, ps + lenL + 1, pe, inorder, i + 1, ie);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode tree = new ConstructTreeFromPreorderAndInorder().buildTree(preorder, inorder);
        TreeUtil.levelOrderTraversal(tree);
    }
}
