package src.hard;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/largest-palindrome-product/
 * @author: wqdong
 * @create: 2019-05-22 19:27
 *
 * Find the largest palindrome made from the product of two n-digit numbers.
 *
 * Since the result could be very large, you should return the largest palindrome mod 1337.
 *
 * Example:
 *
 * Input: 2
 *
 * Output: 987
 *
 * Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
 *
 * Note:
 *
 * The range of n is [1,8].
 *
 * Accepted
 * 14,788
 * Submissions
 * 54,041
 *
 * 输入一个数N，N在1-8之间，得到N位数的最大回文数串乘积，太大的话还要模1337取余数
 *
 * 例子是输入2，两位数的范围是10-99，要求从两个n位的数字的积中找到最大的回文数
 *
 * 那么我们可以形成99/99这两个2位的数字，然后积是9801，不是回文数
 *
 * 那么我们就要继续往下找，99*98=9702，也不是
 *
 * 一直往下找，直到99*91=9009这个回文数
 *
 **/
public class Largest_palindrome_product {
    public static  void main(String[] args){
        System.out.println("/////////////////////////////////");
        int n = 5;
        System.out.println(largestPalindrome(n));
        //int n = 132;
        //String t = Integer.toString(n);
        //System.out.println(t.charAt(t.length()-1));

    }

    public static int largestPalindrome(int n) {
        int upper = (int)Math.pow(10, n) - 1;
        int lower = upper / 10;
        for (int i = upper; i > lower; --i) {

            StringBuffer str = new StringBuffer();
            str.append(i +"");
            String a = str.reverse().toString();

            long p = Long.parseLong((i + a));
            for (int j = upper; j > lower; --j) {
                if (p / j > upper) break;
                if (p % j == 0) return (int)(p % 1337);
            }
        }
        return 9;
    }
}
