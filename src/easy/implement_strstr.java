package src.easy;

/**
 * @program: leetcode
 * @description: ${description}
 * @author: wqdong
 * @create: 2019-12-01 20:34
 **/
public class implement_strstr {

  public static void main(String[] args) {
    String haystack = "hello";
    String needle = "ll";
    System.out.println(strStr(haystack, needle));
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement strStr().
  public static int strStr(String haystack, String needle) {
    int len_needle = needle.length();
    int len_haystack = haystack.length();
    if (len_needle == 0) {
      return 0;
    }
    if (len_needle > len_haystack) {
      return -1;
    }
    for (int i = 0; i < len_haystack - len_needle + 1; i++) {
      if (haystack.substring(i, i + len_needle).equals(needle)) {
        return i;
      }
    }
    return -1;
  }

}
