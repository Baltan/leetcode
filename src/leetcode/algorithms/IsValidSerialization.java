package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 331. Verify Preorder Serialization of a Binary Tree
 *
 * @author Baltan
 * @date 2019-06-23 10:26
 */
public class IsValidSerialization {
    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(isValidSerialization("1,#"));
        System.out.println(isValidSerialization("9,#,#,1"));
    }

    public static boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }

        if (Objects.equals(preorder, "#")) {
            return true;
        }

        String pattern1 = ",\\d+,#,#";
        String pattern2 = "\\d+,#,#";

        while (true) {
            String str = preorder.replaceAll(pattern1, ",#");

            if (Objects.equals(str, preorder)) {
                break;
            } else {
                preorder = str;
            }
        }
        return preorder.matches(pattern2);
    }
}
