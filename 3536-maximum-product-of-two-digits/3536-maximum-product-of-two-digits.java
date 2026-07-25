class Solution {
    public int maxProduct(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        java.util.Arrays.sort(digits);
        int len = digits.length;
        int max1 = digits[len-1]-'0';
        int max2 = digits[len-2]-'0';
        return max1 * max2;
        
        
    }
}