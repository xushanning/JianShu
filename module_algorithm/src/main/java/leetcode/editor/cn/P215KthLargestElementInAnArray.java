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
// 👍 811 👎 0


package leetcode.editor.cn;

//Java：数组中的第K个最大元素
public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int len;
        private int[] nums;

        public int findKthLargest(int[] nums, int k) {
            len = nums.length;
            this.nums = nums;
            if (len == 0) {
                return 0;
            }
            buildHeap();
            for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
                swap(i, 0);
                len--;
                heapify(0);
            }

            return nums[0];
        }

        private void buildHeap() {
            //注意点①
            for (int i = len / 2 - 1; i >= 0; i--) {
                heapify(i);
            }
        }

        private void heapify(int i) {
            int max = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            //注意点②
            if (left < len && nums[left] > nums[max]) {
                max = left;
            }
            if (right < len && nums[right] > nums[max]) {
                max = right;
            }
            if (max != i) {
                swap(max, i);
                heapify(max);
            }
        }

        private void swap(int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}