package leetcode.algorithms;

import java.util.*;

/**
 * Description: 398. Random Pick Index
 *
 * @author Baltan
 * @date 2019-07-05 22:55
 */
public class Solution4 {
    private Random rand;
    private Map<Integer, List<Integer>> map;

    public Solution4(int[] nums) {
        this.rand = new Random();
        this.map = new HashMap<>();

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int num = nums[i];

            if (map.get(num) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num, list);
            } else {
                map.get(num).add(i);
            }
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        Solution4 solution = new Solution4(nums);
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(2));
        System.out.println(solution.pick(3));
    }
}
