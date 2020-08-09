package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 93. Restore IP Addresses
 *
 * @author Baltan
 * @date 2019-05-22 09:17
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("1023213212"));
        System.out.println(restoreIpAddresses("00200"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("100000"));
        System.out.println(restoreIpAddresses("3100310310"));
        System.out.println(restoreIpAddresses("31021301"));
        System.out.println(restoreIpAddresses("76485230"));
        System.out.println(restoreIpAddresses("89012981390"));
        System.out.println(restoreIpAddresses("0279245587303"));
    }

    public static List<String> restoreIpAddresses(String s) {
        return help(s, 4);
    }

    /**
     * 将字符串s分成parts段可以得到的所有分法
     *
     * @param s
     * @param parts
     * @return
     */
    public static List<String> help(String s, int parts) {
        List<String> result = new ArrayList<>();
        /**
         * s无法分成parts段的情况
         */
        if (s == null || parts < 1 || s.length() > 3 * parts || s.length() < parts) {
            return result;
        }

        if (parts == 1) {
            /**
             * 如果只需将s分成一段，则s的长度为1或者s不大于255且不以"0"开头时，符合要求
             */
            if (s.length() == 1 || (!s.startsWith("0") && Integer.valueOf(s) <= 255)) {
                result.add(s);
            }
            return result;
        }
        /**
         * parts段中的第一段可以截取的最大长度
         */
        int longestHead = Math.min(s.length(), 3);

        for (int i = 1; i <= longestHead; i++) {
            if (i == 1) {
                String head = s.substring(0, 1);
                String rest = s.substring(1);
                /**
                 * 递归将s的剩余部分分割成parts-1段
                 */
                List<String> tails = help(rest, parts - 1);

                for (String tail : tails) {
                    result.add(head + "." + tail);
                }
            } else {
                if (!s.startsWith("0")) {
                    String head = s.substring(0, i);

                    if (Integer.valueOf(head) <= 255) {
                        String rest = s.substring(i);
                        /**
                         * 递归将s的剩余部分分割成parts-1段
                         */
                        List<String> tails = help(rest, parts - 1);

                        for (String tail : tails) {
                            result.add(head + "." + tail);
                        }
                    }
                }
            }
        }
        return result;
    }
}
