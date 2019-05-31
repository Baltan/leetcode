package leetcode.entity;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-05-31 09:21
 */
public class RandomNode {
    public int val;
    public RandomNode next;
    public RandomNode random;

    public RandomNode() {
    }

    public RandomNode(int _val, RandomNode _next, RandomNode _random) {
        val = _val;
        next = _next;
        random = _random;
    }

    @Override
    public String toString() {
        return "RandomNode{" +
                "val=" + val +
                ", next=" + (next == null ? null : next.val) +
                ", random=" + (random == null ? null : random.val) +
                '}';
    }
}
