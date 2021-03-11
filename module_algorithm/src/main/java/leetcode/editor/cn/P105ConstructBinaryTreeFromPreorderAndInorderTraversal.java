//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 921 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0 || preorder.length != inorder.length) {
                return null;
            }
            // 前序遍历 preorder = [3,9,20,15,7]
            //中序遍历 inorder = [9,3,15,20,7]
            int len = preorder.length;
            Map<Integer, Integer> map = new HashMap<>(len);
            for (int i = 0; i < len; i++) {
                map.put(inorder[i], i);
            }
            return help(map, preorder, 0, len, 0);
        }

        private TreeNode help(Map<Integer, Integer> map, int[] preorder, int preLeft, int preRight, int inLeft) {

            if (preLeft == preRight) {
                return null;
            }
            int rootNum = preorder[preLeft];
            TreeNode rootNode = new TreeNode(rootNum);
            int rootPosition = map.get(rootNum);
            int leftCount = rootPosition - inLeft;
            rootNode.left = help(map, preorder, preLeft + 1, preLeft + 1 + leftCount, inLeft);
            rootNode.right = help(map, preorder, preLeft + 1 + leftCount, preRight, rootPosition + 1);
            return rootNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}