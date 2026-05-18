class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxarea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i <= n ; i++){
            int currheight = (i == n ) ? 0 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] > currheight){
                int height =  heights[stack.pop()];
                int width = stack.isEmpty() ? i : (i-stack.peek()-1);
                maxarea = Math.max(maxarea,height*width);
            } 
            stack.push(i);
        }
        return maxarea;
        
    }
}