package com.hnu.xyj;

import java.util.HashMap;

public class LRU_Cache {
    HashMap<Integer, Node> map;
    Node head, tail;
    int capacity;

    //使用双向链表和map，map将k对应与链表的节点
    //链表里保存k和value
    public LRU_Cache(int capacity) {
        map = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(1, 1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        //如果map里面有key，那么链表里面也有k
        //取出节点的val，并把节点放到队首
        if (map.containsKey(key)) {
            Node p = map.get(key);
            putToHead(p);
            return p.val;
        } else
            return -1;
    }

    public void set(int key, int value) {
        //如果map里面有，只更新val
        if (map.containsKey(key)) {
            Node p = map.get(key);
            p.val = value;
            putToHead(p);
        }
        //如果map里没有而且没有超过capacity
        //链表和map里面插入新的节点。
        else if (map.size() < capacity) {
            Node p = new Node(key, value);
            putToHead(p);
            map.put(key, p);
        }
        //如果map里没有，且达到capacity
        //移除队尾，将新节点插到队首，并且移除map里面的k
        else {
            Node p = new Node(key, value);
            putToHead(p);
            map.put(key, p);
            int tmpk = removeEnd();
            map.remove(tmpk);
        }
    }

    private int removeEnd() {
        Node p = tail.pre;
        tail.pre.pre.next = tail;
        tail.pre = p.pre;
        p.pre = null;
        p.next = null;
        return p.key;
    }

    private void putToHead(Node p) {
        if (p.next != null && p.pre != null) {
            p.pre.next = p.next;
            p.next.pre = p.pre;
        }
        p.pre = head;
        p.next = head.next;
        head.next.pre = p;
        head.next = p;
    }

}

class Node {
    Node pre;
    Node next;
    int key;
    int val;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}