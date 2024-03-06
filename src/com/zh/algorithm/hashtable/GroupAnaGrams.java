package com.zh.algorithm.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-05 19:54
 * @description: 字母异位词分组—力扣49题
 **/
public class GroupAnaGrams {

    /*
            也是哈希表求解，key是排完序以后的字符串，value为List<String>类型，存储的是对应的未排序的字符串列表
                1：遍历数组
                2：给数组每个元素的字符排序
                3：将kv键值对存储到哈希表中，value有两种情况：
                    1：value没值时，创建一个list
                    2：value有值时，往list里面添加元素
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        // 1：遍历数组
        for (String str : strs) {
            char[] key = str.toCharArray();
            String value = str;
            Arrays.sort(key); // 2：给每个元素的字符排序
            String keyStr=new String(key);
            // 3：存储到哈希表中
            List<String> valueList = map.get(keyStr);
            if (valueList==null) {
                // 1：value没值，新增列表
                valueList = new ArrayList<>();
                valueList.add(value);
                map.put(keyStr, valueList);
            } else {
                // 2: value有值，往列表中添加元素
                valueList.add(value);
            }
        }
        // 直接返回里面的值的集合就可以了
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnaGrams().groupAnagrams(strs));
    }
}
