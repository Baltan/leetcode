package leetcode.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: LCP 40. 心算挑战
 *
 * @author Baltan
 * @date 2022/2/28 18:13
 */
public class MaxmiumScore {
    public static void main(String[] args) {
        System.out.println(maxmiumScore(new int[]{1, 2, 8, 9}, 3));
        System.out.println(maxmiumScore(new int[]{3, 3, 1}, 1));
    }

    public static int maxmiumScore(int[] cards, int cnt) {
        int result = 0;
        /**
         * 奇数列表
         */
        List<Integer> oddList = new ArrayList<>();
        /**
         * 偶数列表
         */
        List<Integer> evenList = new ArrayList<>();

        for (int card : cards) {
            if (card % 2 == 0) {
                evenList.add(card);
            } else {
                oddList.add(card);
            }
        }

        Collections.sort(oddList, Collections.reverseOrder());
        Collections.sort(evenList, Collections.reverseOrder());
        /**
         * 降序排列的奇数列表的前缀和
         */
        int[] oddPrefixSums = new int[oddList.size() + 1];
        /**
         * 降序排列的偶数列表的前缀和
         */
        int[] evenPrefixSums = new int[evenList.size() + 1];

        for (int i = 0; i < oddList.size(); i++) {
            oddPrefixSums[i + 1] = oddList.get(i) + oddPrefixSums[i];
        }

        for (int i = 0; i < evenList.size(); i++) {
            evenPrefixSums[i + 1] = evenList.get(i) + evenPrefixSums[i];
        }
        /**
         * 因为总和为偶数，所以奇数的个数一定为偶数，从0个开始枚举
         */
        for (int oddCount = 0; oddCount <= cnt && oddCount <= oddList.size(); oddCount += 2) {
            int evenCount = cnt - oddCount;
            /**
             * 所有偶数的个数不足所需偶数的个数，继续增加奇数的个数
             */
            if (evenCount > evenList.size()) {
                continue;
            }
            result = Math.max(result, oddPrefixSums[oddCount] + evenPrefixSums[evenCount]);
        }
        return result;
    }
}
