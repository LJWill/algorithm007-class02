// 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

// 假设一个二叉搜索树具有如下特征：

// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // BST - in order traversal is Incremental!!!

 class Solution {


    //solv2: in order traversal with recurrsion
    // public boolean isValidBST(TreeNode root) {
    //     boolean result = true;
    //     if (root == null) return result;

    //     _recur(root, result, 0);
        
    //     System.out.println("result: " + result);

    //     return result;
    // }

    // private void _recur(TreeNode node, boolean result, int lastVisit) {

    //     if (node == null) {
    //         return;
    //     } 
        
    //     if (node.left != null) {
    //         _recur(node.left, result, lastVisit);
    //     }else {
    //         lastVisit = node.val;
    //     }    
        
    
    //     if (node.val < lastVisit) {
    //         result = false;
    //     }

    //     System.out.println(lastVisit + ", " + node.val + ", " + result);

    //     lastVisit = node.val;
    
        
    //     if (node.right != null) {
    //         _recur(node.right, result, lastVisit);
    //     }else {
    //         lastVisit = node.val;
    //     }
        
        
    
    // }

    //solv: inorder traversal use iteration
    // public boolean isValidBST(TreeNode root) {
    //     LinkedList<TreeNode> stack = new LinkedList<> ();
    //     long lastVisit = Long.MIN_VALUE;
    //     boolean result = true;
    //     TreeNode peek = root;

    //     while (peek != null || !stack.isEmpty()) {
    //         while (peek != null) {
    //             stack.addFirst(peek);
    //             peek = peek.left;
    //         }

    //         peek = stack.poll();

    //         if (peek.val <= lastVisit) result = false;

    //         lastVisit = peek.val;

    //         peek = peek.right;

    //     }

    //     return result;
    // }

    //solv3: dfs search through recurrsoin
    public boolean isValidBST(TreeNode root) {
        boolean result = true;
        result = _recur(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return result;
    }

    public boolean _recur(TreeNode node, long lower, long upper) {
        if (node == null) return true;

        if (node.val <= lower || node.val >= upper) return false;

        if (!_recur(node.left, lower, node.val)) return false;

        if (!_recur(node.right, node.val, upper)) return false;

        return true;
    }

}