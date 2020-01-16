package leetcode.solution.dynamicprogramming;

public class SellStockIII {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // 左边最大收益交易，0-i
        int[] maxProfitLeft = new int[prices.length];
        int min = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
            maxProfitLeft[i] = maxProfit;
        }
        // 右边最大收益交易，i - len
        int[] maxProfitRight = new int[prices.length];
        maxProfit = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, max - prices[i]);
            }
            maxProfitRight[i] = maxProfit;
        }
        for (int i = 1; i < prices.length - 1; i++) {
            maxProfit = Math.max(maxProfit, maxProfitLeft[i] + maxProfitRight[i + 1]);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        SellStockIII sellStockIII = new SellStockIII();
        System.out.println(sellStockIII.maxProfit(new int[]{1, 10}));
        System.out.println(sellStockIII.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4, 8, 1, 10}));
    }
}
