package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/climbing-stairs/ Example 1:
 *
 * Input: 2 Output: 2 Explanation: There are two ways to climb to the top. 1. 1 step + 1 step 2. 2
 * steps Example 2:
 *
 * Input: 3 Output: 3 Explanation: There are three ways to climb to the top. 1. 1 step + 1 step + 1
 * step 2. 1 step + 2 steps 3. 2 steps + 1 step
 * @author: wqdong
 * @create: 2019-08-31 11:05
 **/
public class Climbing_Stairs {

  public static void main(String[] args) {
    int n = 35;
    System.out.println(climbStairs(n));
    System.out.println(climbStairs2(n));
    System.out.println(climbStairs3(n));
  }

  // dp
  public static int climbStairs(int n) {
    if (n == 0 || n == 1 || n == 2) {
      return n;
    }
    int[] res = new int[n];
    res[0] = 1;
    res[1] = 2;
    for (int i = 2; i < n; i++) {
      res[i] = res[i - 1] + res[i - 2];
    }
    return res[n - 1];
  }

  // recursion with memo
  public static int climbStairs2(int n) {
    int memo[] = new int[n + 1];
    return climb_Stairs(0, n, memo);
  }

  public static int climb_Stairs(int i, int n, int memo[]) {
    if (i > n) {
      return 0;
    }
    if (i == n) {
      return 1;
    }
    if (memo[i] > 0) {
      return memo[i];
    }
    memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
    return memo[i];
  }

  public static int climbStairs3(int n) {
    if (n == 0 || n == 1 || n == 2) {
      return n;
    }
    int x = 1;
    int y = 1;

    for (int i = 1; i < n; i++) {
      int temp = 0;
      temp = y;
      y = x + y;
      x = temp;
    }
    return y;
  }
}
