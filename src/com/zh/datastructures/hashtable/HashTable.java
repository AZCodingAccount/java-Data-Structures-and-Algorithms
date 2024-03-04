package com.zh.datastructures.hashtable;


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
    }

    /*
        哈希表的参数
        initialCapacity —— 初始容量 default:16
         loadFactor —— 负载因子 default:0.75
         size —— hash表长度 default:0
     */
    int size = 0;
    int initialCapacity = 16;
    Entry[] table = new Entry[initialCapacity];

    // 哈希表的增删改查
    // 增 改。通过hash找到在表中的哪个格子——>判断格子是否有元素——>有 【判断如果key重复，更新value】 否则尾插法插入；无 新增节点
    public Object put(int hash, Object key, Object value) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            // 新增元素
            table[idx] = new Entry(hash, key, value);
        } else {
            // 遍历链表
            Entry p = table[idx];
            while (true) {
                // key相同，更新value
                if (p.key != null && p.key.equals(p)) {
                    p.value = value;
                    return value;
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
        return value;   // 返回插入的值
    }

    // 查 根据元素key查询value，没有返回null
    public Object get(int hash, Object key) {
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
    public boolean remove(int hash, Object key) {
        int idx = hash & (table.length - 1);
        Entry p = table[idx];
        // 1: 链表为空
        if (p == null) {
            return false;
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
                return true;
            }
            // 1: 没找到节点
            if (p.next == null) {
                return false;
            }
            prev = p;
            p = p.next;

        }
    }

}
