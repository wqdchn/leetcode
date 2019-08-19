package src.medium;
import java.util.*;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @author: wqdong
 * @create: 2019-08-19 14:46
 **/
public class Binary_Tree_Level_Order_Traversal {

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

        System.out.println(levelOrder(root));

    }

    // bfs
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        ((Queue<TreeNode>) q).add(root);

        while (!q.isEmpty()){
            int level_size = q.size();
            List<Integer> curr_level = new ArrayList<>();

            for (int i = 0; i < level_size; i++){
                TreeNode curr_node = q.poll();
                curr_level.add(curr_node.val);
                if (curr_node.left != null){
                    ((Queue<TreeNode>) q).add(curr_node.left);
                }
                if (curr_node.right != null){
                    ((Queue<TreeNode>) q).add(curr_node.right);
                }
            }
            res.add(curr_level);
        }

        return res;
    }
}
