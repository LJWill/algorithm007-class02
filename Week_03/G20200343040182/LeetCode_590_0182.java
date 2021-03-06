// 给定一个 N 叉树，返回其节点值的后序遍历。



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

    // solv1: recursion
    // public List<Integer> postorder(Node root) {
    //     List<Integer> output = new ArrayList<> ();
    //     helper(root, output);

    //     return output;
    // }

    // public void helper(Node root, List<Integer> output) {
    //     if (root == null)
    //         return;

    //     for (Node child:root.children) {
    //         helper(child, output);
    //     }

    //     output.add(root.val);
    // }

    //solv2: interation using stack
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> output = new LinkedList<> ();
        Stack<Node> s = new Stack<> ();
        s.push(root);

        if (root == null)
            return output;
            
        while (!s.isEmpty()) {
            Node peek = s.pop();
            output.addFirst(peek.val);
            
            for(Node child:peek.children) {
                s.push(child);

            }

        }
        
        return output;
    }
}