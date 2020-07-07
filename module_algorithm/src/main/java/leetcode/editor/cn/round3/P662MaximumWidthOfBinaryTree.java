//给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节
//点为空。 
//
// 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。 
//
// 示例 1: 
//
// 
//输入: 
//
//           1
//         /   \
//        3     2
//       / \     \  
//      5   3     9 
//
//输出: 4
//解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
// 
//
// 示例 2: 
//
// 
//输入: 
//
//          1
//         /  
//        3    
//       / \       
//      5   3     
//
//输出: 2
//解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
// 
//
// 示例 3: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2 
//       /        
//      5      
//
//输出: 2
//解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
// 
//
// 示例 4: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       /     \  
//      5       9 
//     /         \
//    6           7
//输出: 8
//解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
// 
//
// 注意: 答案在32位有符号整数的表示范围内。 
// Related Topics 树


package leetcode.editor.cn.round3;

import java.util.HashMap;
import java.util.Map;

import leetcode.editor.cn.TreeNode;

//Java：二叉树最大宽度
public class P662MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P662MaximumWidthOfBinaryTree().new Solution();
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
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Map<Integer, Integer> leftMap = new HashMap<>();
            Map<Integer, Integer> rightMap = new HashMap<>();
            dfs(root, leftMap, rightMap, 1, 1);
            int max = 0;
            for (int key : rightMap.keySet()) {
                max = Math.max(max, rightMap.get(key) - leftMap.get(key) + 1);
            }
            return max;
        }

        private void dfs(TreeNode root, Map<Integer, Integer> left, Map<Integer, Integer> right, int deep, int num) {
            if (root == null) {
                return;
            }
            if (!left.containsKey(deep)) {
                left.put(deep, num);
            }
            if (!right.containsKey(deep) || right.get(deep) < num) {
                right.put(deep, num);
            }
            dfs(root.left, left, right, deep + 1, 2 * num);
            dfs(root.right, left, right, deep + 1, 2 * num + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}