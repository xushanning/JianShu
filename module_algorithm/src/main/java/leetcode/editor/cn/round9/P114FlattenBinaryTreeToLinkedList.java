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
// 👍 645 👎 0


package leetcode.editor.cn.round9;

import java.util.ArrayList;
import java.util.List;

import leetcode.editor.cn.TreeNode;

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
            if (root == null) {
                return;
            }
            List<TreeNode> list = new ArrayList<>();
            help(list, root);
            TreeNode cur = list.get(0);
            cur.left = null;
            for (int i = 1; i < list.size(); i++) {
                cur.right = list.get(i);
                cur = cur.right;
                cur.left = null;
            }

        }

        private void help(List<TreeNode> list, TreeNode node) {
            if (node == null) {
                return;
            }
            list.add(node);
            help(list, node.left);
            help(list, node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}