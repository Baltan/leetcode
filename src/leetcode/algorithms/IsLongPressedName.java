package leetcode.algorithms;

/**
 * Description: Long Pressed Name
 *
 * @author Baltan
 * @date 2019-03-16 16:00
 */
public class IsLongPressedName {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleex"));
        System.out.println(isLongPressedName("saeed", "ssaaedd"));
        System.out.println(isLongPressedName("leelee", "lleeelee"));
        System.out.println(isLongPressedName("laiden", "laiden"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        int nameLength = name.length();
        int typedLength = typed.length();
        int index1 = 0;
        int index2 = 0;
        char previousChar = name.charAt(index1);

        while (index1 < nameLength) {
            if (index2 >= typedLength) {
                return false;
            }

            char c1 = name.charAt(index1);
            char c2 = typed.charAt(index2);

            if (c2 != c1 && c2 != previousChar) {
                return false;
            } else if (c2 == c1) {
                index2++;
                index1++;
                previousChar = c1;
            } else if (c2 != c1 && c2 == previousChar) {
                index2++;
            }
        }
        return true;
    }
}
