package src.medium;

import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/validate-binary-search-tree/
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * @author: wqdong
 * @create: 2019-08-15 12:30
 **/
public class Vakudate_binary_search_tree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        if (isValidBST(root,null,null)){
            System.out.print("is BST!");
        }else {
            System.out.print("not BST!");
        }

    }

    public static boolean isValidBST(TreeNode root, Integer min, Integer max) {

        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    //Solution1:Inorder traversal

    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
