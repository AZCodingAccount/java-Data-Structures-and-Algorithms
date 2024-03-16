package com.zh.problem.doublep;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-15 21:44
 * @description: 盛最多水的容器——leetcode11
 **/
public class MaxArea {
    /*
            典型的双指针问题，需要弄清楚何时双指针移动即可
            1：定义i初始化为0、j初始化为height.length-1
            2：如果height[i]<height[j],说明改变i可能会让面积最大，i++，反之改变j
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i >= 0 && j < height.length && i < j) {
            if (height[i] < height[j]) {
                int area = (j - i) * height[i];
                i++;
                max = Math.max(max, area);
            } else {
                int area = (j - i) * height[j];
                j--;
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
    }
}
