package src.medium;

import java.util.*;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * @author: wqdong
 * @create: 2019-05-16 18:36
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 *
 * find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 **/
public class Kth_Smallest_Element_in_a_Sorted_Matrix {

    public static void main(String[] args){
        int[][] matrix = {{1,  5,  9}, {10, 11, 13},{12, 13, 15}};
        int k = 8;

        //打印二维数组
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }

        System.out.println("第"+k+"大的数是"+kthSmallest(matrix, k));

    }

    public static int kthSmallest(int[][] matrix, int k) {
        int output = 0;
        List<Integer> matlist = new ArrayList();

        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++)
                matlist.add(matrix[i][j]);
            System.out.println();
        }

        Collections.sort(matlist);
        return matlist.get(k-1);
    }

    // Runtime: 12 ms, faster than 62.51% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
    public static int kthSmallest2(int[][] matrix, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return o2 - o1;
            }
        });

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (pq.size() < k) {
                    pq.offer(matrix[i][j]);
                } else {

                    if (matrix[i][j] < pq.peek()) {
                        pq.poll();
                        pq.offer(matrix[i][j]);
                    }

                }
            }
        }

        return pq.peek();
    }
}
