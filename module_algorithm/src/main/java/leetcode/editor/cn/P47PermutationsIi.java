//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 499 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：全排列 II
public class P47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        // TO TEST
        solution.permuteUnique(new int[]{1, 1, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();
        private int[] nums;
        private boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums.length == 0) {
                return res;
            }
            this.nums = nums;
            used = new boolean[nums.length];
            Arrays.sort(nums);
            dfs(new ArrayList<>());
            return res;
        }

        private void dfs(List<Integer> cur) {
            if (cur.size() == nums.length) {
                res.add(new ArrayList<>(cur));
            }
            //1 1 2
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                cur.add(nums[i]);
                used[i] = true;
                dfs(cur);
                used[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}