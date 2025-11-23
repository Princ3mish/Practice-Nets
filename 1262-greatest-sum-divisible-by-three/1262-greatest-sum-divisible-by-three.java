class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : nums) {
            int[] temp = dp.clone();

            for (int i = 0; i < 3; i++) {
                if (dp[i] != Integer.MIN_VALUE) {
                    int newSum = dp[i] + num;
                    int remainder = newSum % 3;
                    
                    if (remainder < 0) remainder += 3;
                    temp[remainder] = Math.max(temp[remainder], newSum);
                }
            }

            dp = temp;
        }

        return dp[0];
    }
}
