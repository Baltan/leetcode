package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 3703. Remove K-Balanced Substrings
 *
 * @author baltan
 * @date 2025/11/13 13:48
 */
public class RemoveSubstring {
    public static void main(String[] args) {
        System.out.println(removeSubstring("(())", 1));
        System.out.println(removeSubstring("(()(", 1));
        System.out.println(removeSubstring("((()))()()()", 3));
    }

    public static String removeSubstring(String s, int k) {
        StringBuilder builder = new StringBuilder(s.length());
        /**
         * 队列保存连续且相同的括号的个数，如果为连续x个"("，则保存-x；如果为连续x个")"，则保存x
         */
        Deque<Integer> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (deque.isEmpty() || deque.peekLast() > 0) {
                    /**
                     * 队列为空或者之前为")"，构成连续1个"("，入队值为-1
                     */
                    deque.offerLast(-1);
                } else {
                    /**
                     * 当前"("和之前的连续若干个"("构成连续1-deque.pollLast()个"("，入队值为deque.pollLast()-1
                     */
                    deque.offerLast(deque.pollLast() - 1);
                }
            } else {
                if (deque.isEmpty()) {
                    /**
                     * 队列为空，构成连续1个")"，入队值为1
                     */
                    deque.offerLast(1);
                } else if (deque.peekLast() < 0) {
                    /**
                     * 之前为连续-negative个"("
                     */
                    int negative = deque.pollLast();

                    if (k == 1) {
                        if (negative < -1) {
                            /**
                             * 当前")"可以和之前的一个"("构成1-平衡子串，还剩余-negative-1个"("，重新入队，入队值为negative+1
                             */
                            deque.offerLast(negative + 1);
                        }
                    } else {
                        /**
                         * 当前")"不能和之前的连续若干个"("构成k-平衡子串，将连续-negative个"("和当前")"依次重新入队，入队值依次为
                         * negative和1
                         */
                        deque.offerLast(negative);
                        deque.offerLast(1);
                    }
                } else {
                    /**
                     * 当前")"和之前的连续若干个")"构成连续positive个")"
                     */
                    int positive = deque.pollLast() + 1;

                    if (!deque.isEmpty()) {
                        /**
                         * 连续positive个")"之前为连续-negative个"("
                         */
                        int negative = deque.pollLast();

                        if (negative <= -k && positive >= k) {
                            /**
                             * 连续k个"("和连续")"构成k-平衡子串后，剩余的-negative-k个"("和positive-k个")"依次重新入队，入队值依次
                             * 为negative+k和positive-k
                             */
                            if (negative < -k) {
                                deque.offerLast(negative + k);
                            }

                            if (positive > k) {
                                deque.offerLast(positive - k);
                            }
                        } else {
                            /**
                             * 连续positive个")"和之前的连续-negative个"("不能构成k-平衡子串，将-negative个"("和positive个")"依
                             * 次重新入队，入队值依次为negative和positive
                             */
                            deque.offerLast(negative);
                            deque.offerLast(positive);
                        }
                    } else {
                        /**
                         * 将连续positive个")"入队，入队值为positive
                         */
                        deque.offerLast(positive);
                    }
                }
            }
        }
        /**
         * 将队列保存连续且相同的括号的个数还原为"("和")"构成的字符串
         */
        while (!deque.isEmpty()) {
            int num = deque.pollFirst();

            if (num < 0) {
                builder.append("(".repeat(-num));
            } else {
                builder.append(")".repeat(num));
            }
        }
        return builder.toString();
    }
}
