package leetcode.algorithms;

import java.util.*;

/**
 * 2977. Minimum Cost to Convert String II
 *
 * @author Baltan
 * @date 2023/12/31 21:37
 * @see MinimumCost4
 */
public class MinimumCost5 {
    public static void main(String[] args) {
        String[] original1 = {"a", "b", "c", "c", "e", "d"};
        String[] changed1 = {"b", "c", "b", "e", "b", "e"};
        int[] cost1 = {2, 5, 5, 1, 2, 20};
        System.out.println(minimumCost("abcd", "acbe", original1, changed1, cost1));

        String[] original2 = {"bcd", "fgh", "thh"};
        String[] changed2 = {"cde", "thh", "ghh"};
        int[] cost2 = {1, 3, 5};
        System.out.println(minimumCost("abcdefgh", "acdeeghh", original2, changed2, cost2));

        String[] original3 = {"bcd", "defgh"};
        String[] changed3 = {"ddd", "ddddd"};
        int[] cost3 = {100, 1578};
        System.out.println(minimumCost("abcdefgh", "addddddd", original3, changed3, cost3));

        String[] original4 = {"bg", "xr", "cc", "ip", "vq", "po", "ym", "rh", "vw", "lf", "lo", "ee", "qv", "yr", "f", "w", "i", "u", "g", "a", "e", "f", "s", "r", "p", "j", "o", "g", "i", "u"};
        String[] changed4 = {"xr", "cc", "ip", "vq", "po", "ym", "rh", "vw", "lf", "lo", "ee", "qv", "yr", "yt", "w", "i", "u", "g", "a", "e", "f", "s", "r", "p", "a", "o", "g", "i", "u", "p"};
        int[] cost4 = {97733, 90086, 87125, 85361, 75644, 46301, 21616, 79538, 52507, 95884, 79353, 61127, 58665, 96031, 95035, 12116, 41158, 91096, 47819, 88522, 25493, 80186, 66981, 87597, 56691, 86820, 89031, 99954, 41271, 39699};
        System.out.println(minimumCost("fjybg", "apyyt", original4, changed4, cost4));

        String[] original5 = {"jedgcrpmcaztovstcerciuhubsbmv", "xkferiihtaeltjeirrfvhtsxhqnit", "kcygiwfmlwwvvunlkljkdmhdlhbjk", "kyorooajunrkvhhfkwiarekojoebi", "mhnbabuwliowwhljtkdqtsgxhzjpa", "fkpewddgeiqdjhlxiihotrsxixmii", "hezxaphrbookzhzgeeozkuljfjqts", "qtkbgigqtkoacenswsftfadmlkukb", "zxubtxubycmlqdmfquvqpqmpvusqv", "lgxkhehoksvjhkmfjmyjmwcjmvxzz", "nznjgnpfgiyvcvbgopjtpfwemkaqe", "ldmvzjlaaauunzcuzjhehkhzlkvru", "ciuqrrmflbxqhjzzamerqzdszsfhv", "vlpottqcteafgotxdfbjijfoorrub", "favfcuwnoyizzdglt", "bccvkdtubnzguritr", "siemfsoxzhvzzfjzb", "hagzrstyyelrcxyri", "apzhkuvyhjagtpqbj", "ykpaiqrnzmbmsfzbc", "gzauhnucjhngyzrlx", "nshxmzafbdtweaupw", "ofsqhxkazqridveav", "bexcczxelnnwcnewi", "vssrrwenhcytsnmph", "ngvrqxgikgxevvdgr", "rhqhxtzyjrdstcxjd", "ecnbnqadyrqduuicv", "ugvcmjbbtyjuaypyj", "vfjnufxqrsfk", "xhxdogtfcvpu", "qocidlduxupq", "gsqhfykjwztx", "vcsulzwlutlr", "ettnllttyixa", "etcbnhzuwycv", "gjaogdxnabfz", "wnjncjtrrbjl", "abwcgbziqxyz", "ruvvkakhznyw"};
        String[] changed5 = {"xkferiihtaeltjeirrfvhtsxhqnit", "kcygiwfmlwwvvunlkljkdmhdlhbjk", "kyorooajunrkvhhfkwiarekojoebi", "mhnbabuwliowwhljtkdqtsgxhzjpa", "fkpewddgeiqdjhlxiihotrsxixmii", "hezxaphrbookzhzgeeozkuljfjqts", "qtkbgigqtkoacenswsftfadmlkukb", "zxubtxubycmlqdmfquvqpqmpvusqv", "lgxkhehoksvjhkmfjmyjmwcjmvxzz", "nznjgnpfgiyvcvbgopjtpfwemkaqe", "ldmvzjlaaauunzcuzjhehkhzlkvru", "ciuqrrmflbxqhjzzamerqzdszsfhv", "vlpottqcteafgotxdfbjijfoorrub", "wlhfnbjdgpdjdrvxfeyapopttmsln", "bccvkdtubnzguritr", "siemfsoxzhvzzfjzb", "hagzrstyyelrcxyri", "apzhkuvyhjagtpqbj", "ykpaiqrnzmbmsfzbc", "gzauhnucjhngyzrlx", "nshxmzafbdtweaupw", "ofsqhxkazqridveav", "bexcczxelnnwcnewi", "vssrrwenhcytsnmph", "ngvrqxgikgxevvdgr", "rhqhxtzyjrdstcxjd", "ecnbnqadyrqduuicv", "ugvcmjbbtyjuaypyj", "nulpmzctckumjuvfi", "xhxdogtfcvpu", "qocidlduxupq", "gsqhfykjwztx", "vcsulzwlutlr", "ettnllttyixa", "etcbnhzuwycv", "gjaogdxnabfz", "wnjncjtrrbjl", "abwcgbziqxyz", "ruvvkakhznyw", "iilzxnxuytgq"};
        int[] cost5 = {94841, 23100, 87082, 57883, 81956, 99349, 97053, 97067, 89336, 54493, 92666, 86052, 68569, 95674, 43715, 30544, 22193, 52409, 88347, 96316, 65965, 66902, 75543, 69470, 60507, 96377, 84405, 66202, 68014, 60610, 57118, 99697, 17121, 76156, 68737, 78653, 85300, 99559, 97505, 80492};
        System.out.println(minimumCost("vdvfqarowmpmxjfbqspvdbhcqfroqkxmultokbzaxhfnntrzdjedgcrpmcaztovstcerciuhubsbmvexzrzeujooyhndndloutcemqkcsbyadimlrtfaoqwvctmmogcklwyvvqunrjagpehdheqprvfjnufxqrsfkksxtsiuacjpgpwryvwnslsfolefavfcuwnoyizzdgltxrbqblprtvetzhbqsnmcvmavbx", "vdvfqarowmpmxjfbqspvdbhcqfroqkxmultokbzaxhfnntrzdwlhfnbjdgpdjdrvxfeyapopttmslnexzrzeujooyhndndloutcemqkcsbyadimlrtfaoqwvctmmogcklwyvvqunrjagpehdheqpriilzxnxuytgqksxtsiuacjpgpwryvwnslsfolenulpmzctckumjuvfixrbqblprtvetzhbqsnmcvmavbx", original5, changed5, cost5));

        String[] original6 = {"bh", "zkz", "bhz", "kz", "bhzk", "zb", "hzkz", "bh", "zk", "zbh", "zk", "zb", "hzk", "zb", "hz", "kz", "bhz", "kz", "bhz", "kz", "bh", "zkz", "bhz", "kz", "bh", "zk", "zb", "hzk", "zb", "hz", "kzbh", "zkz", "bhzk", "zb", "hz", "kz", "bh", "zk", "zbh", "zk", "zbh", "zkz", "bh", "zk", "zb", "hz", "kz", "bh", "zk", "zbhz", "kz", "bh", "zkz", "bh", "zkz", "bhzk", "zb", "hzkz", "bh", "zk", "zbh", "zk", "zb", "hzk", "zbh", "zk", "zb", "hzk", "zb", "hz", "kzb", "hz", "kzb", "hz", "kz", "bh", "zk", "zb", "hz", "kz", "bhz", "kz", "bhz", "kz", "bh", "zk", "zbh", "zk", "zb", "hz", "kz", "bh", "zk", "zb", "hzkz", "bh", "zk", "zb", "hz", "bhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkz"};
        String[] changed6 = {"ps", "okw", "pso", "kw", "psok", "wp", "sokw", "ps", "ok", "wps", "ok", "wp", "sok", "wp", "so", "kw", "pso", "kw", "pso", "kw", "ps", "okw", "pso", "kw", "ps", "ok", "wp", "sok", "wp", "so", "kwps", "okw", "psok", "wp", "so", "kw", "ps", "ok", "wps", "ok", "wps", "okw", "ps", "ok", "wp", "so", "kw", "ps", "ok", "wpso", "kw", "ps", "okw", "ps", "okw", "psok", "wp", "sokw", "ps", "ok", "wps", "ok", "wp", "sok", "wps", "ok", "wp", "sok", "wp", "so", "kwp", "so", "kwp", "so", "kw", "ps", "ok", "wp", "so", "kw", "pso", "kw", "pso", "kw", "ps", "ok", "wps", "ok", "wp", "so", "kw", "ps", "ok", "wp", "sokw", "ps", "ok", "wp", "so", "psokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokw"};
        int[] cost6 = {198, 100, 917, 380, 463, 280, 750, 762, 645, 913, 556, 158, 516, 147, 980, 630, 304, 894, 84, 279, 234, 559, 648, 115, 592, 977, 4, 215, 69, 495, 807, 906, 678, 982, 784, 374, 880, 215, 667, 466, 208, 312, 979, 51, 962, 175, 326, 667, 163, 565, 437, 153, 856, 474, 118, 48, 822, 842, 125, 700, 692, 218, 957, 532, 766, 835, 255, 342, 526, 362, 424, 107, 320, 815, 684, 986, 111, 713, 434, 697, 865, 769, 677, 405, 666, 601, 477, 631, 907, 802, 139, 212, 854, 188, 385, 75, 205, 105, 101, 55638};
        System.out.println(minimumCost("bhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkzbhzkz", "psokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokwpsokw", original6, changed6, cost6));

        String[] original7 = {"mifg", "hm", "if", "gh", "mi", "fghm", "if", "ghmi", "fg", "hm", "if", "gh", "mi", "fg", "hmif", "ghm", "if", "ghm", "if", "ghm", "ifgh", "mi", "fgh", "mi", "fgh", "mi", "fg", "hm", "ifgh", "mif", "ghm", "ifg", "hm", "ifg", "hm", "if", "ghm", "ifg", "hm", "ifg", "hm", "if", "ghm", "if", "ghm", "if", "ghmi", "fgh", "mif", "gh", "mi", "fg", "hm", "ifg", "hm", "if", "gh", "mi", "fgh", "mi", "fgh", "mif", "gh", "mi", "fg", "hmif", "ghm", "if", "ghm", "ifgh", "mif", "gh", "mi", "fghm", "ifg", "hm", "if", "gh", "mi", "fg", "hm", "if", "gh", "mi", "fg", "hm", "ifg", "hm", "if", "gh", "mi", "fg", "hm", "ifg", "hmi", "fg", "hm", "ifg", "hmi", "mifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifgh"};
        String[] changed7 = {"vvmi", "rv", "vm", "ir", "vv", "mirv", "vm", "irvv", "mi", "rv", "vm", "ir", "vv", "mi", "rvvm", "irv", "vm", "irv", "vm", "irv", "vmir", "vv", "mir", "vv", "mir", "vv", "mi", "rv", "vmir", "vvm", "irv", "vmi", "rv", "vmi", "rv", "vm", "irv", "vmi", "rv", "vmi", "rv", "vm", "irv", "vm", "irv", "vm", "irvv", "mir", "vvm", "ir", "vv", "mi", "rv", "vmi", "rv", "vm", "ir", "vv", "mir", "vv", "mir", "vvm", "ir", "vv", "mi", "rvvm", "irv", "vm", "irv", "vmir", "vvm", "ir", "vv", "mirv", "vmi", "rv", "vm", "ir", "vv", "mi", "rv", "vm", "ir", "vv", "mi", "rv", "vmi", "rv", "vm", "ir", "vv", "mi", "rv", "vmi", "rvv", "mi", "rv", "vmi", "rvv", "vvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmir"};
        int[] cost7 = {377, 377, 506, 708, 362, 416, 386, 309, 990, 891, 227, 922, 694, 418, 234, 875, 584, 924, 558, 172, 999, 243, 733, 522, 1000, 840, 265, 920, 846, 216, 877, 777, 306, 625, 325, 854, 790, 418, 931, 207, 430, 934, 629, 155, 445, 522, 429, 410, 913, 863, 425, 262, 156, 41, 596, 785, 557, 705, 780, 178, 170, 516, 581, 637, 485, 113, 882, 157, 373, 720, 439, 904, 205, 404, 864, 440, 638, 834, 499, 644, 670, 715, 201, 676, 981, 513, 337, 549, 195, 966, 5, 482, 693, 687, 187, 140, 446, 708, 83, 28836};
        System.out.println(minimumCost("mifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifghmifgh", "vvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmirvvmir", original7, changed7, cost7));

        String[] original8 = {"mmuh", "zm", "muhz", "mmu", "hz", "mm", "uh", "zmm", "uhz", "mmu", "hz", "mmu", "hz", "mm", "uhz", "mm", "uhzm", "muh", "zm", "mu", "hzmm", "uh", "zm", "mu", "hzm", "muh", "zm", "mu", "hz", "mm", "uhz", "mm", "uhz", "mm", "uh", "zmmu", "hz", "mm", "uh", "zmm", "uh", "zm", "mu", "hzm", "mu", "hz", "mm", "uhzm", "muh", "zm", "muhz", "mm", "uh", "zm", "mu", "hz", "mm", "uh", "zm", "muh", "zm", "mu", "hzmm", "uh", "zm", "muh", "zmm", "uh", "zm", "mu", "hz", "mmu", "hzmm", "uhz", "mmuh", "zm", "mu", "hz", "mmu", "hz", "mm", "uhz", "mmu", "hzm", "mu", "hzm", "mu", "hz", "mm", "uh", "zmmu", "hzm", "mu", "hz", "mm", "uh", "zm", "mu", "hz", "mmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhz"};
        String[] changed8 = {"vugr", "kv", "ugrk", "vug", "rk", "vu", "gr", "kvu", "grk", "vug", "rk", "vug", "rk", "vu", "grk", "vu", "grkv", "ugr", "kv", "ug", "rkvu", "gr", "kv", "ug", "rkv", "ugr", "kv", "ug", "rk", "vu", "grk", "vu", "grk", "vu", "gr", "kvug", "rk", "vu", "gr", "kvu", "gr", "kv", "ug", "rkv", "ug", "rk", "vu", "grkv", "ugr", "kv", "ugrk", "vu", "gr", "kv", "ug", "rk", "vu", "gr", "kv", "ugr", "kv", "ug", "rkvu", "gr", "kv", "ugr", "kvu", "gr", "kv", "ug", "rk", "vug", "rkvu", "grk", "vugr", "kv", "ug", "rk", "vug", "rk", "vu", "grk", "vug", "rkv", "ug", "rkv", "ug", "rk", "vu", "gr", "kvug", "rkv", "ug", "rk", "vu", "gr", "kv", "ug", "rk", "vugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrk"};
        int[] cost8 = {632, 317, 883, 156, 532, 929, 987, 318, 856, 616, 49, 288, 747, 909, 975, 91, 702, 647, 681, 122, 126, 343, 623, 349, 942, 105, 197, 5, 87, 384, 981, 964, 252, 363, 631, 691, 346, 894, 489, 867, 346, 905, 957, 986, 852, 264, 157, 282, 272, 146, 535, 423, 277, 241, 28, 345, 753, 956, 641, 847, 617, 595, 146, 812, 932, 853, 520, 52, 691, 756, 361, 25, 893, 962, 197, 300, 13, 495, 950, 581, 559, 709, 889, 27, 338, 651, 872, 728, 302, 321, 729, 178, 831, 338, 859, 870, 950, 878, 32, 8154};
        System.out.println(minimumCost("mmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhzmmuhz", "vugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrkvugrk", original8, changed8, cost8));
    }

