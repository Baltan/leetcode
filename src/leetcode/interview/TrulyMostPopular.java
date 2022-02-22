package leetcode.interview;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 面试题 17.07. 婴儿名字
 *
 * @author Baltan
 * @date 2022/2/22 19:01
 */
public class TrulyMostPopular {
    public static void main(String[] args) {
        String[] names1 = {"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"};
        String[] synonyms1 = {"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"};
        OutputUtils.print1DStringArray(trulyMostPopular(names1, synonyms1));

        String[] names2 =
                {"Fcclu(70)", "Ommjh(63)", "Dnsay(60)", "Qbmk(45)", "Unsb(26)", "Gauuk(75)", "Wzyyim(34)",
                        "Bnea(55)", "Kri(71)", "Qnaakk(76)", "Gnplfi(68)", "Hfp(97)", "Qoi(70)", "Ijveol(46)",
                        "Iidh(64)", "Qiy(26)", "Mcnef(59)", "Hvueqc(91)", "Obcbxb(54)", "Dhe(79)", "Jfq(26)",
                        "Uwjsu(41)", "Wfmspz(39)", "Ebov(96)", "Ofl(72)", "Uvkdpn(71)", "Avcp(41)", "Msyr(9)",
                        "Pgfpma(95)", "Vbp(89)", "Koaak(53)", "Qyqifg(85)", "Dwayf(97)", "Oltadg(95)",
                        "Mwwvj(70)", "Uxf(74)", "Qvjp(6)", "Grqrg(81)", "Naf(3)", "Xjjol(62)", "Ibink(32)",
                        "Qxabri(41)", "Ucqh(51)", "Mtz(72)", "Aeax(82)", "Kxutz(5)", "Qweye(15)", "Ard(82)",
                        "Chycnm(4)", "Hcvcgc(97)", "Knpuq(61)", "Yeekgc(11)", "Ntfr(70)", "Lucf(62)",
                        "Uhsg(23)", "Csh(39)", "Txixz(87)", "Kgabb(80)", "Weusps(79)", "Nuq(61)",
                        "Drzsnw(87)", "Xxmsn(98)", "Onnev(77)", "Owh(64)", "Fpaf(46)", "Hvia(6)", "Kufa(95)",
                        "Chhmx(66)", "Avmzs(39)", "Okwuq(96)", "Hrschk(30)", "Ffwni(67)", "Wpagta(25)",
                        "Npilye(14)", "Axwtno(57)", "Qxkjt(31)", "Dwifi(51)", "Kasgmw(95)", "Vgxj(11)",
                        "Nsgbth(26)", "Nzaz(51)", "Owk(87)", "Yjc(94)", "Hljt(21)", "Jvqg(47)", "Alrksy(69)",
                        "Tlv(95)", "Acohsf(86)", "Qejo(60)", "Gbclj(20)", "Nekuam(17)", "Meutux(64)",
                        "Tuvzkd(85)", "Fvkhz(98)", "Rngl(12)", "Gbkq(77)", "Uzgx(65)", "Ghc(15)", "Qsc(48)",
                        "Siv(47)"};
        String[] synonyms2 =
                {"(Gnplfi,Qxabri)", "(Uzgx,Siv)", "(Bnea,Lucf)", "(Qnaakk,Msyr)", "(Grqrg,Gbclj)",
                        "(Uhsg,Qejo)", "(Csh,Wpagta)", "(Xjjol,Lucf)", "(Qoi,Obcbxb)", "(Npilye,Vgxj)",
                        "(Aeax,Ghc)", "(Txixz,Ffwni)", "(Qweye,Qsc)", "(Kri,Tuvzkd)", "(Ommjh,Vbp)",
                        "(Pgfpma,Xxmsn)", "(Uhsg,Csh)", "(Qvjp,Kxutz)", "(Qxkjt,Tlv)", "(Wfmspz,Owk)",
                        "(Dwayf,Chycnm)", "(Iidh,Qvjp)", "(Dnsay,Rngl)", "(Qweye,Tlv)", "(Wzyyim,Kxutz)",
                        "(Hvueqc,Qejo)", "(Tlv,Ghc)", "(Hvia,Fvkhz)", "(Msyr,Owk)", "(Hrschk,Hljt)",
                        "(Owh,Gbclj)", "(Dwifi,Uzgx)", "(Iidh,Fpaf)", "(Iidh,Meutux)", "(Txixz,Ghc)",
                        "(Gbclj,Qsc)", "(Kgabb,Tuvzkd)", "(Uwjsu,Grqrg)", "(Vbp,Dwayf)", "(Xxmsn,Chhmx)",
                        "(Uxf,Uzgx)"};
        OutputUtils.print1DStringArray(trulyMostPopular(names2, synonyms2));

        String[] names3 =
                {"Pwsuo(71)", "Prf(48)", "Rgbu(49)", "Zvzm(31)", "Xxcl(25)", "Bbcpth(42)", "Padz(70)",
                        "Jmqqsj(19)", "Uwy(26)", "Jylbla(65)", "Xioal(11)", "Npbu(62)", "Jpftyg(96)",
                        "Tal(46)", "Hnc(100)", "Yldu(85)", "Alqw(45)", "Wbcxi(34)", "Kxjw(36)", "Clplqf(8)",
                        "Fayxe(66)", "Slfwyo(48)", "Xbesji(70)", "Pmbz(22)", "Oip(2)", "Fzoe(63)", "Qync(79)",
                        "Utc(11)", "Sqwejn(19)", "Ngi(8)", "Gsiiyo(60)", "Bcs(73)", "Icsvku(1)", "Yzwm(92)",
                        "Vaakt(21)", "Uvt(70)", "Axaqkm(100)", "Gyhh(84)", "Gaoo(98)", "Ghlj(35)", "Umt(13)",
                        "Nfimij(52)", "Zmeop(77)", "Vje(29)", "Rqa(47)", "Upn(89)", "Zhc(44)", "Slh(66)",
                        "Orpqim(69)", "Vxs(85)", "Gql(19)", "Sfjdjc(62)", "Ccqunq(93)", "Oyo(32)",
                        "Bvnkk(52)", "Pxzfjg(45)", "Kaaht(28)", "Arrugl(57)", "Vqnjg(50)", "Dbufek(63)",
                        "Fshi(62)", "Lvaaz(63)", "Phlto(41)", "Lnow(70)", "Mqgga(31)", "Adlue(82)",
                        "Zqiqe(27)", "Mgs(46)", "Zboes(56)", "Dma(70)", "Jnij(57)", "Ghk(14)", "Mrqlne(39)",
                        "Ljkzhs(35)", "Rmlbnj(42)", "Qszsny(93)", "Aasipa(26)", "Wzt(41)", "Xuzubb(90)",
                        "Maeb(56)", "Mlo(18)", "Rttg(4)", "Kmrev(31)", "Kqjl(39)", "Iggrg(47)", "Mork(88)",
                        "Lwyfn(50)", "Lcp(42)", "Zpm(5)", "Qlvglt(36)", "Liyd(48)", "Jxv(67)", "Xaq(70)",
                        "Tkbn(81)", "Rgd(85)", "Ttj(28)", "Ndc(62)", "Bjfkzo(54)", "Lqrmqh(50)",
                        "Vhdmab(41)"};
        String[] synonyms3 =
                {"(Uvt,Rqa)", "(Qync,Kqjl)", "(Fayxe,Upn)", "(Maeb,Xaq)", "(Pmbz,Vje)", "(Hnc,Dma)",
                        "(Pwsuo,Gyhh)", "(Gyhh,Aasipa)", "(Fzoe,Lcp)", "(Mgs,Vhdmab)", "(Qync,Rgd)",
                        "(Gql,Liyd)", "(Gyhh,Tkbn)", "(Arrugl,Adlue)", "(Wbcxi,Slfwyo)", "(Yzwm,Vqnjg)",
                        "(Lnow,Vhdmab)", "(Lvaaz,Rttg)", "(Nfimij,Iggrg)", "(Vje,Lqrmqh)", "(Jylbla,Ljkzhs)",
                        "(Jnij,Mlo)", "(Adlue,Zqiqe)", "(Qync,Rttg)", "(Gsiiyo,Vxs)", "(Xxcl,Fzoe)",
                        "(Dbufek,Xaq)", "(Ccqunq,Qszsny)", "(Zmeop,Mork)", "(Qync,Ngi)", "(Zboes,Rmlbnj)",
                        "(Yldu,Jxv)", "(Padz,Gsiiyo)", "(Oip,Utc)", "(Tal,Pxzfjg)", "(Adlue,Zpm)",
                        "(Bbcpth,Mork)", "(Qync,Lvaaz)", "(Pmbz,Qync)", "(Alqw,Ngi)", "(Bcs,Maeb)",
                        "(Rgbu,Zmeop)"};
        OutputUtils.print1DStringArray(trulyMostPopular(names3, synonyms3));
    }

