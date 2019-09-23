package src.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/longest-string-chain/ Example 1:
 *
 * Input: ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: one of the longest word chain is "a","ba","bda","bdca".
 *
 * Note:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of English lowercase letters.
 * @author: wqdong
 * @create: 2019-09-23 11:53
 **/
public class Longest_String_Chain {

  public static void main(String[] args) {
    String[] words = new String[]{"a", "b", "bca", "ba", "bda", "bdca"};
    System.out.println(longestStrChain(words));
    System.out.println(longestStrChain2(words));
  }

  public static int longestStrChain(String[] words) {
    Map<String, Integer> dp = new HashMap<>();
    Arrays.sort(words, (a, b) -> a.length() - b.length());
    int res = 0;
    for (String word : words) {
      int cur_longest = 0;
      for (int i = 0; i < word.length(); ++i) {
        String prev = word.substring(0, i) + word.substring(i + 1, word.length());
        cur_longest = Math.max(cur_longest, dp.getOrDefault(prev, 0) + 1);
      }
      dp.put(word, cur_longest);
      res = Math.max(res, cur_longest);
    }
    return res;
  }

  // longestStrChain2 Sample from 6ms Solution
  public static int longestStrChain2(String[] words) {
    List<List<String>> strings = new ArrayList<>();
    for (int i = 0; i < 16; i++) {
      strings.add(new ArrayList<>());
    }
    for (String word : words) {
      strings.get(word.length() - 1).add(word);
    }
    int res = 0;
    for (int i = 0; i < 16 && res < 16 - i; i++) {
      for (String cur : strings.get(i)) {
        res = Math.max(res, test(cur, i, strings));
      }
    }
    return res;
  }

  private static int test(String cur, int idx, List<List<String>> strings) {
    if (idx == 15) {
      return 1;
    }
    int res = 1;
    for (String next : strings.get(idx + 1)) {
      if (match(cur, next)) {
        res = Math.max(res, 1 + test(next, idx + 1, strings));
      }
    }
    return res;
  }

  private static boolean match(String cur, String next) {
    if (next.length() - cur.length() != 1) {
      return false;
    }
    int i = 0, j = 0;
    boolean inserted = false;
    while (i < cur.length()) {
      if (cur.charAt(i) != next.charAt(j)) {
        if (inserted) {
          return false;
        }
        inserted = true;
        j++;
      } else {
        i++;
        j++;
      }
    }
    return true;
  }
}
