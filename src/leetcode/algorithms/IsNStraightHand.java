package leetcode.algorithms;

import java.util.Map;
import java.util.TreeMap;

/**
 * Description: 846. Hand of Straights
 *
 * @author Baltan
 * @date 2019-08-31 22:56
 */
public class IsNStraightHand {
    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 4, 5, 2, 3, 4, 5, 6}, 5));
        System.out.println(isNStraightHand(new int[]{1}, 1));
        System.out.println(isNStraightHand(new int[]{1}, 2));
        System.out.println(isNStraightHand(new int[]{5, 1}, 2));
        System.out.println(isNStraightHand(new int[]{2, 3, 4, 5, 11}, 5));
    }

    public static boolean isNStraightHand(int[] hand, int W) {
        int length = hand.length;

        if (length % W != 0) {
            return false;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        /**
         * 统计每种点数的牌出现的张数，并按点数递增排序
         */
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        /**
         * 从点数最小的开始遍历，如果该点数num的牌张数为0，跳过处理下一点数的牌；如果该点数num的牌张数不为0，为count，
         * 逐一判断点数为[num,num+w)的牌的张数，若张数小于count，返回false，否则这些点数的牌都要各自用去count张，继
         * 续遍历，直到所有牌都用完
         */
        for (int num : map.keySet()) {
            int count = map.get(num);

            if (count == 0) {
                continue;
            } else if (count > 0) {
                for (int i = num; i < num + W; i++) {
                    int iCount = map.getOrDefault(i, 0);

                    if (iCount < count) {
                        return false;
                    }
                    map.put(i, iCount - count);
                }
            }
        }
        return true;
    }
}
