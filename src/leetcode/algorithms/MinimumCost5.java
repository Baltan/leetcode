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
    }

    public static long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        /**
         * 数组original和changed中的字符串 -> 字符串对应的唯一id
         */
        Map<String, Integer> idMap = new HashMap<>();
        int id = 0;

        for (String word : original) {
            if (!idMap.containsKey(word)) {
                idMap.put(word, id++);
            }
        }

        for (String word : changed) {
            if (!idMap.containsKey(word)) {
                idMap.put(word, id++);
            }
        }
        /**
         * minCosts[i][j]表示将id为i的字符串变为id为j的字符串的最小代价
         */
        long[][] minCosts = new long[id][id];
        /**
         * dp[i]表示将source.substring(0,i)变为target.substring(0,i)的最小代价
         */
        long[] dp = new long[source.length() + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0L;

        for (int i = 0; i < id; i++) {
            for (int j = 0; j < id; j++) {
                /**
                 * 假设id为i的字符串无法变为id为j的字符串
                 */
                minCosts[i][j] = Long.MAX_VALUE;
            }
            minCosts[i][i] = 0L;
        }
        /**
         * 初始化字符串original[i]变为字符串changed[i]的最小代价
         */
        for (int i = 0; i < original.length; i++) {
            int originalId = idMap.get(original[i]);
            int changedId = idMap.get(changed[i]);
            minCosts[originalId][changedId] = Math.min(minCosts[originalId][changedId], cost[i]);
        }
        /**
         * Floyd算法更新字符串original[j]变为字符串changed[k]的最小代价，判断将字符串original[j]先变为字符串changed[i]，再将字符串
         * changed[i]变为字符串changed[k]，是否可以减小字符串original[j]变为字符串changed[k]的最小代价
         */
        for (int i = 0; i < changed.length; i++) {
            int iId = idMap.get(changed[i]);

            for (int j = 0; j < original.length; j++) {
                int jId = idMap.get(original[j]);

                if (minCosts[jId][iId] == Long.MAX_VALUE) {
                    continue;
                }

                for (int k = 0; k < changed.length; k++) {
                    int kId = idMap.get(changed[k]);

                    if (minCosts[iId][kId] != Long.MAX_VALUE) {
                        minCosts[jId][kId] = Math.min(minCosts[jId][kId], minCosts[jId][iId] + minCosts[iId][kId]);
                    }
                }
            }
        }

        for (int i = 0; i < source.length(); i++) {
            /**
             * 如果字符source[i]不被操作
             */
            if (Objects.equals(source.charAt(i), target.charAt(i)) && dp[i] != Long.MAX_VALUE) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }
            /**
             * 如果字符source[i]会被操作
             */
            for (int j = 0; j < original.length; j++) {
                int jId = idMap.get(original[j]);

                if (!isMatched(source, i, original[j]) || dp[i + 1 - original[j].length()] == Long.MAX_VALUE) {
                    continue;
                }

                for (int k = 0; k < changed.length; k++) {
                    int kId = idMap.get(changed[k]);

                    if (minCosts[jId][kId] != Long.MAX_VALUE && isMatched(target, i, changed[k])) {
                        dp[i + 1] = Math.min(dp[i + 1], dp[i + 1 - original[j].length()] + minCosts[jId][kId]);
                    }
                }
            }
        }
        return dp[source.length()] == Long.MAX_VALUE ? -1 : dp[source.length()];
    }

    /**
     * 判断字符串from以from[index]为结尾的前缀子串的后缀是否为字符串to
     *
     * @param from
     * @param index
     * @param to
     * @return
     */
    public static boolean isMatched(String from, int index, String to) {
        if (index + 1 < to.length()) {
            return false;
        }

        for (int i = 0; i < to.length(); i++) {
            if (from.charAt(index + 1 - to.length() + i) != to.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
