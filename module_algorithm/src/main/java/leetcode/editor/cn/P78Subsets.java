//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：子集
public class P78Subsets {
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //todo 此题还需要进一步理解
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        //k代表子集的长度，
        int n, k;

        public List<List<Integer>> subsets(int[] nums) {
            n = nums.length;
            //思路：从子集长度为0开始，搜索一次所有是0的子集
            //然后k=1，搜索所有子集长度为1的子集
            for (k = 0; k < n + 1; ++k) {
                backtrack(0, new ArrayList<>(), nums);
            }
            return res;
        }

        private void backtrack(int first, List<Integer> cur, int[] nums) {
            if (cur.size() == k) {
                //当路径中的长度满足了当前规定的遍历长度k的时候，就返回
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = first; i < n; i++) {
                //做选择
                cur.add(nums[i]);
                //下钻
                backtrack(i + 1, cur, nums);
                //回退
                cur.remove(cur.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}