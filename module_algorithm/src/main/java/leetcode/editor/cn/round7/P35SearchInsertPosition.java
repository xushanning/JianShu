//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 726 👎 0


package leetcode.editor.cn.round7;

//Java：搜索插入位置
public class P35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new P35SearchInsertPosition().new Solution();
        // TO TEST
        solution.searchInsert(new int[]{1, 3, 5, 6}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            //相当于求第一个大于等于target值的位置
// 输入: [1,3,5,6], 2
//输出: 1
            int len = nums.length;
            if (len == 0) {
                return 0;
            }
            if (nums[len - 1] < target) {
                return len;
            }
            int left = 0, right = len - 1;
            while (left < right) {
                int mid = (right + left) / 2;
                if (nums[mid] < target) {
                    //下一搜索区间是[mid+1,right]
                    left = mid + 1;
                } else {
                    //下一搜索区间是[left,mid]
                    right = mid;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}