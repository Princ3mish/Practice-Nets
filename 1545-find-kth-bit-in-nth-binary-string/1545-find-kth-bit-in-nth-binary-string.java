class Solution {
    public char findKthBit(int n, int k) {
        if( n==1 ) return '0';
        
        int mid = 1 << (n-1); //left shift operator 

        if(k == mid){
            return '1';
        }else if ( k < mid ){
            return findKthBit(n-1,k);
        }else{
            int mirroredK = 2*mid-k;

            char leftBit = findKthBit(n-1,mirroredK);

            return leftBit == '0' ? '1' : '0';
        }
    }
}