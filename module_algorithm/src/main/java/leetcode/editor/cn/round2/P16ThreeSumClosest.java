//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针


package leetcode.editor.cn.round2;

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
            if (len < 3) {
                return 0;
            }
            Arrays.sort(nums);
            //[-4,-1，1，2], 和 target = 1
            int res = nums[0] + nums[1] + nums[2];

            for (int i = 0; i < len; i++) {
                int left = i + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum == target) {
                        return target;
                    } else if (sum > target) {
                        //偏大
                        right--;
                    } else {
                        left++;
                    }

                    if (Math.abs(sum - target) < Math.abs(res - target)) {
                        res = sum;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}