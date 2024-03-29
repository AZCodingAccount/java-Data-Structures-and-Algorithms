package com.zh.job.hashtable;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-29 16:46
 * @description: 同构字符串——leetcode205
 **/
public class IsIsomorphic {
    /*
        记录两个字符的映射,这种映射关系不是a——>e b——>f，是一种更宽泛的问题，比如af，be也是可以的
     */
    public boolean isIsomorphic(String s, String t) {
        int[] marka = new int[130];   // 存储s的映射 egg
        int[] markb = new int[130];   // 存储t的映射 adf
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (marka[sChars[i]] == 0 && markb[tChars[i]] == 0) {   // 说明是第一次
                marka[sChars[i]] = tChars[i];   // e=a  g=d
                markb[tChars[i]] = sChars[i];   // a=e  g=d
            } else {  // 开始校验
                if ((marka[sChars[i]] != tChars[i]) || (markb[tChars[i]] != sChars[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsIsomorphic().isIsomorphic("egg", "add"));
    }
}
