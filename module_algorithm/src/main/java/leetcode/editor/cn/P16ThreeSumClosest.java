//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 620 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：最接近的三数之和
public class P16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int len = nums.length;

            if (len == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int res = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < len - 2; i++) {
                int left = i + 1;
                int right = len - 1;
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                while (right > left) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == target) {
                        return target;
                    } else if (sum -target> 0) {
                        right--;
                    } else {
                        left++;
                    }
                    if (Math.abs(res - target) > Math.abs(sum - target)) {
                        res = sum;
                    }

                }

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}