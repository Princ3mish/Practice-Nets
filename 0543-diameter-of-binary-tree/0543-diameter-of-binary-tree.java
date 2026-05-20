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
    private int maxd = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxd = 0;
        calcheight(root);
        return maxd;
    }
    private int calcheight(TreeNode node ){
        if(node == null){
            return 0;
        }
        int left = calcheight(node.left);
        int right = calcheight(node.right);
        int currentd = left + right;
        maxd = Math.max(maxd , currentd);
        return 1 + Math.max(left , right);
    }
}