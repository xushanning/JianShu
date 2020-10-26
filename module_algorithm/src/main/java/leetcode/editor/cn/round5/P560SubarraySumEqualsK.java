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
// 👍 653 👎 0


package leetcode.editor.cn.round5;

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

            //定义pre[i] 为前i项的和，那么pre[i]=pre[i-1]+nums[i]
            //那么k=pre[i]-pre[j]

            //key为pre[i]的值
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int res = 0, pre = 0;
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (map.containsKey(pre - k)) {
                    res += map.get(pre - k);
                }
                map.put(pre, map.getOrDefault(pre, 0)+1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}