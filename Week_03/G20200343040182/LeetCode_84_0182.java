// 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。



class Solution {

    //solv1 : 暴力法
    // public int maxArea(int[] height) {

    //     int maxArea = 0;
    //     for (int i=0; i<height.length-1; i++) {
    //         for (int j=i+1; j<height.length; j++) {
    //             int area = _getArea(i, j, height);
    //             maxArea = Math.max(maxArea, area);
    //         }
    //     }

    //     return maxArea;
    // }

    // public int _getArea(int i, int j, int[] height) {
    //     return (j-i) * Math.min(height[j], height[i]);
    // }

    //sovl2: 双下标向内收紧, 左右夹逼

    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i=0, j=height.length-1; i<j; ) {
            int nextHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * nextHeight;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

}