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
// 👍 2690 👎 0


package leetcode.editor.cn.round5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
        solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
// 给定数组 nums = [-4, -1, -1, 0, 1, 2]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            Arrays.sort(nums);
            if (nums[0] > 0) {
                return res;
            }
            for (int i = 0; i < len - 2; i++) {

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int l = i + 1;
                int r = len - 1;

                while (r > l) {
                    int sum = nums[i] + nums[r] + nums[l];
                    if (sum == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        while (r > l && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (r > l && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}