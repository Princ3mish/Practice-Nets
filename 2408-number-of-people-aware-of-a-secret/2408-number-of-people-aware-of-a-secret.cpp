class Solution {
public:
    int peopleAwareOfSecret(int n, int delay, int forget) {
        const int MOD = 1e9 + 7;
        std::vector<long long> dp(n + 2, 0); // dp[i]: people who learn secret on day i
        dp[1] = 1;

        long long share = 0;
        for (int i = 2; i <= n; ++i) {
            // Only add sharers if i - delay >= 1 (valid day)
            if (i - delay >= 1)
                share = (share + dp[i - delay]) % MOD;
            // Only subtract forgetters if i - forget >= 1 (valid day)
            if (i - forget >= 1)
                share = (share - dp[i - forget] + MOD) % MOD;
            dp[i] = share;
        }

        long long result = 0;
        // Sum people who learned within last 'forget' days and still remember on day n
        for (int i = n - forget + 1; i <= n; ++i) {
            if (i >= 1) // Only sum for valid days
                result = (result + dp[i]) % MOD;
        }
        return static_cast<int>(result);
    }
};
