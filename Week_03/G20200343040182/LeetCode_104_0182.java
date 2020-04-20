// 给定一个二叉树，找出其最大深度。

// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

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
    //solv1: normal recurrsion
    // public int maxDepth(TreeNode root) {
    
    //     if (root == null) return 0;

    //     int left = maxDepth(root.left);
    //     int right = maxDepth(root.right);

    //     // System.out.print(right);
    //     return Math.max(left, right) + 1;
    // }
    
    //solv2: dfs serarch
    // public int maxDepth(TreeNode root) {
    //     LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<> ();
    //     if (root == null) return 0;
    //     int maxDepth = 0;
    //     stack.addFirst(new Pair<TreeNode, Integer>(root, 1));

    //     while (!stack.isEmpty()) {
    //         Pair peek = stack.poll();
            
    //         TreeNode peekNode = (TreeNode)peek.first;
    //         int peekDepth = (int)peek.second;

    //         if (peekNode != null) {
    //             maxDepth = Math.max(maxDepth, peekDepth);
    //             stack.addFirst(new Pair<TreeNode, Integer>(peekNode.left, peekDepth+1));
    //             stack.addFirst(new Pair<TreeNode, Integer>(peekNode.right, peekDepth+1));
    //         }
    //     }
    //     // System.out.print(right);
    //     return maxDepth;
    // }

    //solv3: bfs search
    public int maxDepth(TreeNode root) {
        int depth = 0;
        LinkedList<TreeNode> queue = new LinkedList<> ();
        if (root == null) return 0;
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth += 1;

            //iterate though curr level
            for (int i=0; i<size; i++) {
                TreeNode peek = queue.poll();
                
                if (peek.left != null)    queue.add(peek.left);
                if (peek.right != null)    queue.add(peek.right);
                
            }
            
        }

        return depth;
    }
}


class Pair<U, V> {

    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}