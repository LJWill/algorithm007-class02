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
    // public List<List<Integer>> levelOrder(Node root) {
    //     List<List<Integer>> output = new ArrayList<> ();
    //     Queue<Node> q = new LinkedList<> ();

    //     if (root == null)
    //         return output;

    //     q.add(root);

    //     while (!q.isEmpty()) {
    //        List<Integer> level = new ArrayList<> ();
            
    //         int size = q.size();
    //         for(int i=0; i<size; i++) {
    //             Node peek = q.poll();
    //             level.add(peek.val);
    //             q.addAll(peek.children);
    //         }

    //         output.add(level);
    //     }
        
    //     return output;
    // }

    //solv2: using prev and curr layers 
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> output = new ArrayList<> ();
        
        if (root == null)
            return output;

        List<Node> prevLayer = new ArrayList<> ();
        prevLayer.add(root);

        while (!prevLayer.isEmpty()) {
            List<Node> currLayer = new ArrayList<> ();
            List<Integer> level = new ArrayList<> ();

            for(Node node:prevLayer) {
                level.add(node.val);
                currLayer.addAll(node.children);
            }

            prevLayer = currLayer;
            output.add(level);
        }

        return output;
    }

}