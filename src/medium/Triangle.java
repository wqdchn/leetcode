package src.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/triangle/
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * @author: wqdong
 * @create: 2019-09-01 10:03
 **/
public class Triangle {

  public static void main(String[] args) {
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add((List<Integer>)Arrays.asList(2));
    triangle.add((List<Integer>)Arrays.asList(3,4));
    triangle.add((List<Integer>)Arrays.asList(6,5,7));
    triangle.add((List<Integer>)Arrays.asList(4,1,8,3));
    System.out.println(minimumTotal(triangle));
  }

  public static int minimumTotal(List<List<Integer>> triangle) {
    int[] res = new int[triangle.size() + 1];
    for (int i = triangle.size() - 1; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j);
      }
    }
    return res[0];
  }

}
