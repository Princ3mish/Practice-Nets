import java.util.*;


class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        
        dfs(root, 0, 0, nodes);
        
        Collections.sort(nodes, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);      
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);      
            return Integer.compare(a[2], b[2]);                        
        });
        
        List<List<Integer>> result = new ArrayList<>();
        int lastCol = Integer.MIN_VALUE;
        for (int[] entry : nodes) {
            if (entry[0] != lastCol) {                   
                result.add(new ArrayList<>());
                lastCol = entry[0];
            }
            result.get(result.size() - 1).add(entry[2]); 
        }
        
        return result;
    }
    
    private void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
        if (node == null) return;
        
        nodes.add(new int[] {col, row, node.val});
        
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }
}
