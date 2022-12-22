package leetcode.algorithms;

/**
 * Description: 2425. Bitwise XOR of All Pairings
 *
 * @author Baltan
 * @date 2022/12/14 09:34
 */
public class XorAllNums {
    public static void main(String[] args) {
        System.out.println(xorAllNums(new int[]{2, 1, 3}, new int[]{10, 2, 5, 0}));
        System.out.println(xorAllNums(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static int xorAllNums(int[] nums1, int[] nums2) {
        int result = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        /**
         * 假设nums1为[x1,x2,……,xm]，nums2为[y1,y2,……,yn]则所求结果为
         * [(x1^y1)^(x1^y2)^……^(x1^yn)]^[(x2^y1)^(x2^y2)^……^(x2^yn)]^……^[(xm^y1)^(xm^y2)^……^(xm^yn)]
         * =[(x1^x1^……^x1)^(x2^x2^……^x2)^……^(xm^xm^……^xm)]^[(y1^y1^……^y1)^(y2^y2^……^y2)^……^(yn^yn^……^yn)]
         *    length2个x1   length2个x2       length2个xm     length1个y1   length1个y2       length1个yn
         * 如果length1为偶数，则length1个y1、length1个y2、……、length1个yn异或值都为0。同理，如果length2为偶数，则length2个x1、
         * length2个x2、……、length2个xm异或值都为0
         */
        if (length1 % 2 != 0) {
            for (int num : nums2) {
                result ^= num;
            }
        }

        if (length2 % 2 != 0) {
            for (int num : nums1) {
                result ^= num;
            }
        }
        return result;
    }
}
