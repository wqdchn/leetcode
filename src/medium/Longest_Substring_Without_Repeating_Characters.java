package src.medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @author: wqdong
 * @create: 2019-10-05 13:49
 **/
public class Longest_Substring_Without_Repeating_Characters {

  public static void main(String[] args) {
    String s = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(s));
    System.out.println(lengthOfLongestSubstring2(s));
  }

  public static int lengthOfLongestSubstring(String s) {
    if (s.length() == 0 || s == null) {
      return 0;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    int res = 0;
    for (int i = 0, j = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        j = Math.max(j, map.get(s.charAt(i)) + 1);
      }
      map.put(s.charAt(i), i);
      res = Math.max(res, i - j + 1);
    }
    return res;
  }

  public static int lengthOfLongestSubstring2(String s) {
    if (s.length() == 0 || s == null) {
      return 0;
    }
    int res = 0, left = 0, right = 0;
    HashSet<Character> set = new HashSet<Character>();
    while (right < s.length()) {
      if (!set.contains(s.charAt(right))) {
        set.add(s.charAt(right++));
        res = Math.max(res, set.size());
      } else {
        set.remove(s.charAt(left++));
      }
    }
    return res;
  }
}
