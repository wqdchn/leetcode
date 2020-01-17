package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/path-sum/
 * @author: wqdong
 * @create: 2020-01-17 08:58
 **/
public class path_sum {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public static void main(String[] args){
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(1);

    int sum = 22;

    if (hasPathSum(root, sum)){
      System.out.println("Has path sum.");
    }else {
      System.out.println("Not has path sum.");
    }

  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
  public static boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    if (root.left == null && root.right == null) return root.val == sum;
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
  }
}
