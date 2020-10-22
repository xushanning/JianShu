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
// 👍 723 👎 0


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
            int len1 = preorder.length;
            int len2 = inorder.length;
            if (len2 == 0 || len1 != len2) {
                return null;
            }

// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len2; i++) {
                map.put(inorder[i], i);
            }
            return getTree(preorder, inorder, map, 0, 0, len1 - 1, len1 - 1);
        }

        private TreeNode getTree(int[] preorder, int[] inorder, Map<Integer, Integer> map, int preLeft, int inLeft, int preRight, int inRight) {
            if (preLeft > preRight) {
                return null;
            }
            //前序第一个节点，肯定是根节点
            int preRoot = preorder[preLeft];
            //根节点在中序遍历中的位置
            int inRootIndex = map.get(preRoot);

            TreeNode root = new TreeNode(preRoot);
            //左字数个数
            int leftCount = inRootIndex - inLeft;
            root.left = getTree(preorder, inorder, map, preLeft + 1, inLeft, preLeft + leftCount, inRootIndex - 1);
            root.right = getTree(preorder, inorder, map, preLeft + leftCount + 1, preRight, inRootIndex + 1, inRight);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}