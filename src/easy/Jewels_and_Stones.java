package easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/jewels-and-stones/
 * @author: wqdong
 * @create: 2019-05-14 21:44
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 *
 **/
public class Jewels_and_Stones {

    public static  void main(String[] args){
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones(J,S));

        J = "z";
        S = "ZZ";
        System.out.println(numJewelsInStones(J,S));
    }

    public static int numJewelsInStones(String J, String S) {
        char[] chJ = J.toCharArray();
        char[] chS = S.toCharArray();
        int output=0;
        for(int i=0;i < chJ.length;i++)
            for (int j = 0; j < chS.length; j++)
                if ((chS[j] - chJ[i]) == 0) {
                    output++;
                }
        return output;

    }
}
