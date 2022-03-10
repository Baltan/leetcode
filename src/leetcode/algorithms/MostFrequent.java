package leetcode.algorithms;

/**
 * Description: 2190. Most Frequent Number Following Key In an Array
 *
 * @author Baltan
 * @date 2022/3/10 19:24
 */
public class MostFrequent {
    public static void main(String[] args) {
        System.out.println(mostFrequent(new int[]{1, 100, 200, 1, 100}, 1));
        System.out.println(mostFrequent(new int[]{2, 2, 2, 2, 3}, 2));
    }

    public static int mostFrequent(int[] nums, int key) {
        /**
         * count[i]表示数组nums中紧跟key的i出现的次数，根据题意，i在[1,1000]范围内
         */
        int[] count = new int[1001];
        int maxCount = 0;
        int result = 0;
        /**
         * 统计数组nums中每个紧跟key的值出现的次数
         */
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == key) {
                count[nums[i]]++;
            }
        }
        /**
         * 查找数组nums中所有紧跟key的值中出现频率最高的一个
         */
        for (int i = 1; i < count.length; i++) {
            if (count[i] > maxCount) {
                result = i;
                maxCount = count[i];
            }
        }
        return result;
    }
}
