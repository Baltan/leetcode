package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 679. 24 Game
 *
 * @author Baltan
 * @date 2019-08-16 09:01
 */
public class JudgePoint24 {
    public static void main(String[] args) {
        System.out.println(judgePoint24(new int[]{4, 1, 8, 7}));
        System.out.println(judgePoint24(new int[]{1, 2, 1, 2}));
        System.out.println(judgePoint24(new int[]{3, 3, 8, 8}));
        System.out.println(judgePoint24(new int[]{3, 3, 3, 3}));
        System.out.println(judgePoint24(new int[]{4, 4, 4, 4}));
        System.out.println(judgePoint24(new int[]{5, 5, 5, 5}));
        System.out.println(judgePoint24(new int[]{6, 6, 6, 6}));
        System.out.println(judgePoint24(new int[]{7, 7, 7, 7}));
        System.out.println(judgePoint24(new int[]{1, 2, 3, 4}));
        System.out.println(judgePoint24(new int[]{7, 3, 7, 3}));
        System.out.println(judgePoint24(new int[]{3, 9, 7, 7}));
    }

    public static boolean judgePoint24(int[] nums) {
        /**
         * 一个很接近于0的数字，用于回避浮点数计算不够精确的问题
         */
        final double THRESHOLD = 0.0000001;
        Set<Double> s1;
        Set<Double> s2;

        s1 = help(nums[0], nums[1]);
        s2 = help(nums[2], nums[3]);
        /**
         * 先用nums[0]和nums[1]计算，再用nums[2]和nums[3]计算，判断两组结果相互计算能不能获得24
         */
        if (help(s1, s2)) {
            return true;
        }
        /**
         * 先用nums[0]和nums[1]计算，再用上述结果和nums[2]计算，再用上述结果和nums[3]计算，判断能不能获得24；
         * 先用nums[0]和nums[1]计算，再用上述结果和nums[3]计算，再用上述结果和nums[2]计算，判断能不能获得24
         */
        if (help(s1, nums[2], nums[3], THRESHOLD)) {
            return true;
        }
        /**
         * 先用nums[2]和nums[3]计算，再用上述结果和nums[0]计算，再用上述结果和nums[1]计算，判断能不能获得24；
         * 先用nums[2]和nums[3]计算，再用上述结果和nums[1]计算，再用上述结果和nums[0]计算，判断能不能获得24
         */
        if (help(s2, nums[0], nums[1], THRESHOLD)) {
            return true;
        }

        s1 = help(nums[0], nums[2]);
        s2 = help(nums[1], nums[3]);
        /**
         * 先用nums[0]和nums[2]计算，再用nums[1]和nums[3]计算，判断两组结果相互计算能不能获得24
         */
        if (help(s1, s2)) {
            return true;
        }
        /**
         * 先用nums[0]和nums[2]计算，再用上述结果和nums[1]计算，再用上述结果和nums[3]计算，判断能不能获得24；
         * 先用nums[0]和nums[2]计算，再用上述结果和nums[3]计算，再用上述结果和nums[1]计算，判断能不能获得24
         */
        if (help(s1, nums[1], nums[3], THRESHOLD)) {
            return true;
        }
        /**
         * 先用nums[1]和nums[3]计算，再用上述结果和nums[0]计算，再用上述结果和nums[2]计算，判断能不能获得24；
         * 先用nums[1]和nums[3]计算，再用上述结果和nums[2]计算，再用上述结果和nums[0]计算，判断能不能获得24
         */
        if (help(s2, nums[0], nums[2], THRESHOLD)) {
            return true;
        }

        s1 = help(nums[0], nums[3]);
        s2 = help(nums[1], nums[2]);
        /**
         * 先用nums[0]和nums[3]计算，再用nums[1]和nums[2]计算，判断两组结果相互计算能不能获得24
         */
        if (help(s1, s2)) {
            return true;
        }
        /**
         * 先用nums[0]和nums[3]计算，再用上述结果和nums[1]计算，再用上述结果和nums[2]计算，判断能不能获得24；
         * 先用nums[0]和nums[3]计算，再用上述结果和nums[2]计算，再用上述结果和nums[1]计算，判断能不能获得24
         */
        if (help(s1, nums[1], nums[2], THRESHOLD)) {
            return true;
        }
        /**
         * 先用nums[1]和nums[2]计算，再用上述结果和nums[0]计算，再用上述结果和nums[3]计算，判断能不能获得24；
         * 先用nums[1]和nums[2]计算，再用上述结果和nums[3]计算，再用上述结果和nums[0]计算，判断能不能获得24
         */
        if (help(s2, nums[0], nums[3], THRESHOLD)) {
            return true;
        }
        return false;
    }

    /**
     * 两个数可以通过四则运算可以获得的所有结果
     *
     * @param num1
     * @param num2
     * @return
     */
    public static Set<Double> help(double num1, double num2) {
        Set<Double> results = new HashSet<>();
        results.add(num1 + num2);
        results.add(num1 - num2);
        results.add(num2 - num1);
        results.add(num1 * num2);
        results.add(num1 / num2);
        results.add(num2 / num1);
        return results;
    }

    /**
     * 将四个数两两分组计算，判断是否能获得24
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean help(Set<Double> s1, Set<Double> s2) {
        for (Double value : s1) {
            if (value == 0) {
                if (s2.contains(24)) {
                    return true;
                }
            } else {
                if (s2.contains(24 - value)) {
                    return true;
                } else if (s2.contains(24 + value)) {
                    return true;
                } else if (s2.contains(value - 24)) {
                    return true;
                } else if (s2.contains(24 / value)) {
                    return true;
                } else if (s2.contains(24 * value)) {
                    return true;
                } else if (s2.contains(value / 24)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 将四个数一三分组计算，判断是否能获得24，threshold是一个很接近于0的数字，用于回避浮点数计算不够精确的问题
     *
     * @param set
     * @param value1
     * @param value2
     * @param threshold
     * @return
     */
    public static boolean help(Set<Double> set, double value1, double value2, double threshold) {
        Set<Double> s;

        for (Double num : set) {
            s = help(num, value1);

            for (Double value : s) {
                if (value == 0) {
                    if (value2 == 24) {
                        return true;
                    }
                } else {
                    if (Math.abs(value2 - (24 - value)) < threshold) {
                        return true;
                    } else if (Math.abs(value2 - (24 + value)) < threshold) {
                        return true;
                    } else if (Math.abs(value2 - (value - 24)) < threshold) {
                        return true;
                    } else if (Math.abs(value2 - (24 / value)) < threshold) {
                        return true;
                    } else if (Math.abs(value2 - (24 * value)) < threshold) {
                        return true;
                    } else if (Math.abs(value2 - (value / 24)) < threshold) {
                        return true;
                    }
                }
            }
        }

        for (Double num : set) {
            s = help(num, value2);

            for (Double value : s) {
                if (value == 0) {
                    if (value1 == 24) {
                        return true;
                    }
                } else {
                    if (Math.abs(value1 - (24 - value)) < threshold) {
                        return true;
                    } else if (Math.abs(value1 - (24 + value)) < threshold) {
                        return true;
                    } else if (Math.abs(value1 - (value - 24)) < threshold) {
                        return true;
                    } else if (Math.abs(value1 - (24 / value)) < threshold) {
                        return true;
                    } else if (Math.abs(value1 - (24 * value)) < threshold) {
                        return true;
                    } else if (Math.abs(value1 - (value / 24)) < threshold) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
