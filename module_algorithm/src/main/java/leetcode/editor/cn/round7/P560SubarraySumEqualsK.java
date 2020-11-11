//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 
// 👍 670 👎 0


package leetcode.editor.cn.round7;

//Java：和为K的子数组
public class P560SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new P560SubarraySumEqualsK().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            //前缀和的进化过程
            int len = nums.length;
            int[] sum = new int[len + 1];
            sum[0] = 0;
            for (int i = 0; i < len; i++) {
                sum[i + 1] = nums[i] + sum[i];
            }
            int res = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    if (sum[j + 1] - sum[i] == k) {
                        res++;
                    }
                }
            }
            //用hashmap降低复杂度
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}