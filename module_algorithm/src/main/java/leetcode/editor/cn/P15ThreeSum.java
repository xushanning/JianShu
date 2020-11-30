//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2785 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            if (len == 0) {
                return res;
            }
            Arrays.sort(nums);
            for (int left = 0; left < len - 2; left++) {
                int mid = left + 1;
                int right = len - 1;
                if (nums[left] > 0) {
                    break;
                }
                if (left > 0 && nums[left] == nums[left - 1]) {
                    continue;
                }
                while (mid < right) {
                    int sum = nums[left] + nums[right] + nums[mid];
                    if (sum == 0) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[left]);
                        item.add(nums[right]);
                        item.add(nums[mid]);
                        res.add(item);
                        while (mid < right && nums[mid] == nums[mid + 1]) {
                            mid++;
                        }
                        while (mid < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        mid++;
                        right--;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        mid++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}