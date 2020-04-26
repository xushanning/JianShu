//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：子集 II
public class P90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new P90SubsetsIi().new Solution();
        // TO TEST
        List<List<Integer>> res = solution.subsetsWithDup(new int[]{2, 2, 1});
        for (int i = 0; i < res.size(); i++) {

        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();
        private int len, k;
        private int[] nums;

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            len = nums.length;
            this.nums = nums;
            Arrays.sort(nums);
            for (k = 0; k <= len; k++) {
                backtrack(0, new ArrayList<>());
            }
            return res;
        }

        private void backtrack(int start, List<Integer> cur) {

            if (cur.size() == k) {
                //如果不包含，那么增加，如果有重复的直接返回
                if (!res.contains(cur)) {
                    res.add(new ArrayList<>(cur));
                }
                return;
            }
            for (int i = start; i < len; i++) {
                //做判断
                cur.add(nums[i]);
                //下钻
                backtrack(i + 1, cur);
                //回溯
                cur.remove(cur.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}