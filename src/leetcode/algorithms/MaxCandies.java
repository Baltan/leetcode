package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1298. Maximum Candies You Can Get from Boxes
 *
 * @author Baltan
 * @date 2019-12-27 10:23
 */
public class MaxCandies {
    public static void main(String[] args) {
        int[] status1 = {1, 0, 1, 0};
        int[] candies1 = {7, 5, 4, 100};
        int[][] keys1 = {{}, {}, {1}, {}};
        int[][] containedBoxes1 = {{1, 2}, {3}, {}, {}};
        int[] initialBoxes1 = {0};
        System.out.println(maxCandies(status1, candies1, keys1, containedBoxes1, initialBoxes1));

        int[] status2 = {1, 0, 0, 0, 0, 0};
        int[] candies2 = {1, 1, 1, 1, 1, 1};
        int[][] keys2 = {{1, 2, 3, 4, 5}, {}, {}, {}, {}, {}};
        int[][] containedBoxes2 = {{1, 2, 3, 4, 5}, {}, {}, {}, {}, {}};
        int[] initialBoxes2 = {0};
        System.out.println(maxCandies(status2, candies2, keys2, containedBoxes2, initialBoxes2));

        int[] status3 = {1, 1, 1};
        int[] candies3 = {100, 1, 100};
        int[][] keys3 = {{}, {0, 2}, {}};
        int[][] containedBoxes3 = {{}, {}, {}};
        int[] initialBoxes3 = {1};
        System.out.println(maxCandies(status3, candies3, keys3, containedBoxes3, initialBoxes3));

        int[] status4 = {1};
        int[] candies4 = {100};
        int[][] keys4 = {{}};
        int[][] containedBoxes4 = {{}};
        int[] initialBoxes4 = {};
        System.out.println(maxCandies(status4, candies4, keys4, containedBoxes4, initialBoxes4));

        int[] status5 = {1, 1, 1};
        int[] candies5 = {2, 3, 2};
        int[][] keys5 = {{}, {}, {}};
        int[][] containedBoxes5 = {{}, {}, {}};
        int[] initialBoxes5 = {2, 1, 0};
        System.out.println(maxCandies(status5, candies5, keys5, containedBoxes5, initialBoxes5));

        int[] status6 =
                {1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0,
                        1, 1, 1, 1, 1, 0, 1, 1, 0, 1,
                        1, 1, 1, 0, 0, 1, 0, 0};
        int[] candies6 =
                {732, 320, 543, 300, 814, 568, 947, 685, 142, 111, 805, 233, 813, 306, 55, 1, 290, 944, 36,
                        592, 150, 596, 372, 299, 644, 445, 605, 202, 64, 807, 753, 731, 552, 766, 119, 862,
                        453, 136, 43, 572, 801, 518, 936, 408, 515, 215, 492, 738, 154};
        int[][] keys6 = {{42, 2, 24, 8, 39, 16, 46}, {20, 39, 46, 21, 32, 31, 43, 16, 12, 23, 3},
                {21, 14, 30, 2, 11, 13, 27, 37, 4, 48}, {16, 17, 15, 6},
                {31, 14, 3, 32, 35, 19, 42, 43, 44, 29, 25, 41},
                {7, 39, 2, 3, 40, 28, 37, 35, 43, 22, 6, 23, 48, 10, 21, 11},
                {27, 1, 37, 3, 45, 32, 30, 26, 16, 2, 35, 19, 31, 47, 5, 14}, {28, 35, 23, 17, 6},
                {6, 39, 34, 22}, {44, 29, 36, 31, 40, 22, 9, 11, 17, 25, 1, 14, 41},
                {39, 37, 11, 36, 17, 42, 13, 12, 7, 9, 43, 41}, {23, 16, 32, 37}, {36, 39, 21, 41},
                {15, 27, 5, 42}, {11, 5, 18, 48, 25, 47, 17, 0, 41, 26, 9, 29},
                {18, 36, 40, 35, 12, 33, 11, 5, 44, 14, 46, 7}, {48, 22, 11, 33, 14},
                {44, 12, 3, 31, 25, 15, 18, 28, 42, 43}, {36, 9, 0, 42},
                {1, 22, 3, 24, 9, 11, 43, 8, 35, 5, 41, 29, 40}, {15, 47, 32, 28, 33, 31, 4, 43},
                {1, 11, 6, 37, 28}, {46, 20, 47, 32, 26, 15, 11, 40},
                {33, 45, 26, 40, 12, 3, 16, 18, 10, 28, 5}, {14, 6, 4, 46, 34, 9, 33, 24, 30, 12, 37},
                {45, 24, 18, 31, 32, 39, 26, 27}, {29, 0, 32, 15, 7, 48, 36, 26, 33, 31, 18, 39, 23, 34, 44},
                {25, 16, 42, 31, 41, 35, 26, 10, 3, 1, 4, 29},
                {8, 11, 5, 40, 9, 18, 10, 16, 26, 30, 19, 2, 14, 4}, {},
                {0, 20, 17, 47, 41, 36, 23, 42, 15, 13, 27}, {7, 15, 44, 38, 41, 42, 26, 19, 5, 47}, {},
                {37, 22}, {21, 24, 15, 48, 33, 6, 39, 11}, {23, 7, 3, 29, 10, 40, 1, 16, 6, 8, 27},
                {27, 29, 25, 26, 46, 15, 16}, {33, 40, 10, 38, 13, 19, 17, 23, 32, 39, 7}, {35, 3, 39, 18},
                {47, 11, 27, 23, 35, 26, 43, 4, 22, 38, 44, 31, 1, 0}, {},
                {18, 43, 46, 9, 15, 3, 42, 31, 13, 4, 12, 39, 22},
                {42, 45, 47, 18, 26, 41, 38, 9, 0, 35, 8, 16, 29, 36, 31},
                {3, 20, 29, 12, 46, 41, 23, 4, 9, 27}, {19, 33}, {32, 18}, {17, 28, 7, 35, 6, 22, 4, 43},
                {41, 31, 20, 28, 35, 32, 24, 23, 0, 33, 18, 39, 29, 30, 16}, {43, 47, 46}};
        int[][] containedBoxes6 =
                {{14}, {}, {26}, {4, 47}, {}, {6}, {39, 43, 46}, {30}, {}, {}, {0, 3}, {}, {}, {}, {}, {27},
                        {}, {}, {}, {}, {12}, {}, {}, {41}, {}, {31}, {20, 29}, {13, 35}, {18}, {10, 40}, {},
                        {38}, {}, {}, {19}, {5}, {}, {}, {11}, {1}, {15}, {}, {}, {}, {24}, {}, {}, {}, {}};
        int[] initialBoxes6 = {2, 7, 8, 9, 16, 17, 21, 22, 23, 25, 28, 32, 33, 34, 36, 37, 42, 44, 45, 48};
        System.out.println(maxCandies(status6, candies6, keys6, containedBoxes6, initialBoxes6));
    }

