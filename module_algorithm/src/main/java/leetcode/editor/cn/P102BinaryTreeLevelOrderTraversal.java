//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 675 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

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
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            dfs(root, 0);

            return res;
        }

        //     3
        //   / \
        //  9  20
        //    /  \
        //   15   7
        private void dfs(TreeNode node, int deep) {
            if (node == null) {
                return;
            }
            //最关键的地方
            //两次都是判断get(deep)==null如果为null，那么增加
            //这里会出问题，因为res的size为0，如果直接取0，会报空指针
            if (res.size() <= deep) {
                res.add(new ArrayList<>());
            }

            res.get(deep).add(node.val);
            dfs(node.left, deep + 1);
            dfs(node.right, deep + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}