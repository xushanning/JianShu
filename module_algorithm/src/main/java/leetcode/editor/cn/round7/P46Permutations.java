//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 974 👎 0


package leetcode.editor.cn.round7;

import java.util.ArrayList;
import java.util.List;

//Java：全排列
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res;
        private int len;
        private int[] nums;

        public List<List<Integer>> permute(int[] nums) {
            len = nums.length;
            res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            this.nums = nums;
            dfs(new ArrayList<>());
            return res;
        }

        private void dfs(List<Integer> cur) {
            if (cur.size() == len) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = 0; i < len; i++) {
                if (!cur.contains(nums[i])) {
                    cur.add(nums[i]);
                    dfs(cur);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}