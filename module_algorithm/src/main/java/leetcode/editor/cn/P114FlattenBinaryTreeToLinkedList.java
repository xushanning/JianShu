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
// 👍 597 👎 0


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
//     1
//   / \
//  2   5
// / \   \
//3   4   6
            List<TreeNode> list = new ArrayList<>();
            dfs(root, list);

            for (int i = 1; i < list.size(); i++) {
                TreeNode pre = list.get(i - 1);
                TreeNode cur = list.get(i);
                pre.left = null;
                pre.right = cur;
            }

        }

        private void dfs(TreeNode node, List<TreeNode> list) {
            if (node != null) {
                list.add(node);
                dfs(node.left, list);
                dfs(node.right, list);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}