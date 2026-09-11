import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;

        for (int num = 100; num <= 999; num += 2) {
            int d1 = num / 100;       
            int d2 = (num / 10) % 10; 
            int d3 = num % 10;        
            int[] currentFreq = new int[10];
            currentFreq[d1]++;
            currentFreq[d2]++;
            currentFreq[d3]++;

            boolean possible = true;
            for (int i = 0; i < 10; i++) {
                if (currentFreq[i] > freq[i]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;
    }
}