class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sum = 0 ;
        int q = 0;
        for(int i = 0 ; i < n / 2 ; i++){
            char c = num.charAt(i);
            if(c == '?'){
                q++;
            }else{
                sum += c - '0';
            }
        }
        for(int i = n / 2 ; i < n ; i++){
            char c = num.charAt(i);
            if(c == '?'){
                q--;
            }else{
                sum -= c - '0';
            }
        }
        return (sum * 2 + q * 9)!= 0;
    }
}