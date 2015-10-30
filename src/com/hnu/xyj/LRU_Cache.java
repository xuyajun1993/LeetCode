package com.hnu.xyj;

import java.util.HashMap;

public class LRU_Cache {
    HashMap<Integer, Node> map;
    Node head, tail;
    int capacity;

    //ʹ��˫�������map��map��k��Ӧ������Ľڵ�
    //�����ﱣ��k��value
    public LRU_Cache(int capacity) {
        map = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(1, 1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        //���map������key����ô��������Ҳ��k
        //ȡ���ڵ��val�����ѽڵ�ŵ�����
        if (map.containsKey(key)) {
            Node p = map.get(key);
            putToHead(p);
            return p.val;
        } else
            return -1;
    }

    public void set(int key, int value) {
        //���map�����У�ֻ����val
        if (map.containsKey(key)) {
            Node p = map.get(key);
            p.val = value;
            putToHead(p);
        }
        //���map��û�ж���û�г���capacity
        //�����map��������µĽڵ㡣
        else if (map.size() < capacity) {
            Node p = new Node(key, value);
            putToHead(p);
            map.put(key, p);
        }
        //���map��û�У��Ҵﵽcapacity
        //�Ƴ���β�����½ڵ�嵽���ף������Ƴ�map�����k
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