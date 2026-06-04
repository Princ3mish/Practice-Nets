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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;
        if(root.val == key){
            return stitch(root);
        }
        TreeNode curr = root;
        while(true){
            if(curr.val > key){
                if(curr.left != null && curr.left.val == key){
                    curr.left = stitch(curr.left);
                    break;
                }else if(curr.left != null){
                    curr = curr.left;
                }else{
                     break;
                }
            }else{
                if(curr.right != null && curr.right.val == key){
                    curr.right = stitch(curr.right);
                    break;
                }else if(curr.right != null){
                    curr = curr.right;
                }else{
                    break;
                }
            }
        }
        return root;
    }
    public TreeNode stitch(TreeNode target) {
    if (target.left == null) return target.right;
    if (target.right == null) return target.left;
    
    TreeNode leftmost = target.right;
    while (leftmost.left != null) {
        leftmost = leftmost.left;
    }
    leftmost.left = target.left;
    return target.right;
}
}