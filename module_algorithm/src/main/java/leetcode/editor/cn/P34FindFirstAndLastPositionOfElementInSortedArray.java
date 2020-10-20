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
// 👍 630 👎 0


package leetcode.editor.cn;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
        solution.getLeft(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4]

//            if (nums.length == 0) {
//                return new int[]{-1, -1};
//            }
            return new int[]{getLeft(nums, target), getRight(nums, target)};
        }

        private int getLeft(int[] nums, int target) {
            int left = -1, right = nums.length - 1;
            while (right > left) {
                int mid = (left + right) / 2;
                int num = nums[mid];
                if (num == target) {
                    right = mid;
                } else if (num < mid) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (nums[right] == target) {
                return right;
            }
            return -1;
        }

        private int getRight(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
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