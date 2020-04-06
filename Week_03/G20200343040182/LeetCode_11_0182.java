// 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
// 说明：你不能倾斜容器，且 n 的值至少为 2。
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/container-with-most-water
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



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

    //sovl2: 双下标向内收紧

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

