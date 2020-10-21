//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 424 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：组合总和 II
public class P40CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();
        private int[] candidates;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            int len = candidates.length;
            if (len == 0) {
                return res;
            }
            Arrays.sort(candidates);
            this.candidates = candidates;
            dfs(0, new ArrayList<>(), target);
            return res;
        }

        // 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
        private void dfs(int start, List<Integer> cur, int lack) {
            if (lack == 0) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (lack - candidates[i] < 0) {
                    break;
                }
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                cur.add(candidates[i]);
                dfs(i + 1, cur, lack - candidates[i]);
                cur.remove(cur.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}