class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();
        for (int num : arr1) {
            while (num > 0) {
                prefixes.add(num);
                num /= 10; 
            }
        }
        
        int maxLength = 0;
        
        for (int num : arr2) {
            while (num > 0) {
                if (prefixes.contains(num)) {
                    int currentLength = String.valueOf(num).length();
                    maxLength = Math.max(maxLength, currentLength);
                    break; 
                }
                num /= 10;
            }
        }
        
        return maxLength;
    }
}