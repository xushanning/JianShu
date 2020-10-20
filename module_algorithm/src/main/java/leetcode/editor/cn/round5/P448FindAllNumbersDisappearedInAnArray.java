//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组 
// 👍 479 👎 0


package leetcode.editor.cn.round5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：找到所有数组中消失的数字
public class P448FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new P448FindAllNumbersDisappearedInAnArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int len = nums.length;
            List<Integer> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                map.put(n, 0);
            }

            for (int i = 1; i <=len; i++) {
                if (map.get(i) == null) {
                    res.add(i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}