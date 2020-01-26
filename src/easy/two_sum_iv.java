package src.easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * @author: wqdong
 * @create: 2020-01-26 16:15
 **/
public class two_sum_iv {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {

    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);

    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);

    root.right.right = new TreeNode(7);

    int target = 9;

    if (findTarget(root, target)) {
      System.out.println("True");
    } else {
      System.out.println("False");
    }

    if (findTarget2(root, target)) {
      System.out.println("True");
    } else {
      System.out.println("False");
    }
  }

  // Runtime: 8 ms, faster than 13.61% of Java online submissions for Two Sum IV - Input is a BST.
  public static boolean findTarget(TreeNode root, int k) {
    Set<Integer> set = new HashSet<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      if (q.peek() != null) {
        TreeNode node = q.remove();
        if (set.contains(k - node.val)) {
          return true;
        }
        set.add(node.val);

        if (node.left != null) {
          q.add(node.left);
        }

        if (node.right != null) {
          q.add(node.right);
        }
      }
    }
    return false;
  }

  // Runtime: 4 ms, faster than 61.43% of Java online submissions for Two Sum IV - Input is a BST.
  public static boolean findTarget2(TreeNode root, int k) {
    Set<Integer> set = new HashSet();
    return find(root, k, set);
  }

  public static boolean find(TreeNode root, int k, Set<Integer> set) {
    if (root == null) {
      return false;
    }
    if (set.contains(k - root.val)) {
      return true;
    }
    set.add(root.val);
    return find(root.left, k, set) || find(root.right, k, set);
  }
}
