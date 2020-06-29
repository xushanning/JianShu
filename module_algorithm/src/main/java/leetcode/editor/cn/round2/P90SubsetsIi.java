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


package leetcode.editor.cn.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：子集 II
public class P90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new P90SubsetsIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();
        private int len;
        private int[] nums;
        private int i;

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            this.len = nums.length;
            this.nums = nums;
            Arrays.sort(nums);
            for (i = 0; i <= len; i++) {

                dfs(new ArrayList<>(), 0);
            }
            return res;
        }

        private void dfs(List<Integer> cur, int start) {
            if (cur.size() == i) {
                if (!res.contains(cur)) {
                    res.add(new ArrayList<>(cur));
                }
                return;
            }

            for (int i = start; i < len; i++) {
                cur.add(nums[i]);
                dfs(cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}