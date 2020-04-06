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
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> output = new ArrayList<Integer> ();

    //     helper(root, output);
        
    //     return output;
    // }

    // public void helper(TreeNode root, List<Integer> output) {

    //     if (root == null)
    //         return;

    //     helper(root.left, output);
    //     output.add(root.val);
    //     helper(root.right, output);

    // } 

    //sovl2: iteration using stack
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer> ();
        Stack <TreeNode> s = new Stack<TreeNode> ();
        TreeNode peek = root;

        while (peek != null || !s.isEmpty()) {

            // keep going left until meet leaf node
            if (peek != null) {
                s.push(peek);
                peek = peek.left;
            } else {
                peek = s.pop();
                output.add(peek.val);
                peek = peek.right;
            }

        }
        
        return output;
    }

}