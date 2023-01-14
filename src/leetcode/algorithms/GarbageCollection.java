package leetcode.algorithms;

/**
 * Description: 2391. Minimum Amount of Time to Collect Garbage
 *
 * @author Baltan
 * @date 2022/12/31 12:50
 */
public class GarbageCollection {
    public static void main(String[] args) {
        System.out.println(garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}));
        System.out.println(garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10}));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int result = 0;
        int length = garbage.length;
        /**
         * 金属垃圾最远的位置
         */
        int furthestM = 0;
        /**
         * 纸最远的位置
         */
        int furthestP = 0;
        /**
         * 玻璃垃圾最远的位置
         */
        int furthestG = 0;

        for (int i = 0; i < length; i++) {
            /**
             * 累加收拾三种垃圾的总时间
             */
            result += garbage[i].length();

            for (char c : garbage[i].toCharArray()) {
                if (c == 'M') {
                    furthestM = i;
                } else if (c == 'P') {
                    furthestP = i;
                } else if (c == 'G') {
                    furthestG = i;
                }
            }
        }
        /**
         * 累加垃圾车开到furthestM位置的时间
         */
        for (int i = 0; i < furthestM; i++) {
            result += travel[i];
        }
        /**
         * 累加垃圾车开到furthestP位置的时间
         */
        for (int i = 0; i < furthestP; i++) {
            result += travel[i];
        }
        /**
         * 累加垃圾车开到furthestG位置的时间
         */
        for (int i = 0; i < furthestG; i++) {
            result += travel[i];
        }
        return result;
    }
}
