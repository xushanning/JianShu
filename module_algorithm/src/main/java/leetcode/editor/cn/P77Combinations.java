//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：组合
public class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
        List<List<Integer>> res = solution.combine(4, 2);
        for (int i = 0; i < res.size(); i++) {
            PrintUtil.print(res.get(i).size());
            for (int j = i; j < res.get(i).size(); j++) {
                PrintUtil.print(res.get(i).get(j));
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new LinkedList<>();
        int n, k;

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            //先选1, 保存的路径上来是空的
            backtrack(1, new LinkedList<>());
            return res;
        }

        /**
         * @param first 要选择的列表
         * @param cur   要保存的路径
         */
        private void backtrack(int first, LinkedList<Integer> cur) {
            //触发结束条件:当保存的路径的长度，等于限制的长度：k个数的组合的时候，这个就满足了，
            //就把结果存放起来
            if (cur.size() == k) {
                //todo 这里不明白，为什么不是res.add(cur)
                //貌似是copy的原因
                res.add(new LinkedList(cur));
                return;
            }

            //做选择
            for (int i = first; i < n + 1; i++) {
                //做选择，记录路径
                cur.add(i);
                //下钻
                backtrack(i + 1, cur);
                //撤销选择,把最后添加的干掉
                cur.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}