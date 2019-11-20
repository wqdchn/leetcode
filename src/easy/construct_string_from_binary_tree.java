package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/construct-string-from-binary-tree/
 * @author: wqdong
 * @create: 2019-11-20 14:58
 **/
public class construct_string_from_binary_tree {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    TreeNode t = new TreeNode(1);
    t.left = new TreeNode(2);
    t.right = new TreeNode(3);
    t.left.left = new TreeNode(4);

    System.out.println(tree2str(t));
  }

  public static String tree2str(TreeNode t) {
    if (t == null) {
      return "";
    }
    if (t.left == null && t.right == null) {
      return t.val + "";
    }
    if (t.right == null) {
      return t.val + "(" + tree2str(t.left) + ")";
    }
    return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
  }
}
