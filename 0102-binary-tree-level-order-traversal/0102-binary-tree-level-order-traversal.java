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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int lvl = queue.size();
            List<Integer> curr = new ArrayList<>();
            for(int i = 0 ; i < lvl ; i++){
                TreeNode currentnode = queue.poll();
                curr.add(currentnode.val);
                if(currentnode.left != null){
                    queue.add(currentnode.left);
                }
                if(currentnode.right != null){
                    queue.add(currentnode.right);
                }
            }
        result.add(curr);
        }
        return result;
    }
}