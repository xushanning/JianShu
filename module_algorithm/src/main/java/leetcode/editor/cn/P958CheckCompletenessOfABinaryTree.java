//给定一个二叉树，确定它是否是一个完全二叉树。 
//
// 百度百科中对完全二叉树的定义如下： 
//
// 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：
//第 h 层可能包含 1~ 2h 个节点。） 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[1,2,3,4,5,6]
//输出：true
//解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
// 
//
// 示例 2： 
//
// 
//
// 输入：[1,2,3,4,5,null,7]
//输出：false
//解释：值为 7 的结点没有尽可能靠向左侧。
// 
//
// 
//
// 提示： 
//
// 
// 树中将会有 1 到 100 个结点。 
// 
// Related Topics 树 
// 👍 85 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的完全性检验
public class P958CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new P958CheckCompletenessOfABinaryTree().new Solution();
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
        public boolean isCompleteTree(TreeNode root) {
            List<ANode> list = new ArrayList<>();
            list.add(new ANode(root, 1));

            int i = 0;
            while (i < list.size()) {
                ANode node = list.get(i++);
                if (node.node != null) {
                    list.add(new ANode(node.node.left, node.code * 2));
                    list.add(new ANode(node.node.right, node.code * 2 + 1));
                }
            }
            return list.get(i - 1).code == list.size();
        }

        class ANode {
            TreeNode node;
            int code;

            ANode(TreeNode node, int code) {
                this.node = node;
                this.code = code;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}