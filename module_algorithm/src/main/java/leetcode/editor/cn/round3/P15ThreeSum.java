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


package leetcode.editor.cn.round3;

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
            //[-1, 0, 1, 2, -1, -4]
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len < 3) {
                return res;
            }
            Arrays.sort(nums);

            for (int i = 0; i < len; i++) {
                //第i个如果大于0，说明不可能出现为0的组合
                if (nums[i] > 0) {
                    break;
                }
                //当前和上一个相同，那么已经处理过，不处理
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i];
                    if (sum == 0) {
                        //说明正好
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[left]);
                        item.add(nums[right]);
                        item.add(nums[i]);
                        res.add(item);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        //如果正好三个数为0，那么排除了相同的，动一个的话，肯定不可能为0，所以两边同时缩圈
                        left++;
                        right--;
                    } else if (sum > 0) {
                        //说明right太大了，需要--
                        right--;
                    } else {
                        //说明left太小了，需要++
                        left++;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}