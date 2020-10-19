//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 384 👎 0


package leetcode.editor.cn.round5;

import java.util.ArrayList;
import java.util.List;

import leetcode.editor.cn.TreeNode;

//Java：二叉树的所有路径
public class P257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();
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
        private List<String> res = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            dfs(sb, root);
            return res;
        }

        private void dfs(StringBuilder sb, TreeNode cur) {
            if (cur == null) {
                return;
            }
            if (cur.left == null && cur.right == null) {
                res.add(sb.toString() + cur.val);
            }
            int len = sb.length();
            sb.append(cur.val).append("->");
            dfs(sb, cur.left);
            dfs(sb, cur.right);
            //回溯
            sb.delete(len, sb.length());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}