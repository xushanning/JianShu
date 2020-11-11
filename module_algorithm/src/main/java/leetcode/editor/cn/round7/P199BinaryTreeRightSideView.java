//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 349 👎 0


package leetcode.editor.cn.round7;

import java.util.ArrayList;
import java.util.List;

import leetcode.editor.cn.TreeNode;

//Java：二叉树的右视图
public class P199BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new P199BinaryTreeRightSideView().new Solution();
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
        public List<Integer> rightSideView(TreeNode root) {
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
            List<Integer> res = new ArrayList<>();
            dfs(res, root, 0);
            return res;
        }

        //
        private void dfs(List<Integer> res, TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            if (res.size() == depth) {
                res.add(root.val);
            }
            dfs(res, root.right, depth + 1);
            dfs(res, root.left, depth + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}