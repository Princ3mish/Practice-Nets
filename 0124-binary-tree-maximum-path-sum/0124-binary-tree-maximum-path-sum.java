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
    private int maxs;
    public int maxPathSum(TreeNode root) {
        maxs = Integer.MIN_VALUE;
        cg(root);
        return maxs;
    }
    private int cg(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Math.max(0,cg(node.left));
        int right = Math.max(0,cg(node.right));
        int cps = node.val + left + right;
        maxs = Math.max(maxs,cps);
        return node.val + Math.max(left , right);

    }
}