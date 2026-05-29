class Solution {
    public int minElement(int[] nums) {
        int minres = Integer.MAX_VALUE;
        for (int num : nums) {
            int res = 0;
            char[] digits = String.valueOf(num).toCharArray();
            for (char d : digits) {
                res += Character.getNumericValue(d); 
            }
            if (res < minres) {
                minres = res;
            }
        }
        
        return minres;
    }
}