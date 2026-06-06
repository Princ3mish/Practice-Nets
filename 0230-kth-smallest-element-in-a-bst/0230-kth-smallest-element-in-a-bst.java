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
    public int kthSmallest(TreeNode root, int k) {
        int[] scnt = {0};
        TreeNode slest = findkthsmallest(root,k,scnt);
        return slest != null ? slest.val : -1;
    }
    private TreeNode findkthsmallest(TreeNode node , int k , int[] count){
        if(node == null)return null;
        TreeNode left = findkthsmallest(node.left , k , count);
        if(left != null)return left;
        count[0]++;
        if(count[0] == k)return node;
        return findkthsmallest(node.right, k ,count);
    }
}