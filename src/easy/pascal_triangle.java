package src.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/pascals-triangle/
 * @author: wqdong
 * @create: 2020-01-28 10:01
 **/
public class pascal_triangle {

  public static void main(String[] args) {
    int numRows = 5;
    for (List<Integer> tri : generate(numRows)) {
      System.out.println(tri);
    }
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();

    if (numRows == 0) {
      return triangle;
    }

    triangle.add(new ArrayList<>());
    triangle.get(0).add(1);

    for (int i = 1; i < numRows; i++) {
      List<Integer> row = new ArrayList<>();
      List<Integer> preRow = triangle.get(i - 1);

      row.add(1);

      for (int j = 1; j < i; j++) {
        row.add(preRow.get(j - 1) + preRow.get(j));
      }

      row.add(1);
      triangle.add(row);
    }

    return triangle;
  }

}
