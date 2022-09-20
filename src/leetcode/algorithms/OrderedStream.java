package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1656. Design an Ordered Stream
 *
 * @author Baltan
 * @date 2022/9/11 20:07
 */
public class OrderedStream {
    private String[] container;
    private int ptr;

    public OrderedStream(int n) {
        /**
         * container[i]保存id为i的(id,value)对，根据题意，共有n个(id,value)对，且id∈[1,n]。为了防止ptr值为n后，继续循环
         * 判断id为n+1的(id,value)对是否存在，造成越界，初始化container的长度为n+2，假设最大可保存id为n+1的(id,value)对
         */
        container = new String[n + 2];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        List<String> result = new LinkedList<>();
        container[idKey] = value;

        while (container[ptr] != null) {
            result.add(container[ptr]);
            ptr++;
        }
        return result;
    }

    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(5);
        System.out.println(orderedStream.insert(3, "ccccc"));
        System.out.println(orderedStream.insert(1, "aaaaa"));
        System.out.println(orderedStream.insert(2, "bbbbb"));
        System.out.println(orderedStream.insert(5, "eeeee"));
        System.out.println(orderedStream.insert(4, "ddddd"));
    }
}
