package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/same-tree/
 * @author: wqdong
 * @create: 2020-01-27 13:40
 **/
public class same_tree {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {

    TreeNode p = new TreeNode(1);
    p.left = new TreeNode(2);
    p.right = new TreeNode(3);

    TreeNode q = new TreeNode(1);
    q.left = new TreeNode(2);
    q.right = new TreeNode(3);

    if (isSameTree(p, q)) {
      System.out.println("True");
    } else {
      System.out.println("False");
    }
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    return isSameTree(p.left, q.left) && isSameTree(q.right, p.right);
  }
}
