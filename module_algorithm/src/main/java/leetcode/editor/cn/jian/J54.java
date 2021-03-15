package leetcode.editor.cn.jian;

import leetcode.editor.cn.TreeNode;

public class J54 {
    public static void main(String[] args) {
        Solution solution = new J54().new Solution();
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
        int res, k;

        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }

        void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.right);
            if (k == 0) {
                return;
            }
            if (--k == 0) {
                res = root.val;
            }
            dfs(root.left);
        }

    }
}
