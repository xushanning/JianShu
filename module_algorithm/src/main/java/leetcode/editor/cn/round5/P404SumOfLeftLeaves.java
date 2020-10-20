//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 247 👎 0


package leetcode.editor.cn.round5;

import leetcode.editor.cn.TreeNode;

//Java：左叶子之和
public class P404SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new P404SumOfLeftLeaves().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int val = 0;
            //如果左节点不为空，且左节点没有左右孩子，那么这个节点就是左叶子
            if (root.left != null && root.left.left == null && root.left.right == null) {
                val = root.left.val;
            }
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + val;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}