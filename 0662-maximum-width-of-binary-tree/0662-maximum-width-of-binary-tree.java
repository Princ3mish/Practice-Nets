import java.util.*;

// Definition for a binary tree node.
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0; 

        Queue<NodeIndex> queue = new LinkedList<>();
        queue.offer(new NodeIndex(root, 0)); 

        int maxWidth = 0; 

        while (!queue.isEmpty()) {
            int size = queue.size(); 
            int first = 0, last = 0; 

            for (int i = 0; i < size; i++) {
                NodeIndex ni = queue.poll();
                TreeNode node = ni.node;
                int idx = ni.index;

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                if (node.left != null)
                    queue.offer(new NodeIndex(node.left, 2 * idx));
                if (node.right != null)
                    queue.offer(new NodeIndex(node.right, 2 * idx + 1));
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }

    static class NodeIndex {
        TreeNode node;
        int index;
        NodeIndex(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
