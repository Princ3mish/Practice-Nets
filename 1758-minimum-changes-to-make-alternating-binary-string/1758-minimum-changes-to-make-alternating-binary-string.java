class Solution {
    public int minOperations(String s) {
        int count = 0 ;
        
        for(int i = 0 ; i < s.length();i++){
            char expected = (char) ('0' + i % 2);

            if(s.charAt(i) != expected){
                count++;
            }
        }
        return Math.min(count , s.length()-count);
    }
}