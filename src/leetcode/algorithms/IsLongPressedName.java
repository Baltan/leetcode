package leetcode.algorithms;

/**
 * Description: 925. Long Pressed Name
 *
 * @author Baltan
 * @date 2019-03-16 16:00
 */
public class IsLongPressedName {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("zlexya", "aazlllllllllllllleexxxxxxxxxxxxxxxya"));
        System.out.println(isLongPressedName("vtkgn", "vttkgnn"));
        System.out.println(isLongPressedName("alex", "alexxr"));
        System.out.println(isLongPressedName("alex", "aaleelx"));
        System.out.println(isLongPressedName("alex", "aaleex"));
        System.out.println(isLongPressedName("saeed", "ssaaedd"));
        System.out.println(isLongPressedName("leelee", "lleeelee"));
        System.out.println(isLongPressedName("laiden", "laiden"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        int nameLength = name.length();
        int typedLength = typed.length();
        int nameIndex = 0;
        int typedIndex = 0;
        char[] nameChars = name.toCharArray();
        char[] typedChars = typed.toCharArray();

        while (nameIndex < nameLength) {
            /**
             * 如果没有键入的字符了，则name无法被匹配完，返回false
             */
            if (typedIndex == typedLength) {
                return false;
            }
            /**
             * 如果当前键入的字符和name指向的字符不匹配，考虑是否是重复键入字符了；否则继续判断下面的字符
             */
            if (typedChars[typedIndex] != nameChars[nameIndex]) {
                /**
                 * 如果键入的字符和前一个字符相同，则是重复键入字符了，继续判断下一个键入的字符；否则不是
                 * 重复键入字符，即键入了错误的字符，返回false
                 */
                if (typedIndex > 0 && typedChars[typedIndex] == typedChars[typedIndex - 1]) {
                    typedIndex++;
                } else {
                    return false;
                }
            } else {
                typedIndex++;
                nameIndex++;
            }
        }
        /**
         * 判断剩余键入的字符是否是重复键入的
         */
        while (typedIndex < typedLength) {
            if (typedChars[typedIndex] != typedChars[typedIndex - 1]) {
                return false;
            }
            typedIndex++;
        }
        return true;
    }
}
