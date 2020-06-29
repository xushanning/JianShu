//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写
//入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计


package leetcode.editor.cn.round2;

import java.util.HashMap;
import java.util.Map;

//Java：LRU缓存机制
public class P146LruCache {
    public static void main(String[] args) {
        //Solution solution = new P146LruCache().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private Map<Integer, Node> data = new HashMap<>();
        private int size = 0;
        private Node head, tail;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node node = data.get(key);
            if (node == null) {
                return -1;
            } else {
                moveToHead(node);
                return node.value;
            }

        }

        public void put(int key, int value) {
            Node node = data.get(key);
            if (node == null) {
                //没有，增加新的
                Node newNode = new Node();
                newNode.key = key;
                newNode.value = value;
                size++;
                data.put(key, newNode);
                addNode(newNode);
                if (size > capacity) {
                    Node tailNode = popTail();
                    data.remove(tailNode.key);
                    size--;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        private void addNode(Node node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addNode(node);
        }

        private void removeNode(Node node) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
        }


        private Node popTail() {
            Node res = tail.pre;
            removeNode(res);
            return res;
        }

        private class Node {
            private int key;
            private int value;
            private Node pre;
            private Node next;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}