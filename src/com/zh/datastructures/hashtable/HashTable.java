package com.zh.datastructures.hashtable;


import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-12-08 22:09
 * @description: 模仿Hash表的实现
 **/
public class HashTable {
    // static keyword to help GC
    // 节点类
    static class Entry {
        // 4个属性，分别是hashCode、K、V、next指针
        int hash;       // hash码
        Object key;     // 键
        Object value;   // 值
        Entry next;     // next指针

        // 构造函数
        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        // help test
        @Override
        public String toString() {
            return "Entry{" +
                    "hash=" + hash +
                    ", key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    /*
        哈希表的参数
        initialCapacity —— 初始容量 default:16
        loadFactor —— 负载因子 default:0.75
        threshold —— 阈值 default:12 table.length * 0.75
        size —— hash表长度 default:0
     */
    private int size = 0;
    private final int initialCapacity = 16;
    private int threshold = 12;
    private final double loadFactor = 0.75;
    private Entry[] table = new Entry[initialCapacity];

    // 哈希表的增删改查
    // 增 改。通过hash找到在表中的哪个格子——>判断格子是否有元素——>有 【判断如果key重复，更新value】 否则尾插法插入；无 新增节点
    private Object put(int hash, Object key, Object value) {
        int idx = hash & (table.length - 1);
        Object oldValue = null;
        if (table[idx] == null) {
            // 新增元素
            table[idx] = new Entry(hash, key, value);
        } else {
            // 遍历链表
            Entry p = table[idx];
            while (true) {
                // key相同，更新value
                if (p.key != null && p.key.equals(key)) {
                    oldValue = p.value;
                    p.value = value;
                    return oldValue;
                }
                // 遍历到头了，尾插法插入，这个放在更新value的后面
                if (p.next == null) {
                    p.next = new Entry(hash, key, value);
                    break;
                }
                p = p.next; // 移动指针
            }
        }
        size++;
        // 扩容逻辑
        if (size >= threshold) {
            resize();   // 给数组扩容
            threshold = (int) (table.length * loadFactor);  // 更新threshold
        }
        return null;   // 返回空值
    }

    // 查 根据元素key查询value，没有返回null
    private Object get(int hash, Object key) {
        int idx = hash & (table.length - 1);
        Entry p = table[idx];
        if (p == null) {
            return null;
        }
        while (true) {
            if (p.key != null && p.key.equals(key)) {
                // 找到，返回value
                return p.value;
            }
            if (p.next == null) {
                // 未找到，返回null
                return null;
            }
            p = p.next;
        }
    }

    /*
         删。通过key删除一个节点，三种情况,没有返回false
            1：节点不存在 —— 返回false
            2：节点为头结点 —— 修改新链表头结点
            3：节点为普通节点 —— p.prev=p.next即可
    */
    private Object remove(int hash, Object key) {
        int idx = hash & (table.length - 1);
        Entry p = table[idx];
        // 1: 链表为空
        if (p == null) {
            return null;
        }
        Entry prev = null; // 记录前一个节点
        while (true) {
            // 2、3：找到节点
            if (p.key != null && p.key.equals(key)) {
                // 2: 节点为头结点
                if (p == table[idx]) {
                    table[idx] = p.next;

                }// 3: 节点为普通节点
                else {
                    prev.next = p.next; // 这里不可能为null，编辑器误报了
                }
                size--; // 更新size
                return p.value;
            }
            // 1: 没找到节点
            if (p.next == null) {
                return null;
            }
            prev = p;
            p = p.next;
        }
    }

    /*
        扩容方法。数组长度扩容为原来的两倍，原数组每个节点的链表都进行相应条件的拆分
            1：创建新数组
            2：遍历旧数组和数组节点的链表，找到每个节点和节点+数组长度的索引 这两个指针
            3：给新数组的两个位置赋值
            4：将新数组赋值给旧数组
     */
    private void resize() {
        // 1：创建新数组
        Entry[] newTable = new Entry[table.length << 1];
        // 2：遍历旧数组
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i];
            if (p == null) {
                break;
            }
            Entry a = null;   // a链表指针
            Entry b = null;   // b链表指针
            Entry aHead = null;   // a链表头指针
            Entry bHead = null;   // b链表头指针
            // 2：遍历旧数组的链表
            while (true) {
                // 说明还是原来的位置，分配给a链表
                if ((p.hash & table.length) == 0) {
                    if (a != null) {
                        a.next = p; // 之前的下一个指针指向p
                    }
                    if (a == null) {
                        aHead = p;  // 记录头指针
                    }
                    // 第一次进来|移动链表位置
                    a = p;
                } // 分配给b链表
                else {
                    if (b != null) {
                        b.next = p;
                    }
                    if (b == null) {
                        bHead = p;  // 记录头指针
                    }
                    b = p;
                }
                // 遍历到头了
                if (p.next == null) {
                    break;
                }
                p = p.next;
            }
            // 3：给新数组的两个位置赋值
            newTable[i] = aHead;
            newTable[i + table.length] = bHead;
        }
        table = newTable;
    }

    /*
            提供几个重载的方法，hashCode不必外层输入
     */
    /*
     * @return Object 插入或更新后的值，插入失败返回null
     * */
    public Object put(Object key, Object value) {
        int hash = hash(key);
        return put(hash, key, value);
    }

    /*
     * @return Object 查找到的值，查找不到返回null
     * */
    public Object get(Object key) {
        int hash = hash(key);
        return get(hash, key);
    }

    /*
     * @return Object 移除键对应的值
     * */
    public Object remove(Object key) {
        int hash = hash(key);
        return remove(hash, key);
    }

    private int hash(Object key) {
        // 修改hash方法帮助演示哈希冲突
        // return 123456;
        return key.hashCode();
    }

    public int size() {
        return size;
    }

    // help test
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : table) {
            if (entry == null) {
                continue;
            }
            Entry p = entry;
            // 遍历链表
            while (true) {
                sb.append("hash: ");
                sb.append(p.hash);
                sb.append(" key: ");
                sb.append(p.key);
                sb.append(" value: ");
                sb.append(p.value);
                if (p.next == null) {
                    break;
                }
                sb.append("  |  ");
                p = p.next;
            }
            if (entry != table[table.length - 1]) {
                sb.append("\n------------------------------------------------\n");
            }
        }
        return sb.toString();
    }
}
