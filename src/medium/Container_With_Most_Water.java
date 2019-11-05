package src.medium;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/container-with-most-water/
 * @author: wqdong
 * @create: 2019-11-05 09:27
 **/
public class Container_With_Most_Water {

  public static void main(String[] args) {
    int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(maxArea(height));
    System.out.println(maxArea_2(height));
  }

  public static int maxArea(int[] height) { // Runtime: 206 ms, faster than 18.39%
    int result = 0;
    for (int i = 0; i < height.length; i++) {
      for (int j = i + 1; j < height.length; j++) {
        result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
      }
    }
    return result;
  }

  public static int maxArea_2(int[] height) { // Runtime: 1 ms, faster than 100.00%
    int result = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      int area = 0;
      if (height[left] < height[right]) {
        area = height[left] * (right - left);
        left++;
      } else {
        area = height[right] * (right - left);
        right--;
      }
      if (area > result) {
        result = area;
      }
    }
    return result;
  }
}
