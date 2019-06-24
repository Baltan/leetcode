package leetcode.algorithms;

import java.util.*;

/**
 * Description: 336. Palindrome Pairs
 *
 * @author Baltan
 * @date 2019-06-24 11:09
 */
public class PalindromePairs {
    public static void main(String[] args) {
        String[] words1 = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(palindromePairs(words1));

        String[] words2 = {"bat", "tab", "cat"};
        System.out.println(palindromePairs(words2));

        String[] words3 = {"ce", "dgeidjahgja", "bajcghhahfjd", "iig", "dbdhhcjccaibed", "adebcdj", "bc",
                "afeibecddhbi", "fa", "jegeaghf", "ejhaicabecjj", "deciibbhjb", "bccc", "aijicdiajibg",
                "djaijcccfjeadcd", "ecfebihegibc", "hdijabfdfffdi", "gcdijdgcbfcgijb", "hfbegbjdighi",
                "ecfjgdeac", "ia", "cgeiicicbdeihb", "ffhhegccgdj", "daaeceebfcdajjhdf",
                "diefiaijcededgggfifg", "cjbjhgjbdajaaefihh", "hicgcehaa", "ahbggajfaiecdebdgeig",
                "aiijacjajijjih", "baeaaefhdfghhaagdd", "jegfdgadjff", "fei", "ggbhgbbbhejiiechaag",
                "iihiecfjijhbhjjjf", "db", "idjei", "f", "gedfcjbefaihafbdbe", "dcdhgcejibebhceggcf", "dfhh",
                "hdbcgjhcf", "hifgd", "gbejajijcjjcigg", "ifaa", "aeeajebihhceicfd", "iedgjfbafdghbjbf",
                "geffejifbfccigcaf", "cgac", "hgdbibjehcc", "eejfchgfjh", "aehcbebeeihejbefdji", "bddae",
                "bcdfg", "hhfjbhcgghghegafcb", "jchhh", "ajdecciafbcgdbhjgi", "ajjfeajdbfdcg",
                "dibfihbibcdeia", "fgaaghhdife", "hgeedf", "gjebijjjeahhdfdjbe", "ifdgchajjhgh",
                "gidihddjagji", "ejghja", "gejbahjc", "ehiaacha", "iiefgcejcedgejgbi", "hc",
                "jiijdfaahgaeajcefhd", "da", "efaihcgbjdffcea", "ahdebbej", "fchihdd", "e", "cfaijjjaf",
                "jegeiiaihhchbgijgd", "jaaeebefe", "c", "eef", "ih", "ddcjfjhehhi", "jagcicfcfihc", "b",
                "cafh", "jdjdffe", "g", "deiifaagad", "cj", "efcaiibfcaichecgh", "fgjcgbdcfgeejehhf",
                "eeajjaejeb", "faheec", "fdfgicfad", "hhcebgad", "ijgc", "bh", "bhc", "geiigeae",
                "gebhhghhiffggchcahci", "hecj", "bfaegafffi", "aej", "bfj", "iigfchgfghfdieig",
                "aefbeiedjiecd", "caebbibdicheei", "baaafeifcacaii", "cgchedaffee", "bcifcfhibdaaegaejag",
                "deccigad", "gdggjaejjfibff", "ciei", "dh", "igjbgd", "aeghjghaejaeehbca", "eeagccebihjhie",
                "ej", "ah", "dbhfiebjg", "gf", "hggbdibgjj", "ecgdcdaj", "fbefjgffcc", "bcgdccjadbeigfibdgf",
                "ibded", "fb", "iddd", "deciehdghfghie", "ecedae", "j", "dahhjgbfidf", "jhdjidieghab",
                "fbabbcbjcab", "gbaacdjjffjae", "fibcdhhibieghehahif", "bghbjbibidij", "ecb",
                "ibadjhfedjbjdhehh", "ajfhedihcbcdaaciaa", "jhh", "ifbffeagiefcbj", "fgiiadihaaicabgfdjhe",
                "hbicfhbbhggffehcjgj", "chjhgeb", "ecigcdcdhihafbdjdbgc", "ggecheijagc", "cfigjaihbeicbb",
                "jdddjaebfeb", "ghgeadfb", "gidgdffbhedijhhgc", "ahjfhajjahedd", "bhjiji", "dcbfbbbdaa",
                "aadecebfbhbaaaaj", "cdejdg", "fbagdeeaaadiedfibfjh", "bcfaghjc", "iifegjbjgehdadi",
                "hicffhfe", "hja", "afdfcceifjejcjdcb", "efaiiddfhecfghcbfbae", "jhafcafiejfhjii",
                "jcdbhagaafgfi", "chhgfcjggcaj", "gagiefegidbceidfff", "efbagegdehfeejijfa",
                "jjicdghbefagiiiai", "d", "ebfafajehaecedeaai", "ec", "ijadajgiaebbadefji", "ee",
                "gbhhgbgbhfe", "adddifjdaaefggdgi", "cfhfdafbah", "aajeefcgc", "abbe", "jddfabgahbgecifbgfh",
                "gegb", "bgibhagfgge", "jfcbajjaaahhee", "gchfgeffjc", "fehcfdbj", "chci", "jhchi", "jeg",
                "ebcfhffddechdbhh", "cfdaj", "hhcbgaeci", "gfjiajbbhjaadchiaj", "dcajbcaddh",
                "faidagcfjdgijh", "ijehjaihdb", "fgccdfhejgbcjhia", "bdaddggfifg", "jibceacaecfdjjcedhde",
                "aid", "cbaiibcifedhgffaffih", "gjjcfcdbibfehfghjgcc", "ffjecgihbfcihebbcaag", "hjgdf",
                "iiah", "bdcihbbf", "hadaea", "bdgegbffehagicejdafi", "cigbeib", "af", "idfcbd", "eccffd",
                "cedcdjhagbabiae", "bj", "cccicdigea", "ififebgaijgchg", "hjba", "abbf", "jebfi",
                "ebaicjdchbhbih", "bcb", "gegjadhjcgiiib", "gcfhibhfbhaebf", "i", "icdfhggcjjghabiig",
                "hbhjedgfddaccdhgiicb", "hdh", "hgchdh", "gccgfefghifhjegagdeh", "idbeifb", "fgjehhjcice",
                "chbidgchdijd", "afhahdfjfjhidahi", "hbcbeijcdhgbaejdhf", "ceaeiehbadbheff",
                "hcbagaibcgijdbh", "hjh", "h", "ejchbbhcadhiffdebb", "ddfiehegbeh", "dejfajga", "cb", "gaj",
                "bjhhegdjcjbbhia", "iag", "bgccdgbhh", "icggjediagddcgeej", "ehbejghbadhcdfddbh",
                "edafejhcgbdihgcc", "ahjbiheddh", "ech", "jfecbadjhbcghhhjhfe", "jhbeigbba", "bcf", "jfigjfh",
                "eafdaecagib", "eabied", "dhbebcfcgehah", "ji", "ciiihahbgchcffabha", "aheacabjfeb", "fehfi",
                "ac", "jcgdgb", "adfbe", "agdhjfibjefe", "bcfadfcfha", "ge", "edbajcfiacdhc", "ehcfe",
                "aeijjj", "abjcij", "dfdjicecccb", "bai", "hhbahdcigeffbhciba", "fcgfjafcedgbfgcigjci",
                "hdihcdhfagajfidid", "dhfhcbec", "gg", "iegjcdcgddgfjad", "ghhdhhgdfadbbfch",
                "dfjdgfcdhiaebdfbc", "dddbccaaadicfgacifeg", "gieaebiihcgfe", "bfgjbbdgiefjibf",
                "fcfebhccjbadgfc", "hcegbdfdjcfedhbbdbd", "ibaifagjaadaghibdjcg", "jdhi", "fbcdebjdicdacdedj",
                "bcijdebebajdjjbbbahe", "dbcccffecfihj", "gbfcidedjdhaahegjf", "eeicb", "jbcfeifghiia",
                "cggghifdhfachjc", "cgcdidfcbi", "facebedieiigbeccfagf", "biaheffcjhhhgea", "bedfaaafji",
                "ceiajfifdagf", "echfbcfdfbfbejeci", "biabifbhaaefecaecdfa", "diabacb", "chibjbegdhhehj",
                "ecghjgghiajeidfghbf", "afajb", "dfh", "ejcebid", "bafiahgbebafdhcicc", "ddgdiadicd", "hhj",
                "hgbhai", "jjedgadhij", "daaeaii", "cdjbjj", "aegbbhdd", "ifee", "dgaeggdcjhcbhjad",
                "icjcjcfcid", "bgjhbbgeahfiiihi", "cadibicddccchicjbe", "faaggedgjcfaideghe", "gbcccfa",
                "bahgbidacchgbbggjff", "ghdcgdbcceieajcdeafd", "abchaehaffheiifgfgag", "dj", "egfidfjdj",
                "deaacgeehhicf", "cfdfciibjfbef", "echa", "affgdd", "faiifjahdifij", "idai",
                "ggdeigadhbjejdehhchb", "aefjbgbcahadiei", "gc", "ibbbbfh", "ejhegccbecij", "ffidefbhfhijjd",
                "jdiedbihegcbifgec", "caba", "hidcdaiij", "dhhab", "fcidefiggbaiahjfigg", "bfdh", "ibjde",
                "fcbbefcec", "bggifdcgdcdgghibf", "eiidiadjaacd", "fcdeiebjhga", "aichjfjaa",
                "dhiaggbggidbba", "bcbbhgeieijeidiabde", "igibfhhicgeehbib", "jdibieibhehj", "ffbiddfhbgdhg",
                "jj", "fafdhdbeecdgjccaiea", "hgd", "eehhefhehidhghcbj", "dihcehfcje", "biajbadedejeibhhihj",
                "jgacieegdc", "ahdbj", "fffcfjfaaaigjeci", "jhcbjbgbj", "ecgcgfejfacbfaee", "ibif", "abdf",
                "edbefjfbgdgdd", "feebehag", "ghjaffhdcdhdi", "idc", "fffcbedddeccfjfdceja", "daggifbjadii",
                "bdei", "ahhhcejebddfbcjedijc", "cgbfbjahiegjc", "iihcbgfgfhcghgj", "bagfeibadiaebaddbb",
                "jjidcbfaifjg", "adjiiffeadfaa", "jjfaabfbbb", "iejggfhdchgji", "jcggfhjdceiajfh",
                "jejadjcdgbj", "hebhfigciefbiiiheca", "bjhdah", "jabdidj", "bgfeieadbheeejdb", "bidc",
                "fdfgdaejeee", "idfdihijjdcacidejea", "efbga", "fcgbf", "ffejbde", "gbgcacjfdcb", "ebf",
                "aeabgibggbbd", "ff", "bge", "eh", "bjhfbbjhebjffdaa", "iaahdfhfhhgcedhg",
                "fcdbdghafijhcdcgj", "degghehdgj", "aeg", "aadbbjbjicfgjgcbia", "adibhdjcbedj", "jaf",
                "cbccaech", "iihheffbhdifdjdbihf", "ggcgjhh", "egbjbgcgeedci", "fc", "hcjajddijghj", "djb",
                "caehhfffda", "icbajai", "jjci", "iigibbd", "bacacgegeih", "ijd", "jedje",
                "gajggdacgagebjbdb", "bcebijgbhcdjeafbgcig", "bbecbc", "iifehgcigcfccebebc", "icffgcfb",
                "bfggcheji", "fhbfaaddjejg", "iaghbbaejcieafhiaejg", "egebcaahccghegaag", "bjghf", "aib",
                "ggdfghjhdgh", "ceibhbaahc", "iiedejiejbgjchebd", "ajfjciceadccabj", "gbiahfjcgjejajef",
                "hcacifagegfhcebibebd", "addafacihjgjed", "djhjebfgfcgjbgbjhdci", "bfbchfdbf",
                "fecjaihfefbfeec", "cddbebehig", "adgciahbj", "ibeheha", "acfaiijjieajib", "ajfij",
                "fghdjcddfaccba", "dibjigfidbhdaieefbgi", "gaiedig", "dgdaeidjgcffbbd", "beedibaedbdggcdj",
                "hecgfeb", "bifchagbjdb", "hegejaddbbcdahfjfi", "bjieffhjdh", "aacbc", "hjjihbacbggfgi",
                "cbjaheadgaad", "ediedj", "gbg", "dgijh", "ijjbjai", "gjeegfbbajhj", "hbbfddgh", "cejhgebag",
                "ahjbcbhgibfefbafjii", "jifhefaacahihagbh", "cegegfdbidjbgiifajf", "jbjj",
                "ihjjaafahagjcgejbebh", "afjacfii", "jjcjafgbeeaiede", "eeabdhecbddfjc", "ghd", "icjhhiibbbe",
                "ghgdfbffcj", "bgdeecefejgidefhg", "bfbgihgfgfcgjf", "idfgcjhjgihbbce", "afj", "ajdfeiiegggc",
                "dacdffcjbfifahi", "a", "gdgdifdfaefjfi", "ifhdehcchcecggcbb", "fcdjgjb", "iajejce",
                "iifdcgicc", "jaijiejdfdchaac", "ggjfgcccd", "chhhaccjccggedja", "afdeceb",
                "ffjbdgghafbjfibhicaj", "ijb", "ed", "dfjg", "fjhdgaecggjd", "digfdjijj", "ebcjbc",
                "dcijfceibhihifbacc", "icbhicaihdacec", "jci", "aaidj", "fdggbcfjeb", "chfijfgigj",
                "aggjjjbhicadjhahecc", "dihchbhaba", "fhhgihebafbdcdcihebi", "cdibchigjjeejcbjbbgj", "hjcf",
                "jbaafihhdigeaigjhf", "ebbiffgebidbcghhc", "gbh", "hgihfjbbiiiaigabb", "aghhidbhjdifdjegij",
                "jaiegcg", "fijdhhaabghdcdg", "aefcehhbdebabbcjbg", "aigfjcfdeeaefd", "gihjcjff",
                "fhjhddacdcddehahfb", "eiibhbijeb", "dddifagidibg", "df", "aahbijghedjgahfifdj", "gh",
                "ajejj", "hifjfbegcjfgcjdjd", "aheabcddbeg", "bcagaegbd", "cdffh", "hcggjfbbfcj", "egfeeh",
                "jccfaig", "jdbchgffijhefhh", "dbh", "chcadc", "aeefejhdjdjbidagf", "fhaigidhfcaf",
                "cfhaiahiaii", "iaedchdfcg", "cicadccghihdg", "fijjebj", "hhagieabjaebcbcej", "cbhbdagj",
                "ejbgaegjafheefdfjdac", "jgdehaeeiafaggcg", "jddgaj", "edeegaaiihe", "ific",
                "dajeijdcjjbdfhdgcga", "ahdccaig", "bjiaehccejb", "bfiaabgaagbehj", "haeaeg", "iigbghgghfaj",
                "eiibhjfbgbidffffi", "hjdbajchgjgjcffbdgbd", "jfaaacbghbdghg", "hifab", "jdgbhgdhej",
                "eiaajhdchcfiah", "ghe", "jhadedjdiefbebah", "bdgcffieb", "fihcdgafcaiedfhgcdgd",
                "gfaiifhjfcehiebh", "edbdacja", "jgafdihj", "ahijahbbiddbdh", "fhgiejjjcabjc", "bifbcfcie",
                "ejf", "ejhag", "giegiedghhaiffaaeeh", "ejjichaj", "iibfgbajfccjhahhba", "bibcdhigjah",
                "cifhahdahadhagj", "dcfdj", "geefaighbfhbc", "bfa", "dcjg", "ejggceidedjeb", "acgeafccj",
                "bgbbjajibhahdahjgh", "fddg", "cgahagjcdha", "diaadij", "fgcaaa", "jhdbf", "ejhei",
                "hbiadbbhfieecb", "ici", "bjfie", "aggaebbbdcjajdijddg", "hbghfihbij", "iggiahehabaiiehgjghe",
                "jdheba", "jadchiajfcjda", "gfafigdicbeifgb", "ddf", "ahe", "jfjicadjcbjc", "hbeij", "cihj",
                "fbdgbiecjcfdggchaaj", "icejd", "gaejifchifja", "he", "hcafaeaijfahgibbdj", "dbcccej",
                "ecdciffhihfci", "jaechbfcidcjdjbfggg", "higijgebicbijjgaae", "dajiahghdefbfeiich",
                "ghhagjbch", "fiddjhjdbdjjjg", "hdajh", "ahbjhdhbeciccjedgjia", "hceeihecae", "ageecjfibcfb",
                "dg", "dcabhdhbhiccigbijjb", "gjaaij", "giiafafghefibcfdh", "aciebfca", "bajccfhee",
                "ibchdhai", "chfbae", "affiefdedb", "jfcbhaidbejcei", "ghiedbhiaceh", "idfgdjbhafe",
                "cjbbcabbdbdhjbfd", "ebaegiagheeefhd", "jhehciieejejdffjcd", "dihhdafbdgebbjd", "ii",
                "hcbighcciibagbgifaf", "chhifhegebhaehj", "jbicgig", "cddafebibfaefiegab", "cccdgg",
                "baiigjaccgeeedghidac", "djaddiabeiadbdab", "gfb", "jafifhjhiajgb", "cfbadjacibhaf",
                "ijfihfghgb", "dcd", "dbdgidcffbff", "geacj", "ijfj", "fj", "def", "ffhdicjccgijeggf",
                "ficcfdiabheghfi", "ihdchifabacjhfj", "fbefbaiafgj", "hdiiicjaffdgdjii", "dabijfi", "ehaa",
                "bjf", "fbjiefgijbghgjcjec", "hbchgdebedbegbhedehi", "dabhggiaccjieeff", "jbacgaibbb",
                "fjgeafcb", "achadegcfhhciahcciee", "ahgfigjjjidjdjjge", "ch", "idcahihiaah",
                "ifahejgafediad", "gdfbcbhedgcdjjbgc", "eihgjjbgecfedecf", "fhhdaehec", "ibeidbiigajdajd",
                "hijbibedfag", "bihifidbijafichehefe", "dbiedghgfgeiaehfa", "dijaehjibiabcgeiha", "agbeggcc",
                "ibgibfigfabihje", "bidheijfhedjji", "cgbejf"};
        System.out.println(palindromePairs(words3));
    }


    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        if (words == null || words.length <= 1) {
            return result;
        }

