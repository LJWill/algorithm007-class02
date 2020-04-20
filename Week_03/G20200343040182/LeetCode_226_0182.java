// 翻转一棵二叉树。






/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    //solv1: recurrsion
    // public TreeNode invertTree(TreeNode root) {

    //     if (root == null) return null;
    //     _recur(root);
     
    //     return root;
    // }

    // public void _recur(TreeNode node) {

    //     if (node == null) return;

    //     _recur(node.left);
    //     _recur(node.right);
    
        
    //     TreeNode tmp = null;
    //     tmp = node.left;
    //     node.left = node.right;
    //     node.right = tmp;  
    // }

    //solv2: another recurrsion
    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left  = right;

        return root;
    }
}