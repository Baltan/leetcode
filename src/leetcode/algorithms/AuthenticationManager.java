package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1797. Design Authentication Manager
 *
 * @author Baltan
 * @date 2022/6/30 17:11
 */
public class AuthenticationManager {
    private int timeToLive;
    /**
     * token -> token的过期时间
     */
    private Map<String, Integer> tokenExpiredTimeMap;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokenExpiredTimeMap = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokenExpiredTimeMap.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (tokenExpiredTimeMap.containsKey(tokenId)) {
            int expiredTime = tokenExpiredTimeMap.get(tokenId);

            if (expiredTime > currentTime) {
                /**
                 * 更新token的过期时间
                 */
                tokenExpiredTimeMap.put(tokenId, currentTime + timeToLive);
            } else {
                /**
                 * token已过期，删除token
                 */
                tokenExpiredTimeMap.remove(tokenId);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        /**
         * token过期时间大于当前时间的都是未过期token
         */
        for (int expiredTime : tokenExpiredTimeMap.values()) {
            if (expiredTime > currentTime) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        AuthenticationManager authenticationManager1 = new AuthenticationManager(5);
        authenticationManager1.renew("aaa", 1);
        authenticationManager1.generate("aaa", 2);
        System.out.println(authenticationManager1.countUnexpiredTokens(6));
        authenticationManager1.generate("bbb", 7);
        authenticationManager1.renew("aaa", 8);
        authenticationManager1.renew("bbb", 10);
        System.out.println(authenticationManager1.countUnexpiredTokens(15));
    }
}
