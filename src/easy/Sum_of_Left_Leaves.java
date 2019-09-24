package src.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/sum-of-left-leaves/
 * @author: wqdong
 * @create: 2019-09-24 18:20
 **/
public class Sum_of_Left_Leaves {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    System.out.println(sumOfLeftLeaves(root));

  }

  public static int sumOfLeftLeaves(TreeNode root) {
    int res = 0;

    if (root == null || root.left == null && root.right == null) {
      return 0;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      int level_size = q.size();
      List<Integer> curr_level = new ArrayList<>();

      for (int i = 0; i < level_size; i++) {
        TreeNode curr_node = q.poll();
        curr_level.add(curr_node.val);
        if (curr_node.left != null) {
          q.offer(curr_node.left);
        }
        if (curr_node.right != null) {
          q.offer(curr_node.right);
        }
        if (curr_node.left != null && curr_node.left.left == null && curr_node.left.right == null) {
          res += curr_node.left.val;
        }
      }
    }
    return res;
  }
}
