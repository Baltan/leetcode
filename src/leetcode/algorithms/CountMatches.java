package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Description: 1773. Count Items Matching a Rule
 *
 * @author Baltan
 * @date 2022/7/14 17:39
 */
public class CountMatches {
    public static void main(String[] args) {
        System.out.println(countMatches(
                Arrays.asList(Arrays.asList("phone", "blue", "pixel"),
                        Arrays.asList("computer", "silver", "lenovo"),
                        Arrays.asList("phone", "gold", "iphone")), "color", "silver"));
        System.out.println(countMatches(
                Arrays.asList(Arrays.asList("phone", "blue", "pixel"),
                        Arrays.asList("computer", "silver", "phone"),
                        Arrays.asList("phone", "gold", "iphone")), "type", "phone"));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int result = 0;

        for (List<String> item : items) {
            if (Objects.equals("type", ruleKey) && Objects.equals(item.get(0), ruleValue)) {
                result++;
            } else if (Objects.equals("color", ruleKey) && Objects.equals(item.get(1), ruleValue)) {
                result++;
            } else if (Objects.equals("name", ruleKey) && Objects.equals(item.get(2), ruleValue)) {
                result++;
            }
        }
        return result;
    }
}
