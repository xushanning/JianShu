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


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：全排列
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
        solution.permute(new int[]{1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();
        private int[] nums;

        public List<List<Integer>> permute(int[] nums) {
            this.nums = nums;
            if (nums.length != 0) {
                List<Integer> also = new ArrayList<>();
                for (int i = 0; i < nums.length; i++) {
                    also.add(nums[i]);
                }
                dfs(new ArrayList<>(), also);
            }
            return res;
        }

        /**
         * @param cur  路径存储
         * @param also 记录剩下可选的list
         */
        private void dfs(List<Integer> cur, List<Integer> also) {
            //递归终止条件
            if (cur.size() == nums.length) {
                res.add(new ArrayList<>(cur));
                return;
            }

            for (int i = 0; i < also.size(); i++) {
                //判断
                cur.add(also.get(i));
                //拷贝一份
                List<Integer> next = new ArrayList<>(also);
                next.remove(i);
                //递归
                dfs(cur, next);
                //回溯
                cur.remove(cur.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}