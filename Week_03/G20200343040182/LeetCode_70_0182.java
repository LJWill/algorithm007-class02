// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？


class Solution {
    public int climbStairs(int n) {

        if (n == 1 || n == 2) {
            return n;
        }
        else {
            int[] arr = new int[n+2];
            arr[0] = 1;
            arr[1] = 2;
           
            for (int i=0; i<n; i++) {
                arr[i+2] = arr[i+1] + arr[i];
            }

            return arr[n-1];
        }
        
    }
}