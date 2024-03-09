package com.zh.algorithm.greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-09 19:14
 * @description: 哈夫曼树和相关方法的代码实现
 **/
public class HuffmanTreeUtil {
    /*
        哈夫曼树用来解决字符编解码问题，使用贪心思想使得最后对某一数据编码的总和最小。这里实现Huffman树的以下方法：
            1：给定一个字符串构建哈夫曼树 aabbc
            2：记录字符串编码，统计字符串编码后的bit数
            3：编解码
     */

    // 哈夫曼树
    static class HuffmanTree {

        Node root;  // 哈夫曼树根节点

        String str;  // 要构建哈夫曼树的原数据

        Map<Character, Node> map = new HashMap<>();   // 存储哈夫曼树的所有节点

        /*
            节点类属性
                name：叶子节点名称
                left：左孩子
                right：右孩子
                frequency：字符频率（仅叶子节点有实际意义）
                code：叶子节点哈夫曼编码  编解码时候要用到
            构造函数：
                （1）：name、frequency —— 提供初始化叶子节点
                （2）：left、right、frequency —— 创建节点
            辅助函数：
                isLeaf —— 判断是否是叶子
                toString —— 便于调试
         */
        static class Node {
            public Character name;
            Node left;
            Node right;
            public int frequency;
            public String code;

            public Node(Character name, int frequency) {
                this.name = name;
                this.frequency = frequency;
            }

            public Node(Node left, Node right, int frequency) {
                this.left = left;
                this.right = right;
                this.frequency = frequency;
            }

            public boolean isLeaf() {
                return left == null || right == null;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "name=" + name +
                        ", frequency=" + frequency +
                        '}';
            }
        }

        // 根据给定的字符串构建哈夫曼树
        public HuffmanTree(String str) {
            char[] chars = str.toCharArray();
            // 初始化map
            for (char aChar : chars) {
                Node node = map.computeIfAbsent(aChar, character -> new Node(character, 0));
                node.frequency++;
            }
            buildTree();    // 建树
            Node node = root;
            StringBuilder sb = new StringBuilder();
            int bits = dfs(node, sb);// 记录字符编码，统计占用bit数
            System.out.println(root + " " + bits);
            this.str = str;
        }

        /*
            遍历哈夫曼树给每个字符编码
         */
        private int dfs(Node node, StringBuilder sb) {
            int count = 0;  // 记录当前节点的左右子树存储的字符所占位数

            if (node.isLeaf()) {
                // 统计占用bit数，并把code赋值给当前节点的code
                node.code = sb.toString();
                count = sb.length() * node.frequency;   // 这里不能直接return，不然后面的移除字符的逻辑走不到就会报错
            }
            // 没有到达叶子节点的时候记录路径的编码
            else {
                int left = dfs(node.left, sb.append("0"));
                int right = dfs(node.right, sb.append("1"));
                count += left + right;
            }
            // 都处理完成以后可能会出现sb为空的情况，这里判断一下
            if (!sb.isEmpty()) {
                sb.deleteCharAt(sb.length() - 1); // 往回走的时候移除
            }
            return count;
        }

        // 对给定字符串编码
        public String encode() {
            // 构建哈夫曼树时已经把每个字符对应的code值记录了下来，现在只需根据key找到node中code拼接即可
            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                Node node = map.get(c);
                String code = node.code;
                sb.append(code);
            }
            return sb.toString();
        }

        // 给定的字节流（这里为了简便使用字符串01模拟）解码成字符串
        public String decode(String bits) {
            /*
                01000001010101   现在需要根据传递的字节流从哈夫曼树的根节点遍历，遍历规则如下
                    1：当发现叶子节点说明找到，把字符拼接到result字符串中。未找到则指针++，继续往下寻找
                    2：找到后重新从根节点开始寻找，直到字节流的长度为0
             */
            int length = bits.toCharArray().length;
            int i = 0;    // 字节流指针
            Node node = root;   // 树节点指针
            StringBuilder result = new StringBuilder();   // 存储结果字符串
            while (length-- > 0) {
                if (bits.charAt(i) == '0') { // 往左走
                    node = node.left;
                } else if (bits.charAt(i) == '1') { // 往右走
                    node = node.right;
                }
                // 判断当前node是不是叶子节点
                if (node.isLeaf()) {
                    result.append(node.name);
                    node = root;
                }
                i++;    // 找到没找到指针都得移动
            }
            return result.toString();
        }


        /*
            建树
            1：把map中的所有元素存储到优先级队列中，并传递比较器对象为根据节点的频率升序排列
            2：每轮取出两个节点，创建一个新节点并把该节点加入到优先级队列中
            3：遍历结束（优先级队列没值时，将根节点存储下来供编解码时使用）
         */
        private void buildTree() {
            PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(value -> value.frequency));
            queue.addAll(map.values()); // 所有元素添加到优先级队列中
            while (queue.size() >= 2) {
                // 取出两个最小的
                Node x = queue.poll();
                Node y = queue.poll();
                Node newV = new Node(x, y, x.frequency + y.frequency);
                // 记录根节点，queue长度为1 ——> 添加下面的newV会进行下一轮循环    queue长度为0 —— 代表遍历到根节点了
                if (queue.isEmpty()) {
                    root = newV;
                }
                queue.offer(newV);
            }
        }
    }

    public static void main(String[] args) {
        /*
                O
            b       O
                  a  c
        b:0     a:10    c:11    1*3+1*2+2*2=9
         */
        HuffmanTree tree = new HuffmanTree("abbbcc");
        String code = tree.encode();
        System.out.println(code);
        String str = tree.decode(code);
        System.out.println(str);
    }

}
