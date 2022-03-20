package medium;

import java.util.ArrayList;

public class ZigzagConversion {

  public static void main(String[] args) {
    String s = "LEETCODE";
    int numRows = 3;
    System.out.println(convert(s, numRows));
    System.out.println(convert2(s, numRows));
  }

  //  Runtime: 11 ms, faster than 65.65% of Java online submissions for Zigzag Conversion.
  //  Memory Usage: 48.8 MB, less than 51.28% of Java online submissions for Zigzag Conversion.
  public static String convert(String s, int numRows) {
    if (numRows < 2) {
      return s;
    }
    ArrayList<StringBuilder> rows = new ArrayList<StringBuilder>();
    for (int i = 0; i < numRows; i++) {
      rows.add(new StringBuilder());
    }
    int i = 0, flag = -1;
    for (char c : s.toCharArray()) {
      rows.get(i).append(c);
      if (i == 0 || i == numRows - 1) {
        flag = -flag;
      }
      i += flag;
    }
    StringBuilder res = new StringBuilder();
    for (StringBuilder row : rows) {
      res.append(row);
    }

    return res.toString();
//    return rows.stream().reduce(StringBuilder::append).get().toString();

  }

  //  Runtime: 17 ms, faster than 46.72% of Java online submissions for Zigzag Conversion.
  //  Memory Usage: 42.8 MB, less than 83.11% of Java online submissions for Zigzag Conversion.
  public static String convert2(String s, int numRows) {
    int n = s.length();
    if (numRows == 1 || numRows >= n) {
      return s;
    }
    String res = "";
    int t = numRows * 2 - 2;
    for (int i = 0; i < numRows; ++i) { // 枚举矩阵的行
      for (int j = 0; j + i < n; j += t) { // 枚举每个周期的起始下标
        res += s.charAt(j + i); // 当前周期的第一个字符
        if (0 < i && i < numRows - 1 && j + t - i < n) {
          res += s.charAt(j + t - i); // 当前周期的第二个字符
        }
      }
    }
    return res;

  }

}
