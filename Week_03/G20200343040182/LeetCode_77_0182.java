// 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。




class Solution {


    //sovl1: dfs backtrack search
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<> ();
        if (n < 1 || k < 1) return output;
        Deque<Integer> comb = new ArrayDeque<> (k);
        
        backtrack(output, comb, n, k, 1);

        return output;
    }

    public void backtrack(List<List<Integer>> output, Deque<Integer> comb, int n, int k, int start) {
        if (comb.size() == k) {
            output.add(new ArrayList<> (comb));
            return;
        }

        // set upper bound for i in order to prune
        for (int i=start; i<=n - (k - comb.size()) + 1; i++) {
            comb.add(i);

            backtrack(output, comb, n, k, i+1);

            comb.removeLast();
            
        }
    }
}