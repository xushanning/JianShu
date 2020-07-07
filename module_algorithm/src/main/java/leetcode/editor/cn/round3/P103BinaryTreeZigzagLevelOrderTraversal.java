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


package leetcode.editor.cn.round3;

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
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return res;
            }
            dfs(root, 1);
            return res;
        }

        private void dfs(TreeNode node, int index) {
            if (index > res.size()) {
                res.add(new ArrayList<>());
            }
            int flag = index % 2;
            if (flag == 1) {
                //等于1，其实对应的是偶数层，从左往右，也就是往尾部追加
                res.get(index - 1).add(node.val);
            } else {
                //等于0，其实对应的奇数层，从右往左，加在开头
                res.get(index - 1).add(0, node.val);
            }


            if (node.left != null) {
                dfs(node.left, index + 1);
            }
            if (node.right != null) {
                dfs(node.right, index + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}