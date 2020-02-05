package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/reverse-bits/
 * @author: wqdong
 * @create: 2020-02-05 10:08
 **/
public class reverse_bits {

  public static void main(String[] args) {
    int n = 43261596;
    int reverse_n = reverseBits(n);

    System.out.println(Integer.toBinaryString(n));
    System.out.println(Integer.toBinaryString(reverse_n));

    System.out.println(reverse_n);
    System.out.println(Integer.reverse(n));
  }

  // you need treat n as an unsigned value
  // Runtime: 1 ms, faster than 99.89% of Java online submissions for Reverse Bits.
  public static int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      res = (res << 1) | (n & 1);
      n >>= 1;
    }
    return res;
  }

}
