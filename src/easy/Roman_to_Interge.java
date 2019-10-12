package src.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/roman-to-integer/
 * Example 1:
 *
 * Input: "III"
 * Output: 3
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 * Example 4:
 *
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 *
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * @author: wqdong
 * @create: 2019-10-12 11:42
 **/
public class Roman_to_Interge {
  public static void main(String[] args){
    String s = "MCMXCIV";
    System.out.println(romanToInt(s));
    System.out.println(romanToInt2(s));
  }

  public static int romanToInt(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    Map<Character, Integer> map = new HashMap<>();
    map.put('M', 1000);
    map.put('D', 500);
    map.put('C', 100);
    map.put('L', 50);
    map.put('X', 10);
    map.put('V', 5);
    map.put('I', 1);

    int res = map.get(s.charAt(0));

    for (int i = 1; i < s.length(); i++) {
      if (map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
        res += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
      } else {
        res += map.get(s.charAt(i));
      }
    }
    return res;
  }

  public static int romanToInt2(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    Map<Character, Integer> map = new HashMap<>();
    map.put('M', 1000);
    map.put('D', 500);
    map.put('C', 100);
    map.put('L', 50);
    map.put('X', 10);
    map.put('V', 5);
    map.put('I', 1);

    int res = 0;

    for (int i = 0; i < s.length(); i++) {
      if (i == s.length() - 1 || map.get(s.charAt(i + 1)) <= map.get(s.charAt(i))) {
        res += map.get(s.charAt(i));
      } else {
        res -= map.get(s.charAt(i));
      }
    }
    return res;
  }
}
