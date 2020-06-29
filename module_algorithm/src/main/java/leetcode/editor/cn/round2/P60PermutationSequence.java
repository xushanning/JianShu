//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法


package leetcode.editor.cn.round2;

import java.util.ArrayList;
import java.util.List;

//Java：第k个排列
public class P60PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new P60PermutationSequence().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> res = new ArrayList<>();
        private int n;

//        public String getPermutation(int n, int k) {
//            this.n = n;
//            for (int i = 0; i < n; i++) {
//                dfs(i, new StringBuilder());
//            }
//            return "";
//        }
//
//        private void dfs(int start, StringBuilder cur) {
//            if (cur.length() == n) {
//                res.add(cur.toString());
//            }
//            for (int i = start; i < n; i++) {
//
//                cur.append(i);
//                dfs(start + 1, cur);
//                cur.deleteCharAt(cur.length() - 1);
//            }
//
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}