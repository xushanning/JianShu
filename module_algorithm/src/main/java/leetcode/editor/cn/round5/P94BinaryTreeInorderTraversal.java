//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 751 👎 0


package leetcode.editor.cn.round5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.editor.cn.TreeNode;

//Java：二叉树的中序遍历
public class P94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
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


        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                //把最左边的弹出去
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }

            return res;
        }

        private void help(TreeNode node, List<Integer> res) {
            if (node == null) {
                return;
            }
            help(node.left, res);
            res.add(node.val);
            help(node.right, res);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}