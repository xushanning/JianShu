//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。 
//
// 实现 LFUCache 类： 
//
// 
// LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象 
// int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。 
// void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之
//前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。 
// 
//
// 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。 
//
// 
//
// 进阶： 
//
// 
// 你是否可以在 O(1) 时间复杂度内执行两项操作？ 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "g
//et"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//输出：
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//解释：
//LFUCache lFUCache = new LFUCache(2);
//lFUCache.put(1, 1);
//lFUCache.put(2, 2);
//lFUCache.get(1);      // 返回 1
//lFUCache.put(3, 3);   // 去除键 2
//lFUCache.get(2);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//lFUCache.put(4, 4);   // 去除键 1
//lFUCache.get(1);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//lFUCache.get(4);      // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 0 <= capacity, key, value <= 104 
// 最多调用 105 次 get 和 put 方法 
// 
// Related Topics 设计 
// 👍 286 👎 0


package leetcode.editor.cn;

import java.util.Map;
import java.util.TreeSet;

//Java：LFU 缓存
public class P460LfuCache {
    public static void main(String[] args) {
        // Solution solution = new P460LfuCache().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {
        private int capacity, time;
        private Map<Integer, Integer> map;
        private TreeSet<Node> set;

        public LFUCache(int capacity) {

        }

        public int get(int key) {
            return 0;
        }

        public void put(int key, int value) {

        }

        class Node implements Comparable<Node> {
            private int cnt, time, key, value;

            public Node(int cnt, int time, int key, int value) {
                this.cnt = cnt;
                this.time = time;
                this.key = key;
                this.value = value;
            }

            @Override
            public int compareTo(Node o) {
                return 0;
            }
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}