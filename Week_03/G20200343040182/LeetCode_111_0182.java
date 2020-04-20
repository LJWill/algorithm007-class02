// 给定一个二叉树，找出其最小深度。

// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

// 说明: 叶子节点是指没有子节点的节点。



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
    //so1v1: recursion
    // public int minDepth(TreeNode root) {
    //     if (root == null) return 0;
    //     // if (root.left == null && root.right == null) return 1;

    //     int left = minDepth(root.left);
    //     int right = minDepth(root.right);
    //     //if curr node is not leaf node, then recur to add 1
    //     if (root.left != null && root.right != null) return Math.min(left, right) + 1;

    //     // if curr node has less or euqal than one child
    //     return Math.max(left, right) + 1;
    // }

    //solv2: iteration through bfs
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int minDepth = 0;
        LinkedList<TreeNode> queue = new LinkedList<> ();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            minDepth += 1;

            //interate through curr level of the tree
            for (int i=0; i<size; i++) {
                TreeNode peek = queue.poll();
                //if peek node is leaf
                if (peek.left == null && peek.right == null) return minDepth;

                if (peek.left != null) queue.add(peek.left);
                if (peek.right != null) queue.add(peek.right);
            }
            
            
        }
        
        return minDepth;
    }
}