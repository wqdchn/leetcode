package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/plus-one/
 * @author: wqdong
 * @create: 2019-12-26 10:15
 **/
public class plus_one {

  public static void main(String[] args) {
    int[] digits = new int[]{1, 3, 9};
    for (int digit : plusOne(digits)) {
      System.out.print(digit + " ");
    }
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
  public static int[] plusOne(int[] digits) {
    int n = digits.length;
    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }
    int[] res = new int[n + 1];
    res[0] = 1;
    return res;
  }
}
