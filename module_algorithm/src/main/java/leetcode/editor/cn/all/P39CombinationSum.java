//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1216 👎 0


package leetcode.editor.cn.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：组合总和
public class P39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
        int[] candidates;
        int len;
        List<List<Integer>> res;
        int target;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.len = candidates.length;
            res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            this.target = target;
            this.candidates = candidates;
            Arrays.sort(candidates);
            dfs(new ArrayList<>(), target, 0);
            return res;
        }

        private void dfs(List<Integer> cur, int lack, int start) {
            if (lack == 0) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = start; i < len; i++) {
                if (lack - candidates[i] < 0) {
                    break;
                }
                cur.add(candidates[i]);
                dfs(cur, lack - candidates[i], i);
                cur.remove(cur.size() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}