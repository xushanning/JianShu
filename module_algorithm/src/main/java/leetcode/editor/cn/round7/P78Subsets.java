//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 865 👎 0


package leetcode.editor.cn.round7;

import java.util.ArrayList;
import java.util.List;

//Java：子集
public class P78Subsets {
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res;
        private int[] nums;
        private int len;

        public List<List<Integer>> subsets(int[] nums) {
            len = nums.length;
            this.nums = nums;
            res = new ArrayList<>();
            for (int i = 0; i <= len; i++) {
                dfs(new ArrayList<>(), i, 0);
            }
            return res;
        }

        private void dfs(List<Integer> cur, int max, int start) {
            if (cur.size() == max) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                cur.add(nums[i]);
                dfs(cur, max, i + 1);
                cur.remove(cur.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}