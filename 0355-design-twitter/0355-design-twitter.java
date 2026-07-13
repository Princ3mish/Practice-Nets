class Twitter {
    private static class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private int timestamp;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        this.timestamp = 0;
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        
        Set<Integer> userIds = new HashSet<>();
        userIds.add(userId);
        if (followMap.containsKey(userId)) {
            userIds.addAll(followMap.get(userId));
        }
        
        for (int id : userIds) {
            List<Tweet> tweets = tweetMap.get(id);
            if (tweets != null && !tweets.isEmpty()) {
                int lastIdx = tweets.size() - 1;
                Tweet t = tweets.get(lastIdx);
                maxHeap.offer(new int[]{t.time, t.id, id, lastIdx - 1});
            }
        }
        
        while (!maxHeap.isEmpty() && res.size() < 10) {
            int[] top = maxHeap.poll();
            res.add(top[1]);
            
            int nextIdx = top[3];
            int authorId = top[2];
            
            if (nextIdx >= 0) {
                Tweet nextTweet = tweetMap.get(authorId).get(nextIdx);
                maxHeap.offer(new int[]{nextTweet.time, nextTweet.id, authorId, nextIdx - 1});
            }
        }
        
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */