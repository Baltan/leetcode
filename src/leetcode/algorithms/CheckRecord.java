package leetcode.algorithms;

/**
 * Description: 551. Student Attendance Record I
 *
 * @author Baltan
 * @date 2017/11/24 10:02
 */
public class CheckRecord {
    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLP"));
        System.out.println(checkRecord("PPALLL"));
    }

    public static boolean checkRecord(String s) {
        int aNum = 0;
        for (int i = 0; i < s.length(); i++) {
            String curr = s.substring(i, i + 1);
            if ("A".equals(curr)) {
                aNum++;
            } else if ("L".equals(curr) && i <= s.length() - 3) {
                if ("L".equals(s.substring(i + 1, i + 2)) && "L".equals(s.substring(i + 2, i + 3))) {
                    return false;
                }
            }
            if (aNum > 1) {
                return false;
            }
        }
        return true;
    }
}
