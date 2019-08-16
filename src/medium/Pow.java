package src.medium;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/powx-n/
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * @author: wqdong
 * @create: 2019-08-16 19:34
 **/
public class Pow {

    public static void main(String[] args){
        System.out.println(myPow(2, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(1.00000, -2147483648));//int 边界
    }

    public static double myPow(double x, int n) {
        //int m = n > 0? n : -n;
        long m = n > 0 ? n : -(long)n;
        double pow = 1;

        while (m != 0){
            if ((m & 1) == 1){
                pow *= x;
            }
            x *= x;
            m >>= 1;
        }
        return n >= 0 ? pow : 1 / pow;
    }
}
