//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 
// 👍 1782 👎 0


package leetcode.editor.cn;

//Java：接雨水
public class P42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int len = height.length;
            if (len < 3) {
                return 0;
            }
            //动态规划 从左往右和从右往左，记录柱子最大值
            //然后取i位置小的那个，和第i个柱子高度比较，比柱子高的那一部分就是这个柱子接雨水的量

            int[] leftMax = new int[len];
            leftMax[0] = height[0];
            for (int i = 1; i < len; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            int[] rightMax = new int[len];
            rightMax[len - 1] = height[len - 1];
            for (int i = len - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
            int res = 0;

            //两个数组中的最小值，肯定大于或者等于这个位置的柱子的高度
            for (int i = 0; i < len; i++) {
                res += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}