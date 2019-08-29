package src.medium;

import java.util.Vector;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/counting-bits/
 * @author: wqdong
 * @create: 2019-08-29 12:06
 **/
public class Counting_Bits {

  public static void main(String[] args) {
    int num = 11;

    for (int i : countBits(num)) {
      System.out.print(i + " ");
    }

    System.out.println();

    for (int i : countBits2(num)) {
      System.out.print(i + " ");
    }
  }

  public static int[] countBits(int num) {
    int[] res = new int[num + 1];
    for (int i = 1; i < num + 1; i++) {
      res[i] = Integer.bitCount(i);
    }
    return res;
  }

  public static int[] countBits2(int num) {
    int[] bits = new int[num+1];
    for (int i = 1; i < num + 1; i++) {
      bits[i] += bits[i & (i - 1)] + 1;
    }
    return bits;
  }
}
