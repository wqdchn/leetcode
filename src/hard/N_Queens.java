package src.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/n-queens/ Example:
 *
 * Input: 4 Output: [ [".Q..",  // Solution 1 "...Q", "Q...", "..Q."],
 *
 * ["..Q.",  // Solution 2 "Q...", "...Q", ".Q.."] ] Explanation: There exist two distinct solutions
 * to the 4-queens puzzle as shown above.
 * @author: wqdong
 * @create: 2019-08-22 11:49
 **/
public class N_Queens {

  public static void main(String[] args) {
    int n = 4;
    System.out.println(solveNQueens(n));
  }

  public static List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    if(n < 1) return result;
    dfs(n, 0, new int[n], new ArrayList<>(), result);
    return result;
  }

  private static void dfs(int n, int idx, int[] valid, List<String> path,
      List<List<String>> result) {
    if (path.size() == n) {
      result.add(path);
    }
    for (int j = 0; j < n; j++) {
      if (checkValid(valid, idx, j)) {
        valid[idx] = j;
        String s = String.join("", Collections.nCopies(j, ".")) + "Q" +
            String.join("", Collections.nCopies(n - j - 1, "."));
        List<String> path_temp = new ArrayList<>(path);
        path_temp.add(s);
        dfs(n, idx + 1, valid, path_temp, result);
      }
    }

  }

  // 假设一维数组valid现在是[0，3，1，0]，且row = 2，col = 1，则表示从上往下从左到右，从零开始计数
  // 当前的Q的位置分别处于，第零行的Q在第0位，第一行的Q处在第3位，第二行Q处在第1位，第三行还没计算
  private static boolean checkValid(int[] valid, int row, int col) {
    for (int i = 0; i < row; i++) {
      if (valid[i] == col || (row - i) == Math.abs(col - valid[i])) {
        return false;
      }
    }
    return true;
  }

  //sample 1 ms submission
  public List<List<String>> solveNQueens2(int n) {
    List<List<String>> res = new ArrayList<>();
    if(n < 1) return res;
    boolean[] cols = new boolean[n];
    boolean[] diag = new boolean[2 * n - 1], anti_diag = new boolean[2 * n - 1];
    char[][] board = new char[n][n];
    for(char[] row : board) Arrays.fill(row, '.');
    dfs2(n, 0, cols, diag, anti_diag, board, res);
    return res;
  }
  private void dfs2(int n, int r, boolean[] cols, boolean[] diag,
      boolean[] anti_diag, char[][] board, List<List<String>> res){
    if(r == n){
      add(res, board);
      return;
    }
    for(int j = 0; j < n; j++){
      if(cols[j] || diag[r + n - 1 - j] || anti_diag[r + j]) continue;
      board[r][j] = 'Q';
      cols[j] = diag[r + n - 1 - j] = anti_diag[r + j] = true;
      dfs2(n, r+1, cols, diag, anti_diag, board, res);
      board[r][j] = '.';
      cols[j] = diag[r + n - 1 - j] = anti_diag[r + j] = false;
    }
  }
  private void add(List<List<String>> res, char[][] board){
    List<String> list = new ArrayList<>();
    for(char[] row : board){
      list.add(new String(row));
    }
    res.add(list);
  }
}
