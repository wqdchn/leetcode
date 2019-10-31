package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/longest-common-prefix/
 * @author: wqdong
 * @create: 2019-10-31 13:32
 **/
public class Longest_Common_Prefix {

  public static void main(String[] args) {
    String[] strs = new String[]{"flower", "flow", "flight"};
    System.out.println(longestCommonPrefix(strs));
  }

  public static String longestCommonPrefix(String[] strs) {
    if (strs.length == 0 || strs == null) {
      return "";
    }
    String pre = strs[0];
    for (int i = 1; i < strs.length; i++) {
      while (strs[i].indexOf(pre) != 0) {
        pre = pre.substring(0, pre.length() - 1);
      }
    }
    return pre;
  }
}
