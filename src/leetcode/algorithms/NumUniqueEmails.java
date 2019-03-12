package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: Unique Email Addresses
 *
 * @author Baltan
 * @date 2019-03-12 09:30
 */
public class NumUniqueEmails {
    public static void main(String[] args) {
        String[] emails1 =
                {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail" +
                        "+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails1));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            String localName = email.split("@")[0];
            String domainName = email.split("@")[1];

            StringBuilder builder = new StringBuilder();
            char[] array = localName.toCharArray();

            for (char c : array) {
                if (c == '+') {
                    break;
                } else if (c == '.') {
                    continue;
                } else {
                    builder.append(c);
                }
            }
            builder.append("@").append(domainName);
            emailSet.add(builder.toString());
        }
        return emailSet.size();
    }
}
