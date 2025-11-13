class Solution {
    private int postIndex;
    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++)
            indexMap.put(inorder[i], i);
        postIndex = postorder.length - 1;
        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int inLeft, int inRight) {
        if (inLeft > inRight)
            return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int idx = indexMap.get(rootVal);

        root.right = build(postorder, idx + 1, inRight);
        root.left = build(postorder, inLeft, idx - 1);

        return root;
    }
}
