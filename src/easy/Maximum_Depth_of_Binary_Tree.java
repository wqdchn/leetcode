package src.easy;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * @author: wqdong
 * @create: 2019-08-20 11:01
 **/
public class Maximum_Depth_of_Binary_Tree {

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

        System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
    }

    // recursively
    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    // bfs
    public static int maxDepth2(TreeNode root){
        if (root == null) return 0;

        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;

        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0){
                TreeNode node = q.poll();

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
