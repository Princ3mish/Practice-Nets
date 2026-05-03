class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        HashMap<Character , Integer> targetmap = new HashMap<>();
        for(char c : t.toCharArray()){
            targetmap.put(c,targetmap.getOrDefault(c,0)+1);
        }
        HashMap<Character , Integer> windowmap = new HashMap<>();
        int have = 0;
        int[] res = {-1,-1};
        int reslen = Integer.MAX_VALUE;
        int need = targetmap.size();
        int left = 0;
        for(int right = 0 ; right < s.length(); right++){
            char c = s.charAt(right);
            windowmap.put(c,windowmap.getOrDefault(c,0)+1);
            if(targetmap.containsKey(c) && windowmap.get(c).equals(targetmap.get(c))){
                have++;
            }
            while(have == need){
                if(right - left + 1 < reslen){
                    reslen = right-left + 1 ;
                    res[0] = left;
                    res[1] = right;
                }
                char leftchar = s.charAt(left);
                windowmap.put(leftchar,windowmap.get(leftchar)-1);
                if(targetmap.containsKey(leftchar) && windowmap.get(leftchar) < targetmap.get(leftchar)){
                    have--;
                }
                left++;
            }
        }
        return reslen == Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);
    }
}