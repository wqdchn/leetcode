package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/find-the-difference/
 * @author: wqdong
 * @create: 2019-09-30 11:13
 **/
public class Find_the_Difference {

  public static void main(String[] agrs) {
    String s = "abcd";
    String t = "abcde";
    System.out.println(findTheDifference(s, t));
  }

  public static char findTheDifference(String s, String t) {
    int charCodeS = 0, charCodeT = 0;

    for (int i = 0; i < s.length(); ++i) {
      charCodeS += (int) s.charAt(i);
    }
    for (int i = 0; i < t.length(); ++i) {
      charCodeT += (int) t.charAt(i);
    }

    return (char) (charCodeT - charCodeS);
  }
}
