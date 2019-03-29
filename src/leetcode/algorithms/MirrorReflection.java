package leetcode.algorithms;

/**
 * Description: Mirror Reflection
 *
 * @author Baltan
 * @date 2019-03-29 09:29
 */
public class MirrorReflection {
    public static void main(String[] args) {
        System.out.println(mirrorReflection(2, 1));
        System.out.println(mirrorReflection(3, 1));
        System.out.println(mirrorReflection(8, 2));
        System.out.println(mirrorReflection(3, 2));
    }

    public static int mirrorReflection(int p, int q) {
        int i = 1;
        float p1 = p * 1.0f;
        float q1 = q * 1.0f;
        while ((p1 * p1 / q1 * i) % p1 != 0) {
            i++;
        }
        if ((i & 1) == 0) {
            return 0;
        } else {
            int j = (int) ((p1 * p1 / q1 * i) / p1);
            if ((j & 1) == 1) {
                return 1;
            } else {
                return 2;
            }
        }
    }
}
