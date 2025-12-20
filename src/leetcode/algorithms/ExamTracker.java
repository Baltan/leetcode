package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 3709. Design Exam Scores Tracker
 *
 * @author baltan
 * @date 2025/11/18 10:59
 */
public class ExamTracker {
    /**
     * 依次保存各次考试的时间
     */
    private List<Integer> timeList;
    /**
     * 保存歌词考试得分的前缀和
     */
    private List<Long> scorePrefixSums;

    public ExamTracker() {
        timeList = new ArrayList<>();
        scorePrefixSums = new ArrayList<>();
        scorePrefixSums.add(0L);
    }

    public void record(int time, int score) {
        /**
         * 此前已进行过timeList.size()次考试，总分为scorePrefixSums.get(timeList.size())
         */
        scorePrefixSums.add(scorePrefixSums.get(timeList.size()) + score);
        timeList.add(time);
    }

    public long totalScore(int startTime, int endTime) {
        int left = getLeft(startTime);
        int right = getRight(endTime);
        return left == -1 || right == -1 ? 0 : scorePrefixSums.get(right + 1) - scorePrefixSums.get(left);
    }

    /**
     * 二分查找不早于startTime的最早一次考试时间在timeList中的索引位置
     *
     * @param startTime
     * @return
     */
    private int getLeft(int startTime) {
        /**
         * 所有考试时间都早于startTime
         */
        if (timeList.getLast() < startTime) {
            return -1;
        }
        int lo = 0;
        int hi = timeList.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (timeList.get(mid) < startTime) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * 二分查找不晚于endTime的最后一次考试时间在timeList中的索引位置
     *
     * @param endTime
     * @return
     */
    private int getRight(int endTime) {
        /**
         * 所有考试时间都晚于endTime
         */
        if (timeList.getFirst() > endTime) {
            return -1;
        }
        int lo = 0;
        int hi = timeList.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (timeList.get(mid) > endTime) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        ExamTracker examTracker1 = new ExamTracker();
        examTracker1.record(1, 98);
        System.out.println(examTracker1.totalScore(1, 1));
        examTracker1.record(5, 99);
        System.out.println(examTracker1.totalScore(1, 3));
        System.out.println(examTracker1.totalScore(1, 5));
        System.out.println(examTracker1.totalScore(3, 4));
        System.out.println(examTracker1.totalScore(2, 5));

        System.out.println("-----------------------------------------");

        ExamTracker examTracker2 = new ExamTracker();
        examTracker2.record(2, 2);
        System.out.println(examTracker2.totalScore(1, 1));
        System.out.println(examTracker2.totalScore(1, 2));
        System.out.println(examTracker2.totalScore(2, 2));
    }
}
