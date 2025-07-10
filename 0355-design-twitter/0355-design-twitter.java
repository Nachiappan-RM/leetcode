
class Twitter {
    //followerMap: userId -> Set of users who follow this user
    private final Map<Integer, Set<Integer>> followerMap;
    //followingMap: userId -> Set of users this user follows
    private final Map<Integer, Set<Integer>> followingMap;

    //tweetMap: userId -> List of tweet IDs posted by this user (most recent first)
    private final Map<Integer, List<TweetInfo>> tweetMap;

    //Global tweet counter to assign unique IDs and maintain order
    private int globalTweetId;
    public Twitter() {
        this.followerMap = new HashMap<>();
        this.followingMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
        this.globalTweetId = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k-> new ArrayList<>()).add(0, new TweetInfo(tweetId, ++globalTweetId));
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<TweetInfo> maxHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.timestamp, a.timestamp)
        );

        //Add user's own tweets
        List<TweetInfo> userTweets = tweetMap.getOrDefault(userId, new ArrayList<>());
        for(int i = 0; i < userTweets.size() && i < 10; i++) {
            maxHeap.offer(userTweets.get(i));
        }
        //Add tweets from followed user
        Set<Integer> following = followingMap.getOrDefault(userId, new HashSet<>());
        for(int followeeId : following) {
            List<TweetInfo> followeeTweets = tweetMap.getOrDefault(followeeId, new ArrayList<>());
            for(int i=0; i< followeeTweets.size() && i<10; i++) {
                maxHeap.offer(followeeTweets.get(i));
            }
        }

        //Extract top 10 tweets
        List<Integer> result = new ArrayList<>();
        while(!maxHeap.isEmpty() && result.size() < 10) {
            result.add(maxHeap.poll().tweetId);
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return; //Users cannot follow themselves

        followerMap.computeIfAbsent(followeeId, k -> new HashSet<>()).add(followerId);
        followingMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followers = followerMap.get(followeeId);
        if(followers != null) {
            followers.remove(followerId);
        }

        Set<Integer> following = followingMap.get(followerId);
        if(following != null) {
            following.remove(followeeId);
        }
    }

    private static class TweetInfo {
        final int tweetId;
        final int timestamp;

        TweetInfo(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
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