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

    public static List<String> help(String s, int parts) {
        List<String> result = new ArrayList<>();

        if (s == null || s.length() == 0 || s.length() > 3 * parts || parts < 1 || s.length() < parts) {
            return result;
        }

        if (parts == 1) {
            if (s.length() == 1) {
                result.add(s);
            } else {
                if (!s.startsWith("0") && Long.valueOf(s) <= 255) {
                    result.add(s);
                }
            }
            return result;
        }

        int threshold = Math.min(s.length(), 3);

        for (int i = 1; i <= threshold; i++) {
            if (i == 1) {
                String head = s.substring(0, 1);
                String rest = s.substring(1);
                List<String> tails = help(rest, parts - 1);

                for (String tail : tails) {
                    result.add(head + "." + tail);
                }
            } else {
                if (!s.startsWith("0")) {
                    String head = s.substring(0, i);
                    if (Long.valueOf(head) <= 255) {
                        String rest = s.substring(i);
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
