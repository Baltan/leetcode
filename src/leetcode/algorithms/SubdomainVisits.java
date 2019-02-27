package leetcode.algorithms;

import java.util.*;

/**
 * Description: Subdomain Visit Count
 *
 * @author Baltan
 * @date 2018/7/30 16:58
 */
public class SubdomainVisits {
    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
        System.out.println(subdomainVisits(
                new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains == null) {
            return null;
        }
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        String url;
        int times;
        String separator = ".";
        int separatorIndex;
        for (int i = 0; i < cpdomains.length; i++) {
            url = cpdomains[i].split(" ")[1];
            times = Integer.valueOf(cpdomains[i].split(" ")[0]);
            while ((separatorIndex = url.indexOf(separator)) != -1) {
                if (map.get(url) == null) {
                    map.put(url, times);
                } else {
                    map.put(url, map.get(url) + times);
                }
                url = url.substring(separatorIndex + 1);
            }
            if (map.get(url) == null) {
                map.put(url, times);
            } else {
                map.put(url, map.get(url) + times);
            }
        }
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            list.add(map.get(key) + " " + key);
        }
        return list;
    }
}