        int length = words.length;
        Map<String, Integer> map = new HashMap<>((int) (length / 0.75));

        for (int i = 0; i < length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            String reverse = new StringBuilder(word).reverse().toString();

            if (Objects.equals(word, "")) {
                continue;
            }

            if (isPalindrome(word) && map.containsKey("")) {
                result.add(Arrays.asList(i, map.get("")));
                result.add(Arrays.asList(map.get(""), i));
            }

            if (!Objects.equals(word, reverse) && map.containsKey(reverse)) {
                result.add(Arrays.asList(i, map.get(reverse)));
            }

            for (int j = 1; j < wordLength; j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);

                if (isPalindrome(left)) {
                    String rightReverse = new StringBuilder(right).reverse().toString();

                    if (map.containsKey(rightReverse)) {
                        result.add(Arrays.asList(map.get(rightReverse), i));
                    }
                }

                if (isPalindrome(right)) {
                    String leftReverse = new StringBuilder(left).reverse().toString();

                    if (map.containsKey(leftReverse)) {
                        result.add(Arrays.asList(i, map.get(leftReverse)));
                    }
                }
            }
        }
        return result;
    }

    public static boolean isPalindrome(String str) {
        int lo = 0;
        int hi = str.length() - 1;

        while (lo <= hi) {
            if (str.charAt(lo) != str.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
