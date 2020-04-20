// 给定一个 没有重复 数字的序列，返回其所有可能的全排列。





class Solution {

    //solv1: using dfs backtrack search
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<> ();
        if (nums == null) return output;
        
        Deque<Integer> path = new ArrayDeque<> (nums.length);
        boolean[] used = new boolean[nums.length];
        backtrack(output, nums, 0, path, used);

        return output;
    }

    public void backtrack(List<List<Integer>> output, int[] nums, int depth, Deque<Integer> path,                               boolean [] used) {
        if (depth == nums.length) {
            output.add(new ArrayList<> (path));
            return;
        }


        // no need to prune since no repeat numbers
        for (int i=0; i<nums.length; i++) {
            if (used[i] == true) continue;

            path.add(nums[i]);
            used[i] = true;

            backtrack(output, nums, depth+1, path, used);
            
            //return to the upper level
            used[i] = false;
            path.removeLast();

        }

    }
}