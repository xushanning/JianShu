//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1052 👎 0


package leetcode.editor.cn;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

//Java：子集
public class P78Subsets {
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：nums = [1,2,3]
        //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        private int len;
        private List<List<Integer>> res;
        private int[] nums;

        public List<List<Integer>> subsets(int[] nums) {
            len = nums.length;
            res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            this.nums = nums;
            for (int i = 0; i <= len; i++) {
                help(new ArrayList<>(), i, 0);
            }


            return res;
        }

        private void help(List<Integer> cur, int size, int start) {
            if (cur.size() == size) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = start; i < len; i++) {
                cur.add(nums[i]);
                help(cur, size, i+1);
                cur.remove(cur.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}