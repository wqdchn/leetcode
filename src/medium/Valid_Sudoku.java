package src.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/valid-sudoku/
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 *
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * @author: wqdong
 * @create: 2019-08-24 10:56
 **/
public class Valid_Sudoku {

  public static void main(String[] args) {
    char[][] board = new char[][] {{'5','3','.','.','7','.','.','.','.'},
      {'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
      {'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},
      {'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},
      {'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

    if (isValidSudoku(board)){
      System.out.println("True");
    }else {
      System.out.println("False");
    }

    if (isValidSudoku2(board)){
      System.out.println("True");
    }else {
      System.out.println("False");
    }
  }

  public static boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      boolean[] rowCheck = new boolean[9];
      boolean[] colCheck = new boolean[9];
      boolean[] boxCheck = new boolean[9];
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
        } else if (rowCheck[board[i][j] - '1']) {
          return false;
        } else {
          rowCheck[board[i][j] - '1'] = true;
        }
        if (board[j][i] == '.') {
        } else if (colCheck[board[j][i] - '1']) {
          return false;
        } else {
          colCheck[board[j][i] - '1'] = true;
        }
        int m = i / 3 * 3 + j / 3;
        int n = i % 3 * 3 + j % 3;
        if (board[m][n] == '.') {
        } else if (boxCheck[board[m][n] - '1']) {
          return false;
        } else {
          boxCheck[board[m][n] - '1'] = true;
        }
      }
    }
    return true;
  }

  public static boolean isValidSudoku2(char[][] board) {
    Set seen = new HashSet();
    for (int i = 0; i < 9; ++i) {
      for (int j = 0; j < 9; ++j) {
        char number = board[i][j];
        if (number != '.') {
          if (!seen.add(number + " in row " + i) ||
              !seen.add(number + " in column " + j) ||
              !seen.add(number + " in block " + i / 3 + "-" + j / 3)) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
