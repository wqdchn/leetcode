package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/repeated-string-match/
 * @author: wqdong
 * @create: 2019-05-25 21:11
 *
 * Given two strings A and B,
 *
 * find the minimum number of times A has to be repeated such that B is a substring of it.
 *
 * If no such solution, return -1.
 *
 * For example, with A = "abcd" and B = "cdabcdab".
 *
 * Return 3, because by repeating A three times (“abcdabcdabcd”),
 *
 * B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 *
 * Note:
 * The length of A and B will be between 1 and 10000.
 *
 **/
public class Repeated_string_match {
    public static void main(String[] args){
        String a = "abc";
        String b = "cabcabcabca";
        System.out.println(repeatedStringMatch(a,b));
    }

    public static int repeatedStringMatch(String A, String B) {
        StringBuilder as = new StringBuilder(A);

        //B的长度除以A的长度再加上2，也就是当B长度小于A的时候，那么可能需要两个A
        for (int rep = 1; rep <= B.length() / A.length() + 2; rep++) {
            if (as.toString().contains(B)) {
                return rep;
            }
            as.append(new StringBuilder(A));
        }
        return -1;
    }

}
