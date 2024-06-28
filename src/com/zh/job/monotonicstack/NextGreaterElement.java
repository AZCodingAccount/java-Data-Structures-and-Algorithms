package com.zh.job.monotonicstack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-28 20:53
 * @description: 下一个更大元素1—lc496
 **/
public class NextGreaterElement {
    /*
        每日温度的进阶版本，绕了个弯，也是使用单调栈解决，但是要求使用O(nums1.length + nums2.length)，要解决两个问题
        1：如何把nums1和nums2关联起来
        2：nums2进行单调栈求解时候怎么在O（1）的时间复杂度找到元素在nums1的下标
        使用HashMap记录nums1的所有元素，key为值，value是索引，这样可以快速定位，然后赋值供给结果数组(nums1题目说了没有重复元素)
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length == 0) return new int[0];
        int[] res = new int[nums1.length];  // 记录结果的数组
        HashMap<Integer, Integer> map = new HashMap<>();    // map，空间换时间
        LinkedList<Integer> stack = new LinkedList<>(); // 单调栈辅助栈
        // 记录nums1
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        // 进行单调栈遍历
        stack.push(nums2[0]);
        Arrays.fill(res, -1);    // 填充结果
        for (int i = 1; i < nums2.length; i++) {
            Integer peeked = stack.peek();
            if (nums2[i] > peeked) { // 有搞头
                // 继续遍历
                while (peeked != null && nums2[i] > peeked) {
                    // 1：加入结果数组
                    Integer num1Index = map.get(peeked);    // 注意这里是peeked，处理的栈里面的元素而非当前元素
                    if (num1Index != null) res[num1Index] = nums2[i];
                    stack.pop();     // 2：弹出元素
                    peeked = stack.peek();    // 3：更新栈顶元素值
                }
            }
            stack.push(nums2[i]);// 最后把当前元素加入到栈中

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElement().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
