package com.zh.weeklymatch.dc138;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-08-31 22:57
 * @description: 第一题-模拟题
 **/
public class GenerateKey {
    public int generateKey(int num1, int num2, int num3) {
        StringBuilder sb = new StringBuilder();
        String newNum1 = addZero(num1);
        String newNum2 = addZero(num2);
        String newNum3 = addZero(num3);
        for (int i = 0; i < 4; i++) {
            sb.append(Math.min(newNum1.charAt(i) - '0', Math.min(newNum2.charAt(i) - '0', newNum3.charAt(i) - '0')));
        }
        return Integer.parseInt(sb.toString());
    }

    // 转文字
    private String addZero(int num) {
        StringBuilder sb = new StringBuilder();
        String numStr = String.valueOf(num);
        int cnt = 4 - numStr.length();
        while (cnt-- > 0) {
            sb.append("0");
        }
        sb.append(numStr);
        return sb.toString();
    }
}
