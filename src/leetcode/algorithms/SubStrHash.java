package leetcode.algorithms;

/**
 * Description: 2156. Find Substring With Given Hash Value
 *
 * @author Baltan
 * @date 2022/2/1 12:28
 */
public class SubStrHash {
    public static void main(String[] args) {
        System.out.println(subStrHash("leetcode", 7, 20, 2, 0));
        System.out.println(subStrHash("fbxzaad", 31, 100, 3, 32));
        System.out.println(subStrHash(
                "kfedcbdngvlykqyrbvwbnaassgjifjxtawlafhcpjtpzfnbsqfasohevbbhkwmtnmixolfepkjmcbadqcljmsbonrngsgfqwzqiisbiwiqgtqtqddukgtjymbxzmtxrobuhkdxmdmqccrauzkrjisstznnkhupiandekzcchsrzwintkkzhvqomqmnbasynmvtxwydcvwoukqmgrpmgzqancuzapgncasxnbyznlrdvcbomdptjftgxdzeqzyavfdpseoxpvohpxtikyjfvskxyqbubgnseraxtrcrwjxloxymhqgaxwbbvzhjsbncqrlpdbiuakdjzjrbclhxgnjjyfrqyjchlsdrcwtdoktviqwjctlmzqemumgmjufcbixkfhzkugsvnkrrakccguybwhmuexiemqusltaaqrswsezccqzaputgaabrjdeihmkpzbojnusmhkwjdxvgiexwdkkazhhmlalgzvxgqgncfytrxuhkwhwcxhmlbvkhjcnyztepwnlpthozdqexvhxpvheopjrsjzkqrstczffkhkikelwydcbnghfiibeyabgegdgaqvasujmggltkvokmnsmontjzsmzoeeqenafvurbnbwqbizvaqxfgnoxasctfrwvqmoufvpajdkethlvbhbehxahcpcizocbchwfznhuqtblwepeqdhycrovqosmxxeeqaffjvvclmpcqdugndexexcykyusetuamymszlteobxkestwbzubpstbwrstuovlybycevedzgurqvlgkouvavcukccgixixsrndurvrkfegegnchbhockujlafxexlxhgysraviztkjymiqxrlldcixvfnzrpserrqycbfmesqbltywmandcqtluccbisfqzosbvedqhsxepdjevaasylvjmfpvyxqvclaalgxytiukyarojmzyovmiunkvqhkouhxxhbemavagrhteofpowvlpdunjjpwgcjibagfswrzwkgrwklppchvtukzncvoqorlsskyghkhrazwvyqqjfygmduhsfkrseddgmtdvlqeruxogmyttdqmdpmscspatkoifauivwjtbwisiiqztrllfqnjvbagrfylrpjudjmvwhdkhahyxlsfbkuuyofryfgblllzeacfiqqawridcbtqnroxwuqhyspqmwhxmjztqokofnkfvupcykszthicdgjbrgafpztktrcwtayoulnjaazigkinnpttghhyboiczvtswenshlmqyelnwhzqlswblqssiiynypfcxerlykpiyimkoodimdfdlzbwmlwflylcqwaflivqeonjswvowxgeoafmppodmfbvooodtnzgmhfnchenaaywqevklrpgajbmbxgiopofghlouhjfarjxlclcullsgyzhohowtragbkaebrvbkmxfxughlirtikheojbrrgxtqldfdnqxndzvfgajiltnqnuwavxbrvuiycsizunlglwnivpseyfwmgydmmpzhxkdtpuzpddacjmjhvncdoicedkimdgaqobdfagpggvjemstqbsshynyvhdyslgldvkapqgusmnuroqxcivjifkhrotomxodficktxmcytkbqitrlalpbtphowfgtzgfacabjodvivgykorvmxhzpqvskolkbfpbdgowlighossrlwiomgohfhgklmlnekniqfjmvvqvmimkeddfxnxwzzroospxvndynetghkgrakuslukqsrdtmjkblwrmwhzzojcwwogrjvnftdwwpoqcjqimvjbwgqgpeffjnwlzdyhkhwmvpwpcmjmdqneexqwcrvdxsfsnidwyflwxwngczklprhoazeeqwclrqvnicfvrtbqailbwrqxadxslouwdjycidupemdwhpkqekaxxprtdtmjficrhlvqidvgwkllaowyyajkxugqiztbpzvjqtpuyugkvdfcaczzruskvucsxtvroljnjojuzncatgnypbzwvilbajqqnjovqxcfunwwbxgshrjlajwveaswqegidfnedpxqdreddvawrpbllkcshlafnxyocbmwacytvgtoonlkukqhxwbfxcfnbgmrfcnkvtxmygiyjoyoljd",
                71717, 94536, 1149, 39999));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/find-substring-with-given-hash-value/solution/zhi-xin-meng-nan-di-yi-ci-yu-dao-fan-xia-ebdv/"></a>
     *
     * @param s
     * @param power
     * @param modulo
     * @param k
     * @param hashValue
     * @return
     */
    public static String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        String result = null;
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        /**
         * 记录当前窗口中子串的hash
         */
        long hash = 0L;
        /**
         * 用于计算每个窗口中最后一个字符的hash
         */
        long lastPower = 1L;
        /**
         * lastPower
         * =(power^(k-1))%modulo
         * =(power*power*……*power)%modulo
         * =((power%modulo)*(power%modulo)*……*(power%modulo))%modulo
         */
        for (int i = 1; i < k; i++) {
            lastPower = (lastPower * (power % modulo)) % modulo;
        }
        /**
         * 最后一个窗口，即字符串s的最后一个子串的hash
         */
        for (int i = length - 1; i >= length - k; i--) {
            /**
             * 窗口左侧添加新的字符，同时将窗口右侧的所有字符的hash乘以power，即
             * ((charArray[i]-'a'+1)+(old_hash*power))%modulo
             * =(((charArray[i]-'a'+1)%modulo)+((old_hash*power)%modulo))%modulo
             * =(((charArray[i]-'a'+1)%modulo)+(((old_hash%modulo)*(power%modulo))%modulo))%modulo
             */
            hash = ((hash * (power % modulo)) % modulo + (charArray[i] - 'a' + 1) % modulo) % modulo;
        }

        if (hash == hashValue) {
            result = s.substring(length - k);
        }
        /**
         * 将窗口逐个字符向前移动，计算新窗口中字符的hash，每次移动除去前一个窗口的最后一个字符的hash，将剩余元素的hash乘以
         * power，再加上新窗口的第一个字符的hash
         */
        for (int i = s.length() - k - 1; i >= 0; i--) {
            /**
             * 前一个窗口的最后一个元素的hash
             * (charArray[i+k]*(power^(k-1)))%modulo
             * =((charArray[i+k]%modulo)*((power^(k-1))%modulo))%modulo
             * =((charArray[i+k]%modulo)*lastPower)%modulo
             */
            long lastRemainder = (((charArray[i + k] - 'a' + 1) % modulo) * lastPower) % modulo;
            /**
             * 除去前一个窗口的最后一个字符的hash，需要现先将old_hash加上modulo，否则可能会计算得到余数为负数
             * (old_hash+modulo-lastRemainder)%modulo
             */
            hash = ((((hash + modulo - lastRemainder) % modulo) * (power % modulo)) % modulo +
                    (charArray[i] - 'a' + 1) % modulo) % modulo;

            if (hash == hashValue) {
                result = s.substring(i, i + k);
            }
        }
        return result;
    }
}
