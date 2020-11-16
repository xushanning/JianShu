//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 624 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树展开为链表
public class P114FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new P114FlattenBinaryTreeToLinkedList().new Solution();
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
        public void flatten(TreeNode root) {
            List<TreeNode> list = new ArrayList<>();
            dfs(list, root);
            for (int i = 1; i < list.size(); i++) {
                TreeNode pre = list.get(i - 1);
                pre.right = list.get(i);
                pre.left = null;
            }
        }

        private void dfs(List<TreeNode> list, TreeNode node) {
            if (node == null) {
                return;
            }
            list.add(node);
            dfs(list, node.left);
            dfs(list, node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}