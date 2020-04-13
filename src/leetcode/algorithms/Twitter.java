package leetcode.algorithms;

import java.util.*;

/**
 * Description: 355. Design Twitter
 *
 * @author Baltan
 * @date 2019-06-27 09:29
 */
public class Twitter {
    /**
     * 将最新发布的tweet加入到队首，队列中每个元素为[该条tweet的发布者的id，tweet id]
     */
    private Deque<int[]> tweetDeque;
    /**
     * 用户id -> 该用户关注的所有用户的集合
     */
    private Map<Integer, Set<Integer>> followMap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        tweetDeque = new ArrayDeque<>();
        followMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        /**
         * 将最新发布的tweet加入到队首
         */
        tweetDeque.offerFirst(new int[]{userId, tweetId});
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be
     * posted by users who the user followed or by the user herself. Tweets must be ordered from most
     * recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweetList = new LinkedList<>();
        followMap.putIfAbsent(userId, new HashSet<>());
        Set<Integer> followSet = followMap.get(userId);
        int tweetNum = 0;
        /**
         * 从队首开始遍历，取出前十条userId用户自己或其关注者发布的tweet
         */
        for (int[] arr : tweetDeque) {
            if (arr[0] == userId || followSet.contains(arr[0])) {
                tweetList.add(arr[1]);
                tweetNum++;
            }

            if (tweetNum == 10) {
                break;
            }
        }
        return tweetList;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        /**
         * 在关注者集合中加入followeeId用户
         */
        followMap.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followSet = followMap.get(followerId);
        /**
         * 从关注者集合followSet中移除followeeId用户
         */
        if (followSet != null && followSet.contains(followeeId)) {
            followSet.remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter1 = new Twitter();
        twitter1.postTweet(1, 5);
        System.out.println(twitter1.getNewsFeed(1));
        twitter1.follow(1, 2);
        twitter1.postTweet(2, 6);
        System.out.println(twitter1.getNewsFeed(1));
        twitter1.unfollow(1, 2);
        System.out.println(twitter1.getNewsFeed(1));
    }
}
