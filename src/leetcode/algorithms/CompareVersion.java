package leetcode.algorithms;

/**
 * Description: 165. Compare Version Numbers
 *
 * @author Baltan
 * @date 2019-06-05 08:54
 */
public class CompareVersion {
    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.0", "1.0.0"));
        System.out.println(compareVersion("1", "1.1"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int length1 = arr1.length;
        int length2 = arr2.length;

        if (length1 > length2) {
            for (int i = 0; i < length2; i++) {
                int num1 = Integer.valueOf(arr1[i]);
                int num2 = Integer.valueOf(arr2[i]);

                if (num1 < num2) {
                    return -1;
                } else if (num1 > num2) {
                    return 1;
                }
            }
            for (int i = length2; i < length1; i++) {
                int num1 = Integer.valueOf(arr1[i]);

                if (num1 > 0) {
                    return 1;
                }
            }
        } else if (length1 < length2) {
            for (int i = 0; i < length1; i++) {
                int num1 = Integer.valueOf(arr1[i]);
                int num2 = Integer.valueOf(arr2[i]);

                if (num1 < num2) {
                    return -1;
                } else if (num1 > num2) {
                    return 1;
                }
            }
            for (int i = length1; i < length2; i++) {
                int num2 = Integer.valueOf(arr2[i]);

                if (num2 > 0) {
                    return -1;
                }
            }
        } else {
            for (int i = 0; i < length1; i++) {
                int num1 = Integer.valueOf(arr1[i]);
                int num2 = Integer.valueOf(arr2[i]);

                if (num1 < num2) {
                    return -1;
                } else if (num1 > num2) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
