package leetcode.algorithms;

/**
 * Description: 831. Masking Personal Information
 *
 * @author Baltan
 * @date 2019-05-04 09:23
 */
public class MaskPII {
    public static void main(String[] args) {
        System.out.println(maskPII("LeetCode@LeetCode.com"));
        System.out.println(maskPII("AB@qq.com"));
        System.out.println(maskPII("1(234)567-890"));
        System.out.println(maskPII("86-(10)12345678"));
    }

    public static String maskPII(String S) {
        if (S == null) {
            return null;
        } else if (S.contains("@")) {
            StringBuilder builder = new StringBuilder();
            String[] strs = S.split("@");
            String str1 = strs[0];
            builder.append(str1.substring(0, 1).toLowerCase()).append("*****")
                    .append(str1.substring(str1.length() - 1).toLowerCase()).append("@")
                    .append(strs[1].toLowerCase());
            return builder.toString();
        } else {
            StringBuilder builder = new StringBuilder();
            int length = S.length();
            int count = 0;
            for (int i = length - 1; i >= 0; i--) {
                char c = S.charAt(i);
                if (c >= '0' && c <= '9') {
                    if (count < 4) {
                        builder.insert(0, c);
                    } else {
                        if (count == 4 || count == 7 || count == 10) {
                            builder.insert(0, "-");
                        }
                        builder.insert(0, "*");
                    }
                    count++;
                }
            }
            if (count > 10) {
                builder.insert(0, "+");
            }
            return builder.toString();
        }
    }
}
