package com.zh.hot.string;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-15 21:19
 * @description: 验证IP地址—lc468
 **/
public class ValidIPAddress {
    public String validIPAddress(String queryIP) {
        String[] arr1 = queryIP.split("\\.", -1);
        String[] arr2 = queryIP.split(":", -1);
        if (arr1.length != 4 && arr2.length != 8) return "Neither"; // 没有一个可能的结果
        if (arr1.length == 4) { // 可能是IPV4地址
            for (String s : arr1) {
                if (!isValidV4(s)) return "Neither";
            }
            return "IPv4";
        } else {  // 可能是IPV6
            for (String s : arr2) {
                if (!isValidV6(s)) return "Neither";
            }
            return "IPv6";
        }
    }

    private boolean isValidV6(String s) {
        if (s.length() < 1 || s.length() > 4) return false; // 不满足长度要求
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c < '0' || c > '9') && (c < 'a' || c > 'f') && (c < 'A' || c > 'F')) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidV4(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') return false; // 排除0
        try {
            int num = Integer.parseInt(s);
            if (num < 0 || num > 255) return false;
        } catch (NumberFormatException e) {
            return false;   // 解析不成数字
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidIPAddress().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}
