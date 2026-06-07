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
    public TreeNode createBinaryTree(int[][] desc) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] d : desc) {
            int p = d[0];
            int c = d[1];
            boolean isLeft = d[2] == 1;
            map.putIfAbsent(p, new TreeNode(p));
            map.putIfAbsent(c, new TreeNode(c));
            if (isLeft) {
                map.get(p).left = map.get(c);
            } else {
                map.get(p).right = map.get(c);
            }
            children.add(c);
        }
        for (int[] d : desc) {
            if (!children.contains(d[0])) {
                return map.get(d[0]);
            }
        }
        return null;
    }
}