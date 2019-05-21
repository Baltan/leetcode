package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 705. Design HashSet
 *
 * @author Baltan
 * @date 2018/8/11 00:32
 */
public class MyHashSet {

    private List<Integer> list = new ArrayList<>();

    public MyHashSet() {

    }

    public void add(int key) {
        if (!list.contains(key)) {
            list.add(key);
        }
    }

    public void remove(int key) {
        if (list.contains(key)) {
            list.remove(new Integer(key));
        }
    }

    public boolean contains(int key) {
        return list.contains(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num).append("\t");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    }
}
