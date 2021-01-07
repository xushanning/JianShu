//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
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
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 304 👎 0


package leetcode.editor.cn.round9;

import java.util.ArrayList;
import java.util.List;

import leetcode.editor.cn.TreeNode;

//Java：二叉树的锯齿形层次遍历
public class P103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(res, root, 0);
            return res;
        }

        private void dfs(List<List<Integer>> res, TreeNode node, int depth) {
            if (node == null) {
                return;
            }
            if (res.size() == depth) {
                res.add(new ArrayList<>());
            }
            if (depth % 2 == 0) {
                res.get(depth).add(node.val);
            } else {
                res.get(depth).add(0, node.val);
            }
            dfs(res, node.left, depth + 1);
            dfs(res, node.right, depth + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}