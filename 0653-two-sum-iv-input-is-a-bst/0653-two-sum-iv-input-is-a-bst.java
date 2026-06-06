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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> s = new HashSet<>();
        return walk(root, k, s);
    }
    
    private boolean walk(TreeNode node, int k, HashSet<Integer> s) {
        if (node == null) return false;
        
        int rem = k - node.val;
        if (s.contains(rem)) return true;
        
        s.add(node.val);
        
        return walk(node.left, k, s) || walk(node.right, k, s);
    }
}