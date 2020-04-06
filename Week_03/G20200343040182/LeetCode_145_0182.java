// 给定一个二叉树，返回它的 后序 遍历。




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

    //solv1: recursion
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> output = new ArrayList<> ();
    //     helper(root, output);

    //     return output;
    // }

    // public void helper(TreeNode root, List<Integer> output) {
    //     if (root == null)
    //         return;

    //     helper(root.left, output);
    //     helper(root.right, output);
    //     output.add(root.val);
    // }

    solv2: iteration with stacks
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer> ();
        Stack<TreeNode> s = new Stack<> ();
        TreeNode peek = root;

        while (peek != null || !s.isEmpty()) {

            if (peek != null) {
               output.add(peek.val);
               s.push(peek.left);
               peek = peek.right;
            }else {
                peek = s.pop();
            }

        }

        Collections.reverse(output);

        return output;
    }


    //solv3: iteration - reverse preorder, using linked list
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     LinkedList<Integer> output = new LinkedList<Integer>();
        
    //     Stack<TreeNode> s = new Stack<> ();
    //     TreeNode peek = root;

    //     while (peek != null || !s.isEmpty()) {

    //         if (peek != null) {
    //            output.addFirst(peek.val);
    //            s.push(peek.left);
    //            peek = peek.right;
    //         }else {
    //             peek = s.pop();
    //         }

    //     }

    //     return output;
    // }

    
}