package com.zkp.map;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zkp
 * @version 1.0
 * 定义双端链表
 * 每个节点都存储数据(key值和value值)
 * 用哈希表来做key值和节点之间的映射
 * 链表表头表示最近使用的数据，表尾则是最久未使用的数据
 * get操作和put操作时，对哈希表和链表进行维护
 * 使用哈希表来定位要获取的元素，key = 元素的key，value = 双向链表的节点
 *
 */
public class LRUCache {

    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);//[1,1]
        cache.put(2,2);//[2,2]
        System.out.println(cache.get(1));//1
        cache.put(3,4);//[3,3]
        System.out.println(cache.get(2));//2
        cache.put(4,4);//[4,4]
        System.out.println(cache.get(1));//[1]
        System.out.println(cache.get(3));//[3]
        System.out.println(cache.get(4));//[4]
    }

    class DeNode{
        int key;
        int value;
        DeNode pre;
        DeNode next;
        public DeNode(){}
        public DeNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    int maxSize;
    int curSize;
    Map<Integer,DeNode> map;
    DeNode head;
    DeNode tail;


    public LRUCache(int capacity) {
        curSize = 0;
        maxSize = capacity;
        map = new HashMap<>();
        //初始化虚拟的头节点和尾节点
        head = new DeNode();
        tail = new DeNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        //根据map获取存储该key数据的DeNode
        DeNode node = map.get(key);
        //将该DeNode移到链表首部
        moveToHead(node);
        //返回该节点的value
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            DeNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        }else{
            //加到首部
            DeNode node = new DeNode(key, value);
            addHead(node);
            map.put(key,node);
            //判断是否超过容量
            if(curSize > maxSize){
                //移除该元素
                map.remove(tail.pre.key);
                //移除尾部元素
                removeTail();
            }
        }
    }
    //将node节点移到链表首部
    private void moveToHead(DeNode node){
        //先移除该节点
        node.pre.next = node.next;
        node.next.pre = node.pre;

        //加到首部
        addHead(node);
    }

    //将节点加入到首部
    private void addHead(DeNode node){
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
        ++curSize;
    }

    //移除尾部元素
    private void removeTail(){
        DeNode node = tail.pre.pre;
        node.next.next = null;
        node.next.pre = null;
        node.next = tail;
        tail.pre = node;
        --curSize;
    }
}
