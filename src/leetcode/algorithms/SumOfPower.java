package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2681. Power of Heroes
 *
 * @author Baltan
 * @date 2023/6/4 18:36
 */
public class SumOfPower {
    public static void main(String[] args) {
        System.out.println(sumOfPower(new int[]{2, 1, 4}));
        System.out.println(sumOfPower(new int[]{1, 1, 1}));
    }

    public static int sumOfPower(int[] nums) {
        long result = 0L;
        int mod = 1000000007;
        int length = nums.length;
        long weight = 0L;
        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            /**
             * 如果排序后的数组nums为[a,b,c,d,e,f,g]，对于最大能力值为a的一组英雄，枚举组中能力的最小值，可能有以下情况：
             * 能力最小值为a：[a]
             * 英雄组的力量之和为a*a*a=a*a*a+a*a*0=a*a*a+a*a*x1
             *
             * 如果排序后的数组nums为[a,b,c,d,e,f,g]，对于最大能力值为b的一组英雄，枚举组中能力的最小值，可能有以下情况：
             * 能力最小值为b：[b]
             * 能力最小值为a：[a,b]
             * 英雄组的力量之和为b*b*(b+a)=b*b*b+b*b*a=b*b*b+b*b*x2
             *
             * 如果排序后的数组nums为[a,b,c,d,e,f,g]，对于最大能力值为c的一组英雄，枚举组中能力的最小值，可能有以下情况：
             * 能力最小值为c：[c]
             * 能力最小值为b：[b,c]
             * 能力最小值为a：[a,c]、[a,b,c]
             * 英雄组的力量之和为c*c*(c+b+a*2)=c*c*c+c*c*(b+a*2)=c*c*c+c*c*x3
             *
             * 如果排序后的数组nums为[a,b,c,d,e,f,g]，对于最大能力值为d的一组英雄，枚举组中能力的最小值，可能有以下情况：
             * 能力最小值为d：[d]
             * 能力最小值为c：[c,d]
             * 能力最小值为b：[b,d]、[b,c,d]
             * 能力最小值为a：[a,d]、[a,b,d]、[a,c,d]、[a,b,c,d]
             * 英雄组的力量之和为d*d*(d+c+b*2+a*4)=d*d*d+d*d*(c+b*2+a*4)=d*d*d+d*d*x4
             *
             * 如果排序后的数组nums为[a,b,c,d,e,f,g]，对于最大能力值为e的一组英雄，枚举组中能力的最小值，可能有以下情况：
             * 能力最小值为e：[e]
             * 能力最小值为d：[d,e]
             * 能力最小值为c：[c,e]、[c,d,e]
             * 能力最小值为b：[b,e]、[b,c,e]、[c,d,e]、[b,c,d,e]
             * 能力最小值为a：[a,e]、[a,b,e]、[a,c,e]、[a,d,e]、[a,b,c,e]、[a,b,d,e]、[a,c,d,e]、[a,b,c,d,e]
             * 英雄组的力量之和为e*e*(e+d+c*2+b*4+a*8)=e*e*e+e*e*(d+c*2+b*4+a*8)=e*e*e+e*e*x5
             *
             * ……
             *
             * 对于以上的系数x1、x2、x3、x4、x5，可得：
             * x2=x1*2+a
             * x3=x2*2+b
             * x4=x3*2+c
             * x5=x4*2+d
             * ……
             * 递推计算即可
             */
            long base = ((long) nums[i] * nums[i]) % mod;
            long part1 = (base * nums[i]) % mod;
            long part2 = (base * weight) % mod;
            result = (((result + part1) % mod) + part2) % mod;
            weight = ((weight * 2) % mod + nums[i]) % mod;
        }
        return (int) result;
    }
}
