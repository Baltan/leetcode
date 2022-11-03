package leetcode.algorithms;

/**
 * Description: 1544. Make The String Great
 *
 * @author Baltan
 * @date 2022/10/26 22:18
 */
public class MakeGood {
    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGood("abBAcC"));
        System.out.println(makeGood("s"));
    }

    public static String makeGood(String s) {
        StringBuilder builder = new StringBuilder(s);
        boolean flag = true;
        /**
         * 相同大写字母和小写字母的ASCII码差值
         */
        int diff = 'a' - 'A';

        while (flag) {
            flag = false;

            for (int i = 0; i <= builder.length() - 2; i++) {
                if (Math.abs(builder.charAt(i) - builder.charAt(i + 1)) == diff) {
                    /**
                     * 删除相邻的两个字符，一定要先删除索引值较大的字符，否则会造成越界
                     */
                    builder.deleteCharAt(i + 1);
                    builder.deleteCharAt(i);
                    flag = true;
                    break;
                }
            }
        }
        return builder.toString();
    }
}
