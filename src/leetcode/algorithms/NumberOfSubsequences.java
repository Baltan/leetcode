package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 3404. Count Special Subsequences
 *
 * @author Baltan
 * @date 2025/1/2 23:23
 */
public class NumberOfSubsequences {
    public static void main(String[] args) {
        System.out.println(numberOfSubsequences(new int[]{429, 687, 278, 349, 606, 176, 505, 145, 105, 120, 293, 90, 726, 942, 761, 623, 135, 158, 143, 855, 216, 778, 991, 263, 19, 367, 916, 12, 233, 111, 948, 205, 547, 63, 313, 834, 496, 76, 113, 499, 861, 402, 611, 494, 279, 441, 95, 984, 999, 331, 65, 365, 792, 969, 923, 360, 816, 461, 929, 701, 229, 808, 138, 591, 988, 434, 434, 453, 693, 535, 843, 660, 387, 785, 103, 756, 184, 774, 230, 366, 700, 157, 802, 541, 257, 148, 793, 391, 360, 509, 303, 160, 659, 759, 674, 84, 669, 593, 114, 72, 688, 933, 21, 690, 793, 743, 238, 973, 439, 857, 506, 565, 801, 879, 361, 552, 95, 956, 96, 514, 119, 728, 382, 314, 138, 293, 105, 921, 803, 861, 739, 818, 696, 932, 223, 863, 590, 204, 391, 660, 161, 532, 921, 938, 517, 94, 205, 747, 651, 727, 222, 253, 448, 753, 455, 762, 198, 528, 664, 582, 837, 789, 169, 917, 108, 477, 325, 935, 500, 751, 147, 628, 148, 724, 711, 7, 96, 504, 672, 264, 302, 697, 300, 159, 457, 246, 642, 449, 184, 104, 552, 779, 512, 428, 784, 286, 250, 689, 856, 905, 784, 298, 328, 295, 133, 687, 460, 66, 710, 376, 630, 921, 158, 670, 541, 386, 260, 560, 835, 328, 511, 157, 263, 406, 751, 594, 829, 817, 689, 768, 177, 289, 234, 614, 109, 20, 3, 256, 59, 760, 240, 869, 649, 833, 517, 757, 591, 916, 516, 847, 68, 169, 891, 596, 100, 870, 402, 873, 467, 324, 777, 821, 758, 75, 509, 572, 925, 304, 598, 427, 644, 851, 632, 773, 11, 954, 141, 911, 507, 687, 351, 252, 587, 14, 31, 778, 580, 222, 572, 581, 700, 537, 858, 960, 216, 252, 58, 469, 888, 207, 745, 565, 543, 465, 947, 628, 235, 770, 598, 552, 964, 138, 570, 338, 125, 520, 302, 334, 468, 934, 630, 144, 740, 657, 458, 926, 665, 215, 847, 978, 458, 772, 800, 526, 937, 546, 148, 241, 356, 306, 608, 186, 358, 679, 876, 249, 748, 551, 328, 36, 513, 570, 103, 64, 510, 15, 431, 446, 901, 324, 526, 429, 417, 978, 119, 347, 201, 100, 960, 589, 269, 64, 446, 552, 909, 109, 900, 160, 873, 547, 281, 359, 260, 215, 972, 724, 385, 577, 350, 126, 97, 626, 828, 355, 696, 313, 55, 934, 385, 566, 212, 450, 920, 709, 600, 757, 512, 510, 753, 854, 822, 661, 723, 801, 356, 804, 144, 845, 552, 684, 400, 393, 636, 524, 207, 953, 747, 191, 110, 253, 198, 163, 384, 775, 161, 937, 993, 113, 10, 190, 680, 537, 280, 895, 167, 326, 114, 634, 335, 293, 610, 491, 525, 636, 732, 181, 562, 481, 743, 429, 165, 600, 100, 903, 603, 682, 581, 470, 775, 863, 432, 744, 414, 517, 117, 637, 956, 957, 146, 812, 519, 490, 978, 146, 902, 808, 898, 695, 448, 405, 915, 544, 961, 887, 518, 816, 459, 407, 737, 646, 780, 347, 69, 431, 289, 470, 103, 897, 690, 55, 28, 856, 155, 979, 733, 237, 625, 757, 407, 285, 734, 185, 969, 482, 28, 237, 330, 931, 835, 278, 313, 869, 315, 217, 542, 476, 8, 284, 301, 461, 501, 985, 350, 182, 543, 530, 666, 626, 10, 595, 370, 429, 845, 184, 595, 810, 771, 575, 3, 859, 476, 296, 43, 969, 255, 795, 896, 68, 86, 140, 268, 232, 209, 896, 692, 727, 841, 495, 648, 81, 597, 863, 480, 98, 412, 253, 652, 750, 740, 435, 730, 32, 190, 640, 606, 552, 381, 781, 879, 176, 686, 380, 316, 810, 570, 744, 65, 771, 476, 638, 745, 861, 787, 725, 761, 204, 967, 518, 463, 293, 872, 56, 1, 204, 924, 803, 403, 191, 699, 294, 528, 961, 194, 710, 471, 576, 595, 794, 399, 287, 114, 894, 686, 223, 6, 117, 731, 667, 986, 293, 375, 584, 532, 13, 895, 535, 256, 639, 972, 370, 668, 243, 499, 650, 590, 620, 826, 55, 319, 447, 440, 335, 341, 982, 760, 589, 432, 272, 673, 87, 805, 318, 728, 372, 764, 795, 849, 616, 766, 366, 483, 294, 741, 872, 837, 673, 705, 242, 775, 966, 564, 722, 727, 37, 568, 367, 329, 336, 948, 863, 358, 203, 224, 831, 840, 310, 693, 74, 664, 68, 223, 268, 557, 992, 128, 832, 605, 645, 805, 373, 229, 366, 306, 126, 464, 505, 678, 764, 883, 262, 506, 539, 150, 472, 731, 951, 924, 909, 313, 109, 233, 559, 906, 547, 181, 910}));
        System.out.println(numberOfSubsequences(new int[]{10, 15, 3, 5, 13, 10, 19}));
        System.out.println(numberOfSubsequences(new int[]{1, 2, 3, 4, 3, 6, 1}));
        System.out.println(numberOfSubsequences(new int[]{3, 4, 3, 4, 3, 4, 3, 4}));
    }

