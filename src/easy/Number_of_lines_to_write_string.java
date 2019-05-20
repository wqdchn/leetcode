package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/number-of-lines-to-write-string/
 * @author: wqdong
 * @create: 2019-05-20 19:59
 *
 * Example :
 * Input:
 * widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "abcdefghijklmnopqrstuvwxyz"
 * Output: [3, 60]
 * Explanation:
 * All letters have the same length of 10. To write all 26 letters,
 * we need two full lines and one line with 60 units.
 *
 * Example :
 * Input:
 * widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "bbbcccdddaaa"
 * Output: [2, 4]
 * Explanation:
 * All letters except 'a' have the same length of 10, and
 * "bbbcccdddaa" will cover 9 * 10 + 2 * 4 = 98 units.
 * For the last 'a', it is written on the second line because
 * there is only 2 units left in the first line.
 * So the answer is 2 lines, plus 4 units in the second line.
 *
 **/
public class Number_of_lines_to_write_string {

    public static  void main(String[] args){
        int[] widths = new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String S = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(numberOfLines(widths, S)[0]+" "+numberOfLines(widths, S)[1]);

        widths = new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        S = "bbbcccdddaaa";
        System.out.println(numberOfLines(widths, S)[0]+" "+numberOfLines(widths, S)[1]);

    }

    public static int[] numberOfLines(int[] widths, String S) {
        int left = 0;
        int lines = 0;
        for (char c : S.toCharArray()) {
            left += widths[c - 'a'];
            if (left >= 100) {
                lines ++;
                left = left > 100 ? widths[c - 'a'] : 0;
            }
        }
        lines += left > 0 ? 1 : 0;
        int[] output = new int[]{lines, left};
        return output ;
    }

}
