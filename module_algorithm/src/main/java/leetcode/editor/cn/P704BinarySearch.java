//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 二分查找


package leetcode.editor.cn;

//Java：二分查找
public class P704BinarySearch {
    public static void main(String[] args) {
        Solution solution = new P704BinarySearch().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //关于while为什么是小于等于，还有为什么是left+1 right-1看这篇文章：
        //https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
        public int search(int[] nums, int target) {
            int res = -1;
            int len = nums.length;
            if (len == 0) {
                return -1;
            }
            //[-1,0,3,5,9,12]  9
            int left = 0;
            int right = len - 1;
            while (left <= right) {
                //取整
                int mid = left + (right - left) / 2;
                int item = nums[mid];
                if (item == target) {
                    return mid;
                } else if (item < target) {
                    //最关键的地方
                    left = mid + 1;
                } else {
                    //最关键的地方
                    right = mid - 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}