    public static String[] trulyMostPopular(String[] names, String[] synonyms) {
        List<String> result = new ArrayList<>();
        /**
         * 姓名x -> 姓名x出现的次数，按照姓名x的字典顺序升序排列
         */
        Map<String, Integer> countMap = new TreeMap<>(String::compareTo);
        /**
         * 姓名x -> 姓名x相同的名字列表
         */
        Map<String, List<String>> synonymMap = new HashMap<>();
        /**
         * 保存姓名x是否已被计算过
         */
        Set<String> isVisited = new HashSet<>();
        /**
         * 处理姓名x和其出现的此处
         */
        for (String name : names) {
            String[] parts = name.split("\\(");
            int count = Integer.valueOf(parts[1].substring(0, parts[1].length() - 1));
            countMap.put(parts[0], count);
        }
        /**
         * 处理相同的姓名对
         */
        for (String synonym : synonyms) {
            String[] parts = synonym.split(",");
            String name1 = parts[0].substring(1);
            String name2 = parts[1].substring(0, parts[1].length() - 1);

            List<String> nameList2 = synonymMap.computeIfAbsent(name2, x -> new ArrayList<>());
            nameList2.add(name1);

            List<String> nameList1 = synonymMap.computeIfAbsent(name1, x -> new ArrayList<>());
            nameList1.add(name2);
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (isVisited.contains(entry.getKey())) {
                continue;
            }
            /**
             * 当前姓名及其相同姓名出现的总次数
             */
            int total = 0;
            Queue<String> nameQueue = new LinkedList<>();
            nameQueue.offer(entry.getKey());
            isVisited.add(entry.getKey());

            while (!nameQueue.isEmpty()) {
                String name = nameQueue.poll();
                /**
                 * 姓名name出现的次数
                 */
                int count = countMap.getOrDefault(name, 0);
                total += count;
                /**
                 * 和当前姓名name相同的姓名
                 */
                List<String> synonymList = synonymMap.get(name);

                if (Objects.nonNull(synonymList)) {
                    for (String synonym : synonymList) {
                        /**
                         * 如果相同的姓名还没有被计算过，就加入队列进行后续累加计算
                         */
                        if (!isVisited.contains(synonym)) {
                            nameQueue.offer(synonym);
                            isVisited.add(synonym);
                        }
                    }
                }
            }
            result.add(entry.getKey() + "(" + total + ")");
        }
        return result.toArray(new String[0]);
    }
}
