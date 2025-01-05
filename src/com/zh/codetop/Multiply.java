package com.zh.codetop;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-02 00:02
 * @description:
 **/
public class Multiply {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] arr = new int[m + n];
        // 模拟乘法，先不进位
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i + j] += ((num1.charAt(m - i - 1) - '0') * (num2.charAt(n - j - 1) - '0'));
            }
        }

        // 进位
        int carry = 0;
        for (int i = 0; i < m + n; i++) {
            int num = (arr[i] + carry) % 10;
            carry = (arr[i] + carry) / 10;
            arr[i] = num;
        }

        // 构造结果
        StringBuilder sb = new StringBuilder();
        for (int i = m + n - 1; i >= 0; i--) {
            if (sb.isEmpty()&&arr[i]==0&&i!=0){
                continue;
            }
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Multiply().multiply("1234", "567"));
    }
}
