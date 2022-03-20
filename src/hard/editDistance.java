package src.hard;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/edit-distance/ Given two words word1 and word2, find
 * the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character Delete a character Replace a character Example 1:
 *
 * Input: word1 = "horse", word2 = "ros" Output: 3 Explanation: horse -> rorse (replace 'h' with
 * 'r') rorse -> rose (remove 'r') rose -> ros (remove 'e')
 * @author: wqdong
 * @create: 2019-09-09 10:55
 **/
public class editDistance {

  public static void main(String[] args) {
    String word1 = "horse";
    String word2 = "ros";
    System.out.println(minDistance(word1, word2));
  }

  public static int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();

    int[][] dp = new int[m+1][n+1];

    for (int i = 0; i < m + 1; i++) {
      dp[i][0] = i;
    }

    for (int j = 0; j < n + 1; j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i - 1][j - 1] += 0;
        } else {
          dp[i - 1][j - 1] += 1;
        }
        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
      }
    }
    return dp[m][n];
  }

}
