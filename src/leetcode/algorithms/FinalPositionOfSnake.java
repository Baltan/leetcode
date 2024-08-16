package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 3248. Snake in Matrix
 *
 * @author baltan
 * @date 2024/8/12 14:33
 */
public class FinalPositionOfSnake {
    public static void main(String[] args) {
        System.out.println(finalPositionOfSnake(2, Arrays.asList("RIGHT", "DOWN")));
        System.out.println(finalPositionOfSnake(3, Arrays.asList("DOWN", "RIGHT", "UP")));
    }

    public static int finalPositionOfSnake(int n, List<String> commands) {
        /**
         * 蛇当前所在行
         */
        int row = 0;
        /**
         * 蛇当前所在列
         */
        int col = 0;

        for (String command : commands) {
            switch (command) {
                case "UP":
                    row--;
                    break;
                case "DOWN":
                    row++;
                    break;
                case "LEFT":
                    col--;
                    break;
                case "RIGHT":
                    col++;
                    break;
            }
        }
        return row * n + col;
    }
}
