package leetcode.entity;

import java.util.Random;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-09-06 11:28
 */
public class SolBase {
    public int rand7() {
        return new Random().nextInt(7) + 1;
    }
}
