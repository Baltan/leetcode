package leetcode.algorithms;


/**
 * Description: 777. Swap Adjacent in LR String
 *
 * @author Baltan
 * @date 2019-10-12 10:27
 */
public class CanTransform {
    public static void main(String[] args) {
        System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
        System.out.println(canTransform("XXRXXLXXXX", "XXXXRXXLXX"));
    }

    public static boolean canTransform(String start, String end) {
        int length = start.length();
        /**
         * i指针指向start中当前字符的位置
         */
        int i = 0;
        /**
         * j指针指向end中当前字符的位置
         */
        int j = 0;

        while (true) {
            /**
             * 找到start中第1个不为"X"的字符的位置
             */
            while (i < length && start.charAt(i) == 'X') {
                i++;
            }
            /**
             * 找到end中第1个不为"X"的字符的位置
             */
            while (j < length && end.charAt(j) == 'X') {
                j++;
            }
            /**
             * 1、如果start和end都已经查找完，没有找到不为"X"的字符，返回true
             * 2、如果start和end某一个查找完，另一个没有查找完，说明另一个还有多余"L"或"R"，返回false
             * 3、如果start和end都没有查找完，并且当前指向的不为"X"的字符不相等，因为"L"和"R"不能交换位置，返回false
             * 4、如果start和end都没有查找完，当前指向的都是"L"，并且当前end的指针j的位置比start的指针i的位置更靠后，
             *    因为"L"只能向左移动，返回false；
             * 5、如果start和end都没有查找完，当前指向的都是"R"，并且当前end的指针j的位置比start的指针i的位置更靠前，
             *    因为"R"只能向右移动，返回false；
             * 6、如果start和end都没有查找完，当前指向的字符相同，并且不为4、5两种情况，将i、j指针都向后移动一位，继续
             *    查找start和end下一个不为"X"的字符，进行判断。
             */
            if (i == length && j == length) {
                return true;
            } else if (i == length || j == length) {
                return false;
            } else {
                char c1 = start.charAt(i);
                char c2 = end.charAt(j);

                if (c1 != c2) {
                    return false;
                } else if (c1 == 'L' && j > i) {
                    return false;
                } else if (c1 == 'R' && j < i) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            }
        }
    }
}
