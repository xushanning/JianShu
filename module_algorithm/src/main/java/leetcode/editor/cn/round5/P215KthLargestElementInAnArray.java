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
// 👍 753 👎 0


package leetcode.editor.cn.round5;

//Java：数组中的第K个最大元素
public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
        solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] nums;
        private int len;

        public int findKthLargest(int[] nums, int k) {
            //建立大顶堆，然后删除两次，堆顶的就是结果
            len = nums.length;
            this.nums = nums;
            //建立大顶堆
            buildMaxHeap();
            for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
                //把第一个，也就是最大的一个和最后一个进行交换，然后重新维护堆，相当于把大的删除了
                swap(i, 0);
                len--;
                //只需要整理堆顶
                heapify(0);
            }
            return nums[0];
        }

        private void buildMaxHeap() {
            //从最后一个非叶子节点为len/2-1
            for (int i = len / 2 - 1; i >= 0; i--) {
                heapify(i);
            }
        }

        /**
         * @param i 堆下标
         */
        private void heapify(int i) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int max = i;

            if (left < len && nums[left] > nums[max]) {
                max = left;
            }
            if (right < len && nums[right] > nums[max]) {
                max = right;
            }
            if (max != i) {
                swap(i, max);
                //重新整理堆,因为max位置的数字发生变化了，所以把max设置成i，再对子节点进行整理
                heapify(max);
            }
        }

        public void swap(int n, int m) {
            int tmp = nums[n];
            nums[n] = nums[m];
            nums[m] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}