package src.hard;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/n-queens-ii/ Example:
 *
 * Input: 4 Output: 2 Explanation: There are two distinct solutions to the 4-queens puzzle as shown
 * below. [ [".Q..",  // Solution 1 "...Q", "Q...", "..Q."],
 *
 * ["..Q.",  // Solution 2 "Q...", "...Q", ".Q.."] ]
 * @author: wqdong
 * @create: 2019-08-30 10:29
 **/
public class N_Queens_II {

  public static int count = 0;

  public static void main(String[] args) {
    int n = 8;
    System.out.println(totalNQueens(n));
  }

  public static int totalNQueens(int n) {
    if (n < 1) {
      return 0;
    }
    dfs(n, 0, 0, 0, 0);
    return count;
  }

  public static void dfs(int n, int row, int cols, int pie, int na) {
    if (row >= n) {
      count += 1;
      return;
    }
    int bits = (~(cols | pie | na)) & ((1 << n) - 1);
    while (bits > 0) {
      int p = bits & -bits;
      dfs(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1);
      bits = bits & (bits - 1);
    }
  }

}