    private static int id;

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-cost-to-convert-string-ii/solutions/2577877/zi-dian-shu-floyddp-by-endlesscheng-oi2r/"></a>
     *
     * @param source
     * @param target
     * @param original
     * @param changed
     * @param cost
     * @return
     */
    public static long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        id = 0;
        Node root = new Node();
        /**
         * minCosts[i][j]表示将id为i的字符串变为id为j的字符串的最小代价
         */
        long[][] minCosts = new long[cost.length * 2][cost.length * 2];
        /**
         * dp[i]表示从source[i]开始的后缀子串被修改为从target[i]开始的后缀子串需要的最小代价
         */
        long[] dp = new long[source.length() + 1];

        for (int i = 0; i < minCosts.length; i++) {
            /**
             * 假设id为i的字符串无法变成其他所有字符串
             */
            Arrays.fill(minCosts[i], Long.MAX_VALUE);
            /**
             * 字符串变为自身不需要花费代价
             */
            minCosts[i][i] = 0;
        }

        /**
         * 将数组original和changed中的字符串都构建到字典树中
         */
        for (int i = 0; i < cost.length; i++) {
            int x = build(root, original[i]);
            int y = build(root, changed[i]);
            /**
             * 更新id为x的字符串变为id为y的字符串的最小代价
             */
            minCosts[x][y] = Math.min(minCosts[x][y], cost[i]);
        }
        /**
         * Floyd算法更新id为j的字符串变为id为k的字符串的最小代价，判断将id为j的字符串先变为id为i的字符串，再将id为i的字符串变为id为k的字
         * 符串，是否可以减小id为j的字符串变为id为k的字符串的最小代价
         */
        for (int i = 0; i < id; i++) {
            for (int j = 0; j < id; j++) {
                if (minCosts[j][i] == Long.MAX_VALUE) {
                    continue;
                }

                for (int k = 0; k < id; k++) {
                    if (minCosts[i][k] != Long.MAX_VALUE) {
                        minCosts[j][k] = Math.min(minCosts[j][k], minCosts[j][i] + minCosts[i][k]);
                    }
                }
            }
        }

