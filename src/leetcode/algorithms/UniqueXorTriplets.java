package leetcode.algorithms;

/**
 * Description: 3513. Number of Unique XOR Triplets I
 *
 * @author Baltan
 * @date 2025/4/24 22:45
 * @see UniqueXorTriplets
 */
public class UniqueXorTriplets {
    public static void main(String[] args) {
        System.out.println(uniqueXorTriplets(new int[]{1, 2}));
        System.out.println(uniqueXorTriplets(new int[]{3, 1, 2}));
    }

    public static int uniqueXorTriplets(int[] nums) {
        /**
         * 如果数组nums为[1]，则只能得到1^1^1=1
         * 如果数组nums为[1,2]，则只能得到x^x^1=1、x^x^2=2，其中，x=1或2
         * 如果数组nums为[1,2,3,……,n-1,n]，假设数组中最大元素n的二进制值的的位数为k，显然最终得到的异或值xor的位数也不大于k。如果xor的位
         * 数为k，则可以令三元组其中一个数为1<<(k-1)，此时剩余两个数按位异或等于xor^(1<<(k-1))，即等于xor低位上k-1位的值即可，从[1,n]中
         * 满足条件的这样两个数必然存在。如果xor的位数小于k且xor不为0，则可以令三元组为[x,x,xor]，其中，x∈[1,n]。如果xor为0，则可以令三
         * 元组为[1,2,3]。综上，xor∈[0,(1<<k)-1]，一共1<<k种情况
         */
        return nums.length <= 2 ? nums.length : 1 << (32 - Integer.numberOfLeadingZeros(nums.length));
    }
}
