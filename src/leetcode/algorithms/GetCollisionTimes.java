package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1776. Car Fleet II
 *
 * @author Baltan
 * @date 2024/6/9 14:42
 */
public class GetCollisionTimes {
    public static void main(String[] args) {
        OutputUtils.print1DDouleArray(getCollisionTimes(new int[][]{{1927, 50}, {3766, 38}, {4148, 11}, {4917, 30}, {5032, 57}, {5304, 45}, {6752, 55}, {7955, 56}, {8297, 56}, {8785, 35}, {8791, 24}, {9271, 20}, {10250, 7}, {11013, 43}, {12557, 46}, {12567, 49}, {13869, 9}, {14851, 41}, {15353, 23}, {15579, 19}, {16277, 15}, {16474, 27}, {16754, 62}, {17867, 30}, {17939, 46}, {18820, 21}, {19653, 27}, {19974, 39}, {20004, 22}, {21035, 18}, {21738, 52}, {21861, 55}, {22707, 63}, {22818, 45}, {23990, 5}, {24027, 10}, {24983, 4}, {25074, 48}, {25488, 32}, {25676, 20}, {25957, 28}, {26008, 51}, {26198, 57}, {26881, 66}, {27019, 35}, {27042, 55}, {28066, 44}, {28901, 62}, {29047, 44}, {29246, 11}, {29511, 8}, {30162, 18}, {30389, 61}, {30498, 23}, {31156, 12}, {31279, 2}, {31590, 9}, {35680, 4}, {35701, 24}, {35929, 36}, {36091, 25}, {36705, 59}, {37965, 52}, {38166, 66}, {38177, 35}, {38876, 34}, {39589, 50}, {39831, 14}, {40048, 51}, {40399, 60}, {40561, 31}, {41500, 10}, {41598, 41}, {41676, 18}, {42559, 4}, {42787, 49}, {42840, 8}, {42881, 38}, {44206, 45}, {44449, 3}, {44505, 57}, {44785, 41}, {45806, 2}, {46476, 41}, {46538, 51}, {47256, 7}, {47549, 58}, {49599, 13}, {49834, 55}, {50961, 52}, {53786, 16}, {54089, 3}, {54137, 2}, {54182, 53}, {54917, 45}, {55138, 23}, {55172, 52}, {56407, 6}, {56650, 19}, {56824, 37}, {57395, 53}, {58244, 22}, {59544, 61}, {59617, 38}, {60678, 33}, {60711, 5}, {62083, 51}, {62228, 53}, {62279, 19}, {62984, 42}, {63500, 22}, {63597, 59}, {63785, 51}, {64528, 17}, {64830, 65}, {64856, 11}, {65753, 51}, {65989, 34}, {66236, 51}, {66531, 63}, {67921, 5}, {68002, 38}, {68082, 21}, {68091, 35}, {68464, 50}, {69082, 36}, {70262, 16}, {70399, 33}, {70520, 2}, {71195, 16}, {71473, 14}, {71624, 60}, {71675, 20}, {71890, 60}, {72936, 31}, {73877, 31}, {73947, 6}, {74964, 29}, {75369, 11}, {76000, 14}, {76778, 13}, {77615, 5}, {79373, 15}, {80649, 6}, {82103, 33}, {82829, 54}, {84940, 19}, {85265, 45}, {87415, 15}, {87476, 7}, {87858, 50}, {88125, 29}, {88565, 21}, {88593, 63}, {88784, 22}, {88820, 46}, {89310, 51}, {91308, 66}, {91759, 22}, {92202, 42}, {92532, 10}, {92807, 7}, {93951, 2}, {94028, 39}, {94120, 13}, {95176, 58}, {95748, 12}, {95904, 1}, {95957, 7}, {96319, 36}, {97778, 40}, {99197, 33}, {99322, 59}, {99418, 50}, {100007, 16}, {100013, 29}, {100395, 40}, {100694, 17}, {100848, 66}, {101575, 65}, {101775, 4}, {102025, 47}, {102634, 58}, {103136, 13}, {103735, 56}, {103902, 20}, {105194, 36}, {106580, 15}, {107765, 48}, {107953, 33}, {108426, 28}, {109426, 43}, {109889, 19}, {110605, 29}, {110848, 1}, {111034, 30}, {111419, 62}, {111774, 46}, {112022, 17}, {112405, 53}, {112530, 44}, {113039, 55}, {115038, 57}, {115470, 15}, {115501, 33}, {115884, 7}, {115902, 38}, {116466, 66}, {116487, 41}, {116813, 26}, {117487, 27}, {118099, 30}, {118415, 31}, {119876, 49}, {121423, 45}, {121432, 33}, {121574, 1}, {121983, 63}, {122462, 65}, {122923, 18}, {122991, 55}, {124846, 62}, {125638, 12}, {125659, 36}, {126267, 13}, {129333, 29}, {129379, 14}, {130596, 55}, {131207, 52}, {133270, 19}, {133383, 15}, {134966, 57}, {135504, 28}, {136100, 21}, {136193, 28}, {136231, 35}, {136259, 47}, {137478, 42}, {138034, 45}, {138181, 33}, {139244, 20}, {139254, 4}, {139572, 29}, {140059, 33}, {140299, 62}, {141197, 3}, {141240, 44}, {142098, 3}, {142267, 23}, {143748, 26}, {143785, 34}, {143881, 30}, {143979, 10}, {144423, 55}, {144568, 48}, {144668, 48}, {145043, 25}, {145110, 14}, {145269, 1}, {145748, 51}, {148353, 44}, {149650, 43}, {149706, 53}, {149754, 44}, {151258, 33}, {151791, 52}, {151861, 36}, {153045, 46}, {153821, 10}, {154721, 56}, {155017, 29}, {155412, 61}, {155965, 45}, {156191, 37}, {157339, 4}, {157478, 14}, {157769, 7}, {158304, 22}, {159073, 29}, {159451, 57}, {160464, 38}, {160526, 55}, {160686, 52}, {160783, 1}, {162106, 9}, {162519, 51}, {163324, 20}, {166021, 27}, {166078, 61}, {167092, 51}, {168165, 64}, {168247, 13}, {168319, 53}, {169068, 22}, {169216, 64}, {169765, 28}, {169871, 40}, {170242, 5}, {170274, 39}, {170455, 38}, {171465, 18}, {172168, 33}, {172703, 66}, {172747, 39}, {173007, 61}, {173018, 18}, {173433, 56}, {174151, 43}, {175230, 42}, {175753, 27}, {177533, 36}, {177855, 6}, {178026, 40}, {178716, 65}, {178718, 38}, {179445, 64}, {180272, 39}, {180687, 34}, {180748, 21}, {180963, 38}, {181260, 34}, {181850, 43}, {181953, 20}, {182256, 34}, {182605, 50}, {182611, 57}, {182696, 64}, {183730, 22}, {184159, 50}, {184887, 6}, {186418, 12}, {187589, 27}, {187602, 41}, {188022, 7}, {188114, 40}, {188448, 6}, {188685, 54}, {188982, 14}, {189169, 42}, {189246, 17}, {189655, 2}, {189918, 45}, {190828, 31}, {191464, 46}, {194262, 56}, {197095, 31}, {198032, 11}, {198599, 5}, {199980, 43}, {201546, 3}, {201608, 57}, {202446, 4}, {202897, 22}, {203338, 36}, {203364, 27}, {203741, 55}, {204134, 38}, {204307, 22}, {204716, 6}, {205143, 5}, {205408, 64}, {205851, 50}, {206581, 15}, {207805, 49}, {209884, 37}, {210260, 56}, {210663, 7}, {211291, 30}, {211358, 43}, {212417, 54}, {213661, 63}, {215946, 27}, {216152, 66}, {216305, 12}, {216448, 44}, {216772, 52}, {217964, 23}, {218389, 31}, {218491, 63}, {218677, 10}, {218692, 54}, {219194, 51}, {219266, 28}, {220916, 33}, {221182, 1}, {221277, 37}, {224584, 5}, {225220, 34}, {226499, 11}, {226620, 24}, {227874, 33}, {227966, 58}, {228141, 56}, {228173, 40}, {228213, 13}, {228269, 39}, {228698, 7}, {228731, 62}, {229496, 23}, {229523, 33}, {229544, 27}, {229699, 17}, {230277, 6}, {230495, 52}, {231405, 2}, {232904, 65}, {232987, 39}, {234818, 1}, {234851, 49}, {235513, 44}, {235901, 13}, {236500, 33}, {236761, 21}, {236969, 26}, {237299, 10}, {237391, 23}, {238454, 49}, {239005, 3}, {239950, 29}, {240605, 52}, {240975, 3}, {241058, 1}, {241383, 54}, {242120, 23}, {242856, 7}, {243247, 51}, {243978, 54}, {244334, 25}, {245268, 21}, {245332, 29}, {245595, 12}, {245633, 58}, {245862, 43}, {246435, 33}, {247143, 25}, {249031, 65}, {249072, 33}, {249563, 50}, {251617, 32}, {251805, 38}, {252593, 33}, {252731, 19}, {252744, 35}, {253418, 47}, {253539, 36}, {254265, 65}, {254695, 29}, {255148, 25}, {255213, 3}, {257247, 14}, {257361, 28}, {258614, 36}, {259640, 22}, {260125, 42}, {260173, 29}, {260359, 21}, {260923, 5}, {261995, 29}, {262049, 50}, {264623, 34}, {264661, 33}, {265000, 28}, {267115, 34}, {268336, 49}, {269759, 6}, {270227, 5}, {271518, 20}, {271763, 64}, {272248, 56}, {272310, 39}, {272381, 47}, {272468, 52}, {273642, 46}, {274802, 26}, {274805, 37}, {275250, 36}, {275260, 34}, {276093, 62}, {276794, 20}, {276947, 46}, {277223, 19}, {277592, 50}, {277719, 8}, {277787, 10}, {278574, 34}, {278817, 10}, {279691, 64}, {279782, 27}, {279940, 59}, {280177, 40}, {281667, 6}, {281724, 35}, {281793, 44}, {281944, 1}, {284601, 64}, {284629, 56}, {284792, 56}, {285076, 55}, {286560, 47}, {290134, 63}, {290211, 25}, {290654, 56}, {291713, 51}, {291833, 38}, {292013, 13}, {292293, 11}, {292496, 21}, {293299, 44}, {293651, 47}, {293730, 55}, {294259, 49}, {294970, 16}, {296056, 49}, {296261, 7}, {296469, 56}, {297071, 26}, {297892, 15}, {299444, 30}, {299802, 62}, {300266, 50}, {300696, 23}, {301456, 18}, {302216, 29}, {302627, 13}, {303686, 45}, {303746, 42}, {304853, 65}, {304909, 57}, {305310, 22}, {306687, 49}, {307865, 62}, {307873, 24}, {307945, 5}, {308462, 65}, {308822, 26}, {310068, 32}, {310418, 17}, {312718, 16}, {314121, 36}, {316331, 2}, {316457, 1}, {317704, 48}, {317820, 37}, {318347, 28}, {318798, 7}, {318993, 40}, {319006, 19}, {319930, 17}, {320897, 9}, {321089, 21}, {321244, 54}, {321603, 35}, {322304, 17}, {322742, 10}, {322839, 25}, {322982, 21}, {323127, 54}, {323821, 28}, {324339, 51}, {325885, 63}, {325899, 23}, {326039, 9}, {326207, 64}, {326697, 32}, {326741, 27}, {327351, 10}, {328277, 20}, {328358, 32}, {328769, 25}, {330107, 19}, {331005, 34}, {331445, 9}, {331555, 48}, {331715, 11}, {332562, 46}, {332637, 36}, {332686, 23}, {333186, 61}, {333944, 56}, {334064, 29}, {334135, 17}, {334325, 16}, {334497, 56}, {335027, 55}, {335343, 48}, {335809, 29}, {335828, 57}, {335879, 51}, {336533, 43}, {336569, 24}, {337262, 7}, {337270, 7}, {337515, 48}, {337897, 60}, {338338, 21}, {338439, 60}, {338638, 48}, {338986, 46}, {340382, 20}, {341361, 59}, {341561, 26}, {341658, 62}, {342775, 37}, {343158, 27}, {343229, 17}, {343375, 29}, {344228, 37}, {345972, 14}, {347368, 12}, {347976, 30}, {350050, 55}, {350172, 66}, {351242, 28}, {351487, 39}, {351585, 64}, {352843, 8}, {353370, 49}, {353581, 27}, {353781, 7}, {354313, 40}, {354415, 39}, {355328, 27}, {356873, 55}, {357005, 2}, {357599, 59}, {358441, 42}, {358465, 54}, {359059, 32}, {360440, 14}, {361008, 22}, {361239, 65}, {362632, 7}, {364189, 49}, {364498, 21}, {365473, 3}, {365744, 66}, {365845, 64}, {366323, 63}, {366429, 48}, {366481, 55}, {366949, 4}, {367169, 56}, {368102, 50}, {368201, 31}, {368802, 2}, {369015, 6}, {370026, 26}, {370049, 41}, {371651, 5}, {372017, 18}, {372156, 57}, {372220, 23}, {372447, 58}, {373037, 19}, {373146, 19}, {373778, 33}, {374196, 65}, {374423, 49}, {374944, 12}, {375902, 66}, {376048, 16}, {376264, 10}, {376984, 50}, {377078, 62}, {378028, 47}, {379129, 27}, {381440, 5}, {381743, 53}, {381755, 29}, {383175, 62}, {383293, 26}, {384589, 22}, {385427, 31}, {385925, 26}, {386197, 44}, {387254, 39}, {388764, 62}, {389326, 65}, {389506, 31}, {390041, 28}, {391259, 37}, {392543, 16}, {392725, 2}, {393836, 5}, {394252, 41}, {394856, 12}, {395552, 23}, {395940, 59}, {398315, 11}, {398475, 53}, {398761, 18}, {398916, 6}, {399035, 18}, {399968, 41}, {400778, 46}, {401136, 58}, {402269, 25}, {402346, 52}, {402375, 60}, {403033, 11}, {403260, 51}, {403379, 47}, {404182, 2}, {404758, 37}, {404828, 28}, {405031, 46}, {405762, 48}, {406354, 1}, {406387, 13}, {407190, 58}, {407513, 52}, {407580, 40}, {408538, 23}, {408668, 39}, {408755, 29}, {410376, 43}, {411080, 43}, {412689, 28}, {412691, 6}, {412831, 7}, {413112, 3}, {413284, 24}, {414203, 60}, {415065, 42}, {416178, 5}, {416292, 35}, {416457, 35}, {416747, 9}, {416875, 32}, {416990, 2}, {417125, 17}, {417364, 53}, {417747, 45}, {417792, 35}, {417794, 64}, {418075, 5}, {418250, 50}, {418688, 15}, {419726, 40}, {419767, 54}, {419776, 32}, {420187, 30}, {420744, 56}, {420941, 34}, {422133, 2}, {423655, 1}, {423708, 20}, {424450, 61}, {426080, 20}, {427654, 45}, {428268, 10}, {428699, 32}, {429266, 20}, {430045, 17}, {430471, 52}, {430487, 18}, {430715, 43}, {431370, 25}, {433050, 17}, {433889, 18}, {434674, 15}, {434876, 17}, {435627, 5}, {435731, 36}, {436166, 35}, {439717, 46}, {439863, 1}, {440140, 19}, {442336, 2}, {442409, 9}, {442792, 59}, {443073, 56}, {445859, 51}, {446108, 40}, {446452, 18}, {446751, 51}, {447960, 55}, {448169, 47}, {449858, 58}, {450269, 45}, {450721, 38}, {450940, 61}, {450980, 24}, {451082, 35}, {451483, 2}, {451539, 40}, {451945, 30}, {452120, 7}, {452239, 64}, {452398, 8}, {452816, 1}, {452848, 11}, {453705, 60}, {453719, 1}, {454248, 32}, {455043, 17}, {456451, 51}, {457342, 50}, {457388, 29}, {457722, 36}, {457970, 24}, {458235, 28}, {459042, 21}, {459101, 12}, {459135, 43}, {459155, 45}, {459158, 12}, {459243, 16}, {460915, 30}, {461611, 27}, {461873, 43}, {462196, 58}, {462685, 11}, {462738, 56}, {463049, 46}, {463087, 22}, {463326, 24}, {463495, 14}, {463688, 46}, {463848, 24}, {464178, 64}, {464282, 11}, {464596, 59}, {464926, 56}, {465681, 28}, {467005, 9}, {467021, 9}, {467308, 33}, {467373, 43}, {467407, 51}, {467433, 48}, {467501, 42}, {468142, 56}, {469095, 10}, {470757, 25}, {471071, 53}, {471238, 45}, {471824, 64}, {472421, 45}, {474119, 16}, {474825, 58}, {475639, 43}, {476048, 2}, {476243, 29}, {476246, 39}, {476362, 53}, {476550, 18}, {476744, 25}, {476812, 36}, {477226, 66}, {477623, 6}, {477673, 21}, {478865, 40}, {478949, 8}, {479264, 15}, {480232, 35}, {480417, 15}, {480644, 24}, {481023, 58}, {482662, 32}, {484214, 60}, {484408, 56}, {485062, 7}, {486088, 19}, {487918, 64}, {488072, 47}, {488553, 65}, {490808, 38}, {491036, 49}, {491050, 12}, {491191, 56}, {491407, 17}, {491661, 66}, {492478, 30}, {492609, 55}, {493451, 63}, {494587, 9}, {494982, 47}, {495104, 24}, {495291, 8}, {495311, 27}, {495450, 25}, {497668, 3}, {497830, 45}, {497906, 31}, {497950, 31}, {498107, 53}, {498258, 54}, {498302, 22}, {500549, 31}, {500595, 1}, {500791, 29}, {500802, 66}, {500916, 8}, {500971, 20}, {501523, 12}, {501569, 4}, {502041, 19}, {502202, 35}, {502572, 30}, {503698, 47}, {503760, 43}, {504282, 18}, {504511, 13}, {504525, 33}, {504692, 53}, {506368, 46}, {506548, 6}, {507016, 8}, {507782, 59}, {507965, 5}, {510781, 41}, {511255, 40}, {511270, 39}, {511906, 50}, {512009, 40}, {512464, 50}, {512509, 62}, {513033, 38}, {513122, 16}, {514240, 2}, {514483, 14}, {515563, 55}, {515862, 10}, {517173, 27}, {517534, 16}, {517614, 2}, {518132, 32}, {518155, 61}, {518276, 10}, {520585, 28}, {521091, 44}, {521326, 28}, {522564, 38}, {524244, 37}, {525606, 60}, {525661, 60}, {526220, 66}, {526274, 27}, {526999, 60}, {528175, 49}, {528252, 11}, {530083, 4}, {530677, 10}, {530911, 39}, {531763, 58}, {531926, 27}, {532123, 38}, {532473, 54}, {533435, 24}, {533535, 51}, {534135, 49}, {534293, 60}, {534739, 29}, {535245, 32}, {536005, 64}, {536224, 2}, {536366, 38}, {536494, 35}, {536770, 61}, {536938, 64}, {537093, 46}, {537259, 15}, {537710, 16}, {538631, 28}, {539476, 58}, {541088, 50}, {542299, 28}, {542591, 54}, {543060, 8}, {544185, 23}, {544218, 50}, {544343, 55}, {544583, 48}, {545183, 19}, {545682, 9}, {546174, 66}, {546259, 21}, {547320, 6}, {547479, 28}, {547711, 65}, {548122, 60}, {548335, 40}, {548575, 39}, {548772, 61}, {549013, 18}, {549437, 3}, {551446, 58}, {551794, 56}, {552174, 45}, {552889, 56}, {554272, 47}, {554736, 28}, {554997, 35}, {555495, 27}, {555519, 60}, {555841, 61}, {556020, 35}, {556903, 54}, {557981, 37}, {558777, 36}, {559118, 57}, {559182, 9}, {559217, 15}, {559498, 42}, {559535, 58}, {559956, 37}, {561303, 30}, {561860, 66}, {562182, 41}, {562309, 32}, {562357, 20}, {562623, 21}, {563560, 33}, {563729, 32}, {563855, 53}, {563970, 4}, {564019, 55}, {564253, 51}, {564389, 29}, {564551, 18}, {564852, 10}, {565353, 11}, {566592, 22}, {567314, 60}, {567501, 49}, {568316, 29}, {568520, 38}, {568527, 51}, {569157, 35}, {569704, 2}, {570201, 37}, {570530, 20}, {570738, 16}, {571165, 56}, {571371, 37}, {572442, 39}, {573208, 54}, {575667, 8}, {575885, 20}, {576807, 13}, {578288, 22}, {578917, 63}, {578945, 56}, {579512, 15}, {580051, 8}, {580538, 46}, {581317, 41}, {582059, 40}, {582347, 5}, {583142, 40}, {583463, 58}, {586162, 5}, {586321, 45}, {586658, 37}, {587161, 28}, {587288, 34}, {587445, 36}, {587709, 22}, {588476, 37}, {588802, 66}, {589536, 44}, {589682, 12}, {589852, 5}, {590027, 17}, {590048, 17}, {590119, 50}, {590433, 42}, {592201, 44}, {592247, 61}, {592969, 22}, {593014, 38}, {593171, 4}, {593814, 34}, {593834, 3}, {594545, 3}, {594724, 54}, {594898, 60}, {595332, 4}, {596393, 66}, {597237, 50}, {597409, 14}, {597666, 16}, {599611, 3}, {600652, 50}, {600718, 12}, {601333, 64}, {602871, 28}, {603067, 46}, {603929, 5}, {604013, 53}, {604681, 61}, {604743, 41}, {605808, 25}, {609419, 2}, {609615, 17}, {610612, 61}, {611019, 61}, {613094, 33}, {613141, 56}, {613366, 66}, {613382, 13}, {613594, 54}, {614717, 58}, {615676, 38}, {615680, 12}, {616364, 7}, {616461, 55}, {617257, 20}, {617637, 45}, {618044, 26}, {618265, 11}, {618562, 59}, {619105, 47}, {619579, 15}, {620582, 43}, {620608, 13}, {620799, 27}, {621062, 41}, {621225, 21}, {622207, 21}, {622218, 43}, {622403, 11}, {623366, 27}, {623554, 38}, {623638, 9}, {624150, 63}, {624196, 60}, {624349, 65}, {624421, 57}, {624963, 50}, {625160, 47}, {625866, 61}, {626929, 23}, {627274, 19}, {628978, 1}, {629402, 23}, {629900, 40}, {630153, 23}, {630840, 20}, {631270, 27}, {631972, 18}, {632302, 32}, {633576, 59}, {634498, 18}, {634626, 11}, {634856, 63}, {635913, 65}, {636171, 50}, {638114, 51}, {639042, 55}, {640462, 65}, {640595, 56}, {640622, 61}, {640683, 36}, {640697, 62}, {641056, 17}, {641058, 26}, {641664, 49}, {642747, 5}, {643371, 36}, {644378, 18}, {644900, 57}, {645508, 28}, {645517, 20}, {646191, 50}, {646605, 57}, {647116, 8}, {647205, 45}, {647775, 29}, {647897, 20}, {648159, 37}, {649753, 63}, {649865, 43}, {650202, 20}, {650562, 9}, {650777, 51}, {650893, 10}, {651512, 10}, {652752, 1}, {653244, 4}, {653453, 10}, {654991, 12}, {655171, 17}, {655639, 33}, {656075, 8}, {656088, 27}, {657321, 56}, {658138, 44}, {658524, 36}, {660622, 46}, {660919, 26}, {664488, 21}, {665205, 53}, {665332, 11}, {666366, 46}, {666553, 15}, {667368, 55}, {667542, 58}, {667670, 43}, {667675, 65}, {668212, 14}, {668429, 2}, {668742, 8}, {668866, 19}, {669546, 53}, {670606, 28}, {670793, 26}, {672802, 9}, {674410, 21}, {674422, 59}, {674822, 66}, {675098, 4}, {676205, 42}, {676787, 38}, {677175, 40}, {678003, 20}, {679479, 58}, {679531, 7}, {681152, 6}, {682963, 37}, {683025, 21}, {683357, 4}, {683635, 41}, {685921, 4}, {685980, 19}, {686220, 33}, {686528, 14}, {686587, 30}, {687853, 33}, {688574, 64}, {689379, 64}, {689386, 25}, {689838, 10}, {690390, 17}, {690683, 37}, {692558, 4}, {692666, 31}, {692721, 21}, {692770, 23}, {693150, 32}, {693925, 59}, {694483, 14}, {694808, 1}, {694859, 26}, {694899, 47}, {696161, 22}, {696549, 35}, {696873, 13}, {698926, 11}, {699461, 39}, {700828, 30}, {701982, 49}, {702274, 39}, {702360, 18}, {702723, 39}, {702972, 18}, {703185, 39}, {704367, 16}, {704870, 39}, {705436, 13}, {705687, 27}, {706113, 57}, {706193, 52}, {706760, 13}, {708195, 4}, {709640, 51}, {709735, 62}, {710266, 1}, {711048, 38}, {711942, 61}, {712343, 61}, {714057, 48}, {714486, 24}, {715361, 27}, {717980, 62}, {718527, 26}, {718534, 29}, {719368, 18}, {720245, 56}, {720857, 26}, {721092, 47}, {721772, 63}, {722195, 30}, {722616, 7}, {722658, 32}, {723045, 15}, {723148, 47}, {723570, 9}, {724496, 6}, {724581, 28}, {724990, 56}, {725050, 43}, {726209, 53}, {726700, 58}, {728974, 57}, {729532, 59}, {730214, 58}, {731061, 48}, {731540, 6}, {731733, 27}, {732544, 34}, {733125, 17}, {733575, 14}, {734719, 54}, {734887, 26}, {735345, 42}, {735414, 14}, {735594, 1}, {736378, 29}, {738120, 26}, {738828, 50}, {739487, 25}, {739608, 39}, {740448, 40}, {740679, 48}, {740922, 30}, {741126, 4}, {741146, 32}, {741167, 36}, {742008, 40}, {742513, 24}, {742634, 15}, {743250, 2}, {743442, 45}, {744487, 20}, {745279, 50}, {745531, 63}, {746978, 59}, {747285, 15}, {747861, 29}, {748653, 45}, {748895, 8}, {749464, 11}, {749700, 31}, {750760, 22}, {751313, 26}, {751555, 55}, {752362, 18}, {753539, 49}, {753695, 52}, {753925, 46}, {754017, 11}, {756458, 5}, {757083, 59}, {757564, 46}, {758797, 37}, {759654, 48}, {760081, 43}, {761161, 48}, {763541, 2}, {764026, 15}, {764033, 50}, {764981, 39}, {764983, 35}, {765084, 8}, {765912, 66}, {767227, 62}, {767840, 36}, {768197, 7}, {768366, 63}, {768858, 41}, {769419, 55}, {770284, 59}, {770725, 66}, {776039, 29}, {776224, 22}, {776430, 66}, {776784, 6}, {776944, 52}, {777121, 33}, {777543, 25}, {777555, 41}, {777730, 26}, {778151, 15}, {780628, 22}, {781357, 54}, {782329, 54}, {783458, 33}, {783797, 17}, {784695, 12}, {786310, 34}, {786406, 31}, {786653, 36}, {786719, 24}, {787086, 59}, {788542, 55}, {789569, 3}, {789573, 19}, {790069, 40}, {791543, 66}, {792878, 18}, {794214, 19}, {794819, 53}, {796632, 5}, {796664, 60}, {796667, 65}, {799664, 64}, {801282, 6}, {803355, 50}, {804448, 14}, {804673, 38}, {805097, 53}, {805460, 60}, {805480, 14}, {806026, 55}, {806788, 53}, {807012, 4}, {807410, 34}, {807696, 8}, {808959, 38}, {809039, 34}, {809100, 42}, {809393, 65}, {809795, 4}, {811228, 18}, {812114, 8}, {812796, 28}, {813402, 41}, {813562, 13}, {814248, 21}, {815093, 39}, {815288, 53}, {816796, 19}, {817018, 11}, {818013, 64}, {818550, 9}, {818911, 55}, {819483, 47}, {820094, 20}, {820636, 59}, {821707, 52}, {821778, 42}, {822607, 37}, {822762, 64}, {822924, 10}, {823042, 18}, {823150, 3}, {823466, 12}, {823892, 27}, {824879, 47}, {825312, 62}, {825754, 66}, {825760, 19}, {827522, 23}, {827913, 17}, {828443, 55}, {829269, 6}, {831548, 10}, {832302, 46}, {832671, 40}, {833718, 33}, {833887, 47}, {835097, 48}, {835855, 40}, {836014, 53}, {836997, 52}, {837017, 61}, {837383, 57}, {837881, 48}, {839661, 42}, {839768, 53}, {840522, 20}, {841241, 17}, {842095, 62}, {842253, 33}, {842256, 33}, {844304, 55}, {844307, 61}, {844572, 7}, {845520, 38}, {847464, 64}, {847555, 45}, {847626, 64}, {847858, 17}, {848406, 58}, {849099, 19}, {849673, 61}, {850372, 20}, {851422, 30}, {851765, 43}, {851803, 9}, {852932, 47}, {852943, 22}, {853151, 54}, {853707, 53}, {854079, 39}, {854520, 35}, {854638, 29}, {854669, 2}, {856017, 62}, {856673, 46}, {857173, 11}, {857707, 34}, {858572, 63}, {858650, 51}, {859503, 59}, {860347, 6}, {860602, 55}, {861249, 33}, {861519, 63}, {862844, 20}, {863312, 42}, {863685, 19}, {863760, 27}, {864140, 49}, {867208, 16}, {867982, 15}, {868243, 42}, {870202, 19}, {871007, 61}, {871071, 58}, {871841, 20}, {872353, 64}, {872588, 20}, {872972, 8}, {873102, 25}, {873403, 52}, {873997, 43}, {874719, 34}, {875266, 63}, {875873, 38}, {875880, 5}, {876161, 56}, {877850, 11}, {878211, 28}, {878305, 4}, {878658, 41}, {878773, 52}, {879116, 38}, {879434, 32}, {879601, 39}, {880598, 56}, {881194, 45}, {881340, 57}, {881563, 42}, {881913, 36}, {882054, 16}, {882197, 48}, {882794, 5}, {883520, 37}, {883593, 27}, {884143, 14}, {884430, 34}, {885188, 3}, {885818, 34}, {886515, 43}, {887332, 15}, {887515, 52}, {887751, 59}, {888840, 38}, {889239, 36}, {890322, 48}, {890465, 19}, {890954, 64}, {891061, 8}, {891747, 14}, {892245, 49}, {892415, 57}, {892678, 41}, {893613, 1}, {894325, 60}, {894719, 31}, {894987, 18}, {895970, 41}, {896122, 20}, {896481, 27}, {897677, 63}, {897681, 22}, {897824, 37}, {898651, 45}, {898793, 29}, {899729, 27}, {900570, 8}, {900908, 59}, {901552, 36}, {902881, 60}, {903751, 60}, {906182, 61}, {907019, 47}, {907344, 55}, {907655, 55}, {907796, 9}, {907844, 29}, {908082, 45}, {909161, 8}, {909812, 42}, {909959, 14}, {910967, 50}, {911475, 64}, {911605, 43}, {912020, 19}, {912385, 26}, {913573, 9}, {913591, 35}, {913623, 64}, {914003, 63}, {915237, 60}, {915268, 41}, {915839, 60}, {915975, 11}, {916213, 64}, {916225, 36}, {916335, 15}, {916420, 17}, {916960, 54}, {917823, 12}, {919141, 19}, {919218, 49}, {919244, 13}, {919786, 55}, {920093, 28}, {921775, 19}, {921976, 1}, {923024, 15}, {923686, 13}, {925917, 11}, {926356, 43}, {927222, 16}, {927398, 48}, {929172, 54}, {929392, 51}, {930109, 10}, {930121, 53}, {930323, 58}, {930488, 39}, {930558, 56}, {931046, 57}, {931279, 51}, {931336, 18}, {931843, 59}, {932028, 62}, {932375, 50}, {932869, 14}, {933648, 43}, {934697, 36}, {936074, 19}, {937053, 34}, {937244, 6}, {937821, 13}, {940038, 22}, {940928, 5}, {941816, 1}, {941835, 42}, {942205, 44}, {942307, 6}, {944151, 21}, {944884, 54}, {945036, 57}, {945520, 3}, {945668, 56}, {945895, 52}, {946069, 16}, {946125, 51}, {949277, 8}, {949766, 4}, {950045, 18}, {950359, 31}, {951154, 65}, {951765, 63}, {952471, 50}, {952477, 41}, {952598, 17}, {952818, 37}, {953072, 18}, {953411, 18}, {953753, 19}, {954644, 19}, {954724, 31}, {955083, 26}, {955455, 4}, {956064, 28}, {956115, 63}, {956980, 59}, {958141, 47}, {958659, 61}, {961013, 55}, {961577, 1}, {964239, 54}, {964950, 31}, {965232, 49}, {967430, 35}, {967699, 4}, {970508, 42}, {972254, 14}, {972970, 66}, {973086, 32}, {974644, 55}, {974898, 33}, {975623, 17}, {975643, 60}, {975667, 48}, {976221, 33}, {977676, 16}, {977882, 12}, {978240, 45}, {978424, 52}, {978634, 57}, {978816, 47}, {980245, 54}, {980542, 65}, {981681, 57}, {982890, 64}, {983167, 49}, {983374, 4}, {986429, 7}, {987518, 63}, {987519, 42}, {987977, 30}, {988139, 14}, {988219, 3}, {988426, 45}, {989249, 10}, {989288, 23}, {990142, 61}, {990222, 16}, {990303, 30}, {991272, 19}, {992218, 59}, {992850, 10}, {993974, 22}, {995281, 36}, {995572, 61}, {996994, 47}, {997031, 24}, {997706, 30}, {997732, 6}, {997746, 38}, {998236, 57}, {998376, 59}, {999251, 37}, {999677, 32}}));
        OutputUtils.print1DDouleArray(getCollisionTimes(new int[][]{{3142, 14}, {4443, 39}, {5053, 41}, {5482, 32}, {5775, 35}, {6713, 7}, {8683, 47}, {8978, 4}, {9030, 11}, {10073, 18}, {15144, 52}, {15919, 48}, {16161, 31}, {19046, 13}, {19222, 43}, {21026, 36}, {22911, 2}, {24249, 66}, {24415, 42}, {25816, 15}, {27406, 46}, {28965, 17}, {30485, 35}, {31739, 52}, {31937, 12}, {34799, 61}, {35855, 54}, {36400, 51}, {37193, 39}, {38011, 29}, {42067, 39}, {42068, 18}, {43016, 7}, {44895, 66}, {45692, 15}, {47088, 23}, {47166, 31}, {48464, 28}, {49320, 56}, {49991, 36}, {51094, 3}, {52462, 33}, {52539, 35}, {53344, 34}, {55377, 61}, {58032, 17}, {58826, 52}, {59181, 14}, {59895, 48}, {60988, 9}, {61269, 47}, {61561, 65}, {63108, 4}, {63759, 40}, {63808, 58}, {67572, 17}, {68014, 20}, {70017, 10}, {72191, 19}, {73489, 28}, {75796, 62}, {76225, 43}, {76349, 47}, {80125, 38}, {81134, 21}, {81968, 20}, {82310, 49}, {82683, 57}, {83382, 52}, {88674, 16}, {89953, 19}, {91429, 35}, {92305, 38}, {93494, 2}, {94405, 2}, {94767, 17}, {94872, 49}, {95460, 13}, {95650, 59}, {95816, 4}, {96281, 56}, {98628, 55}, {99857, 36}, {101259, 48}, {102111, 53}, {103760, 52}, {104043, 60}, {104105, 7}, {105654, 13}, {107856, 61}, {108182, 5}, {108282, 1}, {109774, 6}, {110971, 15}, {112133, 18}, {116335, 66}, {118239, 46}, {118910, 35}, {121779, 46}, {121800, 61}, {122170, 32}, {122827, 31}, {123142, 14}, {123803, 46}, {124159, 21}, {124411, 15}, {125876, 6}, {127566, 41}, {127784, 55}, {129802, 45}, {132506, 33}, {132778, 8}, {133294, 56}, {134137, 54}, {134431, 49}, {135188, 46}, {135760, 38}, {136025, 44}, {136293, 57}, {136321, 31}, {136527, 19}, {136642, 8}, {137305, 44}, {139888, 15}, {141119, 66}, {141629, 23}, {146215, 63}, {146924, 44}, {147144, 16}, {150239, 3}, {151724, 62}, {152231, 27}, {155463, 50}, {155543, 23}, {155562, 51}, {155983, 30}, {156086, 13}, {156378, 32}, {156689, 43}, {156871, 43}, {158346, 32}, {159670, 60}, {163277, 61}, {164660, 48}, {167844, 64}, {170888, 25}, {175242, 56}, {175949, 57}, {176788, 52}, {180433, 16}, {180443, 63}, {181077, 35}, {181789, 17}, {183791, 20}, {184716, 2}, {186205, 49}, {187739, 54}, {190006, 14}, {193568, 4}, {195834, 10}, {196540, 24}, {197998, 59}, {198979, 49}, {199346, 65}, {201250, 37}, {204798, 20}, {205400, 20}, {209053, 14}, {209091, 33}, {209689, 3}, {210120, 60}, {210974, 51}, {211146, 30}, {213225, 51}, {214271, 1}, {215390, 32}, {216154, 55}, {222201, 21}, {223537, 23}, {224236, 44}, {224626, 31}, {224816, 10}, {225051, 21}, {225931, 23}, {227078, 49}, {227941, 3}, {228881, 66}, {230619, 28}, {230967, 55}, {231874, 31}, {232853, 6}, {235417, 25}, {235959, 65}, {237239, 10}, {239663, 32}, {240364, 51}, {242974, 60}, {244547, 16}, {246648, 7}, {247188, 50}, {253402, 12}, {254901, 13}, {257284, 62}, {257311, 6}, {257348, 31}, {258317, 2}, {262153, 3}, {262276, 40}, {263006, 60}, {263802, 36}, {264156, 54}, {265022, 22}, {265525, 18}, {266516, 41}, {268767, 58}, {268928, 65}, {269024, 54}, {270124, 22}, {270402, 51}, {270450, 50}, {272465, 26}, {272875, 64}, {272945, 36}, {273686, 47}, {274410, 20}, {278224, 34}, {278638, 36}, {280030, 23}, {280070, 11}, {280530, 47}, {280991, 44}, {281937, 19}, {282145, 34}, {283105, 33}, {283286, 33}, {283470, 45}, {285169, 50}, {285915, 36}, {286881, 60}, {286970, 2}, {287902, 20}, {287913, 17}, {292295, 33}, {292837, 29}, {293195, 26}, {293383, 10}, {293783, 26}, {295232, 55}, {296230, 31}, {297420, 18}, {297536, 59}, {301094, 51}, {301168, 26}, {301232, 11}, {302612, 10}, {305478, 20}, {308542, 8}, {312813, 4}, {313896, 52}, {314431, 49}, {315094, 54}, {316502, 18}, {316576, 17}, {317356, 10}, {318140, 31}, {318500, 49}, {320136, 18}, {320652, 37}, {322320, 26}, {322710, 51}, {322818, 46}, {327877, 23}, {328422, 29}, {328887, 39}, {330686, 19}, {330881, 45}, {332515, 63}, {334286, 38}, {335099, 12}, {339970, 66}, {341090, 39}, {341222, 27}, {341388, 60}, {341843, 3}, {343477, 38}, {343557, 14}, {345826, 48}, {345857, 57}, {346074, 33}, {346143, 8}, {346154, 7}, {352221, 41}, {352890, 21}, {353464, 17}, {354833, 14}, {355100, 15}, {355115, 56}, {356990, 32}, {357641, 27}, {359078, 65}, {362157, 65}, {363544, 51}, {363729, 16}, {363858, 28}, {363881, 50}, {366598, 18}, {368917, 33}, {369745, 1}, {370386, 16}, {371717, 26}, {379142, 49}, {381856, 62}, {384996, 30}, {385546, 35}, {385631, 5}, {385986, 22}, {386257, 65}, {388115, 30}, {388239, 53}, {388343, 36}, {390735, 54}, {396251, 52}, {397701, 35}, {397924, 64}, {398651, 13}, {399013, 17}, {399211, 24}, {401760, 3}, {402042, 59}, {402901, 6}, {405133, 63}, {406084, 28}, {407329, 51}, {408147, 44}, {408519, 32}, {408633, 13}, {408648, 10}, {410090, 6}, {412178, 55}, {414385, 57}, {418519, 25}, {419122, 23}, {419356, 65}, {421428, 25}, {421674, 66}, {422131, 50}, {423356, 47}, {427096, 26}, {427524, 30}, {428135, 47}, {429395, 9}, {431079, 44}, {431423, 7}, {431640, 59}, {432695, 6}, {432969, 23}, {433903, 19}, {435363, 37}, {436841, 61}, {437873, 6}, {440014, 65}, {441193, 9}, {441313, 51}, {442373, 12}, {442777, 52}, {444722, 66}, {444783, 39}, {445467, 51}, {445774, 35}, {446111, 46}, {446271, 61}, {448462, 7}, {448898, 62}, {449288, 3}, {453080, 55}, {453520, 39}, {454561, 41}, {461637, 20}, {463772, 36}, {464886, 9}, {465760, 47}, {467753, 54}, {469021, 51}, {469253, 4}, {470404, 15}, {471665, 5}, {473027, 2}, {473639, 13}, {473762, 43}, {474160, 44}, {474504, 48}, {476203, 5}, {478307, 48}, {480724, 10}, {485046, 63}, {485375, 11}, {486922, 58}, {487139, 43}, {491958, 65}, {493407, 1}, {502468, 21}, {503000, 42}, {503016, 47}, {503094, 28}, {503471, 19}, {503735, 19}, {503744, 14}, {504525, 52}, {504806, 41}, {505580, 66}, {507222, 54}, {509393, 47}, {509582, 44}, {510314, 34}, {510737, 48}, {515194, 5}, {515246, 9}, {516081, 32}, {516400, 34}, {517594, 51}, {517715, 37}, {518480, 11}, {519070, 10}, {520443, 22}, {522151, 35}, {522986, 53}, {523934, 11}, {525397, 17}, {525471, 37}, {527161, 34}, {527452, 31}, {528427, 27}, {530913, 13}, {532197, 36}, {532487, 62}, {532692, 7}, {534061, 66}, {534109, 39}, {534846, 27}, {536322, 10}, {537387, 41}, {537752, 44}, {538747, 38}, {539266, 18}, {543021, 5}, {543614, 57}, {545343, 47}, {545368, 5}, {546039, 4}, {546390, 41}, {547537, 54}, {549152, 21}, {549188, 6}, {549989, 55}, {550402, 24}, {551161, 26}, {551686, 30}, {551947, 15}, {554154, 17}, {554211, 65}, {557282, 16}, {557831, 35}, {557978, 59}, {558661, 26}, {559606, 8}, {560450, 47}, {560740, 59}, {561638, 43}, {562462, 46}, {562788, 29}, {563065, 2}, {564233, 2}, {565000, 63}, {566794, 5}, {567042, 22}, {568371, 33}, {568932, 6}, {569407, 2}, {570925, 30}, {571260, 11}, {572217, 23}, {573494, 5}, {573592, 26}, {576294, 27}, {576711, 57}, {578161, 37}, {579689, 32}, {584243, 63}, {585783, 65}, {587473, 48}, {588094, 42}, {590113, 51}, {590425, 10}, {590622, 25}, {592178, 24}, {593399, 25}, {595146, 39}, {598964, 55}, {599753, 61}, {600950, 47}, {601657, 3}, {601892, 63}, {602833, 3}, {603565, 14}, {606372, 56}, {607092, 44}, {608104, 44}, {608441, 10}, {608748, 54}, {609286, 25}, {609604, 66}, {612516, 64}, {612996, 65}, {614747, 62}, {616485, 58}, {618217, 61}, {619037, 22}, {619180, 35}, {622455, 39}, {626539, 51}, {627131, 34}, {627323, 33}, {627567, 40}, {628105, 2}, {630340, 6}, {632050, 59}, {634759, 59}, {635157, 46}, {635554, 30}, {638563, 66}, {640327, 57}, {641616, 27}, {642965, 61}, {643032, 43}, {643444, 19}, {645267, 50}, {645760, 56}, {649808, 7}, {652789, 15}, {653847, 46}, {655834, 2}, {656045, 33}, {660567, 7}, {660631, 40}, {661718, 49}, {662848, 2}, {664444, 42}, {666122, 44}, {666484, 40}, {666724, 7}, {667592, 27}, {668072, 11}, {668481, 43}, {669392, 16}, {672171, 9}, {672770, 17}, {673269, 38}, {674485, 53}, {674760, 44}, {675568, 30}, {676382, 4}, {676399, 24}, {677427, 65}, {681219, 47}, {682746, 39}, {683242, 38}, {683833, 49}, {684275, 54}, {689211, 60}, {691004, 10}, {691961, 26}, {693684, 53}, {694562, 30}, {695128, 6}, {695223, 31}, {696524, 29}, {697106, 32}, {701185, 51}, {702207, 49}, {704273, 27}, {708419, 20}, {709684, 39}, {710717, 47}, {712055, 1}, {713756, 40}, {714293, 57}, {714413, 64}, {715087, 22}, {716492, 19}, {717808, 4}, {718030, 48}, {720132, 56}, {720626, 44}, {723631, 66}, {724903, 63}, {724917, 41}, {726283, 15}, {727892, 38}, {729204, 36}, {729805, 55}, {731966, 2}, {732272, 40}, {735352, 12}, {736508, 63}, {737062, 15}, {737068, 65}, {738118, 29}, {738369, 34}, {740569, 56}, {742023, 48}, {743232, 30}, {744781, 7}, {746218, 14}, {748208, 66}, {749374, 66}, {749664, 66}, {750220, 21}, {750970, 17}, {753681, 38}, {754327, 7}, {756145, 9}, {758651, 28}, {759130, 1}, {761076, 8}, {762112, 55}, {763322, 3}, {764709, 9}, {765634, 8}, {768194, 2}, {770201, 5}, {770936, 44}, {771894, 43}, {772408, 3}, {775115, 2}, {775443, 28}, {777122, 61}, {777664, 26}, {779146, 35}, {779278, 38}, {779280, 33}, {779389, 30}, {780785, 24}, {782919, 27}, {783059, 51}, {783140, 8}, {784874, 31}, {785108, 58}, {785765, 5}, {787075, 43}, {787495, 42}, {788748, 53}, {788977, 16}, {794586, 3}, {795409, 24}, {795782, 65}, {796564, 12}, {796766, 24}, {798395, 28}, {800486, 29}, {803550, 23}, {805973, 39}, {807384, 13}, {807753, 8}, {810035, 41}, {811377, 19}, {812336, 9}, {814292, 57}, {814742, 20}, {818722, 30}, {819504, 6}, {821687, 37}, {822030, 45}, {822825, 8}, {824346, 12}, {824625, 57}, {826241, 26}, {827025, 30}, {831818, 24}, {832289, 16}, {832792, 8}, {833170, 26}, {834570, 7}, {834910, 15}, {835622, 12}, {836180, 29}, {836933, 37}, {837775, 33}, {839274, 55}, {840295, 32}, {842563, 5}, {844231, 33}, {846117, 25}, {846675, 42}, {848799, 45}, {849559, 46}, {851159, 59}, {851396, 49}, {852551, 50}, {853575, 12}, {853597, 55}, {854256, 32}, {854496, 63}, {854536, 44}, {855250, 23}, {856832, 15}, {858331, 31}, {859990, 10}, {861641, 56}, {861788, 36}, {862148, 39}, {864262, 43}, {869298, 48}, {869921, 53}, {872014, 59}, {874893, 47}, {874980, 46}, {875337, 41}, {875466, 51}, {878569, 61}, {878984, 66}, {880784, 3}, {881459, 48}, {881645, 17}, {882258, 39}, {883306, 22}, {885005, 39}, {886700, 17}, {887456, 20}, {888805, 22}, {889102, 59}, {891948, 20}, {892487, 18}, {893560, 21}, {893655, 11}, {894540, 33}, {895355, 31}, {896081, 46}, {896691, 41}, {897435, 22}, {899247, 36}, {899519, 61}, {899557, 40}, {901456, 10}, {902875, 55}, {903058, 20}, {903699, 46}, {907536, 58}, {908484, 14}, {911141, 20}, {918628, 41}, {918875, 9}, {922653, 24}, {922779, 62}, {922858, 5}, {925175, 6}, {925575, 25}, {927241, 46}, {928158, 47}, {930274, 65}, {930288, 46}, {930354, 65}, {931081, 48}, {932006, 44}, {932055, 16}, {932795, 24}, {934577, 49}, {934815, 5}, {936162, 35}, {938481, 27}, {938823, 8}, {938910, 32}, {939234, 39}, {940383, 42}, {942261, 52}, {942406, 32}, {942421, 47}, {942523, 7}, {943733, 30}, {947384, 38}, {948115, 1}, {949011, 26}, {949044, 13}, {949370, 18}, {950099, 29}, {950856, 48}, {953667, 65}, {956674, 35}, {956955, 19}, {957230, 21}, {957393, 30}, {958063, 10}, {958368, 40}, {958837, 66}, {963272, 66}, {963474, 56}, {964607, 57}, {967091, 66}, {967875, 61}, {970105, 24}, {970398, 66}, {970786, 46}, {971023, 26}, {971810, 56}, {972678, 10}, {978721, 36}, {980576, 27}, {980593, 30}, {982016, 19}, {984670, 18}, {984819, 27}, {985270, 3}, {988088, 21}, {990627, 63}, {991811, 47}, {992064, 24}, {995462, 7}, {995759, 47}, {998422, 11}, {999680, 31}}));
        OutputUtils.print1DDouleArray(getCollisionTimes(new int[][]{{1, 2}, {11, 4}, {13, 1}, {18, 5}, {19, 2}, {20, 4}}));
        OutputUtils.print1DDouleArray(getCollisionTimes(new int[][]{{1, 4}, {4, 5}, {7, 1}, {13, 4}, {14, 3}, {15, 2}, {16, 5}, {19, 1}}));
        OutputUtils.print1DDouleArray(getCollisionTimes(new int[][]{{1, 2}, {2, 1}, {4, 3}, {7, 2}}));
        OutputUtils.print1DDouleArray(getCollisionTimes(new int[][]{{3, 4}, {5, 4}, {6, 3}, {9, 1}}));
    }

