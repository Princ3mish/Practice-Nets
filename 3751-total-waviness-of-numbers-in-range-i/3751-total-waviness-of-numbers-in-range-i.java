class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0 ;
        int x = num1;

        do{
            total += waviness(x);
            x++;
            
        }while(x <= num2);
        return total;
    }
    private int waviness(int n ){
        if(n < 100) return 0 ;

        int temp = n ;
        int[] digits = new int[6];
        int len = 0;

        for(;temp > 0 ; temp/=10){
            digits[len++] = temp % 10;
        }
        int wavy = 0 ;
        for( int i = 1 ; i < len - 1 ; i++ ){
            int prev = digits[i - 1];
            int curr = digits[i];
            int next = digits[i+1];

            if((curr > prev && curr > next) || (curr < prev && curr < next)){
                wavy++;
            }
            
        }
        return wavy;
    }
}