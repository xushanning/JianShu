//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


package leetcode.editor.cn.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：全排列 II
public class P47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();
        private int[] nums;
        private int len;
        private boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            len = nums.length;
            if (len == 0) {
                return res;
            }
            this.nums = nums;
            used = new boolean[len];
            Arrays.sort(nums);
            dfs(new ArrayList<>());
            return res;
        }

        private void dfs(List<Integer> cur) {
            if (cur.size() == len) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = 0; i < len; i++) {
                if (used[i]) {
                    continue;
                }
                //如果当前和上一个相等，并且上一个没有被用过，所以上面必须得排序
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                cur.add(nums[i]);
                used[i] = true;
                dfs(cur);
                //回溯
                used[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}