    public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes,
                                 int[] initialBoxes) {
        int result = 0;
        int length = status.length;
        /**
         * isVisited[i]表示第i个盒子是否被打开过
         */
        boolean[] isVisited = new boolean[length];
        /**
         * availableKeys[i]表示第i个盒子的钥匙是否已经得到
         */
        boolean[] availableKeys = new boolean[length];
        /**
         * availableBoxes[i]表示第i个盒子是否已经得到
         */
        boolean[] availableBoxes = new boolean[length];
        /**
         * 保存已经得到并且可以打开的盒子的编号
         */
        Queue<Integer> queue = new LinkedList<>();

        for (int initialBoxNumber : initialBoxes) {
            /**
             * 对于初始得到的盒子，如果盒子是打开的，则将这个盒子的编号加入queue，并且标记这个盒子已经
             * 打开过；如果这个盒子没打开，则标记这个盒子已经得到
             */
            if (status[initialBoxNumber] == 1) {
                queue.offer(initialBoxNumber);
                isVisited[initialBoxNumber] = true;
            } else {
                availableBoxes[initialBoxNumber] = true;
            }
        }
        /**
         * 逐一处理queue中已经得到并且可以打开的盒子
         */
        while (!queue.isEmpty()) {
            int boxNumber = queue.poll();
            /**
             * 获取当前盒子中的糖果
             */
            result += candies[boxNumber];

            for (int keyNumber : keys[boxNumber]) {
                /**
                 * 标记当前盒子中的钥匙已经得到
                 */
                availableKeys[keyNumber] = true;
                /**
                 * 对于当前盒子中得到的钥匙，如果对应的盒子已经得到并且还没有被打开过，将这个盒子的编号
                 * 加入queue，并且标记这个盒子已经打开过
                 */
                if (!isVisited[keyNumber] && availableBoxes[keyNumber]) {
                    queue.offer(keyNumber);
                    isVisited[keyNumber] = true;
                }
            }

            for (int containedBoxNumber : containedBoxes[boxNumber]) {
                /**
                 * 标记当前盒子中的盒子已经得到
                 */
                availableBoxes[containedBoxNumber] = true;
                /**
                 * 对于当前盒子中得到的盒子，如果对应的钥匙已经得到或者这个盒子本身就是打开的，并且这个
                 * 盒子还没有被打开过，将这个盒子的编号加入queue，并且标记这个盒子已经打开过
                 */
                if (!isVisited[containedBoxNumber] &&
                        (availableKeys[containedBoxNumber] || status[containedBoxNumber] == 1)) {
                    queue.offer(containedBoxNumber);
                    isVisited[containedBoxNumber] = true;
                }
            }
        }
        return result;
    }
}