        for (int i = source.length() - 1; i >= 0; i--) {
            /**
             * 如果字符source[i]不被操作，且source[i]和target[i]相同，则子串source.substring(i)变为target.substring(i)的最小代价
             * 和source.substring(i+1)变为target.substring(i+1)的最小代价相同
             */
            dp[i] = source.charAt(i) == target.charAt(i) ? dp[i + 1] : Long.MAX_VALUE;
            Node sourceNode = root;
            Node targetNode = root;
            /**
             * 如果字符source[i]会被操作
             */
            for (int j = i; j < source.length(); j++) {
                sourceNode = sourceNode.children[source.charAt(j) - 'a'];
                targetNode = targetNode.children[target.charAt(j) - 'a'];
                /**
                 * 字典树中没有以子串source.substring(i,j+1)或target.substring(i,j+1)作为前缀的字符串，则其余以source[i]和
                 * target[i]开头的长度更大的子串都不可能存在
                 */
                if (sourceNode == null || targetNode == null) {
                    break;
                }
                /**
                 * 字典树中不存在字符串source.substring(i,j+1)或target.substring(i,j+1)，则不可能将子串source.substring(i)变为
                 * target.substring(i)
                 */
                if (sourceNode.id < 0 || targetNode.id < 0) {
                    continue;
                }
                /**
                 * 子串source.substring(i,j+1)变为target.substring(i,j+1)的最小代价为minCosts[sourceNode.id][targetNode.id]，
                 * 子串source.substring(j+1)变为target.substring(j+1)的最小代价为dp[j+1]，所以子串source.substring(i)变为
                 * target.substring(i)的最小代价为minCosts[sourceNode.id][targetNode.id]+dp[j+1]
                 */
                if (minCosts[sourceNode.id][targetNode.id] != Long.MAX_VALUE && dp[j + 1] != Long.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], minCosts[sourceNode.id][targetNode.id] + dp[j + 1]);
                }
            }
        }
        return dp[0] != Long.MAX_VALUE ? dp[0] : -1;
    }

    /**
     * 将字符串word构建到字典树中
     *
     * @param root
     * @param word
     * @return
     */
    public static int build(Node root, String word) {
        Node node = root;

        for (char c : word.toCharArray()) {
            int offset = c - 'a';

            if (node.children[offset] == null) {
                node.children[offset] = new Node();
            }
            node = node.children[offset];
        }
        /**
         * 字符串word的最后一个字符在字典树中对应的节点，节点的id为-1，说明word是一个新出现的字符串，为其定义一个唯一id
         */
        if (node.id == -1) {
            node.id = id++;
        }
        return node.id;
    }

    public static class Node {
        private int id = -1;
        private final Node[] children = new Node[26];
    }
}
