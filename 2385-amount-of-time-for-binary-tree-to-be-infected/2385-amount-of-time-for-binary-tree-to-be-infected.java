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
    private TreeNode targetnode = null;
    private void mapparent(TreeNode root , int start , Map<TreeNode,TreeNode>parentmap){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.val == start){
                targetnode = current;
            }
            if(current.left != null){
                parentmap.put(current.left , current);
                queue.offer(current.left);
            }
            if(current.right != null){
                parentmap.put(current.right , current);
                queue.offer(current.right);
            }
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        if(root == null)return 0;
        Map<TreeNode,TreeNode> parentmap = new HashMap<>();
        mapparent(root,start,parentmap);
        if(targetnode == null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(targetnode);
        visited.add(targetnode);
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean fire = false;
            for(int i = 0 ; i < size ; i++){
                TreeNode current = queue.poll();
                if(current.left != null && !visited.contains(current.left)){
                    visited.add(current.left);
                    queue.offer(current.left);
                    fire = true;

                }
                if(current.right != null && !visited.contains(current.right)){
                    visited.add(current.right);
                    queue.offer(current.right);
                    fire = true;

                }
                TreeNode parent = parentmap.get(current);
                if(parent != null && !visited.contains(parent)){
                    visited.add(parent);
                    queue.offer(parent);
                    fire = true;
                }
            }
            if(fire){
                time++;
            }
        }
        return time;
    }
        
}