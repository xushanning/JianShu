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
// 👍 1074 👎 0


package leetcode.editor.cn;

import org.w3c.dom.ls.LSInput;

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
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            int len = candidates.length;
            if (len == 0) {
                return res;
            }
            //一定要排序，如果不排序，会把一些正确的结果剪掉
            Arrays.sort(candidates);
            help(0, res, new ArrayList<>(), candidates, target);

            return res;
        }

        private void help(int start, List<List<Integer>> res, List<Integer> cur, int[] candidates, int lack) {
            if (lack == 0) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (lack - candidates[i] < 0) {
                    break;
                }
                cur.add(candidates[i]);
                help(i, res, cur, candidates, lack - candidates[i]);
                cur.remove(cur.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}