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


package leetcode.editor.cn.round3;

import java.util.Arrays;

//Java：存在重复元素
public class P217ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new P217ContainsDuplicate().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //妈呀，历史上做的最快的一道题。。不到一分钟搞定了。。日
        public boolean containsDuplicate(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return false;
            }
            Arrays.sort(nums);
            for (int i = 1; i < len; i++) {
                if (nums[i] == nums[i - 1]) {
                    return true;
                }
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}