//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 514 👎 0


package leetcode.editor.cn.round5;

import leetcode.editor.cn.TreeNode;

//Java：二叉树的直径
public class P543DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P543DiameterOfBinaryTree().new Solution();
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
        private int res = 1;

        public int diameterOfBinaryTree(TreeNode root) {
            depth(root);
            return res - 1;
        }

        private int depth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int l = depth(node.left);
            int r = depth(node.right);
            res = Math.max(res, l + r + 1);
            return Math.max(l, r) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}