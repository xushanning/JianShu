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


package leetcode.editor.cn.round2;

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
        private int len;
        private int[] candidates;
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            len = candidates.length;
            if (len == 0) {
                return res;
            }
            this.candidates = candidates;
            Arrays.sort(candidates);
            dfs(0, new ArrayList<>(), target);
            return res;
        }

        private void dfs(int begin, List<Integer> cur, int lave) {
            if (lave == 0) {
                res.add(new ArrayList<>(cur));
                return;
            }

            for (int i = begin; i < len; i++) {
                int item = candidates[i];
                //核心剪枝
                if (i > begin && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                if (lave - item < 0) {
                    break;
                }
                //选择
                cur.add(item);
                //下钻
                dfs(i + 1, cur, lave - item);
                //回溯
                cur.remove(cur.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}