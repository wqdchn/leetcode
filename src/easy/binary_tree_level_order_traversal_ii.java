package src.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * @author: wqdong
 * @create: 2020-01-26 09:45
 **/
public class binary_tree_level_order_traversal_ii {

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

    System.out.println(levelOrderBottom(root));
    System.out.println(levelOrderBottom2(root));
  }

  // Runtime: 2 ms, faster than 11.54% of Java online submissions for Binary Tree Level Order Traversal II.
  public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      int level_size = q.size();
      List<Integer> curr_level = new ArrayList<>();

      for (int i = 0; i < level_size; i++) {
        TreeNode curr_node = q.poll();
        curr_level.add(curr_node.val);
        if (curr_node.left != null) {
          q.add(curr_node.left);
        }
        if (curr_node.right != null) {
          q.add(curr_node.right);
        }
      }
      if (!curr_level.isEmpty()) {
        res.add(0, curr_level);
      }
    }
    return res;
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal II.
  public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    levelOrderBottom(root, res, 0);
    return res;
  }

  private static void levelOrderBottom(TreeNode root, List<List<Integer>> res, int height) {
    if (root == null) {
      return;
    }
    if (height >= res.size()) {
      res.add(0, new ArrayList<Integer>());
    }

    levelOrderBottom(root.left, res, height + 1);
    levelOrderBottom(root.right, res, height + 1);
    res.get(res.size() - height - 1).add(root.val);
  }
}
