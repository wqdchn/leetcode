package src.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * @author: wqdong
 * @create: 2019-08-20 12:54
 **/
public class Minimum_Depth_of_Binary_Tree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(minDepth(root));
        System.out.println(minDepth2(root));
    }

    // dfs
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right ==0) ?
                left + right + 1 : Math.min(left, right) + 1;
    }

    // bfs
    public static int minDepth2(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;

        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0){
                TreeNode node = q.poll();
                if (node.left == null && node.right == null){
                   return depth;
                }
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
            depth++;
        }

        return depth;
    }
}
