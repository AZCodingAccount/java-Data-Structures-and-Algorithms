package com.zh.job.stack;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-16 21:04
 * @description: 用队列实现栈—lc225
 **/
public class MyStack2 {

    /**
     * 实际上我的实现很蠢，很不优雅也有很多冗余代码，可以使用一个队列实现，根据size控制（使用两队列真的横竖不得劲！！！）
     * 实际上还有直接入栈的时候就控制队头是栈顶元素的，怎么实现都可以，就我这个实现有点抽象~~~
     **/


    private LinkedList<Integer> queue1 = new LinkedList<>();
    private LinkedList<Integer> queue2 = new LinkedList<>();

    public MyStack2() {
    }

    public void push(int x) {
        queue1.add(x);
    }

    /**
     * 弹出元素，这里需要将队列中的元素转移
     **/
    public int pop() {
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        } else {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
    }

    /**
     * 查看栈顶元素，这里不需要删除，只需要查看最后一个元素
     **/
    public int top() {
        int res;
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            res = queue2.peek();
            queue1.add(queue2.poll());  // 这里一定要再加回去，不然顺序会乱。
            // queue2  1      1  2                            1
            // queue1  2   （2 1）        不加情况，会输出这个2   2
            // 加回去变成，不加下一次遍历变成了2
        } else {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            res = queue1.peek();
            queue2.add(queue1.poll());
        }
        return res;
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }


    public static void main(String[] args) {
        MyStack2 myStack = new MyStack2();
        myStack.push(1);
        myStack.push(2);
        myStack.top();
        myStack.pop();
        myStack.pop();
    }
}
