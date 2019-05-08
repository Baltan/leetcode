package leetcode.algorithms;

import java.util.*;

/**
 * Description: Maximum Frequency Stack
 *
 * @author Baltan
 * @date 2019-05-08 10:29
 */
public class FreqStack {
    private Map<Integer, Integer> map;
    private TreeMap<Integer, Stack<Integer>> frequencyMap;

    public FreqStack() {
        map = new HashMap<>();
        frequencyMap = new TreeMap<>();
    }

    public void push(int x) {
        int xNewFrequency = map.getOrDefault(x, 0) + 1;
        map.put(x, xNewFrequency);

        if (frequencyMap.get(xNewFrequency) == null) {
            Stack<Integer> stack = new Stack<>();
            stack.push(x);
            frequencyMap.put(xNewFrequency, stack);
        } else {
            frequencyMap.get(xNewFrequency).push(x);
        }
    }

    public int pop() {
        Map.Entry<Integer, Stack<Integer>> entry = frequencyMap.lastEntry();
        int frequency = entry.getKey();
        Stack<Integer> stack = entry.getValue();
        int x = stack.pop();

        if (stack.isEmpty()) {
            frequencyMap.remove(new Integer(frequency));
        }
        map.put(x, map.get(x) - 1);
        return x;
    }

    public static void main(String[] args) {
        FreqStack freqStack1 = new FreqStack();
        freqStack1.push(5);
        freqStack1.push(7);
        freqStack1.push(5);
        freqStack1.push(7);
        freqStack1.push(4);
        freqStack1.push(5);
        System.out.println(freqStack1.pop());
        System.out.println(freqStack1.pop());
        System.out.println(freqStack1.pop());
        System.out.println(freqStack1.pop());

        System.out.println("---------------------------------");

        FreqStack freqStack2 = new FreqStack();
        freqStack2.push(1);
        freqStack2.push(1);
        freqStack2.push(1);
        freqStack2.push(2);
        System.out.println(freqStack2.pop());
        System.out.println(freqStack2.pop());
        freqStack2.push(2);
        freqStack2.push(2);
        freqStack2.push(1);
        System.out.println(freqStack2.pop());
        System.out.println(freqStack2.pop());
        System.out.println(freqStack2.pop());
    }
}
