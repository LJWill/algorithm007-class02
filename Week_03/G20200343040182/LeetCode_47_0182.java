// 给定一个可包含重复数字的序列，返回所有不重复的全排列。





class Solution {

    // solv1: backtrack
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> output = new ArrayList<> ();
        if (nums == null) return output;
        int len = nums.length;

        //sort arrays in order to prune tree
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        
        Deque<Integer> path = new ArrayDeque<> (len);

        backtrack(output, nums, 0, used, path);

        return output;
    }

    //dfs 
    public void backtrack(List<List<Integer>> output, int[] nums, int depth,                                                            boolean[] used, Deque<Integer> path) {

        if (depth == nums.length) {
            output.add(new ArrayList<> (path));
            return;
        }


        for (int i=0; i< nums.length; i++) {
            if (used[i]) continue;

            //pruning
            //!used[i-1] means 
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            
            path.add(nums[i]);
            used[i] = true;

            backtrack(output, nums, depth+1, used, path);

            //now its time for back tracking
            used[i] = false;
            path.removeLast();

        }
        

        


    }
}