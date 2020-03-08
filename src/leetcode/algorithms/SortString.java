package leetcode.algorithms;

/**
 * Description: 1370. Increasing Decreasing String
 *
 * @author Baltan
 * @date 2020-03-08 13:02
 */
public class SortString {
    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc"));
        System.out.println(sortString("rat"));
        System.out.println(sortString("leetcode"));
        System.out.println(sortString("ggggggg"));
        System.out.println(sortString("spo"));
    }

    public static String sortString(String s) {
        int length = s.length();
        StringBuilder builder = new StringBuilder(length);
        int[] counts = new int[26];
        /**
         * flag为true表示升序排列字符串（步骤1-3），false表示降序排列字符串（步骤4-6）
         */
        boolean flag = true;
        /**
         * 对s中每个字符出现的次数计数
         */
        for (int i = 0; i < length; i++) {
            counts[s.charAt(i) - 'a']++;
        }

        while (length > 0) {
            if (flag) {
                for (int i = 0; i < 26; i++) {
                    if (counts[i] > 0) {
                        builder.append((char) ('a' + i));
                        counts[i]--;
                        length--;
                    }
                }
            } else {
                for (int i = 25; i >= 0; i--) {
                    if (counts[i] > 0) {
                        builder.append((char) ('a' + i));
                        counts[i]--;
                        length--;
                    }
                }
            }
            flag = !flag;
        }
        return builder.toString();
    }
}
