package leetcode.algorithms;

/**
 * Description: 3771. Total Score of Dungeon Runs
 *
 * @author baltan
 * @date 2026/1/29 16:33
 */
public class TotalScore {
    public static void main(String[] args) {
        System.out.println(totalScore(11, new int[]{3, 6, 7}, new int[]{4, 2, 5}));
        System.out.println(totalScore(2, new int[]{10000, 1}, new int[]{1, 1}));
    }

    public static long totalScore(int hp, int[] damage, int[] requirement) {
        long result = 0L;
        int length = damage.length;
        /**
         * 数组damage的前缀和数组
         */
        int[] damagePrefixSums = new int[length + 1];

        for (int i = 0; i < length; i++) {
            damagePrefixSums[i + 1] = damagePrefixSums[i] + damage[i];
        }
        /**
         * 如果从房间x（x<=i）开始到达房间i的剩余生命值不小于requirement[i]，则从[x,i]这个范围内的房间开始到达房间i的剩余生命值都不小于
         * requirement[i]。对于每个房间i，二分查找可以在该房间获得分数的最小开始房间索引
         */
        for (int i = 0; i < length; i++) {
            if (hp - damage[i] < requirement[i]) {
                continue;
            }
            int lo = 0;
            int hi = i;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                int damageSum = damagePrefixSums[i + 1] - damagePrefixSums[mid];

                if (hp - damageSum >= requirement[i]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            result += i - lo + 1;
        }
        return result;
    }
}
