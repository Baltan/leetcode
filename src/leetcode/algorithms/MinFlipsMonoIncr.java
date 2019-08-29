package leetcode.algorithms;

/**
 * Description: 926. Flip String to Monotone Increasing
 *
 * @author Baltan
 * @date 2019-08-29 18:06
 */
public class MinFlipsMonoIncr {
    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00110"));
        System.out.println(minFlipsMonoIncr("010110"));
        System.out.println(minFlipsMonoIncr("00011000"));
        System.out.println(minFlipsMonoIncr("11001010101010101010101010101011010"));
        System.out.println(minFlipsMonoIncr("00001010101011110101010111100101101"));
        System.out.println(minFlipsMonoIncr("11011"));
    }

    public static int minFlipsMonoIncr(String S) {
        char[] charArray = S.toCharArray();
        int zeroCount = 0;
        /**
         * 统计字符串中"0"的个数
         */
        for (char c : charArray) {
            if (c == '0') {
                zeroCount++;
            }
        }
        /**
         * 假设把字符串中所有"0"变更为"1"，或将所有"1"变更为"0"，初始化结果为两者的较小值
         */
        int result = Math.min(zeroCount, charArray.length - zeroCount);
        int currentZeroCount = 0;
        int currentOneCount = 0;
        /**
         * 遍历字符串，统计到当前位置"0"的个数和"1"的个数，将当前位置前（包含当前位置）的所有"1"变更为"0"，
         * 当前位置后（不包含当前位置）的所有"0"变更为"1"，两项变更操作的总次数和result取较小值
         */
        for (char c : charArray) {
            if (c == '0') {
                currentZeroCount++;
            } else {
                currentOneCount++;
            }
            result = Math.min(zeroCount - currentZeroCount + currentOneCount, result);
        }
        return result;
    }
}
