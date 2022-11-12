package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1348. Tweet Counts Per Frequency
 *
 * @author Baltan
 * @date 2022/11/5 15:30
 */
public class TweetCounts {
    /**
     * 关键字tweetName -> 带有关键字tweetName的推文发布时间列表
     */
    private Map<String, List<Integer>> map;

    public TweetCounts() {
        map = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        List<Integer> times = map.computeIfAbsent(tweetName, x -> new ArrayList<>());
        times.add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> times = map.get(tweetName);

        if (times == null) {
            return Collections.emptyList();
        }
        Collections.sort(times);
        int interval = getInterval(freq);
        List<Integer> result = new ArrayList<>();

        for (int chunkStart = startTime; chunkStart <= endTime; chunkStart += interval) {
            /**
             * 当前时间块的结束时间，因为时间块不包括chunkEnd这个时刻，所以endTime要加1
             */
            int chunkEnd = Math.min(chunkStart + interval, endTime + 1);
            result.add(getTweetCount(times, chunkStart, chunkEnd));
        }
        return result;
    }

    /**
     * 计算times中在[chunkStart,chunkEnd)范围内的元素的数量
     *
     * @param times
     * @param chunkStart
     * @param chunkEnd
     * @return
     */
    private int getTweetCount(List<Integer> times, int chunkStart, int chunkEnd) {
        int size = times.size();
        /**
         * times中没有元素小于chunkEnd
         */
        if (times.get(0) >= chunkEnd) {
            return 0;
        }
        /**
         * times中没有元素大于等于chunkStart
         */
        if (times.get(size - 1) < chunkStart) {
            return 0;
        }
        /**
         * times中所有元素都在范围[chunkStart,chunkEnd)内
         */
        if (times.get(0) >= chunkStart && times.get(size - 1) < chunkEnd) {
            return size;
        }
        /**
         * times中大于等于chunkStart的第一个元素的索引值
         */
        int startIndex = getStartIndex(times, chunkStart);
        /**
         * times中小于chunkEnd的最后一个元素的索引值
         */
        int endIndex = getEndIndex(times, chunkEnd);
        /**
         * times中范围[times[startIndex],times[endIndex]]内的元素的个数
         */
        return endIndex - startIndex + 1;
    }

    /**
     * 二分计算times中小于chunkEnd的最后一个元素的索引值
     *
     * @param times
     * @param chunkEnd
     * @return
     */
    private int getEndIndex(List<Integer> times, int chunkEnd) {
        int lo = 0;
        int hi = times.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (times.get(mid) >= chunkEnd) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    /**
     * 二分计算times中大于等于chunkStart的第一个元素的索引值
     *
     * @param times
     * @param chunkStart
     * @return
     */
    private int getStartIndex(List<Integer> times, int chunkStart) {
        int lo = 0;
        int hi = times.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (times.get(mid) < chunkStart) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * 计算每个时间块的秒数
     *
     * @param freq
     * @return
     */
    private int getInterval(String freq) {
        switch (freq) {
            case "minute":
                return 60;
            case "hour":
                return 3600;
            default:
                return 86400;
        }
    }

    public static void main(String[] args) {
        TweetCounts tweetCounts1 = new TweetCounts();
        tweetCounts1.recordTweet("tweet3", 0);
        tweetCounts1.recordTweet("tweet3", 60);
        tweetCounts1.recordTweet("tweet3", 10);
        System.out.println(tweetCounts1.getTweetCountsPerFrequency("minute", "tweet3", 0, 59));
        System.out.println(tweetCounts1.getTweetCountsPerFrequency("minute", "tweet3", 0, 60));
        tweetCounts1.recordTweet("tweet3", 120);
        System.out.println(tweetCounts1.getTweetCountsPerFrequency("hour", "tweet3", 0, 210));

        System.out.println("--------------------------------");

        TweetCounts tweetCounts2 = new TweetCounts();
        tweetCounts2.recordTweet("tweet0", 33);
        tweetCounts2.recordTweet("tweet1", 89);
        tweetCounts2.recordTweet("tweet2", 99);
        tweetCounts2.recordTweet("tweet3", 53);
        tweetCounts2.recordTweet("tweet4", 3);
        System.out.println(tweetCounts2.getTweetCountsPerFrequency("hour", "tweet0", 89, 3045));
        tweetCounts2.recordTweet("tweet0", 28);
        tweetCounts2.recordTweet("tweet0", 91);
        tweetCounts2.recordTweet("tweet0", 9);
        tweetCounts2.recordTweet("tweet1", 6);

        System.out.println("--------------------------------");

        TweetCounts tweetCounts3 = new TweetCounts();
        tweetCounts3.recordTweet("tweet0", 19);
        tweetCounts3.recordTweet("tweet1", 34);
        tweetCounts3.recordTweet("tweet2", 36);
        tweetCounts3.recordTweet("tweet3", 59);
        tweetCounts3.recordTweet("tweet4", 64);
        tweetCounts3.recordTweet("tweet2", 48);
        tweetCounts3.recordTweet("tweet4", 21);
        tweetCounts3.recordTweet("tweet2", 44);
        System.out.println(tweetCounts3.getTweetCountsPerFrequency("minute", "tweet1", 59, 9302));
        tweetCounts3.recordTweet("tweet2", 74);
        System.out.println(tweetCounts3.getTweetCountsPerFrequency("minute", "tweet4", 64, 2783));
        tweetCounts3.recordTweet("tweet2", 16);
    }
}
