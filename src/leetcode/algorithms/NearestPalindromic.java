package leetcode.algorithms;

/**
 * Description: Find the Closest Palindrome
 *
 * @author Baltan
 * @date 2019-03-22 11:27
 */
public class NearestPalindromic {
    public static void main(String[] args) {
        System.out.println(nearestPalindromic(""));
        System.out.println(nearestPalindromic("0"));
        System.out.println(nearestPalindromic("9"));
        System.out.println(nearestPalindromic("10"));
        System.out.println(nearestPalindromic("15"));
        System.out.println(nearestPalindromic("55"));
        System.out.println(nearestPalindromic("99"));
        System.out.println(nearestPalindromic("100"));
        System.out.println(nearestPalindromic("123"));
        System.out.println(nearestPalindromic("999"));
        System.out.println(nearestPalindromic("1000"));
        System.out.println(nearestPalindromic("1008"));
        System.out.println(nearestPalindromic("9999"));
        System.out.println(nearestPalindromic("686768"));
        System.out.println(nearestPalindromic("11011"));
    }

    public static String nearestPalindromic(String n) {
        if (n == null) {
            return null;
        }
        if (n.length() == 0) {
            return "";
        }
        if (n.length() == 1) {
            int nInt = Integer.valueOf(n);
            if (nInt > 0) {
                return String.valueOf(nInt - 1);
            } else {
                return "1";
            }
        }

        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        StringBuilder builder3 = new StringBuilder();
        int length = n.length();
        int halfLength = length / 2;
        String firstHalfStr;

        if ((length & 1) == 1) {
            firstHalfStr = n.substring(0, halfLength + 1);
        } else {
            firstHalfStr = n.substring(0, halfLength);
        }

        if ((length & 1) == 1) {
            builder1.append(firstHalfStr).append(reverseFirstHalf(n));
        } else {
            builder1.append(firstHalfStr).append(reverseFirstHalf(n));
        }

        if ((length & 1) == 1) {
            int firstHalfInt = Integer.parseInt(firstHalfStr);
            int firstHaflLessInt = firstHalfInt - 1;
            String firstHaflLessStr = String.valueOf(firstHaflLessInt);
            int firstHaflLessStrLength = firstHaflLessStr.length();

            if (firstHalfStr.length() > firstHaflLessStrLength) {
                for (int i = 0; i < length - 1; i++) {
                    builder2.append("9");
                }
            } else {
                builder2.append(firstHaflLessInt).append(reverse(firstHaflLessStr.substring(0,
                        firstHaflLessStrLength - 1)));
            }
        } else {
            int firstHalfInt = Integer.parseInt(firstHalfStr);
            int firstHaflLessInt = firstHalfInt - 1;
            if (firstHaflLessInt == 0) {
                builder2.append("9");
            } else {
                String firstHaflLessStr = String.valueOf(firstHaflLessInt);
                int firstHaflLessStrLength = firstHaflLessStr.length();

                if (firstHalfStr.length() > firstHaflLessStrLength) {
                    for (int i = 0; i < length - 1; i++) {
                        builder2.append("9");
                    }
                } else {
                    builder2.append(firstHaflLessStr).append(reverse(firstHaflLessStr));
                }
            }
        }

        if ((length & 1) == 1) {
            int firstHalfInt = Integer.parseInt(firstHalfStr);
            int firstHaflMoreInt = firstHalfInt + 1;
            String firstHaflMoreStr = String.valueOf(firstHaflMoreInt);
            int firstHaflMoreStrLength = firstHaflMoreStr.length();

            if (firstHalfStr.length() < firstHaflMoreStrLength) {
                builder3.append("1");
                for (int i = 0; i < length - 1; i++) {
                    builder3.append("0");
                }
                builder3.append("1");
            } else {
                builder3.append(firstHaflMoreStr).append(reverse(firstHaflMoreStr.substring(0,
                        firstHaflMoreStrLength - 1)));
            }
        } else {
            int firstHalfInt = Integer.parseInt(firstHalfStr);
            int firstHaflMoreInt = firstHalfInt + 1;
            String firstHaflMoreStr = String.valueOf(firstHaflMoreInt);
            int firstHaflMoreStrLength = firstHaflMoreStr.length();

            if (firstHalfStr.length() < firstHaflMoreStrLength) {
                builder3.append("1");
                for (int i = 0; i < length - 1; i++) {
                    builder3.append("0");
                }
                builder3.append("1");
            } else {
                builder3.append(firstHaflMoreStr).append(reverse(firstHaflMoreStr));
            }
        }

        long num = Long.valueOf(n);
        long num1 = Long.valueOf(builder1.toString());
        long num2 = Long.valueOf(builder2.toString());
        long num3 = Long.valueOf(builder3.toString());

        if (num1 != num) {
            if (Math.abs(num - num1) < Math.abs(num - num2)) {
                if (Math.abs(num - num1) < Math.abs(num - num3)) {
                    return builder1.toString();
                } else if (Math.abs(num - num1) == Math.abs(num - num3)) {
                    if (num1 < num3) {
                        return builder1.toString();
                    } else {
                        return builder3.toString();
                    }
                } else {
                    return builder3.toString();
                }
            } else if (Math.abs(num - num1) == Math.abs(num - num2)) {
                if (Math.abs(num - num1) < Math.abs(num - num3)) {
                    if (num1 < num2) {
                        return builder1.toString();
                    } else {
                        return builder2.toString();
                    }
                } else if (Math.abs(num - num1) == Math.abs(num - num3)) {
                    if (num1 < num2 && num1 < num3) {
                        return builder1.toString();
                    } else if (num2 < num1 && num2 < num3) {
                        return builder2.toString();
                    } else {
                        return builder3.toString();
                    }
                } else {
                    return builder3.toString();
                }
            } else {
                if (Math.abs(num - num2) < Math.abs(num - num3)) {
                    return builder2.toString();
                } else if (Math.abs(num - num2) == Math.abs(num - num3)) {
                    if (num2 < num3) {
                        return builder2.toString();
                    } else {
                        return builder3.toString();
                    }
                } else {
                    return builder3.toString();
                }
            }
        } else {
            if (Math.abs(num - num2) < Math.abs(num - num3)) {
                return builder2.toString();
            } else if (Math.abs(num - num2) == Math.abs(num - num3)) {
                if (num2 < num3) {
                    return builder2.toString();
                } else {
                    return builder3.toString();
                }
            } else {
                return builder3.toString();
            }
        }
    }

    /**
     * 12345 -> 21
     * 1234 -> 21
     *
     * @param str
     * @return
     */
    public static StringBuilder reverseFirstHalf(String str) {
        int length = str.length();
        int halfLength = length / 2;
        StringBuilder firstHalfReverse = new StringBuilder(halfLength);

        for (int i = 0; i < halfLength; i++) {
            firstHalfReverse.append(str.charAt(halfLength - 1 - i));
        }
        return firstHalfReverse;
    }

    public static StringBuilder reverse(String str) {
        int length = str.length();
        StringBuilder reverse = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            reverse.append(str.charAt(length - 1 - i));
        }
        return reverse;
    }
}
