package com.zh.weeklymatch.dc138;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-08-31 23:12
 * @description: 字符串哈希—第二题
 **/
public class stringHash {
    public String stringHash(String s, int k) {
        int len = s.length();
        int cnt = len / k;
        StringBuilder sb = new StringBuilder();

        // 遍历每个子字符串
        for (int i = 0; i < cnt; i++) {
            String subStr = s.substring(i * k, (i + 1) * k);
            int totalIdx = 0;

            // 累加子字符串中每个字符的哈希值
            for (int j = 0; j < k; j++) {
                char ch = subStr.charAt(j);
                totalIdx += ch - 'a';  // 确保正确处理字符范围
            }

            // 取模并转换为对应的字符
            int hashChar = totalIdx % 26;
            sb.append((char) ('a' + hashChar));
        }

        return sb.toString();
    }

}
