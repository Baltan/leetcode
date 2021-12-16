package leetcode.algorithms;

/**
 * Description: 2103. Rings and Rods
 *
 * @author Baltan
 * @date 2021/12/16 09:11
 */
public class CountPoints {
    public static void main(String[] args) {
        System.out.println(countPoints("B0B6G0R6R0R6G9"));
        System.out.println(countPoints("B0R0G0R9R0B0G0"));
        System.out.println(countPoints("G4"));
    }

    public static int countPoints(String rings) {
        int result = 0;
        /**
         * rods[i]表示第i（0-based）根柱子上环的情况，其中rods[i]二进制表示从右往左数如果为1，依次表示有
         * "B"、"G"、"R"颜色的环，为0则没有
         */
        int[] rods = new int[10];
        int length = rings.length();

        for (int i = 0; i < length; i += 2) {
            char color = rings.charAt(i);
            int index = rings.charAt(i + 1) - '0';

            if (color == 'R') {
                rods[index] |= 0B100;
            } else if (color == 'G') {
                rods[index] |= 0B10;
            } else if (color == 'B') {
                rods[index] |= 0B1;
            }
        }

        for (int rod : rods) {
            if (rod == 0b111) {
                result++;
            }
        }
        return result;
    }
}
