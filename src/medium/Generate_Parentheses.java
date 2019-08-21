package src.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/generate-parentheses/
 * @author: wqdong
 * @create: 2019-08-21 11:29
 **/
public class Generate_Parentheses {

  public static void main(String[] args) {
    int n = 3;
    System.out.println(generateParenthesis(3));
  }

  public static List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    generate("", res, n, n);
    return res;
  }

  public static void generate(String sublist, List<String> res, int left, int right) {
    if (left == 0 && right == 0) {
      res.add(sublist);
      return;
    }
    if (left > 0) {
      generate(sublist + "(", res, left - 1, right);
    }
    if (right > left) {
      generate(sublist + ")", res, left, right - 1);
    }
  }
}
