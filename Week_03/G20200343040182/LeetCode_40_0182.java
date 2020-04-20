// 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。



class Solution {
    //solv1: through recursion
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> output = new ArrayList<> ();
    //     if (nums.length == 0) return output;
        
    //     _recur(output, nums, new ArrayList<Integer> (), 0);
    //     return output;
    // }

    // public void _recur(List<List<Integer>> output, int[] nums, List<Integer> subset, int index) {
    //     if (index == nums.length) {
    //         output.add(new ArrayList<Integer> (subset));
    //         return;
    //     }

    //     subset = new ArrayList<> (subset);

    //     //no action to the number of that index
    //     _recur(output, nums, subset, index+1);

    //     //add curr number to subset of that index
    //     subset.add(nums[index]);
    //     _recur(output, nums, subset, index+1);

    //     //reverse state
    //     // subset.remove(subset.size() - 1);
    // }

    //solv2: binary style
    //time: O(n * 2^n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<> ();
        if (nums.length == 0) return output;
        
        for (int i=0; i<(1<<nums.length); i++){
            List<Integer> subset = new ArrayList<> ();
            for (int j=0; j<nums.length; j++) {
                if ((i>>j & 1) == 1) subset.add(nums[j]);
            }
            output.add(subset);
        }

        return output;
    }
    
}