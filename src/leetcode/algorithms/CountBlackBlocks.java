package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2768. Number of Black Blocks
 *
 * @author Baltan
 * @date 2023/7/9 22:41
 * @see CountBlackBlocks1
 */
public class CountBlackBlocks {
    public static void main(String[] args) {
        OutputUtils.print1DLongArray(countBlackBlocks(3, 3, new int[][]{{0, 0}}));
        OutputUtils.print1DLongArray(countBlackBlocks(3, 3, new int[][]{{0, 0}, {1, 1}, {0, 2}}));
    }

    public static long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        long[] result = new long[5];
        /**
         * isBlack.get(i).get(j)表示格子matrix[i][j]是否为黑色
         */
        Map<Integer, Map<Integer, Boolean>> isBlack = new HashMap<>();
        /**
         * isVisited[i][j]表示黑色格子matrix[i][j]依次作为左上角、右上角、左下角、右下角时的情况是否已被计数过
         */
        Map<Integer, Map<Integer, boolean[]>> isVisited = new HashMap<>();
        /**
         * 某个黑色格子依次作为左上角、右上角、左下角、右下角时，田字格中的左上角、右上角、左下角、右下角四个格子相对该黑色格子的位置
         */
        int[][][] relatives = {{{0, 0}, {0, 1}, {1, 0}, {1, 1}},
                {{0, -1}, {0, 0}, {1, -1}, {1, 0}},
                {{-1, 0}, {-1, 1}, {0, 0}, {0, 1}},
                {{-1, -1}, {-1, 0}, {0, -1}, {0, 0}}};
        /**
         * 查找矩阵matrix中的所有黑色格子
         */
        for (int[] coordinate : coordinates) {
            isBlack.computeIfAbsent(coordinate[0], x -> new HashMap<>()).put(coordinate[1], Boolean.TRUE);
        }

        for (Map.Entry<Integer, Map<Integer, Boolean>> outerEntry : isBlack.entrySet()) {
            for (Map.Entry<Integer, Boolean> innerEntry : outerEntry.getValue().entrySet()) {
                /**
                 * i属于[0,3]依次代表matrix[x][y]作为左上角、右上角、左下角、右下角时的情况
                 */
                loop:
                for (int i = 0; i < 4; i++) {
                    int x = outerEntry.getKey();
                    int y = innerEntry.getKey();
                    /**
                     * 当前田字格中的黑色格子数
                     */
                    int count = 0;
                    /**
                     * 依次判断当前田字格中左上角、右上角、左下角、右下角四个格子的情况
                     */
                    for (int j = 0; j < 4; j++) {
                        int gridX = x + relatives[i][j][0];
                        int gridY = y + relatives[i][j][1];
                        /**
                         * 当前格子matrix[gridX][gridY]已超出矩阵范围，不用继续计算第i种情况
                         */
                        if (gridX < 0 || gridX == m || gridY < 0 || gridY == n) {
                            continue loop;
                        }
                        /**
                         * 格子matrix[gridX][gridY]依次作为左上角、右上角、左下角、右下角时的情况是否已被计数过
                         */
                        boolean[] conditions = isVisited.computeIfAbsent(gridX, arg -> new HashMap<>())
                                .computeIfAbsent(gridY, arg -> new boolean[4]);
                        /**
                         * 格子matrix[gridX][gridY]不为黑色，继续判断田字格中的下一个格子
                         */
                        if (!isBlack.getOrDefault(gridX, Collections.emptyMap()).getOrDefault(gridY, Boolean.FALSE)) {
                            continue;
                        }
                        /**
                         * 黑色格子matrix[gridX][gridY]在田字格中位置为第j种情况已被计算过，不用继续计算第i种情况
                         */
                        if (conditions[j]) {
                            continue loop;
                        }
                        count++;
                        /**
                         * 标记黑色格子matrix[gridX][gridY]在田字格中位置为第j种情况已被计算过
                         */
                        conditions[j] = true;
                    }
                    result[count]++;
                }
            }
        }
        /**
         * 排除有黑色格子的田字格，剩余所有情况的田字格都不包含黑色格子
         */
        result[0] = (long) (m - 1) * (n - 1) - result[1] - result[2] - result[3] - result[4];
        return result;
    }
}
