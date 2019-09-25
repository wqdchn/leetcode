package src.hard;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/trapping-rain-water/
 * @author: wqdong
 * @create: 2019-09-25 15:02
 **/
public class Trapping_Rain_Water {

  public static void main(String[] args) {
    int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(trap(height));
    System.out.println(trap2(height));
  }

  public static int trap(int[] height) {
    if (height.length == 0) {
      return 0;
    }
    int left = 0;
    int right = height.length - 1;
    int leftMax = 0;
    int rightMax = 0;
    int res = 0;

    while (left < right) {
      if (height[left] < height[right]) {
        leftMax = Math.max(height[left], leftMax);
        res += leftMax - height[left];
        left++;
      } else {
        rightMax = Math.max(height[right], rightMax);
        res += rightMax - height[right];
        right--;
      }
    }
    return res;
  }

  public static int trap2(int[] height) {
    int res = 0;
    int curr = 0;
    Stack<Integer> stack = new Stack<>();
    while (curr < height.length) {
      while (!stack.isEmpty() && height[curr] > height[stack.peek()]) {
        int top = height[stack.pop()];
        if (stack.isEmpty()) {
          break;
        }
        int distance = curr - stack.peek() - 1;
        int h = Math.min(height[curr], height[stack.peek()]) - top;
        res += distance * h;
      }
      stack.push(curr);
      curr++;
    }
    return res;
  }
}
