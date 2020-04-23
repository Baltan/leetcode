package leetcode.algorithms;

/**
 * Description: 1419. Minimum Number of Frogs Croaking
 *
 * @author Baltan
 * @date 2020-04-23 08:02
 */
public class MinNumberOfFrogs {
    public static void main(String[] args) {
        System.out.println(minNumberOfFrogs("croakcroak"));
        System.out.println(minNumberOfFrogs("crcoakroak"));
        System.out.println(minNumberOfFrogs("croakcrook"));
        System.out.println(minNumberOfFrogs("croakcroa"));
    }

    public static int minNumberOfFrogs(String croakOfFrogs) {
        int result = 0;
        /**
         * 当前正在蛙鸣的青蛙的只数
         */
        int currentCount = 0;
        /**
         * count[0]为当前"c"的个数，count[1]为当前"r"的个数，count[2]为当前"o"的个数，count[3]为当前"a"的个
         * 数，count[4]为当前"k"的个数
         */
        int[] count = new int[5];

        for (char c : croakOfFrogs.toCharArray()) {
            if (c == 'c') {
                count[0]++;
                /**
                 * 又一只青蛙开始蛙鸣，当前正在蛙鸣的青蛙的只数+1
                 */
                currentCount++;
                result = Math.max(result, currentCount);
            } else if (c == 'r') {
                count[1]++;
            } else if (c == 'o') {
                count[2]++;
            } else if (c == 'a') {
                count[3]++;
            } else {
                count[4]++;
                /**
                 * 一只青蛙结束蛙鸣，当前正在蛙鸣的青蛙的只数-1
                 */
                currentCount--;
            }
            /**
             * "croak"的五个字母必须按序出现，如果出现后面的字母数量多于前面的字母，说明字符串croakOfFrogs不是
             * 由若干有效的"croak"字符混合而成的，返回-1
             */
            if (count[1] > count[0] || count[2] > count[1] || count[3] > count[2] || count[4] > count[3]) {
                return -1;
            }
        }
        /**
         * 如果croak"的五个字母出现的次数不一致，说明没有输出全部五个字母，返回-1
         */
        if (count[1] != count[0] || count[2] != count[1] || count[3] != count[2] || count[4] != count[3]) {
            return -1;
        }
        return result;
    }
}
