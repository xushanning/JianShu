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
// 👍 1190 👎 0


package leetcode.editor.cn;

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
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            if (len == 0) {
                return res;
            }
            help(res, nums, new ArrayList<>(), len);
            return res;
        }

        private void help(List<List<Integer>> res, int[] nums, List<Integer> cur, int len) {
            if (cur.size() == len) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = 0; i < len; i++) {
                if (!cur.contains(nums[i])) {
                    cur.add(nums[i]);
                    help(res, nums, cur, len);
                    cur.remove(cur.size() - 1);
                }

            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}