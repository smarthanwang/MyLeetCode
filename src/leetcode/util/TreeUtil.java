package leetcode.util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import leetcode.common.TreeNode;

public class TreeUtil {

    public static TreeNode createTree(int[] vals) {

        TreeNode[] treeNodes = new TreeNode[vals.length];
        for (int i = 0; i < vals.length; i++) {
            TreeNode node = treeNodes[i];
            if (node == null) {
                node = new TreeNode(vals[i]);
                treeNodes[i] = node;
            }
            if (2 * i + 1 < vals.length) {
                TreeNode left = new TreeNode(vals[2 * i + 1]);
                node.left = left;
                treeNodes[2 * i + 1] = left;
            }
            if (2 * i + 2 < vals.length) {
                TreeNode right = new TreeNode(vals[2 * i + 2]);
                node.right = right;
                treeNodes[2 * i + 2] = right;
            }
        }
        return treeNodes[0];
    }

    public static void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 5, 6};
        TreeNode root = createTree(vals);
        preorderTraversal(root);
        System.out.println();
        inorderTraversal(root);
        System.out.println();
        postorderTraversal(root);
        System.out.println();
        levelOrderTraversal(root);
    }
}
