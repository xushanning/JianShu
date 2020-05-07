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


package leetcode.editor.cn.round1;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //边界条件太操蛋了
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[]{-1, -1};
            if (nums.length == 0) {
                return res;
            }
            res[0] = searchLeft(nums, target);
            res[1] = searchRight(nums, target);
            return res;
        }

        /**
         * 找左边界
         *
         * @param nums
         * @param target
         * @return
         */
        private int searchLeft(int[] nums, int target) {
            int left = -1;
            int right = nums.length - 1;
            while (left + 1 < right) {
                //中间值
                int mid = (left + right) / 2;
                if (nums[mid] < target) {
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

        /**
         * 找右边界
         *
         * @param nums
         * @param target
         * @return
         */
        private int searchRight(int[] nums, int target) {
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