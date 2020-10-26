//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树 
// 👍 629 👎 0


package leetcode.editor.cn.round5;

import java.util.HashMap;
import java.util.Map;

import leetcode.editor.cn.TreeNode;

//Java：路径总和 III
public class P437PathSumIii {
    public static void main(String[] args) {
        Solution solution = new P437PathSumIii().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        private int res = 0;

        public int pathSum(TreeNode root, int sum) {
            //前缀和
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            return help(root, map, sum, 0);
        }

        private int help(TreeNode node, Map<Integer, Integer> map, int target, int curSum) {
            if (node == null) {
                return 0;
            }
            int res = 0;
            curSum += node.val;
            res += map.getOrDefault(curSum - target, 0);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
            res += help(node.left, map, target, curSum);
            res += help(node.right, map, target, curSum);
            map.put(curSum, map.get(curSum) - 1);
            return res;
        }


        //双dfs方法
//        public int pathSum(TreeNode root, int sum) {
//            //前缀和
//            if (root == null) {
//                return res;
//            }
//            dfs(root, sum);
//            pathSum(root.left, sum);
//            pathSum(root.right, sum);
//            return res;
//        }
//
//
//        private void dfs(TreeNode node, int lack) {
//            if (node == null) {
//                return;
//            }
//            if (node.val == lack) {
//                res++;
//                //这里不能有return，因为有负数，还可能存在res++的情况
//            }
//            dfs(node.left, lack - node.val);
//            dfs(node.right, lack - node.val);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}