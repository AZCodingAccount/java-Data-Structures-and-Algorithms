package com.zh.hot.string;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-05 17:06
 * @description: 字符串中的单词翻转
 **/
public class ReverseMessage {
    public String reverseMessage(String message) {
        StringBuilder sb = new StringBuilder();
        String[] split = message.strip().split("\\s+");
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
            if(i!=0) sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseMessage().reverseMessage("a good   example"));
    }
}
