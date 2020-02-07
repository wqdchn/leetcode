package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/reverse-string/
 * @author: wqdong
 * @create: 2020-02-07 09:57
 **/
public class reverse_string {

  public static void main(String[] args) {
    char[] s = new char[]{'h', 'e', 'l', 'l'};
    reverseString(s);
    for (char c : s){
      System.out.print(c + " ");
    }
  }

  // Runtime: 1 ms, faster than 99.54% of Java online submissions for Reverse String.
  public static void reverseString(char[] s) {
    int i = 0;
    int j = s.length - 1;

    while (i <= j){
      char temp = s[i];
      s[i] = s[j];
      s[j] = temp;

      i++;
      j--;
    }
  }

}
