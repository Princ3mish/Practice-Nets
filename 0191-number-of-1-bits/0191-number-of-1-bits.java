class Solution {
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        char[] count = str.toCharArray();
        int cnt = 0;
        for(int i = 0 ; i < count.length ; i++){
            if(count[i] == '1'){
                cnt++;
            }
        }
        return cnt;
    }
}