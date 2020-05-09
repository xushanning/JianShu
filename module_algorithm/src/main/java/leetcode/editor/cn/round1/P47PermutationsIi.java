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


package leetcode.editor.cn.round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.editor.cn.PrintUtil;

//Java：全排列 II
public class P47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        // TO TEST
        List<List<Integer>> res = solution.permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> item : res) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : item) {
                sb.append(i);
            }
            PrintUtil.print(sb.toString());
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();
        private int len;
        private int[] nums;
        private boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            len = nums.length;
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
                //如果第i个用了，那么跳过
                if (used[i]) {
                    continue;
                }
                //剪枝，最难理解的地方，关键
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