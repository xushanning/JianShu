//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 1003 👎 0


package leetcode.editor.cn.all;

//Java：下一个排列
public class P31NextPermutation {
    public static void main(String[] args) {
        Solution solution = new P31NextPermutation().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            int i = len - 2;
            //确认第一个降序的位置
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            //找出第一个比nums[i]大的位置
            //因为存在这种情况[3,2,1]并不存在更大的一个排列，所以要判断i是否大于等于0
            if (i >= 0) {
                int j = len - 1;
                while (nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
            }
            //升序排列i+1，end
            int left = i + 1;
            int right = len - 1;
            while (right > left) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}