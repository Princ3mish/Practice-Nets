class Solution {
    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);       
        ans.add(node.val);    
        dfs(node.right);      
    }
}
