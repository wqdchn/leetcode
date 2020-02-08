package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/count-primes/
 * @author: wqdong
 * @create: 2020-02-08 08:51
 **/
public class count_primes {

  public static void main(String[] args) {
    int n = 10000000;
    System.out.println(countPrimes(n));
    System.out.println(countPrimes2(n));
  }

  //Runtime: 548 ms, faster than 13.15% of Java online submissions for Count Primes.
  public static int countPrimes(int n) {
    int count = 0;
    for (int i = 1; i < n; i++) {
      if (isPrime(i)) {
        count++;
      }
    }

    return count;
  }

  public static boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  // Runtime: 6 ms, faster than 99.32% of Java online submissions for Count Primes.
  public static int countPrimes2(int n) {
    if (n < 3) {
      return 0;
    }
    int count = n / 2;
    boolean s[] = new boolean[n];

    for (int i = 3; i * i < n; i += 2) {
      if (s[i]) {
        continue;
      }
      for (int j = i * i; j < n; j += i * 2) {
        if (!s[j]) {
          s[j] = true;
          count--;
        }
      }
    }

    return count;
  }

}
