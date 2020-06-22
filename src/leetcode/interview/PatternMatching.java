package leetcode.interview;

import java.util.Objects;

/**
 * Description: 面试题 16.18. 模式匹配
 *
 * @author Baltan
 * @date 2020-06-22 08:43
 */
public class PatternMatching {
    public static void main(String[] args) {
        System.out.println(patternMatching("bbaba", "ajocitdfyhohchqvilvdjjocitdfyhohchqvilvdj"));
        System.out.println(patternMatching("bbbaa", "xxxxxxy"));
        System.out.println(patternMatching("bbb", "xxxxxx"));
        System.out.println(patternMatching("abba", "dogcatcatdog"));
        System.out.println(patternMatching("abba", "dogcatcatfish"));
        System.out.println(patternMatching("aaaa", "dogcatcatdog"));
        System.out.println(patternMatching("abba", "dogdogdogdog"));
        System.out.println(patternMatching("", ""));
        System.out.println(patternMatching("ab", ""));
    }

    public static boolean patternMatching(String pattern, String value) {
        /**
         * 如果pattern为""，当value为""时，a和b代表任意不相等的字符串都能使pattern匹配value，返回true，
         * 否则pattern一定无法匹配非""的value，返回false
         */
        if (pattern.length() == 0) {
            return value.length() == 0;
        }

        int length = value.length();
        /**
         * pattern中"a"的个数
         */
        int aCount = 0;
        int bCount = 0;
        /**
         * pattern中"b"的个数
         */
        char[] charArray = pattern.toCharArray();

        for (char c : charArray) {
            if (c == 'a') {
                aCount++;
            } else {
                bCount++;
            }
        }

        if (bCount == 0) {
            return onePatternMatching(value, length, aCount);
        } else if (aCount == 0) {
            return onePatternMatching(value, length, bCount);
        } else {
            return twoPatternMatching(value, length, aCount, bCount, charArray);
        }
    }

    /**
     * 当pattern中只有"a"或"b"一种字符时
     *
     * @param value
     * @param length
     * @param patternCount
     * @return
     */
    public static boolean onePatternMatching(String value, int length, int patternCount) {
        /**
         * 当value的长度length不能等分为patternCount份时，pattern一定无法匹配value
         */
        if (length % patternCount != 0) {
            return false;
        }
        /**
         * pattern中每一个字符代表的字符串的长度
         */
        int aLength = length / patternCount;
        /**
         * value中第一个长度为aLength的子串
         */
        String aStr = value.substring(0, aLength);
        /**
         * value中截取长度为aLength的子串的起始索引
         */
        int start = aLength;
        /**
         * 依次判断value中每个长度为aLength的子串是否和aStr相同，只要有一个不同，pattern就无法匹配value
         */
        while (start < length) {
            String subStr = value.substring(start, start + aLength);

            if (!Objects.equals(aStr, subStr)) {
                return false;
            }
            start += aLength;
        }
        return true;
    }

    /**
     * 当pattern中有"a"和"b"两种字符时
     *
     * @param value
     * @param length
     * @param aCount
     * @param bCount
     * @param charArray
     * @return
     */
    public static boolean twoPatternMatching(String value, int length, int aCount, int bCount,
                                             char[] charArray) {
        /**
         * pattern中字符"a"代表的字符串长度范围为[0,length]，从短到长尝试"a"代表的字符串的所有情况
         */
        outer:
        for (int aLength = 0; aLength <= length; aLength++) {
            /**
             * 如果aCount个长度为aLength的子串总长度超过length，pattern就无法匹配value，并且更长的子串
             * 的长度也不可能使pattern匹配value
             */
            if (length - aLength * aCount < 0) {
                return false;
            }
            /**
             * 如果除去pattern中字符"a"代表的字符串，value中剩余的长度不能等分为bCount份时，pattern一定
             * 无法匹配value
             */
            if ((length - aLength * aCount) % bCount != 0) {
                continue;
            }
            /**
             * pattern中字符"b"代表的字符串的长度
             */
            int bLength = (length - aLength * aCount) / bCount;
            /**
             * pattern中字符"a"代表的字符串
             */
            String aStr = null;
            /**
             * pattern中字符"b"代表的字符串
             */
            String bStr = null;
            /**
             * value中截取长度为aLength或bLength的子串的起始索引
             */
            int start = 0;

            for (char c : charArray) {
                if (c == 'a') {
                    String subStr = value.substring(start, start + aLength);

                    if (Objects.isNull(aStr)) {
                        aStr = subStr;
                    } else {
                        /**
                         * 如果当前"a"代表的字符串和之前的"a"代表的字符串不同，当前"a"和"b"无法使
                         * pattern匹配value
                         */
                        if (!Objects.equals(aStr, subStr)) {
                            continue outer;
                        }
                    }
                    /**
                     * 如果"a"和"b"代表的字符串相同，不符合题意，当前"a"和"b"无法使pattern匹配value
                     */
                    if (Objects.equals(aStr, bStr)) {
                        continue outer;
                    }
                    start += aLength;
                } else {
                    String subStr = value.substring(start, start + bLength);

                    if (Objects.isNull(bStr)) {
                        bStr = subStr;
                    } else {
                        /**
                         * 如果当前"b"代表的字符串和之前的"b"代表的字符串不同，当前"a"和"b"无法使
                         * pattern匹配value
                         */
                        if (!Objects.equals(bStr, subStr)) {
                            continue outer;
                        }
                    }
                    /**
                     * 如果"a"和"b"代表的字符串相同，不符合题意，当前"a"和"b"无法使pattern匹配value
                     */
                    if (Objects.equals(aStr, bStr)) {
                        continue outer;
                    }
                    start += bLength;
                }
            }
            return true;
        }
        return false;
    }
}
