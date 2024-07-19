package com.zh.hot.sort;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-19 16:52
 * @description: 交易逆序对的总数—lcr170
 **/
public class ReversePairs {
    int res = 0;

    public int reversePairs(int[] record) {
        split(record, 0, record.length - 1, new int[record.length]);
        return res;
    }

    private void split(int[] a, int l, int r, int[] temp) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        split(a, l, m, temp);   // 切分左边
        split(a, m + 1, r, temp);   // 切分右边
        merge(a, l, m, m + 1, r, temp);
        System.arraycopy(temp, 0, a, l, r - l + 1);    // 从left开始拷贝
    }

    private void merge(int[] a, int l1, int r1, int l2, int r2, int[] temp) {
        int p = 0;
        // 2 5      3 4
        while (l1 <= r1 && l2 <= r2) {
            if (a[l1] <= a[l2]) {
                temp[p++] = a[l1++];
            } else {
                temp[p++] = a[l2++];
                res += (r1 - l1 + 1);
            }
        }
        // 剩下的没有合并完的 1 2   3 4
        if (l1 <= r1) System.arraycopy(a, l1, temp, p, r1 - l1 + 1);
        if (l2 <= r2) System.arraycopy(a, l2, temp, p, r2 - l2 + 1);
    }


    public static void main(String[] args) {
        System.out.println(new ReversePairs().reversePairs(new int[]{9, 7, 5, 4, 6}));
    }
}
