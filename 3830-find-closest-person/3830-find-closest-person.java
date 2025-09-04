class Solution {
    public int findClosest(int x, int y, int z) {
        int distx = Math.abs(x - z);
        int disty = Math.abs(y - z);
        if ( distx == disty){
            return 0;
        }
        else if(distx < disty){
            return 1;
        }
        else{
            return 2;
        }
    }
}