class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int  n = s.length();
        if(s.charAt(n-1) == '1') return false;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int far = 0;
        while(!queue.isEmpty()){
            int i = queue.poll();
            if(i == n-1)return true;
            int start = Math.max(i+minJump,far+1);
            int end = Math.min(i+maxJump,n-1);
            for(int j = start ; j <= end ;j++){
                if(s.charAt(j) == '0'){
                    queue.offer(j);
                }
            }
            far = Math.max(far,i+maxJump);
        }
        return false;
    }
}