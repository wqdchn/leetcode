package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/add-binary/
 * @author: wqdong
 * @create: 2020-01-04 09:48
 **/
public class add_binary {

  public static void main(String[] args) {
    String a = "1010";
    String b = "10111";

    System.out.println(addBinary(a, b));
    System.out.println(addBinary_easy(a, b));
  }

  // Runtime: 4 ms, faster than 11.48% of Java online submissions for Add Binary.
  public static String addBinary(String a, String b) {
    if (a.length() > b.length()) {
      int dif_lne1 = a.length() - b.length();
      for (int i = 0; i < dif_lne1; i++) {
        b = "0" + b;
      }
    } else if (a.length() < b.length()) {
      int dif_len2 = b.length() - a.length();
      for (int i = 0; i < dif_len2; i++) {
        a = "0" + a;
      }
    }

    String sum = new String("");
    int carry = 0;

    for (int i = a.length() - 1; i >= 0; i--) {
      String a_temp = "" + a.charAt(i);
      String b_temp = "" + b.charAt(i);

      int sum_temp = Integer.parseInt(a_temp) + Integer.parseInt(b_temp) + carry;
      if (sum_temp >= 2) {
        carry = 1;
        sum = sum_temp - 2 + "" + sum;
      } else {
        carry = 0;
        sum = sum_temp + "" + sum;
      }

    }
    if (carry == 1) {
      sum = "1" + sum;
    }
    return sum;
  }

  // Some test case has runtime error
  public static String addBinary_easy(String a, String b) {
    int A = Integer.parseInt(a, 2);
    int B = Integer.parseInt(b, 2);
    int sum = A + B;
    return Integer.toBinaryString(sum);
  }
}
