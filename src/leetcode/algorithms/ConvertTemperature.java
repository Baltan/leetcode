package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2469. Convert the Temperature
 *
 * @author Baltan
 * @date 2023/2/7 10:02
 */
public class ConvertTemperature {
    public static void main(String[] args) {
        OutputUtils.print1DDouleArray(convertTemperature(36.50));
        OutputUtils.print1DDouleArray(convertTemperature(122.11));
    }

    public static double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.8 + 32};
    }
}
