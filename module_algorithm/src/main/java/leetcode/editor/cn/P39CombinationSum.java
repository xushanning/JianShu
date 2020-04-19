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


package leetcode.editor.cn;

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
        //数组
        private int[] candidates;
        //长度
        int len;
        //存放结果
        List<List<Integer>> res = new ArrayList<>();

        int target;

        //按照这个思路来
        //https://leetcode-cn.com/problems/combination-sum/solution/fei-chang-xiang-xi-de-di-gui-hui-su-tao-lu-by-re-2/
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates = candidates;
            this.target = target;
            len = candidates.length;
            //排序
            Arrays.sort(candidates);
            dpf(0, new ArrayList<>(), target);

            return res;

        }

        // candidates = [2,3,6,7], target = 7

        /**
         * @param begin   本轮搜索的起点下标
         * @param cur
         * @param residue 还剩下多少，比如选了2，目标是7，那么还剩5
         */
        private void dpf(int begin, ArrayList<Integer> cur, int residue) {
            //终止条件:已经够了，剩余0了
            if (residue == 0) {
                //拷贝
                res.add(new ArrayList<>(cur));
            }

            //这里的begin是为了去重,因为重复利用，所以还是可以从当前数字开始
            for (int i = begin; i < len; i++) {
                //因为已经排序了，如果小于0，那么就跳出循环
                if (residue - candidates[i] < 0) {
                    break;
                }
                //做选择
                cur.add(candidates[i]);
                //递归
                dpf(i, cur, residue - candidates[i]);
                //回溯
                cur.remove(cur.size() - 1);

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}