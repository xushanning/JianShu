//给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。 
//
// 示例 1: 
//
// 
//输入: [3, 2, 1]
//
//输出: 1
//
//解释: 第三大的数是 1.
// 
//
// 示例 2: 
//
// 
//输入: [1, 2]
//
//输出: 2
//
//解释: 第三大的数不存在, 所以返回最大的数 2 .
// 
//
// 示例 3: 
//
// 
//输入: [2, 2, 3, 1]
//
//输出: 1
//
//解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
//存在两个值为2的数，它们都排第二。
// 
// Related Topics 数组 
// 👍 173 👎 0


package leetcode.editor.cn;

import java.util.Set;
import java.util.TreeSet;

//Java：第三大的数
public class P414ThirdMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new P414ThirdMaximumNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int thirdMax(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }
            //set会去重，默认构造函数，会按照自然顺序排序，所以，第一个最小，最后一个最大。
            TreeSet<Integer> set = new TreeSet<>();
            for (Integer i : nums) {
                set.add(i);
                if (set.size() > 3) {
                    //把最小的干掉
                    set.remove(set.first());
                }
            }
            return set.size() < 3 ? set.last() : set.first();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}