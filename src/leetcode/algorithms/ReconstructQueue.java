package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 406. Queue Reconstruction by Height
 *
 * @author Baltan
 * @date 2019-05-07 09:56
 */
public class ReconstructQueue {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        OutputUtils.print2DIntegerArray(reconstructQueue(people));
    }

    public static int[][] reconstructQueue(int[][] people) {
        /**
         * 将所有人按照身高递减排序，如果身高相等，按照前面身高大于或等于该身高的人数递增排序
         */
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int length = people.length;
        List<int[]> list = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[length][2]);
    }
}
