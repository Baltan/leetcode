package leetcode.algorithms;

/**
 * Description: 2591. Distribute Money to Maximum Children
 *
 * @author Baltan
 * @date 2023/3/19 11:51
 */
public class DistMoney {
    public static void main(String[] args) {
        System.out.println(distMoney(20, 3));
        System.out.println(distMoney(16, 2));
        System.out.println(distMoney(17, 2));
    }

    public static int distMoney(int money, int children) {
        /**
         * 尝试为尽可能多的孩子分得8美金
         */
        for (int i = children; i >= 0; i--) {
            int cost = i * 8;
            /**
             * 不足以为i个孩子每人分得8美金
             */
            if (money < cost) {
                continue;
            }
            /**
             * 为i个孩子每人分配8美金后，钱还有剩余，但是没有其他孩子了
             */
            if (cost < money && children == i) {
                continue;
            }
            /**
             * 为i个孩子每人分配8美金后，剩下的孩子不能保证每人至少分到1美金
             */
            if (money - cost < children - i) {
                continue;
            }
            /**
             * 为i个孩子每人分配8美金后，剩下只有1个孩子且这个孩子刚好要分得4美金
             */
            if (money - cost == 4 && children - i == 1) {
                continue;
            }
            return i;
        }
        return -1;
    }
}
