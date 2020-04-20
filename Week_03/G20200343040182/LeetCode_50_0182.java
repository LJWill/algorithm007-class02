// 实现 pow(x, n) ，即计算 x 的 n 次幂函数。




class Solution {


    //need to confirm the range of x and n

    //solv1: brute force loop
    // public double myPow(double x, int n) {
    //     double result = 1.0;
    //     if (n<0) {
    //         x = 1/x;
    //         n = -n;
    //     }

    //     for (int i=0; i<n; i++) {
    //         result *= x;
    //     }
    //     return result;
    // }

    //solv2: divide n conquer
    // public double myPow(double x, int n) {
    //     double result = 1.0;
    //     if (n<0) {
    //         x = 1/x;
    //         n = -n;
    //     }

    //     result = _recur(x, n);

    //     return result;
    // }

    // public double _recur(double x, int n) {
    //     if (n == 0) return 1.0;

    //     double half = _recur(x, n/2);

    //     if (n%2 == 0) {
    //         return half * half;
    //     }else {
    //         return half * half * x;
    //     }

    // }

    //solv3 another recursion
    public double myPow(double x, int n) {
        if (n==0) return 1.0;
        if (n==1) return x;
        if (n==-1) return 1/x;

        double half = myPow(x, n/2);
        double rest = myPow(x, n%2);

        return rest * half * half;
    }
}