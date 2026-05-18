class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? (i+1) : (i - stack.peek());
            stack.push(i);
        }
        stack.clear();
        for(int i = n-1 ; i>=0 ; i--){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? (n-i) : (stack.peek() - i);
            stack.push(i);
        }
        long totalsum = 0;
        long mod = 1000000007;
        for(int i = 0 ; i < n ; i++){
            long count = ((long)left[i]*right[i])%mod;
            long contribution = ((count)*arr[i])%mod;
            totalsum = (totalsum + contribution)%mod;
        }
        return (int) totalsum;
    }
}