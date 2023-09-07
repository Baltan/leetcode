package leetcode.algorithms;

/**
 * Description: 2839. Check if Strings Can be Made Equal With Operations I
 *
 * @author baltan
 * @date 2023/9/7 09:24
 */
public class CanBeEqual1 {
    public static void main(String[] args) {
        System.out.println(canBeEqual("abcd", "cdab"));
        System.out.println(canBeEqual("abcd", "dacb"));
    }

    public static boolean canBeEqual(String s1, String s2) {
        boolean condition1 = s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2);
        boolean condition2 = s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0);
        boolean condition3 = s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3);
        boolean condition4 = s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1);
        return (condition1 || condition2) && (condition3 || condition4);
    }
}
