import java.math.BigInteger;
import java.util.*;

class Solution {
    public long sumOfLargestPrimes(String s) {
        int n = s.length();
        Set<Long> primes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                long val = Long.parseLong(sub); // ignores leading zeros
                if (val >= 2 && isPrime(val)) primes.add(val);
            }
        }
        if (primes.isEmpty()) return 0L;
        List<Long> list = new ArrayList<>(primes);
        list.sort(Comparator.reverseOrder());
        long sum = 0L;
        for (int i = 0; i < Math.min(3, list.size()); i++) sum += list.get(i);
        return sum;
    }

    private boolean isPrime(long x) {
        return BigInteger.valueOf(x).isProbablePrime(20);
    }
}
