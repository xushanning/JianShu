//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 370 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：路径总和 II
public class P113PathSumIi {
    public static void main(String[] args) {
        Solution solution = new P113PathSumIi().new Solution();
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

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            dfs(root, new ArrayList<>(), sum);
            return res;
        }

        //               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1

        //节点的值可能是负的
        private void dfs(TreeNode node, List<Integer> cur, int lack) {
            if (node == null) {
                return;
            }

            //这里比较特殊，需要先增加，再进行判断
            cur.add(node.val);
            lack -= node.val;
            if (lack == 0 && node.right == null && node.left == null) {
                res.add(new ArrayList<>(cur));
            }

            dfs(node.left, cur, lack);
            dfs(node.right, cur, lack);
            cur.remove(cur.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}