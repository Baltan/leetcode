package leetcode.interview;

/**
 * Description: 面试题 16.10. 生存人数
 *
 * @author Baltan
 * @date 2020-05-21 16:00
 * @see MaxAliveYear1
 * @see leetcode.algorithms.CarPooling
 */
public class MaxAliveYear {
    public static void main(String[] args) {
        int[] birth1 = {1900, 1901, 1950};
        int[] death1 = {1948, 1951, 2000};
        System.out.println(maxAliveYear(birth1, death1));
    }

    public static int maxAliveYear(int[] birth, int[] death) {
        /**
         * 假设生存人数最多的一年为2000年
         */
        int result = 2000;
        /**
         * 生存人数最多的一年的生存人数
         */
        int maxCount = 0;
        /**
         * array[i]为1900+i年的生存人数
         */
        int[] array = new int[101];
        int length = birth.length;

        for (int i = 0; i < length; i++) {
            int start = birth[i];
            int end = death[i];

            for (int j = start; j <= end; j++) {
                array[j - 1900]++;
            }
        }
        /**
         * 从2000年到1900年逆序遍历每年的生存人数，查找生存人数最多的年份，如果有多个年份生存人数相同且均为最大
         * 值，取其中最小的年份
         */
        for (int i = 100; i >= 0; i--) {
            if (array[i] >= maxCount) {
                maxCount = array[i];
                result = i + 1900;
            }
        }
        return result;
    }
}
