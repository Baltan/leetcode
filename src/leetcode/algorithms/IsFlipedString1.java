package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 面试题 01.09. 字符串轮转
 *
 * @author Baltan
 * @date 2020-03-11 22:22
 */
public class IsFlipedString1 {
    public static void main(String[] args) {
        System.out.println(isFlipedString("waterbottle", "erbottlewat"));
        System.out.println(isFlipedString("aa", "aba"));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/string-rotation-lcci/solution/javajian-ming-ban-ben-0ms100-by-demondaydream/"></a>
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (Objects.equals(s1, s2)) {
            return true;
        }

        s1 += s1;
        return s1.contains(s2);
    }
}
