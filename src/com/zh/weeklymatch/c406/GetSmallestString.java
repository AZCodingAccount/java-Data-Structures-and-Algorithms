package com.zh.weeklymatch.c406;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-14 10:53
 * @description: 406周赛第一题
 **/
public class GetSmallestString {
    public String getSmallestString(String s) {
        int len = s.length();
        StringBuilder res = new StringBuilder();
        boolean flag = false;    // 没有被交换过
        for (int i = 0; i < len; i++) {
            int i1 = s.charAt(i) - '0';
            if (flag || i == len - 1) {
                res.append(i1);
                continue;
            }
            int i2 = s.charAt(i + 1) - '0';
            if ((((isEven(i1) && isEven(i2)) || (!isEven(i1) && !isEven(i2))) && i1 > i2)) {
                res.append(i2);
                res.append(i1);
                i++;
                flag = true;
            } else {
                res.append(i1);
            }
        }
        return res.toString();
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(new GetSmallestString().getSmallestString("24"));
    }
}
