package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: Video Stitching
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
        Arrays.sort(clips, (c1, c2) -> {
            if (c1[0] == c2[0]) {
                return c2[1] - c1[1];
            } else {
                return c1[0] - c2[0];
            }
        });

        if (clips[0][0] > 0) {
            return -1;
        }

        int result = 1;
        int end = clips[0][1];
        int index = 0;
        int length = clips.length;

        while (end < T) {
            int endTime = -1;
            for (int i = index + 1; i < length; i++) {
                if (clips[i][0] <= end && clips[i][1] > endTime) {
                    endTime = clips[i][1];
                    index = i;
                } else if (clips[i][0] > end) {
                    break;
                }
            }
            if (endTime == -1) {
                return -1;
            }
            end = endTime;
            result++;
        }
        return result;
    }
}
