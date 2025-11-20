class Solution {
    public String concatHex36(int n) {
        long a = 1L * n * n;       
        long b = 1L * n * n * n;   
        
        return toBase(a, 16) + toBase(b, 36);
    }
    
    private String toBase(long x, int base) {
        if (x == 0) return "0";
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            sb.append(chars.charAt((int)(x % base)));
            x /= base;
        }
        return sb.reverse().toString();
    }
}
