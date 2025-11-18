class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int floorLog2 = 31 - Integer.numberOfLeadingZeros(n);
        return 1 << (floorLog2 + 1);
    }
}
