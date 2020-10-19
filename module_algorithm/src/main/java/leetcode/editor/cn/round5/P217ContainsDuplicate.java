//给定一个整数数组，判断是否存在重复元素。 
//
// 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 
// 👍 303 👎 0


package leetcode.editor.cn.round5;

import java.util.HashMap;
import java.util.Map;

//Java：存在重复元素
public class P217ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new P217ContainsDuplicate().new Solution();
        // TO TEST
        solution.containsDuplicate(new int[]{1, 2, 3, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            int len = nums.length;
            if (len < 2) {
                return false;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                Integer cur = map.get(nums[i]);
                if (cur == null) {
                    map.put(nums[i], 1);
                } else if (cur == 1) {
                    return true;
                }
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}