    public static double[] getCollisionTimes(int[][] cars) {
        double[] result = new double[cars.length];
        List<Double> times = new ArrayList<>();
        List<Integer> speeds = new ArrayList<>();
        times.add(0d);
        speeds.add(cars[cars.length - 1][1]);
        result[cars.length - 1] = -1;
        outer:
        for (int i = cars.length - 2; i >= 0; i--) {
            double diff = cars[i + 1][0] - cars[i][0];
            List<Double> currTimes = new ArrayList<>();
            List<Integer> currSpeeds = new ArrayList<>();
            currTimes.add(0d);
            currSpeeds.add(cars[i][1]);

            for (int j = 0; j < speeds.size(); j++) {
                if (j + 1 == speeds.size()) {
                    if (cars[i][1] <= speeds.get(j)) {
                        result[i] = -1;
                    } else {
                        result[i] = times.get(j) + diff / (cars[i][1] - speeds.get(j));
                        currTimes.add(result[i]);
                        currSpeeds.add(speeds.get(j));
                    }
                    times = currTimes;
                    speeds = currSpeeds;
                    continue outer;
                } else {
                    if ((cars[i][1] - speeds.get(j)) * (times.get(j + 1) - times.get(j)) >= diff) {
                        result[i] = times.get(j) + diff / (cars[i][1] - speeds.get(j));
                        currTimes.add(result[i]);
                        currSpeeds.add(speeds.get(j));

                        for (int k = j + 1; k < speeds.size(); k++) {
                            currTimes.add(times.get(k));
                            currSpeeds.add(speeds.get(k));
                        }
                        times = currTimes;
                        speeds = currSpeeds;
                        continue outer;
                    } else {
                        diff = diff + (speeds.get(j) - cars[i][1]) * (times.get(j + 1) - times.get(j));
                    }
                }
            }
        }
        return result;
    }
}
