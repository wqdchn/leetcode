package src.easy;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/valid-anagram/
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * @author: wqdong
 * @create: 2019-08-13 12:32
 **/
public class Valid_anagram {

    public static void main(String[] args){
        String s = "abc";
        String t = "cba";

        Valid_anagram solution = new Valid_anagram();

        if (solution.isAnagram2(s, t)){
            System.out.print("is Anagram!");
        }else {
            System.out.print("not Anagram!");
        }
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1, str2);
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
