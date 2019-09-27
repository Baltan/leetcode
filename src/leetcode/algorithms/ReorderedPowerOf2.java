package leetcode.algorithms;

import java.util.*;

/**
 * Description: 869. Reordered Power of 2
 *
 * @author Baltan
 * @date 2019-09-27 10:57
 */
public class ReorderedPowerOf2 {
    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(1));
        System.out.println(reorderedPowerOf2(10));
        System.out.println(reorderedPowerOf2(16));
        System.out.println(reorderedPowerOf2(24));
        System.out.println(reorderedPowerOf2(46));
        System.out.println(reorderedPowerOf2(368407186));
        System.out.println(reorderedPowerOf2(679213508));
        System.out.println(reorderedPowerOf2(850239671));
    }

    public static boolean reorderedPowerOf2(int N) {
        List<String> list = permutation(String.valueOf(N));

        for (String s : list) {
            if (!s.startsWith("0")) {
                int value = Integer.parseInt(s);

                while (value != 1) {
                    if (value % 2 != 0) {
                        break;
                    }
                    value /= 2;
                }

                if (value == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<String> permutation(String str) {
        List<String> result = new LinkedList<>();
        int length = str.length();

        if (length == 1) {
            result.add(str);
        } else {
            HashSet<String> set = new HashSet<>();

            for (char c : str.toCharArray()) {
                set.add(String.valueOf(c));
            }

            for (String head : set) {
                int position = str.indexOf(head);
                String restStr = str.substring(0, position) + str.substring(position + 1, length);
                List<String> list = permutation(restStr);

                for (String tail : list) {
                    result.add(head + tail);
                }
            }
        }
        return result;
    }
}
