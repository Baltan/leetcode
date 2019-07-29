package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1138. Alphabet Board Path
 *
 * @author Baltan
 * @date 2019-07-29 09:06
 */
public class AlphabetBoardPath {
    public static void main(String[] args) {
        System.out.println(alphabetBoardPath("leet"));
        System.out.println(alphabetBoardPath("code"));
        System.out.println(alphabetBoardPath("zb"));
        System.out.println(alphabetBoardPath("zdz"));
    }

    public static String alphabetBoardPath(String target) {
        /**
         *  a   b   c   d   e
         *  f   g   h   i   j
         *  k   l   m   n   o
         *  p   q   r   s   t
         *  u   v   w   x   y
         *  z
         */
        StringBuilder builder = new StringBuilder();
        Map<Character, int[]> map = new HashMap<>();
        int x = 0;
        int y = 0;
        int length = target.length();

        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, new int[]{(i - 'a') % 5, (i - 'a') / 5});
        }

        for (int i = 0; i < length; i++) {
            char c = target.charAt(i);
            int[] position = map.get(c);
            int moveX = position[0] - x;
            int moveY = position[1] - y;
            /**
             * 如果目标字母是"z"，必须先走x轴到最左边，再走y轴到最下面，否则可能超出面板
             * 其他字母，都可以先走y轴，再走x轴
             */
            if (c == 'z') {
                if (moveX > 0) {
                    while (moveX > 0) {
                        builder.append("R");
                        moveX--;
                    }
                } else if (moveX < 0) {
                    while (moveX < 0) {
                        builder.append("L");
                        moveX++;
                    }
                }

                if (moveY > 0) {
                    while (moveY > 0) {
                        builder.append("D");
                        moveY--;
                    }
                } else if (moveY < 0) {
                    while (moveY < 0) {
                        builder.append("U");
                        moveY++;
                    }
                }
            } else {
                if (moveY > 0) {
                    while (moveY > 0) {
                        builder.append("D");
                        moveY--;
                    }
                } else if (moveY < 0) {
                    while (moveY < 0) {
                        builder.append("U");
                        moveY++;
                    }
                }

                if (moveX > 0) {
                    while (moveX > 0) {
                        builder.append("R");
                        moveX--;
                    }
                } else if (moveX < 0) {
                    while (moveX < 0) {
                        builder.append("L");
                        moveX++;
                    }
                }
            }

            builder.append("!");
            x = position[0];
            y = position[1];
        }
        return builder.toString();
    }
}
