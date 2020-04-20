// 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。





class Solution {
    //solv1: through recursion
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<> ();
        if (nums.length == 0) return output;
        
        _recur(output, nums, new ArrayList<Integer> (), 0);
        return output;
    }

    public void _recur(List<List<Integer>> output, int[] nums, List<Integer> subset, int index) {
        if (index == nums.length) {
            output.add(new ArrayList<Integer> (subset));
            return;
        }

        subset = new ArrayList<> (subset);

        //no action to the number of that index
        _recur(output, nums, subset, index+1);

        //add curr number to subset of that index
        subset.add(nums[index]);
        _recur(output, nums, subset, index+1);

        //reverse state
        // subset.remove(subset.size() - 1);
    }
    
}