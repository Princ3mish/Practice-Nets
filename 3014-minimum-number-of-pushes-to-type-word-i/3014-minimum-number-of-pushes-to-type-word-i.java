class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int ans = 0;
        ans += Math.min(n , 8)*1;
        if(n > 8){
            ans += Math.min(n-8 , 8) * 2;
        }
        if(n > 16){
            ans += Math.min(n-16 , 8)*3;
        }
        if(n > 24){
            ans += (n-24)*4;
        }
        return ans;
        
    }
}