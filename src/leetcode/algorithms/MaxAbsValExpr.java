package leetcode.algorithms;

/**
 * Description: 1131. Maximum of Absolute Value Expression
 *
 * @author Baltan
 * @date 2019-09-22 10:45
 */
public class MaxAbsValExpr {
    public static void main(String[] args) {
        int[] arr11 = {1, 2, 3, 4};
        int[] arr12 = {-1, 4, 5, 6};
        System.out.println(maxAbsValExpr(arr11, arr12));

        int[] arr21 = {1, -2, -5, 0, 10};
        int[] arr22 = {0, -2, -1, -7, -4};
        System.out.println(maxAbsValExpr(arr21, arr22));
    }


    public static int maxAbsValExpr(int[] arr1, int[] arr2) {
        int result = 0;
        /**
         * 将绝对值表达式展开后有以下八种情况：
         * i-j+arr1[i]-arr1[j]+arr2[i]-arr2[j]=(i+arr1[i]+arr2[i])-(j+arr1[j]+arr2[j])
         * i-j+arr1[i]-arr1[j]+arr2[j]-arr2[i]=(i+arr1[i]-arr2[i])-(j+arr1[j]-arr2[j])
         * i-j+arr1[j]-arr1[i]+arr2[i]-arr2[j]=(i-arr1[i]+arr2[i])-(j-arr1[j]+arr2[j])
         * i-j+arr1[j]-arr1[i]+arr2[j]-arr2[i]=(i-arr1[i]-arr2[i])-(j-arr1[j]-arr2[j])
         *
         * j-i+arr1[i]-arr1[j]+arr2[i]-arr2[j]=(j-arr1[j]-arr2[j])-(i-arr1[i]-arr2[i])
         * j-i+arr1[i]-arr1[j]+arr2[j]-arr2[i]=(j-arr1[j]+arr2[j])-(i-arr1[i]+arr2[i])
         * j-i+arr1[j]-arr1[i]+arr2[i]-arr2[j]=(j+arr1[j]-arr2[j])-(i+arr1[i]-arr2[i])
         * j-i+arr1[j]-arr1[i]+arr2[j]-arr2[i]=(j+arr1[j]+arr2[i])-(i+arr1[i]+arr2[i])
         *
         * 后四种情况是前四种情况交换i和j后的结果，只需讨论前四种情况。
         * 假设有如下四个函数：
         * f(x)=x+arr1[x]+arr2[x],x∈[0,length)
         * f(x)=x+arr1[x]-arr2[x],x∈[0,length)
         * f(x)=x-arr1[x]+arr2[x],x∈[0,length)
         * f(x)=x-arr1[x]-arr2[x],x∈[0,length)
         * 求出每个函数的最大值和最小值后，将最大值和最小值求差，四个差值的最大值即为所求
         */
        int condition1Max = Integer.MIN_VALUE;
        int condition1Min = Integer.MAX_VALUE;
        int condition2Max = Integer.MIN_VALUE;
        int condition2Min = Integer.MAX_VALUE;
        int condition3Max = Integer.MIN_VALUE;
        int condition3Min = Integer.MAX_VALUE;
        int condition4Max = Integer.MIN_VALUE;
        int condition4Min = Integer.MAX_VALUE;
        int length = arr1.length;

        for (int i = 0; i < length; i++) {
            int condition1 = i + arr1[i] + arr2[i];
            int condition2 = i + arr1[i] - arr2[i];
            int condition3 = i - arr1[i] + arr2[i];
            int condition4 = i - arr1[i] - arr2[i];
            condition1Max = Math.max(condition1Max, condition1);
            condition1Min = Math.min(condition1Min, condition1);
            condition2Max = Math.max(condition2Max, condition2);
            condition2Min = Math.min(condition2Min, condition2);
            condition3Max = Math.max(condition3Max, condition3);
            condition3Min = Math.min(condition3Min, condition3);
            condition4Max = Math.max(condition4Max, condition4);
            condition4Min = Math.min(condition4Min, condition4);
        }

        result = Math.max(result, condition1Max - condition1Min);
        result = Math.max(result, condition2Max - condition2Min);
        result = Math.max(result, condition3Max - condition3Min);
        result = Math.max(result, condition4Max - condition4Min);
        return result;
    }
}
