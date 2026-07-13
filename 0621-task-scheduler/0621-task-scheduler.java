class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int maxfreq = freq[25];
        int maxfreqcnt = 0;
        for(int i = 25 ; i >= 0 ; i--){
            if(freq[i] == maxfreq){
                maxfreqcnt++;
            }else{
                break;
            }
        }
        int intervals = (maxfreq - 1) * (n + 1 ) + maxfreqcnt;
        return Math.max(tasks.length , intervals);
    }
}
