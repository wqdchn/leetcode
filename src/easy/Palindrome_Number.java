package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/palindrome-number/
 * @author: wqdong
 * @create: 2019-10-08 09:58
 **/
public class Palindrome_Number {

  public static void main(String[] args) {
    int x = 12121;
    if (isPalindrome(x)) {
      System.out.println("is Palindrome Number.");
    } else {
      System.out.println("not Palindrome Number");
    }
  }

  public static boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    int div = 1;
    while (x / div >= 10) {
      div *= 10;
    }
    while (x > 0) {
      if (x / div != x % 10) {
        return false;
      }
      x = (x % div) / 10;
      div /= 100;
    }
    return true;
  }
}
