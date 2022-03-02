package leetcode.algorithms;

/**
 * Description: LCP 33. 蓄水
 *
 * @author Baltan
 * @date 2022/3/2 16:11
 */
public class StoreWater {
    public static void main(String[] args) {
        int[] bucket1 = {1, 3};
        int[] vat1 = {6, 8};
        System.out.println(storeWater(bucket1, vat1));

        int[] bucket2 = {9, 0, 1};
        int[] vat2 = {0, 2, 2};
        System.out.println(storeWater(bucket2, vat2));

        int[] bucket3 = {3, 2, 5};
        int[] vat3 = {0, 0, 0};
        System.out.println(storeWater(bucket3, vat3));

        int[] bucket4 =
                {9988, 5017, 5130, 2445, 9896, 9151, 3625, 7801, 608, 3283, 1386, 979, 5209, 4182, 8234, 9870,
                        8714
                        , 6435, 3800, 956, 4006, 5620, 7474, 1205, 6993, 3320, 1201, 7593, 905, 3816, 4522,
                        4560, 8027, 8219, 6686, 3779, 2141, 1240, 6504, 6612, 6921, 7329, 8145, 5745, 7652,
                        4340, 7933, 6246, 5157, 9447, 107, 9665, 3653, 2978, 9832, 4945, 4312, 2199, 449,
                        8432, 3230, 8163, 800, 6547, 1110, 1194, 9384, 632, 3275, 1229, 7230, 8643, 7613,
                        8256, 5043, 1288, 3088, 8997, 4554, 4755, 7433, 8146, 9722, 3469, 8863, 5831, 7816,
                        5058, 4316, 7946, 8402, 975, 2450, 4958, 9811, 9336, 21, 9309, 8999, 56};
        int[] vat4 =
                {9991, 6973, 7192, 9876, 9910, 9549, 3700, 8814, 1308, 9981, 9234, 7292, 7732, 8458, 8441,
                        9939, 9621, 7285, 7452, 2718, 6589, 7555, 8788, 3202, 7832, 4781, 8798, 9299, 2112,
                        9963, 8755, 7240, 9217, 8587, 6782, 9703, 8954, 3759, 6907, 7218, 7333, 8020, 8323,
                        5750, 9510, 8571, 8664, 8510, 9363, 9741, 8643, 9825, 4227, 8530, 9961, 8511, 8949,
                        7486, 9086, 9690, 5316, 9581, 9314, 8817, 7234, 8998, 9485, 5394, 7365, 1501, 7984,
                        9802, 9778, 8314, 7482, 7117, 5117, 9609, 8732, 9728, 9330, 8800, 9775, 6210, 8966,
                        7700, 8802, 7607, 8950, 9730, 9855, 1231, 5228, 5329, 9982, 9532, 3230, 9951, 9034,
                        8299};
        System.out.println(storeWater(bucket4, vat4));
    }

    public static int storeWater(int[] bucket, int[] vat) {
        int result = Integer.MAX_VALUE;
        int length = bucket.length;
        /**
         * 所有水缸的最大容量
         */
        int maxCapacity = 0;

        for (int i = 0; i < length; i++) {
            maxCapacity = Math.max(maxCapacity, vat[i]);
        }
        /**
         * 如果所有水缸的容量都为0，则不需要进行任何操作
         */
        if (maxCapacity == 0) {
            return 0;
        }
        /**
         * 枚举蓄水操作的总次数
         */
        for (int i = 1; i <= maxCapacity; i++) {
            /**
             * 所有水桶倒满对应的水缸需要的总操作次数，初始值为需要蓄水操作的次数
             */
            int times = i;

            for (int j = 0; j < length; j++) {
                /**
                 * 水桶的最小容量
                 */
                int capacity = (int) Math.ceil(1.0 * vat[j] / i);
                /**
                 * 如果第j个水桶的容量不足水桶所需的最小容量，则需要进行水桶升级操作，操作次数为两个容量之差
                 */
                if (capacity > bucket[j]) {
                    times += capacity - bucket[j];
                }
            }
            /**
             * 更新总操作次数的最小值
             */
            result = Math.min(result, times);
        }
        return result;
    }
}
