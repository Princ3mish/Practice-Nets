class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] left = new int[26];

        int[] right = new int[26];
        Arrays.fill(left,n);

        for(int i = 0 ; i < n ; i++){
            int idx = s.charAt(i) - 'a';

            left[idx] = Math.min( left[idx] , i);
            right[idx] = i ;

        }
        List<int[]> intervals = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            int idx = s.charAt(i) - 'a';
            if(i!=left[idx])continue;

            int start = i ;
            int end = right[idx];
            boolean valid = true;

            for(int j = start ; j <= end ; j++){
                int charIndex = s.charAt(j) - 'a';

                if(left[charIndex] <  start ){
                    valid = false;
                    break;
                }
                end = Math.max(end, right[charIndex]);
            }
            if(valid){
                intervals.add(new int[]{start , end });
            }
        }
        intervals.sort((a,b) -> a[1] -b[1]);
        List<String> result = new ArrayList<>();
        int prevEnd = -1;

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];

            if(start > prevEnd){
                result.add(s.substring(start,end+1));
                prevEnd = end ;
            }
        }
        return result;
        
    }
}