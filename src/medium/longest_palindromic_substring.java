package src.medium;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/longest-palindromic-substring/
 * @author: wqdong
 * @create: 2019-12-02 13:29
 **/
public class longest_palindromic_substring {

  public static void main(String[] args) {
    String s = "babad";
    System.out.println(longestPalindrome(s));
  }

  // Runtime: 50 ms, faster than 32.82% of Java online submissions for Longest Palindromic Substring.
  public static String longestPalindrome(String s) {
    if (s.isEmpty()) {
      return "";
    }
    int len = s.length();
    int left = 0;
    int right = 0;

    boolean[][] dp = new boolean[len][len];

    for (int j = 0; j < len; j++) {
      for (int i = 0; i <= j; i++) {
        dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 2 || dp[i + 1][j - 1] == true);
        if (dp[i][j] == true && j - i > right - left) {
          left = i;
          right = j;
        }
      }
    }
    return s.substring(left, right + 1);
  }

}
