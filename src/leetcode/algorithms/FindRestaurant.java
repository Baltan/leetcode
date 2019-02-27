package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:Minimum Index Sum of Two Lists
 *
 * @author Baltan
 * @date 2018/1/3 13:58
 */
public class FindRestaurant {
    public static void main(String[] args) {
        OutputUtils.print1DStringArray(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King",
                        "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}));
        OutputUtils.print1DStringArray(
                findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"KFC", "Shogun", "Burger King"}));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        int minIndexSum = Integer.MAX_VALUE;
        List<String> commonInterestList = new ArrayList<>();
        List<String> list2List = Arrays.asList(list2);
        for (int i = 0; i < list1.length; i++) {
            if (list2List.contains(list1[i])) {
                if (i + list2List.indexOf(list1[i]) < minIndexSum) {
                    commonInterestList.removeAll(commonInterestList);
                    commonInterestList.add(list1[i]);
                    minIndexSum = i + list2List.indexOf(list1[i]);
                } else if (i + list2List.indexOf(list1[i]) == minIndexSum) {
                    commonInterestList.add(list1[i]);
                }
            }
        }
        String[] commonInterest = new String[commonInterestList.size()];
        for (int i = 0; i < commonInterestList.size(); i++) {
            commonInterest[i] = commonInterestList.get(i);
        }
        return commonInterest;
    }
}
