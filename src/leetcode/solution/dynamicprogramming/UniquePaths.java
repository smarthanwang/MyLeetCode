package leetcode.solution.dynamicprogramming;

public class UniquePaths {

    // 递归会超时
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    public int uniquePathsLoop(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] count = new int[m][n];
        for (int i = 0; i < n; i++) {
            count[m - 1][i] = 1;
        }
        for (int j = 0; j < m; j++) {
            count[j][n - 1] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                count[i][j] = count[i+1][j] + count[i][j+1];
            }
        }
        return count[0][0];
    }

    private void test(int m, int n){
        long start = System.currentTimeMillis();
        System.out.println(uniquePaths(m,n));
        System.out.println("Recursive elapsed time:\t" + (System.currentTimeMillis()-start));
        start = System.currentTimeMillis();
        System.out.println(uniquePathsLoop(m,n));
        System.out.println("Loop elapsed time:\t" + (System.currentTimeMillis()-start));
    }

    public static void main(String[] args) {

        UniquePaths uniquePaths = new UniquePaths();
        uniquePaths.test(7,3);
        uniquePaths.test(30,10);
    }
}
