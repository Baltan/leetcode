package leetcode.algorithms;

/**
 * Description: 706. Design HashMap
 *
 * @author Baltan
 * @date 2018/8/10 09:21
 */
public class MyHashMap {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
        hashMap.put(2, 1);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));
    }

    private static final int MAX_KEY = 1000000;
    Integer[] array = new Integer[MAX_KEY + 1];

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        if (key < 0 || key > MAX_KEY) {
            throw new RuntimeException("MyHashMapIndexOutOfBoundsException");
        }
        if (value < 0 || value > MAX_KEY) {
            throw new RuntimeException("MyHashMapIllegalValueException");
        }
        array[key] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for
     * the key
     */
    public int get(int key) {
        if (key < 0 || key > MAX_KEY) {
            throw new RuntimeException("MyHashMapIllegalValueException");
        }
        return array[key] == null ? -1 : array[key];
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        if (key < 0 || key > MAX_KEY) {
            throw new RuntimeException("MyHashMapIllegalValueException");
        }
        array[key] = null;
    }
}
