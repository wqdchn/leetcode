package src.medium;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/broken-calculator/
 * @author: wqdong
 * @create: 2019-06-09 14:15
 *
 * On a broken calculator that has a number showing on its display, we can perform two operations:
 *
 * Double: Multiply the number on the display by 2, or;
 * Decrement: Subtract 1 from the number on the display.
 * Initially, the calculator is displaying the number X.
 *
 * Return the minimum number of operations needed to display the number Y.
 *
 * Example 1:
 *
 * Input: X = 2, Y = 3
 * Output: 2
 * Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
 * Example 2:
 *
 * Input: X = 5, Y = 8
 * Output: 2
 * Explanation: Use decrement and then double {5 -> 4 -> 8}.
 * Example 3:
 *
 * Input: X = 3, Y = 10
 * Output: 3
 * Explanation:  Use double, decrement and double {3 -> 6 -> 5 -> 10}.
 * Example 4:
 *
 * Input: X = 1024, Y = 1
 * Output: 1023
 * Explanation: Use decrement operations 1023 times.
 *
 * Note:
 *
 * 1 <= X <= 10^9
 * 1 <= Y <= 10^9
 *
 **/
public class Broken_calculator {

    public static void main(String[] args){
        int X = 3;
        int Y = 10;
        System.out.println(brokenCalc(X,Y));
    }


    public static int brokenCalc(int X, int Y) {
        return X >= Y ? X - Y : 1 + Y % 2 + brokenCalc(X, (Y + 1) / 2);
        //如果X大于Y那么直接返回X-Y我们就得到了从X得到Y的操作次数
        //如果X小于Y那么观察Y是奇数还是偶数
        //如果是奇数，那么最后一个操作一定是减一；如果是偶数，那么最后一个操作一定是乘二
    }
  }
