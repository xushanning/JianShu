//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn.round1;

//Java：相同的树
public class P100SameTree {
    public static void main(String[] args) {
        Solution solution = new P100SameTree().new Solution();
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
        //贼他妈的简单
        public boolean isSameTree(TreeNode m, TreeNode n) {
            if (m == null && n == null) {
                return true;
            }

            if (m != null && n != null) {
                if (m.val != n.val) {
                    return false;
                }
                return isSameTree(m.left, n.left) && isSameTree(m.right, n.right);
            }
            return false;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}