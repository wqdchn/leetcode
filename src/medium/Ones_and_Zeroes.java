package src.medium;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/ones-and-zeroes/
 * @author: wqdong
 * @create: 2019-05-17 14:42
 * Note:
 *
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600.
 *
 * Example 1:
 *
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 *
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 *
 * Example 2:
 *
 * Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 *
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 **/
public class Ones_and_Zeroes {

    public static  void main(String[] args){
        String[] str ;
        int m = 5;// m 个0
        int n = 3;// n 个1

        str = new String[]{"10", "0001", "111001", "1", "0"};
        for(String s: str){
            System.out.println(s.toCharArray());
        }

        System.out.println("/////////////////////////////////");
        System.out.println(findMaxForm(str, m, n));

        str = new String[]{"10", "0", "1"};
        for(String s: str){
            System.out.println(s.toCharArray());
        }

        System.out.println("/////////////////////////////////");
        System.out.println(findMaxForm(str, 1, 1));

    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int output = 0;

        int[][] dp = new int[m+1][n+1];
        for (int s = strs.length-1; s>=0; s--)
        {
            int[] zero_ones_count = new int[2];
            zero_ones_count[0] = strs[s].replaceAll("1", "").length(); //just the zeros
            zero_ones_count[1] = strs[s].replaceAll("0", "").length(); //just the ones

            for (int i = m; i >= zero_ones_count[0]; i--){
                for (int j = n; j >= zero_ones_count[1]; j--){
                    dp[i][j] = Math.max(1 + dp[i-zero_ones_count[0]][j-zero_ones_count[1]], dp[i][j]);
                }
            }

        }
        output = dp[m][n];
        return output;
    }
}
