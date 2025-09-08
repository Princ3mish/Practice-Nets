class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = 1;
        
        while (containsZero(a) || containsZero(n - a)) {
            a++;
        }
        return new int[] {a, n - a};
    }
    
    
    private boolean containsZero(int x) {
        return String.valueOf(x).contains("0");
    }
}
