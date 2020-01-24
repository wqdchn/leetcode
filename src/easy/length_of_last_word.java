package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/length-of-last-word/
 * @author: wqdong
 * @create: 2020-01-24 09:28
 **/
public class length_of_last_word {

  public static void main(String[] args) {
    String s = "Hello World";
    System.out.println(lengthOfLastWord(s));
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
  public static int lengthOfLastWord(String s) {
    int len = 0;
    for (int i = s.length() - 1; i >= 0 ;i--){
      if (s.charAt(i) == ' ' && len > 0){
        return len;
      }else if (s.charAt(i) != ' '){
        len++;
      }
    }
    return len;
  }
}
