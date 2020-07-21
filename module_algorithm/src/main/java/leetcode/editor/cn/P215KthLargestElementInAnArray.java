//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 614 👎 0


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

//Java：数组中的第K个最大元素
public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
        solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            if (len == 0 || k < 1) {
                return 0;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (int item : nums) {
                queue.offer(item);
            }
            int res = 0;
            for (int i = 0; i < k; i++) {
                res = queue.poll();
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}