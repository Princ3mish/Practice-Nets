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
    private int MaxSum =  Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return MaxSum;
        
    }
    private int dfs(TreeNode node){
        if (node == null) return 0;

        int leftGain=Math.max(0,dfs(node.left));
        int RightGain=Math.max(0,dfs(node.right));

        int priceNewpath = node.val + leftGain + RightGain;

        MaxSum = Math.max( MaxSum , priceNewpath);

        return node.val +  Math.max(leftGain,RightGain);
    }
}