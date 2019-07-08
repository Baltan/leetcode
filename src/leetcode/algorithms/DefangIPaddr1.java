package leetcode.algorithms;

/**
 * Description: 1108. Defanging an IP Address
 *
 * @author Baltan
 * @date 2019-07-08 16:44
 */
public class DefangIPaddr1 {
    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
        System.out.println(defangIPaddr("255.100.50.0"));
    }

    public static String defangIPaddr(String address) {
        StringBuilder builder = new StringBuilder();
        char[] arr = address.toCharArray();

        for (char c : arr) {
            if (c == '.') {
                builder.append("[.]");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
