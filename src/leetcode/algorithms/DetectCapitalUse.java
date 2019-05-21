package leetcode.algorithms;

/**
 * Description: 520. Detect Capital
 * @author Baltan
 *
 * @date 2017/11/17 14:57
 */
public class DetectCapitalUse {
    public static void main(String[] args) {

    }

    public static boolean detectCapitalUse(String word) {
        if (word.length() < 2) {
            return true;
        }
        String start = word.substring(0, 1);
        String second = word.substring(1, 2);
        boolean flag = true;
        if (start.equals(start.toUpperCase()) && second.equals(second.toUpperCase())) {
            for (int i = 2; i < word.length(); i++) {
                String current = word.substring(i, i + 1);
                if (!current.equals(current.toUpperCase())) {
                    flag = false;
                    break;
                }
            }
        } else if (start.equals(start.toUpperCase()) && !second.equals(second.toUpperCase())) {
            for (int i = 2; i < word.length(); i++) {
                String current = word.substring(i, i + 1);
                if (current.equals(current.toUpperCase())) {
                    flag = false;
                    break;
                }
            }
        } else if (!start.equals(start.toUpperCase()) && !second.equals(second.toUpperCase())) {
            for (int i = 2; i < word.length(); i++) {
                String current = word.substring(i, i + 1);
                if (current.equals(current.toUpperCase())) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }
}
