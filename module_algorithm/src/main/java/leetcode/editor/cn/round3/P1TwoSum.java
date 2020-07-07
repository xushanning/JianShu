//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


package leetcode.editor.cn.round3;

import java.util.HashMap;
import java.util.Map;

//Java：两数之和
public class P1TwoSum {
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int len = nums.length;
            if (len < 2) {
                return null;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                int a = target - nums[i];
                if (map.containsKey(a)) {
                    return new int[]{map.get(a), i};
                } else {
                    map.put(nums[i], i);
                }
            }
            throw new IllegalArgumentException("没有这两个");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}