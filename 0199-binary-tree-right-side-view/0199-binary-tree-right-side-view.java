import java.util.*;

// Definition for a binary tree node.
// public class TreeNode {
//     int val;                    // value of the node
//     TreeNode left;              // left child node
//     TreeNode right;             // right child node
//     TreeNode() {}               // default constructor
//     TreeNode(int val) { this.val = val; }  // constructor with value
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); 
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); 
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                
                if (i == levelSize - 1) {
                    result.add(current.val);
                }
                
                if (current.left != null) {
                    queue.offer(current.left);
                }
                
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return result;
    }
}
