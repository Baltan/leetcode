package leetcode.algorithms;

/**
 * Description: 2029. Stone Game IX
 *
 * @author Baltan
 * @date 2021/11/30 22:00
 * @see PredictTheWinner
 * @see PredictTheWinner1
 * @see StoneGame
 * @see StoneGameII
 * @see StoneGameIII
 * @see StoneGameVI
 * @see StoneGameVII
 */
public class StoneGameIX {
    public static void main(String[] args) {
        System.out.println(stoneGameIX(new int[]{2, 1}));
        System.out.println(stoneGameIX(new int[]{2}));
        System.out.println(stoneGameIX(new int[]{5, 1, 2, 4, 3}));
        System.out.println(stoneGameIX(new int[]{2, 3}));
        System.out.println(stoneGameIX(new int[]{2, 3}));
        System.out.println(stoneGameIX(new int[]{2, 3}));
    }

    /**
     * 参考：<a href="https://leetcode-cn.com/problems/stone-game-ix/comments/">评论@beginning</a>
     *
     * @param stones
     * @return
     */
    public static boolean stoneGameIX(int[] stones) {
        /**
         * remainderCount[i]表示个数对3取模余数为i的石头的堆数
         */
        int[] remainderCount = new int[3];

        for (int stone : stones) {
            remainderCount[stone % 3]++;
        }
        /**
         * 因为如果已经被拿走的石头总个数为3的倍数时，最后拿石头的人会输，所以第一个拿石头的Alice只能拿1个或者2个石头，此时Bob
         * 只能相应地拿1个或者2个石头才能不输，继而形成序列【1、1、2、1、2、1、2……】或者【2、2、1、2、1、2、1……】。
         *
         * 对于0个一堆的石头，假设一个人拿了0个一堆的石头，另一个人总是可以也拿0个一堆的石头，相抵消，对序列没有影响。因此如果0
         * 个一堆的石头个数为偶数，则对结果没有影响；如果为奇数则会使结果相反，因为相当于Alice多拿一次石头，但是这步操作对结果没
         * 有影响，此时回合轮到Bob，Bob可以用Alice的策略反过来对付Alice。
         *
         * 1、当0个一堆的石头堆数为偶数，即这部分石碓对序列不会有影响时：
         *
         * 考虑余下的石头，如果剩下的石头都是1个一堆，假设1个一堆的石头堆数为1，则Alice拿完后Bob无石头可拿，Alice输；假设1个一
         * 堆的石头堆数为2，则Alice先拿，Bob再拿后Alice无石头可拿，Alice输；假设1个一堆的石头堆数为3，则Alice第二次拿完后被
         * 拿走的石头总个数为3，被3整除，Alice输，因此无论如何Alice会输。同理如果剩下的石头都是2个一堆，无论如何Alice会输，理
         * 由同上。如果剩下没有石头，Alice直接没有石头可拿，Alice输。
         *
         * 如果1个一堆的石头和2个一堆的石头堆数相等，Alice不论先拿1个一堆还是2个一堆，总是会轮到Bob拿最后剩下的2个一堆或者1个一
         * 堆，使得被拿走的石头总个数为3的倍数，Alice胜。
         *
         * 如果1个一堆的石头和2个一堆的石头堆数不相等，Alice只需拿堆数较少的那个，总是会在轮到Bob拿的时候使得被拿走的石头总个数
         * 为3的倍数，Alice胜。
         *
         * 2、当0个一堆的石头堆数为奇数，即这部分石碓会使得结果相反时：
         *
         * 只有当1个一堆的石头和2个一堆的石头堆数之差大于2，Alice先手拿较多的那一堆，例如是1个一堆的，Bob后手只能拿0个一堆的石
         * 头或者也继续拿1个一堆的。如果Bob拿0个一堆的石头，则此时的情景和第一种情况类似，剩余偶数个0个一堆的石头对接下去的结果
         * 没有影响，剩余1个一堆的石头多余2个一堆的石头，Alice继续拿1个一堆的石头，继而形成序列【1、3】【1、2、1、2……、1】，
         * 因为剩余的1个一堆的石头比2个一堆的石头至少多一堆，最先轮到Bob没有2个一堆的石头可拿，只能拿1个一堆的石头，此时被拿走的
         * 石头总个数为3的倍数，Alice胜。
         *
         * 如果1个一堆的石头和2个一堆的石头堆数之差不大于2，Alice先手拿较多的那一堆，例如是1个一堆的，Bob后手只能拿0个一堆的石
         * 头或者也继续拿1个一堆的。如果Bob拿0个一堆的石头，则此时的情景和第一种情况类似，剩余偶数个0个一堆的石头对接下去的结果
         * 没有影响，剩余1个一堆的石头和2个一堆的石头堆数之差不大于1，Alice继续拿1个一堆的石头，继而形成序列【1、3】【1、2、1
         * 、2……】，最先轮到Bob没有2个一堆的石头可拿或者Alice没有1个一堆的石头可拿或者轮到Alice时只能拿2个一堆的石头使得被拿
         * 走的石头总个数为3的倍数（分别对应剩余1个一堆的石头比2个一堆的石头多一堆、剩余1个一堆的石头和2个一堆的石头一样多、1个
         * 一堆的石头比2个一堆的石头少一堆），无论什么情况都是Alice输。
         */
        if (remainderCount[0] % 2 == 0) {
            return !(remainderCount[1] == 0 || remainderCount[2] == 0);
        } else {
            return Math.abs(remainderCount[1] - remainderCount[2]) > 2;
        }
    }
}
