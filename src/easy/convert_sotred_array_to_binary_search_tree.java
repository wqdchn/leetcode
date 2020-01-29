package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author: wqdong
 * @create: 2020-01-29 09:25
 **/
public class convert_sotred_array_to_binary_search_tree {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-10, -3, 0, 5, 9};
    TreeNode root = sortedArrayToBST(nums);
    preOrder_rec(root);
  }


  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
  public static TreeNode sortedArrayToBST(int[] nums) {
    return dfs_helper(nums, 0, nums.length - 1);
  }

  public static TreeNode dfs_helper(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }
    int mid = left + (right - left) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = dfs_helper(nums, left, mid - 1);
    root.right = dfs_helper(nums, mid + 1, right);
    return root;
  }

  public static void preOrder_rec(TreeNode root) { // 前序遍历，递归
    if (root != null) {
      System.out.print(root.val + " ");
      preOrder_rec(root.left);
      preOrder_rec(root.right);
    }
  }
}
