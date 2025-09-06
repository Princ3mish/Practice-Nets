class Solution {
    public long minOperations(int[][] queries) {
        long total = 0 ;

        for( int query[] : queries){
            int l = query[0];
            int r = query[1];

            long steps = countSteps(r) - countSteps(l-1);

            total += (steps + 1) / 2;

        }
        return total;
    }

    private long countSteps( int n ){
        long sum = 0 ;
        int layers = 0 ;

        for ( int x = 1 ; x <= n ;  x *= 4){
            int left = x ;
            int right = Math.min( n , x*4 - 1);
            layers++;

            sum+= ( long)(right - left + 1) * layers;
        }
        return sum;
    }
}