package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 886. Possible Bipartition
 *
 * @author Baltan
 * @date 2020-02-23 12:12
 */
public class PossibleBipartition {
    public static void main(String[] args) {
        int[][] dislikes1 = {{1, 2}, {1, 3}, {2, 4}};
        System.out.println(possibleBipartition(4, dislikes1));

        int[][] dislikes2 = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(possibleBipartition(3, dislikes2));

        int[][] dislikes3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        System.out.println(possibleBipartition(5, dislikes3));

        int[][] dislikes4 =
                {{21, 47}, {4, 41}, {2, 41}, {36, 42}, {32, 45}, {26, 28}, {32, 44}, {5, 41}, {29, 44},
                        {10, 46}, {1, 6}, {7, 42}, {46, 49}, {17, 46}, {32, 35}, {11, 48}, {37, 48}, {37, 43},
                        {8, 41}, {16, 22}, {41, 43}, {11, 27}, {22, 44}, {22, 28}, {18, 37}, {5, 11},
                        {18, 46}, {22, 48}, {1, 17}, {2, 32}, {21, 37}, {7, 22}, {23, 41}, {30, 39}, {6, 41},
                        {10, 22}, {36, 41}, {22, 25}, {1, 12}, {2, 11}, {45, 46}, {2, 22}, {1, 38}, {47, 50},
                        {11, 15}, {2, 37}, {1, 43}, {30, 45}, {4, 32}, {28, 37}, {1, 21}, {23, 37}, {5, 37},
                        {29, 40}, {6, 42}, {3, 11}, {40, 42}, {26, 49}, {41, 50}, {13, 41}, {20, 47},
                        {15, 26}, {47, 49}, {5, 30}, {4, 42}, {10, 30}, {6, 29}, {20, 42}, {4, 37}, {28, 42},
                        {1, 16}, {8, 32}, {16, 29}, {31, 47}, {15, 47}, {1, 5}, {7, 37}, {14, 47}, {30, 48},
                        {1, 10}, {26, 43}, {15, 46}, {42, 45}, {18, 42}, {25, 42}, {38, 41}, {32, 39},
                        {6, 30}, {29, 33}, {34, 37}, {26, 38}, {3, 22}, {18, 47}, {42, 48}, {22, 49},
                        {26, 34}, {22, 36}, {29, 36}, {11, 25}, {41, 44}, {6, 46}, {13, 22}, {11, 16},
                        {10, 37}, {42, 43}, {12, 32}, {1, 48}, {26, 40}, {22, 50}, {17, 26}, {4, 22},
                        {11, 14}, {26, 39}, {7, 11}, {23, 26}, {1, 20}, {32, 33}, {30, 33}, {1, 25}, {2, 30},
                        {2, 46}, {26, 45}, {47, 48}, {5, 29}, {3, 37}, {22, 34}, {20, 22}, {9, 47}, {1, 4},
                        {36, 46}, {30, 49}, {1, 9}, {3, 26}, {25, 41}, {14, 29}, {1, 35}, {23, 42}, {21, 32},
                        {24, 46}, {3, 32}, {9, 42}, {33, 37}, {7, 30}, {29, 45}, {27, 30}, {1, 7}, {33, 42},
                        {17, 47}, {12, 47}, {19, 41}, {3, 42}, {24, 26}, {20, 29}, {11, 23}, {22, 40},
                        {9, 37}, {31, 32}, {23, 46}, {11, 38}, {27, 29}, {17, 37}, {23, 30}, {14, 42},
                        {28, 30}, {29, 31}, {1, 8}, {1, 36}, {42, 50}, {21, 41}, {11, 18}, {39, 41}, {32, 34},
                        {6, 37}, {30, 38}, {21, 46}, {16, 37}, {22, 24}, {17, 32}, {23, 29}, {3, 30}, {8, 30},
                        {41, 48}, {1, 39}, {8, 47}, {30, 44}, {9, 46}, {22, 45}, {7, 26}, {35, 42}, {1, 27},
                        {17, 30}, {20, 46}, {18, 29}, {3, 29}, {4, 30}, {3, 46}};
        System.out.println(possibleBipartition(50, dislikes4));
    }

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        /**
         * 将所有人安排进两个组，distributions[i]为0表示还未分组，为1表示第i个人被分到了第1组，
         * 为2表示第i个人被分到了第2组
         */
        int[] distributions = new int[N + 1];
        /**
         * relations[i]为第i个人所有不喜欢的人
         */
        List<Integer>[] relations = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            relations[i] = new LinkedList<>();
        }

        for (int[] dislike : dislikes) {
            int num1 = dislike[0];
            int num2 = dislike[1];
            relations[num1].add(num2);
            relations[num2].add(num1);
        }

        for (int i = 1; i <= N; i++) {
            /**
             * 如果distributions[i]不为0，说明第i个人已经被分组了，否则就从第i个人开始，将和
             * 他有直接关系或间接关系的所有人进行分组
             */
            if (distributions[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                /**
                 * 假设第i个人被分到了第1组
                 */
                distributions[i] = 1;

                while (!queue.isEmpty()) {
                    int size = queue.size();

                    for (int j = 0; j < size; j++) {
                        int num = queue.poll();
                        /**
                         * 第num个人所有不喜欢的人要分到和他不同的组
                         */
                        int team = distributions[num] == 1 ? 2 : 1;
                        /**
                         * 第num个人所有不喜欢的人
                         */
                        List<Integer> dislikeList = relations[num];

                        for (int dislikeNum : dislikeList) {
                            /**
                             * 第dislikeNum个人应当和第num个人分到不同的组，但是如果第
                             * dislikeNum个人已经被分组了，而且还不是被分到了team组，此时
                             * 就产生了冲突，说明不能完成题目要求的分组，返回false。如果
                             * 第dislikeNum个人还没有被分组，就将他分到第team组，并将他加
                             * 入队列，后续安排他不喜欢的人
                             */
                            if (distributions[dislikeNum] != 0 && distributions[dislikeNum] != team) {
                                return false;
                            } else if (distributions[dislikeNum] == 0) {
                                distributions[dislikeNum] = team;
                                queue.offer(dislikeNum);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
