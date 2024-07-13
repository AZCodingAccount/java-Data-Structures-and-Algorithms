package com.zh.hot.other;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-13 21:21
 * @description: 反转数字
 **/
public class ReverseWord {
    public int reverse (int x) {
        // write code here
        String str=String.valueOf(x);
        int length=str.length();
        long res=0,label=1;
        for(int i=length-1;i>=0;i--){
            if(str.charAt(i)=='-'){
                label=-1;
                continue;
            }else{
                res=(str.charAt(i)-'0')+res*10;
                if(res>Integer.MAX_VALUE) return -1;
            }
        }
        return (int) ((int)label*res);
    }
}
