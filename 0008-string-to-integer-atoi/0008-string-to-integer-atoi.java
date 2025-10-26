class Solution {
    public int myAtoi(String s) {
        
        if (s == null || s.isEmpty()) return 0;

        int i = 0, n = s.length();
        long result = 0; 
        int sign = 1;    

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';  // convert char '5' → int 5

            if (result > (Integer.MAX_VALUE - digit) / 10) {
                
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit; 
            i++;
        }

        
        return (int) (sign * result);
    }
}
