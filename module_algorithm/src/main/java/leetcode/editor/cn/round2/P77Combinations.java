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


package leetcode.editor.cn.round2;

import java.util.ArrayList;
import java.util.List;

//Java：组合
public class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();
        private int n;
        private int k;

        //一次性做对，比第一次好
        public List<List<Integer>> combine(int n, int k) {
            if (n < 1 || k < 1) {
                return res;
            }
            this.n = n;
            this.k = k;
            dfs(new ArrayList<>(), 1);
            return res;
        }

        private void dfs(List<Integer> cur, int start) {
            if (cur.size() == k) {
                res.add(new ArrayList<>(cur));
                return;
            }

            for (int i = start; i <= n; i++) {
                if (!cur.contains(i)) {
                    cur.add(i);
                }
                dfs(cur, i + 1);
                cur.remove(cur.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}