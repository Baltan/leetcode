package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 535. Encode and Decode TinyURL
 *
 * @author Baltan
 * @date 2018/1/10 17:05
 */
public class Codec {
    Map<Integer, String> urlMap = new HashMap<>();
    int urlCode = 1;

    /**
     * Encodes a URL to a shortened URL.
     *
     * @param longUrl
     * @return
     */
    public String encode(String longUrl) {
        urlMap.put(urlCode, longUrl);
        String shortUrl = longUrl.split("//")[0] + "//" + "tinyurl.com/" + urlCode;
        urlCode++;
        return shortUrl;
    }

    /**
     * Decodes a shortened URL to its original URL.
     *
     * @param shortUrl
     * @return
     */
    public String decode(String shortUrl) {
        int urlCode = Integer.valueOf(shortUrl.substring(shortUrl.lastIndexOf("/") + 1));
        String longUrl = urlMap.get(urlCode);
        return longUrl;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();

        String shortUrl1 = codec.encode("http://www.baidu.com");
        System.out.println(shortUrl1);
        String longUrl1 = codec.decode(shortUrl1);
        System.out.println(longUrl1);
        String shortUrl2 = codec.encode("https://www.zhihu.com");
        System.out.println(shortUrl2);
        String longUrl2 = codec.decode(shortUrl2);
        System.out.println(longUrl2);
    }
}
