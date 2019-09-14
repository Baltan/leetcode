package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 468. Validate IP Address
 *
 * @author Baltan
 * @date 2019-09-14 11:00
 */
public class ValidIPAddress {
    public static void main(String[] args) {
        System.out.println(validIPAddress("172.16.254.1"));
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(validIPAddress("256.256.256.256"));
        System.out.println(validIPAddress("2001:0db8:85a3::8A2E:0370:7334"));
        System.out.println(validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
    }

    public static String validIPAddress(String IP) {
        /**
         * 1、如果IP以"."或者":"开头或结尾，则IP既不是IPv4，也不是IPv6地址
         * 2、如果IP同时包含"."和":"，则IP既不是IPv4，也不是IPv6地址
         * 3、如果IP既不包含"."，也不包含":"，则IP既不是IPv4，也不是IPv6地址
         * 4、如果IP只包含"."，用"."将IP分割为数组
         *    1、如果数组长度不为4，则IP既不是IPv4，也不是IPv6地址
         *    2、如果IP某一段为""，则IP既不是IPv4，也不是IPv6地址
         *    3、如果IP某一段以"0"开头却不为"0"，则IP既不是IPv4，也不是IPv6地址
         *    4、如果IP某一段长度大于3，则IP既不是IPv4，也不是IPv6地址
         *    5、如果IP某一段包含0-9以外的字符，则IP既不是IPv4，也不是IPv6地址
         *    6、如果IP某一段值大于255，则IP既不是IPv4，也不是IPv6地址
         *    7、否则IP为IPv4地址
         * 5、如果IP只包含":"，用":"将IP分割为数组
         *    1、如果数组长度不为8，则IP既不是IPv4，也不是IPv6地址
         *    2、如果IP某一段为""，则IP既不是IPv4，也不是IPv6地址
         *    3、如果IP某一段长度大于4，则IP既不是IPv4，也不是IPv6地址
         *    4、如果IP某一段包含0-9、a-f、A-F以外的字符，则IP既不是IPv4，也不是IPv6地址
         *    5、否则IP为IPv6地址
         */
        if (IP.startsWith(".") || IP.endsWith(".") || IP.startsWith(":") || IP.endsWith(":")) {
            return "Neither";
        } else if (IP.contains(".") && IP.contains(":")) {
            return "Neither";
        } else if (!IP.contains(".") && !IP.contains(":")) {
            return "Neither";
        } else if (IP.contains(".")) {
            String[] segments = IP.split("\\.");

            if (segments.length != 4) {
                return "Neither";
            } else {
                for (String segment : segments) {
                    if (Objects.equals(segment, "")) {
                        return "Neither";
                    } else if (segment.startsWith("0") && !Objects.equals(segment, "0")) {
                        return "Neither";
                    } else if (segment.length() > 3) {
                        return "Neither";
                    } else {
                        for (char c : segment.toCharArray()) {
                            if (c < '0' || c > '9') {
                                return "Neither";
                            }
                        }

                        if (Integer.valueOf(segment) > 255) {
                            return "Neither";
                        }
                    }
                }
                return "IPv4";
            }
        } else {
            String[] segments = IP.split(":");

            if (segments.length != 8) {
                return "Neither";
            } else {
                for (String segment : segments) {
                    if (Objects.equals(segment, "")) {
                        return "Neither";
                    } else if (segment.length() > 4) {
                        return "Neither";
                    } else {
                        for (char c : segment.toCharArray()) {
                            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') ||
                                    (c >= 'A' && c <= 'F'))) {
                                return "Neither";
                            }
                        }
                    }
                }
                return "IPv6";
            }
        }
    }
}
