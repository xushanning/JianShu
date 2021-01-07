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
// 👍 1024 👎 0


package leetcode.editor.cn.round9;

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
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            help(res, new ArrayList<>(), nums);
            return res;
        }

        private void help(List<List<Integer>> res, List<Integer> cur, int[] nums) {
            if (cur.size() == nums.length) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!cur.contains(nums[i])) {
                    cur.add(nums[i]);
                    help(res, cur, nums);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}