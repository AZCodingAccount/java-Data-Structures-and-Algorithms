package com.zh.again;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-31 23:16
 * @description:
 **/
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        LinkedList<Integer> monoStack=new LinkedList<>();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            if(!monoStack.isEmpty()&&temperatures[i]>temperatures[monoStack.peek()]){
                // 处理结果
                res[monoStack.peek()]=i-monoStack.pop();
            }
            monoStack.push(i);
        }
        return res;
    }
}
