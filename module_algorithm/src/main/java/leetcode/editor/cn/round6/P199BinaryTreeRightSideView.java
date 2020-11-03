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
// 👍 347 👎 0


package leetcode.editor.cn.round6;

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
        private List<Integer> res = new ArrayList<>();

        public List<Integer> rightSideView(TreeNode root) {
            dfs(root, 0);
            return res;
        }

        //这个题和层序遍历很像
        private void dfs(TreeNode node, int deep) {
            if (node == null) {
                return;
            }
            if (res.size() == deep) {
                res.add(node.val);
            }

            dfs(node.right, deep + 1);
            dfs(node.left, deep + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}