    public static long numberOfSubsequences(int[] nums) {
        long result = 0L;
        int length = nums.length;
        /**
         * 根据题意，nums[p]*nums[r]==nums[q]*nums[s]，即nums[p]/nums[q]=nums[s]/nums[r]。对于元素nums[r]，map[i]表示当q不大于
         * r-2时，nums[p]/nums[q]的值为i的所有数对(nums[p],nums[q])的个数
         */
        Map<Double, Integer> map = new HashMap<>();
        /**
         * 根据题意，r不可能小于4，所以需要计算r为4的情况时，必须先已知q不大于2时数对(nums[p],nums[q])的个数，此时只有一个符合题意的数对，
         * 即(nums[0],nums[2])
         */
        map.put((double) nums[0] / nums[2], 1);
        /**
         * 枚举所有数对(nums[s],nums[r])，此时q最大为r-2，可以对每个nums[s]/nums[r]，从map中计算得到nums[p]/nums[q]也等于nums[s]/
         * nums[r]的数对的个数
         */
        for (int r = 4; r < length; r++) {
            for (int s = r + 2; s < length; s++) {
                double value = (double) nums[s] / nums[r];
                int count = map.getOrDefault(value, 0);
                result += count;
            }
            /**
             * 更新q不大于r-1时，nums[p]/nums[q]的值为i的情况
             */
            for (int p = r - 3; p >= 0; p--) {
                map.merge((double) nums[p] / nums[r - 1], 1, Integer::sum);
            }
        }
        return result;
    }
}
