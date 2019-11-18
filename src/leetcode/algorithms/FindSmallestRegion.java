package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1257. Smallest Common Region
 *
 * @author Baltan
 * @date 2019-11-18 09:18
 */
public class FindSmallestRegion {
    public static void main(String[] args) {
        List<List<String>> regions1 = Arrays.asList(Arrays.asList("Earth", "North America", "South America"),
                Arrays.asList("North America", "United States", "Canada"),
                Arrays.asList("United States", "New York", "Boston"),
                Arrays.asList("Canada", "Ontario", "Quebec"), Arrays.asList("South America", "Brazil"));
        System.out.println(findSmallestRegion(regions1, "Quebec", "New York"));
    }

    public static String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        /**
         * 保存一个区域和他的父级区域
         */
        Map<String, String> parentRegionMap = new HashMap();
        HashSet<String> parentRegionsOfRegion1 = new HashSet();

        for (List<String> regionList : regions) {
            if (regionList == null || regionList.isEmpty()) {
                continue;
            }

            String parentRegion = regionList.get(0);
            int size = regionList.size();

            for (int i = 1; i < size; i++) {
                parentRegionMap.put(regionList.get(i), parentRegion);
            }
        }
        /**
         * 将所有包含region1（包括region1自己）的区域加入parentRegionsOfRegion1
         */
        while (region1 != null) {
            parentRegionsOfRegion1.add(region1);
            region1 = parentRegionMap.get(region1);
        }
        /**
         * 逐级查找region2的父级区域，如果parentRegionsOfRegion1中包含某一级的父级区域，则该区域即为所求
         */
        while (true) {
            if (parentRegionsOfRegion1.contains(region2)) {
                return region2;
            }
            region2 = parentRegionMap.get(region2);
        }
    }
}
