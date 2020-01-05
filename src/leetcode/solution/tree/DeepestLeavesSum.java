package leetcode.solution.tree;

import java.util.ArrayList;
import java.util.List;
import leetcode.common.TreeNode;
import leetcode.util.TreeUtil;

public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] levelSum = new int[10000];
        dfs(root, 0, levelSum);
        int index = levelSum.length - 1;
        while (levelSum[index] == 0) {
            index--;
        }
        return levelSum[index];
    }

    private void dfs(TreeNode root, int depth, int[] levelSum) {
        if (root != null) {
            if (root.left != null || root.right != null) {
                dfs(root.left, depth + 1, levelSum);
                dfs(root.right, depth + 1, levelSum);
            } else {
                levelSum[depth] += root.val;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtil.createTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        TreeUtil.levelOrderTraversal(tree);
        System.out.println();
        System.out.println(new DeepestLeavesSum().deepestLeavesSum(tree));
    }
}
