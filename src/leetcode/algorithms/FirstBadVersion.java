package leetcode.algorithms;

/**
 * Description: First Bad Version
 *
 * @author Baltan
 * @date 2018/8/11 00:09
 */
public class FirstBadVersion {
    private int errorVersion;

    public int firstBadVersion(int n) {
        int head = 1;
        int tail = n;
        int mid = head + (tail - head) / 2;
        boolean flag;
        while (head < tail) {
            flag = isBadVersion(mid);
            if (flag) {
                tail = mid;
                mid = head + (tail - head) / 2;
            } else {
                head = mid + 1;
                mid = head + (tail - head) / 2;
            }
        }
        return head;
    }

    /**
     * The isBadVersion API is defined in the parent class VersionControl.
     *
     * @param version
     * @return
     */
    public boolean isBadVersion(int version) {
        return version >= errorVersion;
    }

    public static void main(String[] args) {

    }
}
