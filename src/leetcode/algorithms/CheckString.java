package leetcode.algorithms;

/**
 * Description: 2124. Check if All A's Appears Before All B's
 *
 * @author Baltan
 * @date 2022/1/6 09:12
 */
public class CheckString {
    public static void main(String[] args) {
        System.out.println(checkString("aaabbb"));
        System.out.println(checkString("abab"));
        System.out.println(checkString("bbb"));
    }

    public static boolean checkString(String s) {
        /**
         * 标记'b'是否出现过
         */
        boolean appearB = false;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                appearB = true;
            } else {
                /**
                 * 如果出现'a'，但是之前已经出现过'b'，返回false
                 */
                if (appearB) {
                    return false;
                }
            }
        }
        return true;
    }
}
