package src.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/invert-binary-tree/
 * @author: wqdong
 * @create: 2020-02-06 09:18
 **/
public class invert_binary_tree {


  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(7);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);

    pre_order(root);

    System.out.println();
    TreeNode invert_root = invertTree3(root);
    pre_order(invert_root);

  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
  public static TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode temp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(temp);
    return root;
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
  public static TreeNode invertTree2(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    invertTree(root.left);
    invertTree(root.right);
    return root;
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
  public static TreeNode invertTree3(TreeNode root) {
    if (root == null) {
      return null;
    }
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    ((LinkedList<TreeNode>) q).add(root);
    while (!q.isEmpty()) {
      TreeNode curr = q.poll();
      TreeNode temp = curr.left;
      curr.left = curr.right;
      curr.right = temp;

      if (curr.left != null) {
        ((LinkedList<TreeNode>) q).add(curr.left);
      }
      if (curr.right != null) {
        ((LinkedList<TreeNode>) q).add(curr.right);
      }
    }
    return root;
  }

  public static void pre_order(TreeNode root) {
    if (root != null) {
      System.out.print(root.val + " ");
      pre_order(root.left);
      pre_order(root.right);
    }
  }
}
