package leetcode.algorithms;

/**
 * Description: 458. Poor Pigs
 *
 * @author Baltan
 * @date 2018/8/8 10:02
 */
public class PoorPigs {
    public static void main(String[] args) {
        System.out.println(poorPigs(1000, 15, 60));
    }

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int sections = minutesToTest / minutesToDie + 1;

        return (int) Math.ceil((Math.log(buckets) / Math.log(sections)));
    }
}
