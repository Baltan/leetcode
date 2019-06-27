package leetcode.algorithms;

import java.util.*;

/**
 * Description: 355. Design Twitter
 *
 * @author Baltan
 * @date 2019-06-27 09:29
 */
public class Twitter {
    private Deque<int[]> tweetDeque;
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
        tweetDeque.offerFirst(new int[]{userId, tweetId});
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be
     * posted by users who the user followed or by the user herself. Tweets must be ordered from most
     * recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweetList = new LinkedList<>();
        Set<Integer> followSet = followMap.get(userId);
        int tweetNum = 0;

        if (followSet == null) {
            followSet = new HashSet<>();
            followMap.put(userId, followSet);
        }

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
        if (followMap.get(followerId) == null) {
            Set<Integer> followSet = new HashSet<>();
            followSet.add(followeeId);
            followMap.put(followerId, followSet);
        } else {
            followMap.get(followerId).add(followeeId);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followSet = followMap.get(followerId);
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
