package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * @author: wqdong
 * @create: 2019-08-18 15:54
 **/
public class Best_Time_to_Buy_and_Sell_Stock {

    public static void main(String[] args){

        int[] prices = new int[] {1,2};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
        System.out.println(maxProfit3(prices));
    }

    // force
    public static int maxProfit(int[] prices) {
        int max_profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++){
                int profit = prices[j] - prices[i];
                if (profit > max_profit){
                    max_profit = profit;
                }
            }
        }
        return max_profit;
    }

    // one pass
    public static int maxProfit2(int[] prices) {
        int max_profit = 0;
        int min_prices = Integer.MAX_VALUE;

        for (int price : prices){
            if (price < min_prices){
                min_prices = price;
            }
            if ((price - min_prices)> max_profit){
                max_profit = price - min_prices;
            }
        }
        return max_profit;
    }

    // dp
    public static int maxProfit3(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        int min_prices = prices[0];
        int[] dp = new int[length];

        for (int i = 1; i < length ; i++){
            min_prices = Math.min(min_prices, prices[i]);
            dp[i] = Math.max(dp[i-1], prices[i] - min_prices);
        }
        return dp[length - 1];
    }
}
