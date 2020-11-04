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
// 👍 741 👎 0


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
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0 || preorder.length != inorder.length) {
                return null;
            }
            int len = preorder.length;
            //把中序的值存储起来 key为值，value为位置，这样，从托preorder可以直接找到inorder的根节点位置
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                map.put(inorder[i], i);
            }
            return help(map, preorder, 0, len, 0, len);
        }

        private TreeNode help(Map<Integer, Integer> map, int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
            if (preLeft == preRight) {
                return null;
            }
            int rootNum = preorder[preLeft];
            //构建根节点
            TreeNode rootNode = new TreeNode(rootNum);
            //找到根节点在中序中的位置
            int rootPosition = map.get(rootNum);
            int leftCount = rootPosition - inLeft;
            //这里preRight是否+1，会决定上面是否跳出递归
            TreeNode left = help(map, preorder, preLeft + 1, preLeft + 1 + leftCount, inLeft, rootPosition);
            TreeNode right = help(map, preorder, preLeft + 1 + leftCount, preRight, rootPosition + 1, inRight);
            rootNode.left = left;
            rootNode.right = right;
            return rootNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}