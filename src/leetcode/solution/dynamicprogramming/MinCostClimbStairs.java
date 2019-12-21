package leetcode.solution.dynamicprogramming;

public class MinCostClimbStairs {

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        for (int i = 2; i < n; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[n - 1], cost[n - 2]);
    }

    public static void main(String[] args) {
        MinCostClimbStairs climbStairs = new MinCostClimbStairs();
        System.out.println(climbStairs.minCostClimbingStairs(
                new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
