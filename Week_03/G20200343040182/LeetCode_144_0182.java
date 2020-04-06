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
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> output = new ArrayList<> ();
    //     helper(root, output);

    //     return output;
    // }

    // public void helper(TreeNode root, List<Integer> output) {
    //     if (root == null)
    //         return;

    //     output.add(root.val);
    //     helper(root.left, output);        
    //     helper(root.right, output);
    // }

    //sovl2: interation using stack
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<> ();
        Stack<TreeNode> s = new Stack<> ();
        TreeNode peek = root;

        while(peek != null || !s.isEmpty()) {
           if (peek != null) {
               output.add(peek.val);
               s.push(peek.right);
               peek = peek.left;
           }else {
               peek = s.pop();
           }
        }

        return output;
    }


}