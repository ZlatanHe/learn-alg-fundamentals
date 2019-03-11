package dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 *
 * Created by Zlatan on 19/3/11.
 */
class BuyStocks {
    public int maxProfit(int[] prices) {
        int maxPrice = Integer.MIN_VALUE;
        int maxProfit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            } else {
                int profit = maxPrice - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] s) {
        System.out.println(new BuyStocks().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new BuyStocks().maxProfit(new int[]{7,6,4,3,1}));

    }
}
