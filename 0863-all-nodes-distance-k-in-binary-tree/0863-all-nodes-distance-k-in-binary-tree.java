/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void populateparentmap(TreeNode root , Map<TreeNode , TreeNode>parentmap){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if(root == null || target == null)return result;
        Map<TreeNode , TreeNode> parentmap = new HashMap<>();
        populateparentmap(root,parentmap);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int currentdistance = 0;
        while(!queue.isEmpty()){
            if(currentdistance == k){
                break;
            }
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode current = queue.poll();
                if(current.left != null && !visited.contains(current.left)){
                    visited.add(current.left);
                    queue.offer(current.left);
                }
                if(current.right != null && !visited.contains(current.right)){
                    visited.add(current.right);
                    queue.offer(current.right);
                }
                TreeNode parent = parentmap.get(current);
                if(parent != null && !visited.contains(parent)){
                    visited.add(parent);
                    queue.offer(parent);
                }
            }
            currentdistance++;
        }
        while(!queue.isEmpty()){
            result.add(queue.poll().val);
        }
        return result;

    }
}