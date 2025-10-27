class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        String prev = countAndSay(n - 1);
        
        StringBuilder result = new StringBuilder();
        
        int i = 0;
        while (i < prev.length()) {
            char currentDigit = prev.charAt(i);
            int count = 0;
            
            while (i < prev.length() && prev.charAt(i) == currentDigit) {
                count++;   
                i++;       
            }
            
            result.append(count);         
            result.append(currentDigit);  
        }
        
        return result.toString();
    }
}
