package leetcode.algorithms;

/**
 * Description: 657. Robot Return to Origin
 *
 * @author Baltan
 * @date 2017/11/17 14:13
 */
public class JudgeCircle {
    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle("LL"));
    }

    public static boolean judgeCircle(String moves) {
        int[] position = {0, 0};
        for (int i = 0; i < moves.length(); i++) {
            String letter = moves.substring(i, i + 1);
            if ("U".equalsIgnoreCase(letter)) {
                position[0]++;
            } else if ("D".equalsIgnoreCase(letter)) {
                position[0]--;
            } else if ("R".equalsIgnoreCase(letter)) {
                position[1]++;
            } else if ("L".equalsIgnoreCase(letter)) {
                position[1]--;
            }
        }
        if (position[0] == 0 && position[1] == 0) {
            return true;
        }
        return false;
    }
}
