package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 3694. Distinct Points Reachable After Substring Removal
 *
 * @author baltan
 * @date 2025/11/12 17:12
 */
public class DistinctPoints {
    public static void main(String[] args) {
        System.out.println(distinctPoints("LUL", 1));
        System.out.println(distinctPoints("UDLR", 4));
        System.out.println(distinctPoints("UU", 1));
    }

    public static int distinctPoints(String s, int k) {
        int result = 1;
        int length = s.length();
        /**
         * 所在位置的坐标
         */
        int[] coordinate = {0, 0};
        /**
         * 保存从原点(0,0)开始按照长度为k的子串移动后的坐标的哈希值
         */
        Set<Long> isVisited = new HashSet<>();

        for (int i = 0; i < k; i++) {
            move(coordinate, s.charAt(i), 1);
        }
        isVisited.add(hash(coordinate, length));

        for (int i = k; i < length; i++) {
            /**
             * 长度为k的子串删除字符s[i-k]，新增字符s[i]
             */
            move(coordinate, s.charAt(i - k), -1);
            move(coordinate, s.charAt(i), 1);
            long hash = hash(coordinate, length);

            if (!isVisited.contains(hash)) {
                result++;
                isVisited.add(hash);
            }
        }
        return result;
    }

    /**
     * 向字符c表示的方向前进distance距离
     *
     * @param coordinate
     * @param c          U-上，D-下，L-左，R-右
     * @param distance   新增字符c时，前进距离为1；删除字符c时，前进距离为-1
     */
    public static void move(int[] coordinate, char c, int distance) {
        switch (c) {
            case 'U':
                coordinate[1] += distance;
                break;
            case 'D':
                coordinate[1] -= distance;
                break;
            case 'L':
                coordinate[0] -= distance;
                break;
            case 'R':
                coordinate[0] += distance;
                break;
        }
    }

    /**
     * 计算坐标coordinate的哈希值
     *
     * @param coordinate
     * @param length
     * @return
     */
    public static long hash(int[] coordinate, int length) {
        /**
         * 因为字符串s的长度为length，所以可以将坐标coordinate的两个数字看做length进制下的两位数
         */
        return (long) coordinate[0] * length + coordinate[1];
    }
}
