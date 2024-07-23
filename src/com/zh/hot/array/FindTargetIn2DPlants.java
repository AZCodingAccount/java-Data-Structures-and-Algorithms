package com.zh.hot.array;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-23 20:06
 * @description: 寻找目标值-二维数组——lcr121
 **/
public class FindTargetIn2DPlants {
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        if (plants.length == 0) return false;
        int m = plants.length, n = plants[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (plants[x][y] == target) return true;
            else if (plants[x][y] > target) y--;
            else x++;
        }
        return false;
    }
}
