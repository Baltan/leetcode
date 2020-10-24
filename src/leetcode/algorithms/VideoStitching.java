package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1024. Video Stitching
 *
 * @author Baltan
 * @date 2019-04-27 19:28
 */
public class VideoStitching {
    public static void main(String[] args) {
        int[][] clips1 = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        System.out.println(videoStitching(clips1, 10));

        int[][] clips2 = {{0, 1}, {1, 2}};
        System.out.println(videoStitching(clips2, 5));

        int[][] clips3 =
                {{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5},
                        {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
        System.out.println(videoStitching(clips3, 9));

        int[][] clips4 = {{0, 4}, {2, 8}};
        System.out.println(videoStitching(clips4, 5));
    }

    public static int videoStitching(int[][] clips, int T) {
        /**
         * 将所有视频片段先按照起始时间升序排列，起始时间相同的情况下再按照结束时间降序排列
         */
        Arrays.sort(clips, (c1, c2) -> {
            if (c1[0] == c2[0]) {
                return c2[1] - c1[1];
            } else {
                return c1[0] - c2[0];
            }
        });
        /**
         * 如果第一个片段的起始时间大于0，则我们无法得到从0时刻开始的完整视频，直接返回false
         */
        if (clips[0][0] > 0) {
            return -1;
        }

        int result = 1;
        /**
         * 当前已拿到的视频片段的最后结束时刻
         */
        int end = clips[0][1];
        int index = 0;
        int length = clips.length;

        while (end < T) {
            /**
             * 这轮筛选可以得到的最大视频结束时刻
             */
            int endTime = -1;
            /**
             * 尽可能地选择能和已有的视频衔接并且结束时间尽可能大的视频片段
             */
            for (int i = index + 1; i < length; i++) {
                if (clips[i][0] <= end && clips[i][1] > endTime) {
                    endTime = clips[i][1];
                    index = i;
                } else if (clips[i][0] > end) {
                    break;
                }
            }
            /**
             * 无法得到满足条件的视频片段，则视频的最后一部分无法拼接上，直接返回false
             */
            if (endTime == -1) {
                return -1;
            }
            /**
             * 更新当前已拿到的视频片段的最后结束时刻
             */
            end = endTime;
            result++;
        }
        return result;
    }
}
