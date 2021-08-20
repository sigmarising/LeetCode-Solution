package TencentTop50;

import java.util.HashMap;
import java.util.Map;

public class Problem146 {
    public class LRUCache {
        private class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
            public DLinkedNode() {}
            public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
        }

        private class DLinkedList {
            public DLinkedNode head, tail;
            public int size;

            public void addToHead(DLinkedNode node) {
                node.prev = head;
                node.next = head.next;
                head.next.prev = node;
                head.next = node;
            }

            public void removeNode(DLinkedNode node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            public void moveToHead(DLinkedNode node) {
                removeNode(node);
                addToHead(node);
            }

            public DLinkedNode removeTail() {
                DLinkedNode res = tail.prev;
                removeNode(res);
                return res;
            }
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private DLinkedList lruList = new DLinkedList();
        private int lruCapacity;

        public LRUCache(int capacity) {
            lruCapacity = capacity;
            lruList.size = 0;

            lruList.head = new DLinkedNode();
            lruList.tail = new DLinkedNode();
            lruList.head.next = lruList.tail;
            lruList.tail.prev = lruList.head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }

            lruList.moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                DLinkedNode newNode = new DLinkedNode(key, value);
                cache.put(key, newNode);
                lruList.addToHead(newNode);
                lruList.size += 1;
                if (lruList.size > lruCapacity) {
                    DLinkedNode tail = lruList.removeTail();
                    cache.remove(tail.key);
                    lruList.size -= 1;
                }
            }
            else {
                node.value = value;
                lruList.moveToHead(node);
            }
        }
    }
}
