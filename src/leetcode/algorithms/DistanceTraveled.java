package leetcode.algorithms;

/**
 * Description: 2739. Total Distance Traveled
 *
 * @author Baltan
 * @date 2023/6/18 19:44
 */
public class DistanceTraveled {
    public static void main(String[] args) {
        System.out.println(distanceTraveled(5, 10));
        System.out.println(distanceTraveled(1, 2));
    }

    public static int distanceTraveled(int mainTank, int additionalTank) {
        int result = 0;

        while (mainTank >= 5) {
            /**
             * 从副油箱可以补油到主油箱的最大次数
             */
            int times = mainTank / 5;
            /**
             * 主油箱消耗了times*5升油，使卡车前进了times*50公里
             */
            result += times * 10 * 5;
            /**
             * 从副油箱向主油箱补油的次数，也为补油的体积
             */
            int transfer = Math.min(additionalTank, times);
            /**
             * 主油箱消耗了times*5升油，又补充了transfer升油
             */
            mainTank = mainTank - 5 * times + transfer;
            /**
             * 副油箱剩余油量
             */
            additionalTank -= transfer;
        }
        /**
         * 主油箱中剩余的油量还能使卡车前进mainTank*10公里
         */
        return result + mainTank * 10;
    }
}
