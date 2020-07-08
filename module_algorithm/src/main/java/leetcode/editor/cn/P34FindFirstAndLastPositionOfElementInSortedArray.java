//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 492 👎 0


package leetcode.editor.cn;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return nums;
            }
            return new int[]{searchLeft(nums, target, len), searchRight(nums, target, len)};
        }

        // 输入: nums = [5,7,7,8,8,10], target = 8
        private int searchLeft(int[] nums, int target, int len) {
            int left = -1;
            int right = len - 1;
            while (left + 1 < right) {
                int mid = (left + right) / 2;
                int item = nums[mid];
                if (item < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            if (nums[right] == target) {
                return right;
            }
            return -1;
        }

        private int searchRight(int[] nums, int target, int len) {
            int left = 0;
            int right = len;
            while (left + 1 < right) {
                //中间值
                int mid = (left + right) / 2;
                if (nums[mid] <= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            if (nums[left] == target) {
                return left;
            }
            return -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}