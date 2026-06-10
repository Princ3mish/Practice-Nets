class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }
        int rows = image.length;
        int cols = image[0].length;
        int initialcolor = image[sr][sc];
        dfs(image , sr , sc , rows , cols , initialcolor , color);
        return image;
    }
    private void dfs(int[][] image , int r , int c , int rows , int cols , int initialcolor , int color){
        if(r < 0 || r >= rows || c < 0 || c >= cols || image[r][c] != initialcolor){
            return;
        }
        image[r][c] = color;
        dfs(image , r+1 , c , rows , cols , initialcolor , color);
        dfs(image , r-1 , c , rows , cols , initialcolor , color);
        dfs(image , r , c+1 , rows , cols , initialcolor , color);
        dfs(image , r , c-1 , rows , cols , initialcolor , color);
    }
}