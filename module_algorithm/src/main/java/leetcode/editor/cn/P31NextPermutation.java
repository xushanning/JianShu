//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 559 👎 0


package leetcode.editor.cn;

//Java：下一个排列
public class P31NextPermutation {
    public static void main(String[] args) {
        Solution solution = new P31NextPermutation().new Solution();
        // TO TEST
        //solution.nextPermutation(new int[]{1, 2, 3, 8, 5, 7, 6, 4});
        solution.nextPermutation(new int[]{1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return;
            }


            //12385764->12386457

            //1、从后向前找到第一个对升序的元素(i,j)
            int i = len - 2;
            while (i >= 0 && nums[i + 1] <= nums[i]) {
                i--;
            }
            //2、在[j,end)中找到第一个比nums[i]大的数字nums[k]
            if (i >= 0) {
                int j = i + 1;
                int k = j+1;
                while (k < len) {
                    if (nums[k] > nums[i]) {
                        break;
                    }
                    k++;
                }

                //3、交换i和k的值
                swap(nums, i, k);
                //4、从小到大排序(j,end)
                reverse(nums, j);
            }


        }

        private void reverse(int[] nums, int start) {
            int i = start, j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}