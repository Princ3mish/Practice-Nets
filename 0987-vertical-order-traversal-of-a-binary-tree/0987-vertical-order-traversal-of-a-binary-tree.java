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
    class Tuple {
        TreeNode node;
        int row;
        int col;
        
        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        queue.add(new Tuple(root, 0, 0));
        
        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;
            
            if (!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }
            if (!map.get(col).containsKey(row)) {
                map.get(col).put(row, new PriorityQueue<>());
            }
            map.get(col).get(row).add(node.val);
            
            if (node.left != null) {
                queue.add(new Tuple(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.add(new Tuple(node.right, row + 1, col + 1));
            }
        }
        
        for (TreeMap<Integer, PriorityQueue<Integer>> columns : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> nodesInRow : columns.values()) {
                while (!nodesInRow.isEmpty()) {
                    colList.add(nodesInRow.poll());
                }
            }
            result.add(colList);
        }
        
        return result;
    }
}