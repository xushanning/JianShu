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
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法


package leetcode.editor.cn.round2;

import java.util.ArrayList;
import java.util.List;

//Java：组合总和
public class P39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();
        private int[] candidates;
        private int len;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates = candidates;
            len = candidates.length;
            if (len == 0) {
                return res;
            }
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
                if (lave - item < 0) {
                    continue;
                }


                //做选择
                cur.add(item);
                //下钻
                dfs(i, cur, lave - item);
                //回溯
                cur.remove(cur.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}