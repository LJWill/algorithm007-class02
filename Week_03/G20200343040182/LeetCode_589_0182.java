
// 给定一个 N 叉树，返回其节点值的前序遍历。
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {

    //solv1: recursion
    // public List<Integer> preorder(Node root) {
    //     List<Integer> output = new ArrayList<> ();

    //     helper(root, output);

    //     return output;
    // }

    // public void helper(Node root, List<Integer> output) {
    //     if (root == null)
    //         return;
        
    //     output.add(root.val);

    //     for (Node child:root.children) {
    //         helper(child, output);
    //     }
    // }

    //sovl2: iteration using stack
    public List<Integer> preorder(Node root) {
        List<Integer> output = new ArrayList<> ();
        Stack<Node> s = new Stack<> ();

        if (root == null)
            return output;

        s.push(root);
        while (!s.isEmpty()) {
            Node peek = s.pop();
            output.add(peek.val);

            for (int i=peek.children.size()-1; i>=0; i--) {
                s.push(peek.children.get(i));
            }


        }
    

        return output;
    }

}