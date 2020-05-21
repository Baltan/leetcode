package leetcode.interview;

/**
 * Description: 面试题 16.10. 生存人数
 *
 * @author Baltan
 * @date 2020-05-21 16:42
 * @see MaxAliveYear
 * @see leetcode.algorithms.CarPooling
 */
public class MaxAliveYear1 {
    public static void main(String[] args) {
        int[] birth1 = {1900, 1901, 1950};
        int[] death1 = {1948, 1951, 2000};
        System.out.println(maxAliveYear(birth1, death1));
    }

    public static int maxAliveYear(int[] birth, int[] death) {
        /**
         * 假设生存人数最多的一年为1900年
         */
        int result = 1900;
        /**
         * birthNumbers[i]为1900+i年出生的人数
         */
        int[] birthNumbers = new int[101];
        /**
         * deathNumbers[i]为1900+i年出生的人数
         */
        int[] deathNumbers = new int[101];
        int length = birth.length;
        /**
         * 某一年的存活人数
         */
        int liveCount = 0;
        /**
         * 生存人数最多的一年的生存人数
         */
        int maxCount = 0;
        /**
         * 统计每一年出生和死亡的人数
         */
        for (int i = 0; i < length; i++) {
            int birthYear = birth[i];
            int deathYear = death[i];
            birthNumbers[birthYear - 1900]++;
            deathNumbers[deathYear - 1900]++;
        }

        for (int i = 0; i < 101; i++) {
            /**
             * 加上第1900+i年出生的人数
             */
            liveCount += birthNumbers[i];

            if (liveCount > maxCount) {
                result = i + 1900;
                maxCount = liveCount;
            }
            /**
             * 第1900+i年过后还存活的人数
             */
            liveCount -= deathNumbers[i];
        }
        return result;
    }
}
