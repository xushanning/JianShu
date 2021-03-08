//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 748 👎 0


package leetcode.editor.cn.round10;

import java.util.ArrayList;
import java.util.List;

import leetcode.editor.cn.TreeNode;

//Java：二叉树的层序遍历
public class P102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
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
        private List<List<Integer>> res;

        public List<List<Integer>> levelOrder(TreeNode root) {
            res = new ArrayList<>();
            help(root, 0);
            return res;
        }

        private void help(TreeNode node, int depth) {
            if (node == null) {
                return;
            }
            if (res.size() == depth) {
                res.add(new ArrayList<>());
            }
            res.get(depth).add(node.val);
            help(node.left, depth + 1);
            help(node.right, depth + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}