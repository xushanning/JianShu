//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表 
// 👍 207 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：存在重复元素 II
public class P219ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new P219ContainsDuplicateIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            // 输入: nums = [1,2,3,1], k = 3
            //输出: true
            int len = nums.length;
            if (len < 2) {
                return false;
            }
            //key 值
            //value 位置
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                int cur = nums[i];
                Integer position = map.get(cur);
                if (position != null && i - position <= k) {
                    return true;
                } else {
                    map.put(cur, i);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}