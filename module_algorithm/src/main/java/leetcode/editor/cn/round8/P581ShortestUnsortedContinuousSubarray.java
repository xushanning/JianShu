//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 你找到的子数组应是最短的，请输出它的长度。 
//
// 示例 1: 
//
// 
//输入: [2, 6, 4, 8, 10, 9, 15]
//输出: 5
//解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 说明 : 
//
// 
// 输入的数组长度范围在 [1, 10,000]。 
// 输入的数组可能包含重复元素 ，所以升序的意思是<=。 
// 
// Related Topics 数组 
// 👍 440 👎 0


package leetcode.editor.cn.round8;

import java.util.Arrays;

//Java：最短无序连续子数组
public class P581ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new P581ShortestUnsortedContinuousSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            //[2,6,4,8,10,9,15]
            //[2,4,6,8,9,10,15]
            int len = nums.length;
            if (len <= 1) {
                return 0;
            }
            int[] nums1 = nums.clone();
            Arrays.sort(nums);
            int start = len;
            int end = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] != nums1[i]) {
                    start = Math.min(start, i);
                    end = Math.max(end, i);
                }
            }
            return (end >= start) ? end - start + 1 : 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}