package leetcode.solution.dynamicprogramming;

import java.util.List;

public class MinimumTotalTriangle {
    public int minimumTotal(List<List<Integer>> triangle) {

        int height = triangle.size();
        if (height == 1){
            return triangle.get(0).get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int i=1; i < height; i ++){
            List<Integer> pre = triangle.get(i-1);
            List<Integer> cur = triangle.get(i);
            cur.set(0, cur.get(0) + pre.get(0));
            cur.set(i, cur.get(i) + pre.get(i-1));
            for (int j= 1; j < i; j++){
                cur.set(j, Math.min(pre.get(j-1), pre.get(j)) + cur.get(j));
            }
        }

        List<Integer> cur = triangle.get(height-1);
        for (int j= 0; j < height; j++){
            min = Math.min(min, cur.get(j));
        }
        return min;
    }
}
