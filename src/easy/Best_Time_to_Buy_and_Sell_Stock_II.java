package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * @author: wqdong
 * @create: 2019-08-18 14:01
 **/
public class Best_Time_to_Buy_and_Sell_Stock_II {

    public static void main(String[] args){

        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]){
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }
}
