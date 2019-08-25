package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/sqrtx/
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 * @author: wqdong
 * @create: 2019-08-25 11:13
 **/
public class Sqrt {

  public static void main(String[] args){
    System.out.println(mySqrt(5));
    System.out.println(mySqrt(2147395599));

    System.out.println(mySqrt2(5));
    System.out.println(mySqrt2(2147395599));
  }

  public static int mySqrt(int x) {
    long r = x;
    while (r * r > x) {
      r = (r + x / r) / 2;
    }
    return (int) r;
  }

  public static int mySqrt2(int x) {
    if (x == 0 || x == 1) {
      return x;
    }

    int left = 0, right = x;
    int res = 0;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (mid == x / mid) {
        return mid;
      } else if (mid > x / mid) {
        right = mid - 1;
      } else {
        left = mid + 1;
        res = mid;
      }
    }
    return res;
  }
}
