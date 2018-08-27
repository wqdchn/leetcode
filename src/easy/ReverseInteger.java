package easy;

/**
 * @program: leetcode
 * @description: Given a 32-bit signed integer, reverse digits of an integer.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose
 * of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 * @author: wqdong
 * @create: 2018-08-27 19:33
 **/
public class ReverseInteger {

    public static int reverseK(int x) {//leetcode key
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static int reverse(int n){
        if(n>Integer.MAX_VALUE||n<Integer.MIN_VALUE){
            return 0;
        }
        String s = String.valueOf(n);
        if(n<0){
            s = s.substring(1,s.length());
            char[] array = s.toCharArray();
            String reverse = "-";
            for (int i = array.length - 1; i >= 0; i--) {
                reverse += array[i];
            }
            s = reverse;
        }else {
            char[] array = s.toCharArray();
            String reverse = "";
            for (int i = array.length - 1; i >= 0; i--) {
                reverse += array[i];
            }
            while (reverse.length()>1&&reverse.charAt(0)=='0'){
                reverse = reverse.substring(1,reverse.length());
            }
            s = reverse;
        }
        int i = 0;
        try{
             i = Integer.parseInt(s.toString().trim());
        }catch(Exception e){
            return 0;
        }
        return i;

    }

    public static void show(int[] num){
        for (int i = 0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] n = {123,-123,120};
        int x = 1534236469;
        System.out.println(reverseK(x));
        System.out.println(reverse(x));
    }

}
