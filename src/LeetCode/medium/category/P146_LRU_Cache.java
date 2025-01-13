package LeetCode.medium.category;

import java.util.*;

// doubly-linked-list, HashMap으로 풀이
public class P146_LRU_Cache {
    class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int cap;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map = new HashMap<>();

    public P146_LRU_Cache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node node) {
        Node temp = head.next;

        head.next = node;
        node.prev = head;

        node.next = temp;
        temp.prev = node;
    }

    public void deleteNode(Node node) {
        Node pprev = node.prev;
        Node nnext = node.next;

        pprev.next = nnext;
        nnext.prev = pprev;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node target = map.get(key);

            deleteNode(target);
            addNode(target);

            return target.val;
        }
        return -1;
    }

    // 있으면 변경
    public void put(int key, int value) {
        // 이미 존재하는 경우
        if (map.containsKey(key)) {
            Node target = map.get(key);

            deleteNode(target);
            addNode(target);
            target.val = value;
            return;
        }

        // 존재하지 않는 경우
        if (map.size() == cap) {
            Node target = tail.prev;
            map.remove(target.key);
            deleteNode(target);
        }

        addNode(new Node(key, value));
        map.put(key, head.next);
    }

    public static void main(String[] args) {
        P146_LRU_Cache cache = new P146_LRU_Cache(3);
        cache.get(1);
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(3, 4);
        cache.put(4, 5);
        cache.put(5, 6);
        Node cur = cache.head.next;
        while(cur != cache.tail) {
            System.out.println(cur.key + ", " + cur.val);
            cur = cur.next;
        }
    }
}
