class Solution {
        Integer[][][] dp;
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        dp = new Integer[m][n][3];
        return solve(0,0,0,coins);
        
    }
    int solve( int i , int j , int k , int[][] coins){
        int m = coins.length;
        int n = coins[0].length;

        if(i>=m || j>=n){
            return Integer.MIN_VALUE;
        }
        if( i == m-1 && j == n-1){
            if(coins[i][j] < 0 && k < 2){
                return 0;
            }
            return coins[i][j];
        }
        if(dp[i][j][k] != null ){
            return dp[i][j][k];
        }
        int value = coins[i][j];
        int right = solve(i ,  j+1 , k , coins);
        int down = solve( i+1 , j , k , coins);
        int best = Math.max(right,down);
        int result;

        if ( value >= 0){
            result = best+value;

        }
        else{
            int takeLoss =  value + best;
            int neutralize =  Integer.MIN_VALUE;

            if( k < 2 ){
                int rightN = solve ( i , j+1 , k+1 , coins);
                int downN = solve( i+1 , j , k+1 , coins);
                neutralize = Math.max(rightN , downN);

            }
            result = Math.max(takeLoss , neutralize);
        }
        return dp[i][j][k] = result;
    }
}