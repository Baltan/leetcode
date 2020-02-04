package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 399. Evaluate Division
 *
 * @author Baltan
 * @date 2020-02-04 13:18
 */
public class CalcEquation {
    public static void main(String[] args) {
        List<List<String>> equations1 = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double[] values1 = {2.0, 3.0};
        List<List<String>> queries1 =
                Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"),
                        Arrays.asList("a", "a"), Arrays.asList("x", "x"));
        OutputUtils.print1DDouleArray(calcEquation(equations1, values1, queries1));
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values,
                                        List<List<String>> queries) {
        int querySize = queries.size();
        double[] result = new double[querySize];
        /**
         * 将给出的方程式整理成map：
         * 1、先将被除数作为key，value还是一个map，除数是value的key，商是value的value
         * 2、如果商不为0（即被除数不为0），再将除数作为key，value还是一个map，被除数是value的key，
         * 商的倒数是value的value
         * 例如给出方程：a/b=2.0、c/d=0.0、a/d=0.25，可以得到
         * map={
         *      a={b=2.0,d=0.25},
         *      b={a=0.5},
         *      c={d=0.0},
         *      d={a=4.0}
         *     }
         */
        Map<String, Map<String, Double>> equationMap = new HashMap<>();
        int equationCount = equations.size();

        for (int i = 0; i < equationCount; i++) {
            /**
             * 被除数
             */
            String dividend = equations.get(i).get(0);
            /**
             * 除数
             */
            String divisor = equations.get(i).get(1);
            double value = values[i];
            /**
             * 先将被除数作为key，value还是一个map，除数是value的key，商是value的value
             */
            equationMap.putIfAbsent(dividend, new HashMap<>());
            equationMap.get(dividend).put(divisor, value);
            /**
             * 如果商不为0（即被除数不为0），再将除数作为key，value还是一个map，被除数是value的
             * key，商的倒数是value的value
             */
            if (value != 0) {
                equationMap.putIfAbsent(divisor, new HashMap<>());
                equationMap.get(divisor).put(dividend, 1 / value);
            }
        }

        outer:
        for (int i = 0; i < querySize; i++) {
            result[i] = -1.0;
            /**
             * 被除数
             */
            String dividend = queries.get(i).get(0);
            /**
             * 除数
             */
            String divisor = queries.get(i).get(1);
            /**
             * 如果除数和被除数相等并且equationMap中同时含有除数和被除数这两个key（说明除数不为0），
             * 可以直接得到这个算式的结果为1.0
             */
            if (equationMap.containsKey(dividend) && equationMap.containsKey(divisor) &&
                    Objects.equals(dividend, divisor)) {
                result[i] = 1.0;
                continue;
            }
            /**
             * 如果equationMap中不存在除数这个key或者被除数这个key，则这个算式无法计算，结果为-1.0
             */
            if (!equationMap.containsKey(dividend) || !equationMap.containsKey(divisor)) {
                continue;
            }
            /**
             * 保存除数的队列，除数和中间结算过程一一对应
             */
            Queue<String> divisorQueue = new LinkedList<>();
            /**
             * 保存中间计算过程的队列，中间计算过程和除数一一对应
             */
            Queue<Double> valueQueue = new LinkedList<>();
            /**
             * 保存除数的集合，避免重复的除数入队
             */
            Set<String> divisorSet = new HashSet<>();
            /**
             * 初始化将dividend作为被除数的方程的除数入队
             */
            for (Map.Entry<String, Double> entry : equationMap.get(dividend).entrySet()) {
                divisorQueue.offer(entry.getKey());
                valueQueue.offer(entry.getValue());
                divisorSet.add(entry.getKey());
            }
            /**
             * 广度优先搜索，将队列中的除数作为被除数的方程的除数入队，直到找到一个除数为divisor，此
             * 时可以得到算式的结果；如果最终没有找到任何一个方程的除数为divisor，则这个算式无法计算，
             * 结果为-1.0
             *
             * 如果已知方程：A/B=l,B/C=m,C/D=n，则
             * A/D=(A/B)*(B/C)*(C/D)=l*m*n
             */
            while (!divisorQueue.isEmpty()) {
                String currentDivisor = divisorQueue.poll();
                double currentValue = valueQueue.poll();

                for (Map.Entry<String, Double> entry : equationMap.get(currentDivisor)
                        .entrySet()) {
                    /**
                     * 如果除数为divisor可以得到算式的结果
                     */
                    if (Objects.equals(entry.getKey(), divisor)) {
                        result[i] = currentValue * entry.getValue();
                        continue outer;
                    } else if (!divisorSet.contains(entry.getKey())) {
                        divisorQueue.offer(entry.getKey());
                        valueQueue.offer(currentValue * entry.getValue());
                        divisorSet.add(entry.getKey());
                    }
                }
            }
        }
        return result;
    }
}
