package leetcode.entity;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-08-01 16:59
 */
public class MountainArrayImpl implements MountainArray {
    int[] nums;

    public MountainArrayImpl(int[] nums) {
        this.nums = nums;
    }

    @Override
    public int get(int index) {
        return nums[index];
    }

    @Override
    public int length() {
        return nums.length;
    }
}
