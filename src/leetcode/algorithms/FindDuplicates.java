package leetcode.algorithms;


import java.util.*;

/**
 * Description:
 *
 * @author Baltan
 * @date 2017/11/28 08:37
 */
public class FindDuplicates {
    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums1));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        Map map = new HashMap<Integer, Integer>();
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int currNum = map.get(nums[i]) == null ? 0 : Integer.valueOf(map.get(nums[i]).toString());
            currNum++;
            map.put(nums[i], currNum);
        }
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            Integer num = it.next();
            if (Integer.valueOf(map.get(num).toString()) > 1) {
                al.add(num);
            }
        }
        return al;
    }
}
