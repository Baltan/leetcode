package leetcode.algorithms;

/**
 * Description: 2125. Number of Laser Beams in a Bank
 *
 * @author Baltan
 * @date 2022/1/4 09:43
 */
public class NumberOfBeams {
    public static void main(String[] args) {
        System.out.println(numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
        System.out.println(numberOfBeams(new String[]{"000", "111", "000"}));
    }

    public static int numberOfBeams(String[] bank) {
        if (bank.length == 1) {
            return 0;
        }

        int result = 0;
        /**
         * 上一个有安全防盗装置的行中装置的数量
         */
        int prevCount = 0;
        int rows = bank.length;
        int cols = bank[0].length();

        for (int i = 0; i < rows; i++) {
            /**
             * 当前行中装置的数量
             */
            int currCount = 0;

            for (int j = 0; j < cols; j++) {
                if (bank[i].charAt(j) == '1') {
                    currCount++;
                }
            }
            /**
             * 如果前面有装有装置的行，并且当前行也有装置，则两两可以产生激光束
             */
            if (prevCount > 0 && currCount > 0) {
                result += prevCount * currCount;
                prevCount = currCount;
                /**
                 * 如果前面没有装有装置的行，但是当前行有装置，则当前行可以尝试和后面行的装置产生激光束
                 */
            } else if (currCount > 0) {
                prevCount = currCount;
            }
        }
        return result;
    }
}
