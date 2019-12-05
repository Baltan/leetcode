package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 927. Three Equal Parts
 *
 * @author Baltan
 * @date 2019-12-05 09:38
 */
public class ThreeEqualParts {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(
                threeEqualParts(new int[]{0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0}));
        OutputUtils.print1DIntegerArray(threeEqualParts(new int[]{1, 0, 1, 0, 1}));
        OutputUtils.print1DIntegerArray(threeEqualParts(new int[]{1, 1, 0, 1, 1}));
        OutputUtils.print1DIntegerArray(threeEqualParts(new int[]{0, 0, 0, 0, 0}));
    }

    public static int[] threeEqualParts(int[] A) {
        int length = A.length;
        /**
         * 数组中1的总个数
         */
        int countOf1 = 0;
        int boundary1;
        int boundary2;

        for (int num : A) {
            if (num == 1) {
                countOf1++;
            }
        }
        /**
         * 如果数组中没有1，有多种分割法，选择第一个0单独作为第一部分，最后一个0单独作为最后一部分，剩余的0作为
         * 第二部分即可
         */
        if (countOf1 == 0) {
            return new int[]{0, length - 1};
        }
        /**
         * 如果数组中1的总个数不为3的倍数，无法完成分割
         */
        if (countOf1 % 3 != 0) {
            return new int[]{-1, -1};
        }
        /**
         * 每一部分1的个数
         */
        int countOf1PerPart = countOf1 / 3;
        /**
         * 第countOf1PerPart个1的索引位置
         */
        int a = -1;
        /**
         * 第countOf1PerPart+1个1的索引位置
         */
        int b = -1;
        /**
         * 第countOf1PerPart*2个1的索引位置
         */
        int c = -1;
        /**
         * 第countOf1PerPart*2+1个1的索引位置
         */
        int d = -1;
        /**
         * 第countOf1PerPart*3（最后一个）个1的索引位置
         */
        int e = -1;
        /**
         * 第1个1的索引位置
         */
        int f = -1;
        int currentCountOf1 = 0;

        for (int i = 0; i < length; i++) {
            if (A[i] == 1) {
                currentCountOf1++;

                if (f == -1 && currentCountOf1 == 1) {
                    f = i;
                }

                if (a == -1 && currentCountOf1 == countOf1PerPart) {
                    a = i;
                }

                if (b == -1 && currentCountOf1 == countOf1PerPart + 1) {
                    b = i;
                }

                if (c == -1 && currentCountOf1 == countOf1PerPart << 1) {
                    c = i;
                }

                if (d == -1 && currentCountOf1 == countOf1PerPart * 2 + 1) {
                    d = i;
                }

                if (e == -1 && currentCountOf1 == countOf1) {
                    e = i;
                }
            }
        }
        /**
         * 数组最后一个1后面的0的个数，即第三部分最后一个1后面0的个数，那么第一、第二部分最后一个1后面0的个数
         * 也必须相同
         */
        int suffixCountOf0 = length - e - 1;
        /**
         * 如果第countOf1PerPart个1后面不足连续suffixCountOf0个0，无法完成分割，否则第一部分最后一个数字的
         * 索引位置为a+suffixCountOf0，分界点为a+suffixCountOf0
         */
        if (a + suffixCountOf0 < b) {
            boundary1 = a + suffixCountOf0;
            /**
             * 如果第countOf1PerPart*2个1后面不足连续suffixCountOf0个0，无法完成分割，否则第二部分最后一
             * 个数字的索引位置为c+suffixCountOf0，分界点为c+suffixCountOf0+1
             */
            if (c + suffixCountOf0 < d) {
                boundary2 = c + suffixCountOf0 + 1;
            } else {
                return new int[]{-1, -1};
            }
        } else {
            return new int[]{-1, -1};
        }
        /**
         * 第一部分数组，不包括前导0，包括所有后缀0
         */
        int[] arr1 = Arrays.copyOfRange(A, f, boundary1 + 1);
        /**
         * 第二部分数组，不包括前导0，包括所有后缀0
         */
        int[] arr2 = Arrays.copyOfRange(A, b, boundary2);
        /**
         * 第三部分数组，不包括前导0，包括所有后缀0
         */
        int[] arr3 = Arrays.copyOfRange(A, d, length);
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int arr3Length = arr3.length;
        /**
         * 如果三个数组的长度不是两两相等的，三个数组表示的二进制值肯定不完全相等，无法完成分隔
         */
        if (arr1Length != arr2Length || arr2Length != arr3Length) {
            return new int[]{-1, -1};
        } else {
            for (int i = 0; i < arr1Length; i++) {
                /**
                 * 如果三个数组的每一位上，有任何一位不是两两相等的，三个数组表示的二进制值肯定不完全相等，
                 * 无法完成分隔
                 */
                if (arr1[i] != arr2[i] || arr2[i] != arr3[i]) {
                    return new int[]{-1, -1};
                }
            }
        }
        return new int[]{boundary1, boundary2};
    }
}
