package com.zh.hot.array;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-13 18:26
 * @description: 最大数—lc179
 **/
public class LargestNumber {
    public String largestNumber(int[] nums) {
        Integer[] boxedArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArr, (o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            String order1 = s1 + s2; // o1o2
            String order2 = s2 + s1; // o2o1
            return order2.compareTo(order1);
        });
        if(boxedArr[0]==0) return "0";
        StringBuilder res = new StringBuilder();
        for (int num : boxedArr) {
            res.append(num);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{111311, 1113}));
        System.out.println(new LargestNumber().largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
