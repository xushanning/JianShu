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
// 👍 788 👎 0


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
//输出: [1,3,12,0,0]
            int len = nums.length;
            if (len == 0) {
                return;
            }
            int j = 0;
            for (int i = 0; i < len; i++) {
                //如果i位置为0，那么++，不管
                //不为0,交换
                //可以理解为把右边遇到的不为0的移动到左边去，j位置的不管是不是0，都交换
                if (nums[i] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}