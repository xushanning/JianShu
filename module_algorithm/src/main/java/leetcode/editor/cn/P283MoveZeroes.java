//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 770 👎 0


package leetcode.editor.cn;

//Java：移动零
public class P283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
// 输入: [0,1,0,3,12]
            //[1,0,0,3,12]
            //[1,3,0,0,12]
            //[1,3,12,0,0]
//输出: [1,3,12,0,0]
            int len = nums.length;
            if (len == 0) {
                return;
            }
            int l = 0;
            for (int r = 0; r < len; r++) {
                if (nums[r] != 0) {
                    int temp = nums[r];
                    nums[r] = nums[l];
                    nums[l] = temp;
                    l++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}