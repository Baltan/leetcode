package leetcode.algorithms;

/**
 * Description: 2678. Number of Senior Citizens
 *
 * @author Baltan
 * @date 2023/5/17 23:02
 */
public class CountSeniors {
    public static void main(String[] args) {
        System.out.println(countSeniors(new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"}));
        System.out.println(countSeniors(new String[]{"1313579440F2036", "2921522980M5644"}));
    }

    public static int countSeniors(String[] details) {
        int result = 0;

        for (String detail : details) {
            /**
             * details[11]和details[12]连在一起的两位数表示年龄
             */
            if ((detail.charAt(11) - '0') * 10 + (detail.charAt(12) - '0') > 60) {
                result++;
            }
        }
        return result;
    }
}
