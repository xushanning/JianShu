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
// 👍 347 👎 0


package leetcode.editor.cn.round5;

import java.util.ArrayList;
import java.util.List;

import leetcode.editor.cn.TreeNode;

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
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            dfs(root, 0);
            return res;
        }

        public void dfs(TreeNode node, int depth) {
            if (node == null) {
                return;
            }
            //说明满了，需要增加新的，越深的越放在前面
            if (depth == res.size()) {
                res.add(0, new ArrayList<>());
            }
            res.get(res.size() - depth - 1).add(node.val);
            dfs(node.left, depth + 1);
            dfs(node.right, depth + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}