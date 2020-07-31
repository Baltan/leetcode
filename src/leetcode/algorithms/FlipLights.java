package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 672. Bulb Switcher II
 *
 * @author Baltan
 * @date 2020-02-12 11:45
 * @see BulbSwitch
 * @see BulbSwitch1
 * @see NumTimesAllBlue
 * @see MinFlips1
 */
public class FlipLights {
    public static void main(String[] args) {
        System.out.println(flipLights(1, 1));
        System.out.println(flipLights(2, 1));
        System.out.println(flipLights(3, 1));
        System.out.println(flipLights(1000, 888));
        System.out.println(flipLights(1000, 999));
        System.out.println(flipLights(1000, 1000));
    }

    public static int flipLights(int n, int m) {
        if (m == 0 || n == 0) {
            return 1;
        }

        Set<String> set = new HashSet<>();
        /**
         * 四个按钮分别改变第i、2i、2i+1、3(i-1)+1盏灯的状态，其中i∈N，所以第k盏灯和第k+6盏灯
         * 的状态始终是相同的，所以至多只要考虑前六盏灯的状态即可
         */
        n = Math.min(n, 6);
        /**
         * 考虑四个按钮分别被按下的次数的奇偶性，共有16种可能，只有按下次数为奇数次时会改变灯的
         * 最终状态
         *
         *   奇偶序列        产生这种奇偶序列需要按下按钮的总次数
         *
         * 0-偶偶偶偶                   0、2、4、6……
         * 1-奇偶偶偶                   1、3、5、7……
         * 2-偶奇偶偶                   1、3、5、7……
         * 3-偶偶奇偶                   1、3、5、7……
         * 4-偶偶偶奇                   1、3、5、7……
         * 5-奇奇偶偶                   2、4、6、8……
         * 6-奇偶奇偶                   2、4、6、8……
         * 7-奇偶偶奇                   2、4、6、8……
         * 8-偶奇奇偶                   2、4、6、8……
         * 9-偶奇偶奇                   2、4、6、8……
         * 10-偶偶奇奇                  2、4、6、8……
         * 11-奇奇奇偶                  3、5、7、9……
         * 12-奇奇偶奇                  3、5、7、9……
         * 13-奇偶奇奇                  3、5、7、9……
         * 14-偶奇奇奇                  3、5、7、9……
         * 15-奇奇奇奇                  4、6、8、10……
         */
        char[][] lights = new char[16][n];

        for (int i = 0; i < 16; i++) {
            /**
             * lights[i]表示第i种奇偶序列所有灯的最终状态
             */
            lights[i] = new char[n];
            /**
             * 将所有灯初始化为打开状态，'1'表示打开，'0'表示关闭
             */
            Arrays.fill(lights[i], '1');
        }

        for (int i = 1; i <= n; i++) {
            /**
             * 第1、5、6、7、11、12、13、14种奇偶序列会改变第i盏灯的状态
             */
            lights[1][i - 1] = lights[1][i - 1] == '1' ? '0' : '1';
            lights[5][i - 1] = lights[5][i - 1] == '1' ? '0' : '1';
            lights[6][i - 1] = lights[6][i - 1] == '1' ? '0' : '1';
            lights[7][i - 1] = lights[7][i - 1] == '1' ? '0' : '1';
            lights[11][i - 1] = lights[11][i - 1] == '1' ? '0' : '1';
            lights[12][i - 1] = lights[12][i - 1] == '1' ? '0' : '1';
            lights[13][i - 1] = lights[13][i - 1] == '1' ? '0' : '1';
            lights[15][i - 1] = lights[15][i - 1] == '1' ? '0' : '1';
            /**
             * 第2、5、8、9、11、12、14、15种奇偶序列会改变第i盏灯的状态
             */
            if (i % 2 == 0) {
                lights[2][i - 1] = lights[2][i - 1] == '1' ? '0' : '1';
                lights[5][i - 1] = lights[5][i - 1] == '1' ? '0' : '1';
                lights[8][i - 1] = lights[8][i - 1] == '1' ? '0' : '1';
                lights[9][i - 1] = lights[9][i - 1] == '1' ? '0' : '1';
                lights[11][i - 1] = lights[11][i - 1] == '1' ? '0' : '1';
                lights[12][i - 1] = lights[12][i - 1] == '1' ? '0' : '1';
                lights[14][i - 1] = lights[14][i - 1] == '1' ? '0' : '1';
                lights[15][i - 1] = lights[15][i - 1] == '1' ? '0' : '1';
            }
            /**
             * 第3、6、8、10、11、13、14、15种奇偶序列会改变第i盏灯的状态
             */
            if (i % 2 == 1) {
                lights[3][i - 1] = lights[3][i - 1] == '1' ? '0' : '1';
                lights[6][i - 1] = lights[6][i - 1] == '1' ? '0' : '1';
                lights[8][i - 1] = lights[8][i - 1] == '1' ? '0' : '1';
                lights[10][i - 1] = lights[10][i - 1] == '1' ? '0' : '1';
                lights[11][i - 1] = lights[11][i - 1] == '1' ? '0' : '1';
                lights[13][i - 1] = lights[13][i - 1] == '1' ? '0' : '1';
                lights[14][i - 1] = lights[14][i - 1] == '1' ? '0' : '1';
                lights[15][i - 1] = lights[15][i - 1] == '1' ? '0' : '1';
            }
            /**
             * 第4、7、9、10、12、13、14、15种奇偶序列会改变第i盏灯的状态
             */
            if ((i - 1) % 3 == 0) {
                lights[4][i - 1] = lights[4][i - 1] == '1' ? '0' : '1';
                lights[7][i - 1] = lights[7][i - 1] == '1' ? '0' : '1';
                lights[9][i - 1] = lights[9][i - 1] == '1' ? '0' : '1';
                lights[10][i - 1] = lights[10][i - 1] == '1' ? '0' : '1';
                lights[12][i - 1] = lights[12][i - 1] == '1' ? '0' : '1';
                lights[13][i - 1] = lights[13][i - 1] == '1' ? '0' : '1';
                lights[14][i - 1] = lights[14][i - 1] == '1' ? '0' : '1';
                lights[15][i - 1] = lights[15][i - 1] == '1' ? '0' : '1';
            }
        }
        /**
         * 如果总共按下按钮1次，可能产生第1、2、3、4种奇偶序列；
         * 如果总共按下按钮2次，可能产生第0、5、6、7、8、9、10种奇偶序列；
         * 如果总共按下按钮2k+1次，其中k∈N+，可能产生第1、2、3、4、11、12、13、14种奇偶序列
         * 如果总共按下按钮2k+2次，其中k∈N+，可能产生第0、5、6、7、8、9、10、15种奇偶序列
         *
         * 计算各种序列下的灯的最终状态种数
         */
        if (m == 1) {
            set.add(new String(lights[1]));
            set.add(new String(lights[2]));
            set.add(new String(lights[3]));
            set.add(new String(lights[4]));
        } else if (m == 2) {
            set.add(new String(lights[0]));
            set.add(new String(lights[5]));
            set.add(new String(lights[6]));
            set.add(new String(lights[7]));
            set.add(new String(lights[8]));
            set.add(new String(lights[9]));
            set.add(new String(lights[10]));
        } else if (m % 2 == 1) {
            set.add(new String(lights[1]));
            set.add(new String(lights[2]));
            set.add(new String(lights[3]));
            set.add(new String(lights[4]));
            set.add(new String(lights[11]));
            set.add(new String(lights[12]));
            set.add(new String(lights[13]));
            set.add(new String(lights[14]));
        } else {
            set.add(new String(lights[0]));
            set.add(new String(lights[5]));
            set.add(new String(lights[6]));
            set.add(new String(lights[7]));
            set.add(new String(lights[8]));
            set.add(new String(lights[9]));
            set.add(new String(lights[10]));
            set.add(new String(lights[15]));
        }
        return set.size();
    }
}
