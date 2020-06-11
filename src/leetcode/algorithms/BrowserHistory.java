package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 1472. Design Browser History
 *
 * @author Baltan
 * @date 2020-06-10 20:56
 */
public class BrowserHistory {
    /**
     * 当前所在网页
     */
    private String currUrl;
    /**
     * 当前网页后退可以访问的网页历史
     */
    private Deque<String> prevHistory;
    /**
     * 当前网页前进可以访问的网页历史
     */
    private Deque<String> nextHistory;

    public BrowserHistory(String homepage) {
        this.prevHistory = new ArrayDeque<>();
        this.nextHistory = new ArrayDeque<>();
        this.currUrl = homepage;
    }

    public void visit(String url) {
        /**
         * 清空所有当前网页前进可以访问的网页历史
         */
        while (!nextHistory.isEmpty()) {
            nextHistory.pollFirst();
        }
        /**
         * 跳转到新的网页后，当前网页会成为新网页退后可访问的网页
         */
        prevHistory.offerLast(currUrl);
        /**
         * 跳转到新网页
         */
        currUrl = url;
    }

    public String back(int steps) {
        while (steps-- > 0 && !prevHistory.isEmpty()) {
            /**
             * 将当前网页加入到前进可访问的网页历史中
             */
            nextHistory.offerFirst(currUrl);
            /**
             * 跳转到新网页
             */
            currUrl = prevHistory.pollLast();
        }
        return currUrl;
    }

    public String forward(int steps) {
        while (steps-- > 0 && !nextHistory.isEmpty()) {
            /**
             * 将当前网页加入到后退可访问的网页历史中
             */
            prevHistory.offerLast(currUrl);
            /**
             * 跳转到新网页
             */
            currUrl = nextHistory.pollFirst();
        }
        return currUrl;
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory1 = new BrowserHistory("leetcode.com");
        browserHistory1.visit("google.com");
        browserHistory1.visit("facebook.com");
        browserHistory1.visit("youtube.com");
        System.out.println(browserHistory1.back(1));
        System.out.println(browserHistory1.back(1));
        System.out.println(browserHistory1.forward(1));
        browserHistory1.visit("linkedin.com");
        System.out.println(browserHistory1.forward(2));
        System.out.println(browserHistory1.back(2));
        System.out.println(browserHistory1.back(7));
    }
}
