package com.zh.weeklymatch.c407;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-21 11:15
 * @description: 将 1 移动到末尾的最大操作次数—407第三题
 **/
public class MaxOperations {
    public int maxOperations(String s) {
        int res = 0;
        char[] chs = s.toCharArray();
        boolean flag = true, isFirst = true; // 标记是否需要下一轮扫描
        int cache = 0;
        do {
            flag = true;
            isFirst = true;
            for (int i = cache; i < chs.length - 1; i++) {
                if (chs[i] == '1' && chs[i + 1] == '0') {
                    // 右移并交换
                    res++;
                    int j = i + 1;  // 跳过0
                    while (j < s.length() - 1 && chs[j + 1] != '1') {
                        j++;
                    }
                    chs[j] = '1';
                    chs[i] = '0';
                    i = j;
                    if (isFirst) {
                        cache = Math.max(i - 1, 0);
                        isFirst = false;
                    }
                    flag = false;   // 有交换就可以继续扫描
                }
            }
        } while (!flag);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new MaxOperations().maxOperations("1001101"));
    }
}
