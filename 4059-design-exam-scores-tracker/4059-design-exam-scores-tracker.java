import java.util.*;

class ExamTracker {
    private final List<Integer> times;
    private final List<Long> pref;

    public ExamTracker() {
        times = new ArrayList<>();
        pref = new ArrayList<>();
    }
    
    public void record(int time, int score) {
        times.add(time);
        long sum = score + (pref.isEmpty() ? 0L : pref.get(pref.size() - 1));
        pref.add(sum);
    }
    
    public long totalScore(int startTime, int endTime) {
        int l = lowerBound(times, startTime);       
        int r = upperBound(times, endTime) - 1;     
        if (l >= times.size() || l > r) return 0L;
        long res = pref.get(r) - (l == 0 ? 0L : pref.get(l - 1));
        return res;
    }
    
    private int lowerBound(List<Integer> a, int target) {
        int lo = 0, hi = a.size(); 
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a.get(mid) < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
    
    private int upperBound(List<Integer> a, int target) {
        int lo = 0, hi = a.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a.get(mid) <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */
