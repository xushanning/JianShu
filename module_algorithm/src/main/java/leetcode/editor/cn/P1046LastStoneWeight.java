//有一堆石头，每块石头的重量都是正整数。 
//
// 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下： 
//
// 
// 如果 x == y，那么两块石头都会被完全粉碎； 
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 
// 
//
// 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。 
//
// 
//
// 示例： 
//
// 输入：[2,7,4,1,8,1]
//输出：1
//解释：
//先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
//再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
//接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
//最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 1000 
// 
// Related Topics 堆 贪心算法 
// 👍 84 👎 0


package leetcode.editor.cn;

//Java：最后一块石头的重量
public class P1046LastStoneWeight {
    public static void main(String[] args) {
        Solution solution = new P1046LastStoneWeight().new Solution();
        // TO TEST
        solution.lastStoneWeight(new int[]{7, 6, 7, 6, 9});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] stones;
        private int len;

        public int lastStoneWeight(int[] stones) {
            this.stones = stones;
            this.len = stones.length;
            buildMaxHeap();

            //0的数量，如果等于len-1，那么就跳出
            //脑壳疼

//            while (len > 1) {
//                int max = stones[0];
//                swap(0, len - 1);
//            }


            return stones[0];
        }

        //建立大顶堆
        private void buildMaxHeap() {
            for (int i = len / 2 - 1; i >= 0; i--) {
                heapify(i);
            }
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int max = i;
            if (left < len && stones[left] > stones[max]) {
                max = left;
            }
            if (right < len && stones[right] > stones[max]) {
                max = right;
            }
            if (max != i) {
                //需要交换，并重新构建堆
                swap(max, i);
                heapify(max);
            }
        }

        private void swap(int m, int n) {
            int temp = stones[m];
            stones[m] = stones[n];
            stones[n] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}