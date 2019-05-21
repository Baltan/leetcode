package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 91. Decode Ways
 *
 * @author Baltan
 * @date 2019-05-21 09:01
 */
public class NumDecodings {
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("10"));
        System.out.println(numDecodings("20"));
        System.out.println(numDecodings("30"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("32313123311332432"));
        System.out.println(numDecodings("13133203"));
        System.out.println(numDecodings("33320320110"));
        System.out.println(numDecodings("333203201104320"));
        System.out.println(numDecodings("432353643423"));
        System.out.println(numDecodings("31310318381013"));
        System.out.println(numDecodings("12342031321101213201"));
        System.out.println(numDecodings("13131031312111220313"));
        System.out.println(numDecodings("423000211"));
    }

    public static int numDecodings(String s) {
        if (s.length() == 1) {
            if (Objects.equals(s, "0")) {
                return 0;
            } else {
                return 1;
            }
        }

        if (s.contains("00") || s.contains("30") || s.contains("40") || s.contains("50") ||
                s.contains("60") || s.contains("70") || s.contains("80") || s.contains("90")) {
            return 0;
        }

        if (s.startsWith("0")) {
            return 0;
        }

        int length = s.length();
        int[] arr = new int[length];

        arr[0] = 1;

        if (s.charAt(1) == '0') {
            arr[1] = 1;
        } else {
            int head = Integer.valueOf(s.substring(0, 2));
            arr[1] = head >= 1 && head <= 26 ? 2 : 1;
        }

        for (int i = 2; i < length; i++) {
            if (s.charAt(i) == '0') {
                arr[i] = arr[i - 2];
            } else {
                String tailStr = s.substring(i - 1, i + 1);
                int tail = Integer.valueOf(tailStr);

                if (tailStr.startsWith("0")) {
                    arr[i] = arr[i - 1];
                } else {
                    if (tail >= 1 && tail <= 26) {
                        arr[i] = arr[i - 1] + arr[i - 2];
                    } else {
                        arr[i] = arr[i - 1];
                    }
                }
            }
        }
        return arr[length - 1];
    }
}