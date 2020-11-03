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
// 👍 2704 👎 0


package leetcode.editor.cn.round6;

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
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
            //-4 -1 -1 0 1 2
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len < 3) {
                return res;
            }
            Arrays.sort(nums);


            for (int i = 0; i < len - 2; i++) {

                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 1;
                int right = len - 1;

                while (right > left) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        List<Integer> cur = new ArrayList<>();
                        cur.add(nums[i]);
                        cur.add(nums[left]);
                        cur.add(nums[right]);
                        res.add(cur);
                        while (right > left && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        //忘了这两行代码了
                        left++;
                        right--;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }

            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}