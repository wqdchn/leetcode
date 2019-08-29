package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/power-of-two/
 * @author: wqdong
 * @create: 2019-08-29 10:40
 **/
public class Power_of_Two {

  public static void main(String[] args) {
    int n = 1024;
    if (isPowerOfTwo(n) && isPowerOfTwo2(n) && isPowerOfTwo3(n) && isPowerOfTwo4(n)) {
      System.out.println("is Power of Two!");
    } else {
      System.out.println("not Power of Two!");
    }
  }

  public static boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }

  public static boolean isPowerOfTwo2(int n) {
    if (n <= 0) {
      return false;
    }
    return Integer.bitCount(n) == 1;
  }

  public static boolean isPowerOfTwo3(int n) {
    if (n <= 0) {
      return false;
    }
    while (n % 2 == 0) {
      n /= 2;
    }
    return n == 1;
  }

  public static boolean isPowerOfTwo4(int n) {
    return Math.ceil(Math.log10(n) / Math.log10(2)) - Math.log10(n) / Math.log10(2)  == 0;
  }
}
