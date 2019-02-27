package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: Prime Number of Set Bits in Binary Representation
 *
 * @author Baltan
 * @date 2018/7/31 14:50
 */
public class CountPrimeSetBits {
    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
        System.out.println(countPrimeSetBits(10, 15));
    }

    public static int countPrimeSetBits(int L, int R) {
        List<Integer> primeNumList = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
        int num = 0;

        for (int i = L; i <= R; i++) {
            int setBitsNum = 0;
            int j = i;
            while (j > 0) {
                j &= j - 1;
                setBitsNum++;
            }
            if (primeNumList.contains(setBitsNum)) {
                num++;
            }
        }
        return num;
    }
}
