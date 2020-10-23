//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 800 👎 0


package leetcode.editor.cn.round5;

//Java：乘积最大子数组
public class P152MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }

            //由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin
            int max = Integer.MIN_VALUE;
            int iMin = 1;
            int iMax = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {
                    int temp = iMax;
                    iMax = iMin;
                    iMin = temp;
                }
                iMin = Math.min(nums[i], iMin * nums[i]);
                iMax = Math.max(nums[i], iMax * nums[i]);
                max = Math.max(max, iMax);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}