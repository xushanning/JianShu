//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 358 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的层次遍历 II
public class P107BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();
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

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
//     3
//   / \
//  9  20
//    /  \
//   15   7
// [
//  [15,7],
//  [9,20],
//  [3]
//]
            List<List<Integer>> res = new ArrayList<>();
            dfs(root, res, 0);
            return res;

        }

        private void dfs(TreeNode node, List<List<Integer>> res, int deep) {
            if (node == null) {
                return;
            }
            if (res.size() <= deep) {
                res.add(0, new ArrayList<>());
            }
            res.get(res.size() - deep - 1).add(node.val);
            dfs(node.left, res, deep + 1);
            dfs(node.right, res, deep + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}