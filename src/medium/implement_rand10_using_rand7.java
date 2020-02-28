package src.medium;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/implement-rand10-using-rand7/
 * @author: wqdong
 * @create: 2020-02-28 19:06
 **/
public class implement_rand10_using_rand7 {

  public static int rand7() {

    int rd7 = (int) (1 + Math.random() * 7);
    return rd7;
  }

  public static int rand10() {
    int rd10 = 40;
    while (rd10 >= 40) {
      rd10 = 7 * (rand7() - 1) + (rand7() - 1);
    }

    return rd10 % 10 + 1;
  }

  public static int rand10_way2() {
    int rd10 = 0;

    while (true) {

      int rd49 = rand7() + (7 * (rand7() - 1));
      if (rd49 <= 40) {
        rd10 = (rd49 - 1) % 10 + 1;
        return rd10;
      }

    }

  }

}
