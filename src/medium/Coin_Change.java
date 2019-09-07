package src.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/coin-change/ Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1 Example 2:
 *
 * Input: coins = [2], amount = 3 Output: -1
 * @author: wqdong
 * @create: 2019-09-07 15:07
 **/
public class Coin_Change {

  public static void main(String[] args) {
    int[] coins = new int[]{1};
    int amount = 1;
    System.out.println(coinChange(coins, amount));
  }

  public static int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int coin : coins) {
      for (int i = coin; i < amount + 1; i++) {
        dp[i] = Math.min(dp[i], dp[i - coin] + 1); // +1 表示需要走一步，也就是拿一个硬币
      }
    }
    return dp[amount] != amount + 1 ? dp[amount] : -1;
  }

}
