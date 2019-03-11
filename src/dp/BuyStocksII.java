package dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * Created by Zlatan on 19/3/11.
 */
public class BuyStocksII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        int curProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                curProfit = prices[i] - minPrice;
            }
            if (prices[i] < prices[i - 1]) {
                maxProfit += curProfit;
                curProfit = 0;
                minPrice = prices[i];
            }
        }
        maxProfit += curProfit;
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new BuyStocksII().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BuyStocksII().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new BuyStocksII().maxProfit(new int[]{7,6,4,3,1}));
    }
}
