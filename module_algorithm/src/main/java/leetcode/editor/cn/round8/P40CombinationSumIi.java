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
// 👍 442 👎 0


package leetcode.editor.cn.round8;

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
        // 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            Arrays.sort(candidates);
            List<List<Integer>> res = new ArrayList<>();
            dfs(candidates, target, res, new ArrayList<>(), 0);
            return res;

        }

        //可以重复
        private void dfs(int[] candidates, int lack, List<List<Integer>> res, List<Integer> cur, int start) {
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
                dfs(candidates, lack - candidates[i], res, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
        //期望结果：[[1,1,6],[1,2,5],[1,7],[2,6]]
        //dfs递归的时候i不加1：[[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,2],[1,1,1,1,2,2],[1,1,1,5],[1,1,2,2,2],[1,1,6],[1,2,5],[1,7],[2,2,2,2],[2,6]]
        //i永远从0开始[[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,2],[1,1,1,1,1,2,1],[1,1,1,1,2,1,1],[1,1,1,1,2,2],[1,1,1,2,1,1,1],[1,1,1,2,1,2],[1,1,1,2,2,1],[1,1,1,5],[1,1,2,1,1,1,1],[1,1,2,1,1,2],[1,1,2,1,2,1],[1,1,2,2,1,1],[1,1,2,2,2],[1,1,5,1],[1,1,6],[1,2,1,1,1,1,1],[1,2,1,1,1,2],[1,2,1,1,2,1],[1,2,1,2,1,1],[1,2,1,2,2],[1,2,2,1,1,1],[1,2,2,1,2],[1,2,2,2,1],[1,2,5],[1,5,1,1],[1,5,2],[1,6,1],[1,7],[2,1,1,1,1,1,1],[2,1,1,1,1,2],[2,1,1,1,2,1],[2,1,1,2,1,1],[2,1,1,2,2],[2,1,2,1,1,1],[2,1,2,1,2],[2,1,2,2,1],[2,1,5],[2,2,1,1,1,1],[2,2,1,1,2],[2,2,1,2,1],[2,2,2,1,1],[2,2,2,2],[2,5,1],[2,6],[5,1,1,1],[5,1,2],[5,2,1],[6,1,1],[6,2],[7,1]]
    }
//leetcode submit region end(Prohibit modification and deletion)

}