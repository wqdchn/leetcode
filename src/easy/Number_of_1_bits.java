package src.easy;

/**
 * @program: leetcode
 * @description:  https://leetcode.com/problems/number-of-1-bits/
 * @author: wqdong
 * @create: 2019-06-11 21:19
 *
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 *
 * Example 1:
 *
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 *
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 *
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
 *
 **/
public class Number_of_1_bits {

  public static void main(String[] args) {
    int n = 0b000011111110;//声明一个二进制数
    System.out.println(hammingWeight(n));
    System.out.println(hammingWeight2(n));
    System.out.println(hammingWeight3(n));

    n = 0b11111111111111111111111111111101;
    System.out.println(hammingWeight(n));
    System.out.println(hammingWeight2(n));
    System.out.println(hammingWeight3(n));
  }

  public static int hammingWeight(int n) {
    return Integer.bitCount(n);
  }

  public static int hammingWeight2(int n) {
    int res = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) {
      if ((n & mask) != 0) {
        res++;
      }
      mask <<= 1;
    }
    return res;
  }

  public static int hammingWeight3(int n) {
    int res = 0;
    while (n != 0) {
      res++;
      n &= (n - 1);
    }
    return res;
  }
}
