package com.zh.job.greedy;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-29 17:31
 * @description: 单调递增的数字—lc738
 **/
public class MonotoneIncreasingDigits {
    /*
        从当前数字开始，从后往前遍历，如果碰到前一个数字大于后一个数字的情况，前一个数字减1，后面的数字都赋值为9，
     */
    public int monotoneIncreasingDigits(int n) {
        String num = n + "";    // 转换成字符串好处理一点
        for (int i = num.length() - 1; i > 0; i--) {
            if (num.charAt(i - 1) > num.charAt(i)) {
                // 从当前遍历的索引开始到结束，填充成9。可以记录要填充的位置，最后统一填充
                num = num.substring(0, i - 1) +
                        (Integer.parseInt(String.valueOf(num.charAt(i - 1))) - 1) +
                        "9".repeat(num.length() - i);
            }
        }
        return Integer.parseInt(num);
    }

    public int monotoneIncreasingDigits2(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int index = digits.length;

        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i - 1] > digits[i]) {
                digits[i - 1]--;
                index = i;
            }
        }
        for (int i = index; i < digits.length; i++) {
            digits[i] = '9';
        }
        return Integer.parseInt(new String(digits));
    }

    public static void main(String[] args) {
        System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits(1234));
    }
}
