package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/fibonacci-number/
 * @author: wqdong
 * @create: 2019-11-30 14:59
 **/
public class fibonacci_number {

  public static void main(String[] args) {
    int N = 30;

    System.out.println(fib1(N));
    System.out.println(fib2(N));
    System.out.println(fib3(N));
  }

  public static int fib1(int N) {// 递归
    if (N <= 1) {
      return N;
    }
    return fib1(N - 1) + fib1(N - 2);
  }

  public static int fib2(int N) {// 遍历
    if (N <= 1) {
      return N;
    }
    int[] res = new int[N + 1];
    res[1] = 1;
    for (int i = 2; i < N + 1; i++) {
      res[i] = res[i - 1] + res[i - 2];
    }
    return res[N];
  }

  // 通项公式 f(n) = a1((b1)^n - (b2)^n)
  // a1 = 1/sqrt(5)
  // b1 = (1+sqrt(5))/2, b2 = (1-sqrt(5))/2
  public static int fib3(int N) {
    double a1 = 1 / Math.sqrt(5);
    double b1 = (1 + Math.sqrt(5)) / 2;
    double b2 = (1 - Math.sqrt(5)) / 2;

    return (int) (a1 * (Math.pow(b1, N) -  Math.pow(b2, N)));
  }
}
