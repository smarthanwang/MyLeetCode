package leetcode.solution.dynamicprogramming;

public class SellStockIII {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit,
                    maxProfit(prices, 0, i) + maxProfit(prices, i + 1, prices.length-1));
        }
        return maxProfit;
    }

    //TODO optimize speed
    private int maxProfit(int[] prices, int s, int e) {
        if (s >= e) {
            return 0;
        }
        int min = prices[s];
        int maxProfit = 0;
        for (int i = s + 1; i <= e; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        SellStockIII sellStockIII = new SellStockIII();
        System.out.println(sellStockIII.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4, 8,1,10}));
    }
}
