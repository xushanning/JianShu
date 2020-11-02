//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 
// 👍 655 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：和为K的子数组
public class P560SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new P560SubarraySumEqualsK().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {

            //key为前i项的和，value为在数组中的位置，这个是为了比如说下面这个数组
            //[1,2,3,-2,-3,3,2,4,8]
            //前3项和为6，map<3,6>
            //前7项和也为6，map<7,6>
            //那么如果k为6的话，就有两种了
            Map<Integer, Integer> map = new HashMap<>();
            int res = 0;
            int cur = 0;
            //前缀和0首现出现1次，即：在-1位置（空数组）
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                cur += nums[i];
                if (map.containsKey(cur - k)) {
                    res += map.get(cur - k);
                }
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}