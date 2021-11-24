package leetcode.algorithms;

/**
 * Description: 2043. Simple Bank System
 *
 * @author Baltan
 * @date 2021/11/19 10:43
 */
public class Bank {
    public static void main(String[] args) {
        Bank bank1 = new Bank(new long[]{10, 100, 20, 50, 30});
        System.out.println(bank1.withdraw(3, 10));
        System.out.println(bank1.transfer(5, 1, 20));
        System.out.println(bank1.deposit(5, 20));
        System.out.println(bank1.transfer(3, 4, 15));
        System.out.println(bank1.withdraw(10, 50));

        Bank bank2 = new Bank(
                new long[]{7070, 4948, 770, 1881, 5988, 6120, 4221, 1430, 1809, 3438, 9381, 5440, 5847,
                        1145, 5751, 1431, 5036, 3461, 5095, 4098, 9157, 3252, 491, 9758, 9726, 1691, 2488,
                        4390, 2948, 9658, 6823, 9956, 8917, 877, 8233, 5084, 4772, 8928, 8359, 1196, 7864,
                        9764, 6035, 2528, 5792, 5247, 6134, 4763, 9544, 6948, 8429, 2183, 9358, 7959, 4631,
                        1487, 1936, 8825, 7822, 2167, 2087, 505, 5703, 6796, 850, 7041, 6712, 6548, 1379,
                        3357, 3833, 7026, 7354, 3397, 8665, 9995, 9532, 4483, 9994, 9954, 50, 2071, 4131,
                        7921, 2386, 5226, 2470, 7628, 6232, 4175, 1595, 7684, 5434, 2062, 6864, 4101, 6122,
                        7620, 7918, 6374, 4660, 1268, 4260, 2406, 1496, 8782, 2690, 7944, 8579, 1494, 5992,
                        5937, 7341, 8824, 3124, 663, 7036, 8447, 8749, 7618, 5926, 4504, 7069, 1484, 8133,
                        3965, 8894, 7487, 1786, 932, 4081, 6096, 51, 5822, 2529, 8903, 3052, 2924, 8605, 6922,
                        8684, 4565, 9170, 7514, 404, 510, 4328, 1322, 6424, 8457, 7456, 136, 4472, 868, 9562,
                        1527, 4561, 6750, 4247, 8948, 2183, 6956, 8742, 245, 3211, 1612, 793, 9706, 335, 2952,
                        3663, 347, 1084, 6718, 2500, 1173, 4484, 2908, 2114, 7774, 3777, 1908, 8392, 4356,
                        4934, 7958, 5475, 3855, 1266, 5037, 4447, 4692, 7497, 9881, 1263, 8126, 5411, 429,
                        7878, 8199, 6346, 781, 9130, 80, 5329, 8888, 6028, 4460, 5164, 8174, 2374, 3773, 584,
                        4170, 8063, 4447, 9168, 4967, 2323, 4414, 9896, 9778, 7131, 7791, 1851, 3483, 7543,
                        5412, 636, 9977, 9870, 585, 5990, 4534, 708, 42, 3624, 4733, 9023, 6220, 2270, 1874,
                        3001, 7135, 1088, 1678, 5679, 3768, 4340, 2972, 4888, 9809, 2790, 4427, 2064, 3552,
                        5825, 7431, 2312, 3925, 6487, 6036, 3936, 1196, 9597, 4765, 1248, 9126, 905, 8252,
                        8300, 9696, 6699, 6293, 6811, 9159, 7804, 7295, 2563, 3028, 3861, 4490, 6009, 6011,
                        7916, 9028, 9354, 3367, 6038, 8693, 7135, 6025, 7243, 9326, 6842, 701, 4520, 7018,
                        8162, 9699, 4016, 6568, 386, 494, 274, 2695, 5837, 1278, 227, 6679, 5519, 8855, 2771,
                        4380, 3369, 4025, 8199, 75, 2803, 8862, 75, 8627, 802, 194, 4303, 4192, 6952, 9012,
                        9321, 1834, 4823, 2085, 8093, 4029, 9464, 1669, 6564, 3998, 9838, 9617, 8929, 5848,
                        348, 6949, 5726, 4650, 9693, 1639, 8182, 9924, 9505, 8230, 7299, 4315, 7936, 8073,
                        2258, 2013, 7189, 5957, 5757, 2439, 4249, 8121, 6268, 3557, 6029, 4110, 5467, 9661,
                        2788, 9318, 2569, 651, 7504, 3382, 3312, 8642, 9736, 9235, 4095, 5151, 445, 468, 744,
                        25, 3182, 8242, 180, 1554, 5387, 4529, 2874, 9909, 1577, 929, 263, 7638, 9603, 5360,
                        4395, 6319, 9897, 5073, 1954, 426, 4667, 943, 3582, 3646, 2727, 6466, 8036, 5248,
                        6364, 6800, 1615, 6413, 1081, 3640, 1201, 4139, 9323, 8404, 1286, 2514, 1415, 2861,
                        8853, 8963, 8454, 6507, 4639, 3779, 2639, 2943, 8864, 8737, 491, 9473, 4165, 1927,
                        3257, 7435, 6843, 5507, 512, 9278, 7776, 1677, 1771, 6602, 6933, 6793, 2826, 6864,
                        8414, 736, 940, 925, 9004, 3154, 568, 4746, 218, 3138, 7136, 15, 1583, 9683, 8953,
                        9389, 5504, 9032, 6713, 8125, 3723, 9986, 5799, 4368, 5407, 6649, 4440, 2449, 8929,
                        3931, 8572, 897, 1183, 8700, 6302, 4220, 7079, 606, 1997, 3320, 3972, 1665, 7040,
                        5498, 183, 9913, 7578, 7960, 2693, 7350, 2695, 4119, 8687, 9768, 9750, 3194, 8094,
                        4217, 2685, 517, 5405, 643, 8330, 709, 5094, 1785, 7373, 9959, 9744, 8258, 9817, 9125,
                        2108, 2399, 2829, 7452, 7959, 7445, 691, 8593, 2607, 9654, 6818, 1229, 9627, 8351,
                        6534, 2638, 1404, 4351, 5570, 2592, 2449, 6346, 9682, 8385, 3301, 3446, 9827, 3892,
                        7905, 7993, 9453, 9130, 3539, 1329, 5509, 1480, 3923, 4281, 2023, 2831, 4094, 325,
                        2525, 298, 4585, 1504, 9083, 8083, 2549, 8935, 6434, 8693, 8390, 8946, 3759, 6957,
                        1920, 9872, 3330, 2548, 7869, 9895, 4396, 3427, 9233, 3454, 8025, 1223, 645, 2683,
                        839, 6973, 6312, 3088, 6144, 5787, 4069, 7490, 6861, 8064, 3078, 6062, 29, 8112, 9105,
                        9435, 6905, 1194, 7444, 2481, 375, 7504, 8987, 5733, 6958, 8267, 8278, 6778, 6425,
                        566, 2751, 9991, 4960, 5293, 6992, 9922, 7566, 4263, 5549, 1869, 3827, 6242, 9912,
                        3500, 2993, 89, 2724, 4124, 6707, 9892, 6036, 9428, 1764, 1366, 7572, 7006, 6514,
                        6895, 5714, 501, 6816, 2610, 8596, 6374, 8250, 1172, 8538, 7761, 4758, 4823, 5837,
                        4523, 9108, 6070, 9439, 3384, 6145, 1840, 3848, 1181, 9191, 7958, 1016, 4590, 2825,
                        9447, 6935, 6521, 3495, 1705, 8347, 62, 4941, 9374, 5294, 3799, 3905, 1225, 3139,
                        4678, 2254, 2912, 4717, 6936, 4152, 2818, 4106, 7612, 9055, 7652, 8776, 2090, 5871,
                        507, 510, 9518, 103, 4866, 745, 8437, 4663, 8084, 8304, 1019, 6603, 1102, 4566, 9744,
                        5208, 8751, 4109, 7437, 7145, 6275, 7022, 4829, 855, 9119, 547, 8207, 2321, 481, 9566,
                        6055, 8689, 370, 1331, 4270, 6673, 7286, 7907, 1837, 5802, 2954, 4798, 345, 8622,
                        7509, 6777, 2609});
        System.out.println(bank2.deposit(105, 2521));
        System.out.println(bank2.transfer(577, 1522, 4860));
        System.out.println(bank2.transfer(537, 736, 786));
        System.out.println(bank2.transfer(271, 751, 5424));
        System.out.println(bank2.deposit(3699, 1787));
        System.out.println(bank2.transfer(618, 264, 4576));
        System.out.println(bank2.withdraw(359, 9799));
        System.out.println(bank2.withdraw(745, 1872));
    }

    /**
     * 保存每个账户的余额
     */
    private long[] balance;
    /**
     * 存在的账户数量
     */
    private int balanceNum;

    public Bank(long[] balance) {
        this.balance = new long[balance.length + 1];
        this.balanceNum = balance.length;

        for (int i = 0; i < balance.length; i++) {
            this.balance[i + 1] = balance[i];
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        /**
         * 判断账户是否存在或者转出账户余额是否足够
         */
        if (account1 > balanceNum || account2 > balanceNum || balance[account1] < money) {
            return false;
        }
        balance[account1] -= money;
        balance[account2] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        /**
         * 判断账户是否存在
         */
        if (account > balanceNum) {
            return false;
        }

        balance[account] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        /**
         * 判断账户是否存在或者转出账户余额是否足够
         */
        if (account > balanceNum || balance[account] < money) {
            return false;
        }
        balance[account] -= money;
        return true;
    }
}