/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Solution {

    private void swap(TreeNode curr) {
        if (curr == null) return;

        
        swap(curr.left);
        swap(curr.right);

        TreeNode temp = curr.left;
        curr.left = curr.right;
        curr.right = temp;
    }

    public TreeNode invertTree(TreeNode root) {
        swap(root);
        return root;
    }
}
