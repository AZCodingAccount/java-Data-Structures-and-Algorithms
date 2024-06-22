package com.zh.job.origin;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-27 14:28
 * @description: 判断回文串——leetcode125
 **/
public class IsPalindrome {
    /*
        这个可以直接正则匹配，也可以手动筛选出字符串
     */
    public boolean isPalindrome(String s) {
        char[] chs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chs) {
            if (ch >= 'A' && ch <= 'Z') {   // 大写字符转换成小写
                sb.append((char) (ch - ('Z' - 'z')));
            } else if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                sb.append(ch);
            }
        }

        String str = sb.toString();
        // 拼接或者双指针  aba     abba
        int left = 0, right = str.length() - 1;
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[left] != charArray[right]) {   // 如果有不相等的，直接退出
                return false;
            }
            if (left >= right) {    // 长度为奇数或者偶数
                break;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }

}
