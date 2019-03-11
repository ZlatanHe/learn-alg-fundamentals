package others;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zlatan on 19/3/11.
 */
class LRUCache {

    public static class CacheNode {
        int key;
        int value;
        CacheNode pre;
        CacheNode next;

        public CacheNode(int key, int value, CacheNode pre, CacheNode next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    private int capacity;

    private Map<Integer, CacheNode> cacheKeyMap;

    private CacheNode head;

    private CacheNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheKeyMap = new HashMap<>(capacity);
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        CacheNode cacheNode = cacheKeyMap.get(key);
        if (cacheNode == null) {
            return -1;
        }
        touch(cacheNode);
        return cacheNode.value;
    }

    // touch to head
    private void touch(CacheNode cacheNode) {
        if (head != cacheNode) {
            cacheNode.pre.next = cacheNode.next;
            if (cacheNode.next != null) {
                cacheNode.next.pre = cacheNode.pre;
            } else {
                // cacheNode is tail
                tail = cacheNode.pre;
            }
            head.pre = cacheNode;
            cacheNode.pre = null;
            cacheNode.next = head;
            head = cacheNode;
        }
    }

    public void put(int key, int value) {
        CacheNode cacheNode = cacheKeyMap.get(key);
        // not cached
        if (cacheNode == null) {
            cacheNode = new CacheNode(key, value, null, null);

            // first add
            if (head == null) {
                head = cacheNode;
                tail = cacheNode;
                cacheKeyMap.put(key, cacheNode);
                return;
            }

            // add to head
            cacheNode.next = head;
            head.pre = cacheNode;
            head = cacheNode;
            cacheKeyMap.put(key, cacheNode);

            // expire tail if need
            if (cacheKeyMap.size() > capacity) {
                cacheKeyMap.remove(tail.key);
                CacheNode tailPre = tail.pre;
                tail.pre = null;
                tailPre.next = null;
                tail = tailPre;
            }
        } else {
            touch(cacheNode);
            cacheNode.value = value;
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */