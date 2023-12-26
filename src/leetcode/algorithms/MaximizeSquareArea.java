package leetcode.algorithms;

import java.util.Collections;
import java.util.Objects;
import java.util.TreeSet;

/**
 * Description: 2975. Maximum Square Area by Removing Fences From a Field
 *
 * @author baltan
 * @date 2023/12/26 17:38
 */
public class MaximizeSquareArea {
    public static void main(String[] args) {
        System.out.println(maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2}));
        System.out.println(maximizeSquareArea(6, 7, new int[]{2}, new int[]{4}));
        System.out.println(maximizeSquareArea(603, 602, new int[]{15, 103, 558, 306, 20, 428, 426, 366, 544, 74, 385, 272, 55, 2, 56, 541, 119, 463, 600, 587, 311, 180, 520, 574, 494, 89, 320, 168, 161, 392, 454, 412, 499, 323, 482, 387, 34, 519, 433, 461, 111, 142, 54, 195, 369, 224, 371, 300, 59, 172, 79, 328, 326, 273, 374, 566, 160, 419, 496, 578, 282, 397, 327, 318, 110, 440, 597, 190, 179, 513, 165, 46, 559, 241, 382, 511, 347, 286, 279, 331, 163, 19, 149, 551, 275, 562, 228, 4, 422, 581, 530, 573, 307, 141, 452, 353, 469, 329, 517, 120, 189, 533, 571, 17, 389, 52, 264, 293, 529, 197, 480, 112, 310, 187, 584, 205, 439, 576, 554, 302, 227, 343, 396, 425, 590, 346, 213, 169, 93, 49, 151, 487, 450, 537, 457, 495, 321, 199, 470, 201, 359, 240, 398, 121, 87, 598, 18, 132, 244, 472, 198, 154, 117, 23, 599, 206, 167, 145, 62, 237, 594, 436, 32, 140, 147, 386, 473, 416, 502, 36, 174, 148, 208, 166, 16, 411, 535, 38, 139, 395, 509, 296, 506, 127, 295, 86, 232, 150, 193, 223, 267, 278, 192, 401, 78, 350, 466, 504, 218, 349, 319, 577, 171, 493, 235, 486, 214, 66, 284, 312, 115, 39, 460, 8, 162, 80, 542, 85, 403, 207, 99, 477, 5, 474, 408, 317, 12, 510, 455, 373, 14, 269, 451, 583, 342, 40, 186, 447, 58, 29, 164, 414, 316, 568, 230, 352, 399, 498, 560, 106, 155, 274, 250, 540, 481, 507, 514, 301, 356, 376, 479, 490, 358, 251, 393, 91, 521, 430, 185, 464, 515, 334, 546, 497, 261, 400, 42, 65, 128, 137, 449, 484, 564, 345, 184, 467, 368, 406, 41, 404, 582, 602, 243, 285, 330, 341, 83, 333, 13, 219, 118, 229, 70, 204, 245, 305, 182, 572, 61, 28, 298, 134, 270, 129, 82, 324, 410, 108, 291, 138, 69, 354, 364, 50, 90, 33, 534, 325, 294, 531, 372, 254, 10, 441, 409, 156, 51, 297, 427, 315, 196, 549, 351, 421, 585, 453, 299, 104, 181, 125, 247, 483, 280, 446, 107, 335, 246, 478, 173, 135, 159, 100, 357, 512, 233, 3, 402, 271, 72, 462, 9, 567, 21, 378, 501, 595, 363, 314, 44, 532, 290, 256, 200, 491, 191, 528, 262, 338, 485, 216, 580, 153, 492, 471, 225, 276, 308, 563, 53, 340, 76, 217, 7, 252, 527, 503, 391, 57, 379, 212, 543, 458, 24, 71, 158, 413, 596, 561, 96, 360, 176, 130, 592, 588, 178, 202, 27, 238, 417, 593, 383, 476, 94, 500, 84, 183, 177, 289, 146, 388, 253, 438, 407, 367, 384, 266, 101, 283, 443, 210, 361, 444, 81, 43, 209, 381, 355, 522, 152, 579, 552, 64, 475, 6, 548, 73, 553, 405, 133, 45, 586, 258, 211, 344, 124, 332, 257, 434, 459, 105, 31, 143, 423, 136, 508, 248, 114, 375, 601, 545, 337, 48, 424, 377, 22, 536, 268, 339, 242, 465, 188, 220, 30, 488, 131, 95, 222, 288, 92, 123, 565, 557, 429, 431, 277, 322, 113, 418, 575, 539, 336, 456, 35, 448, 525, 231, 313, 550, 523, 309, 175, 555, 215, 468, 526, 37, 538, 116, 432, 126, 265, 524, 68, 109, 67, 263, 303, 260, 365, 255, 420, 589, 569, 75, 370, 234, 203, 60, 380, 157, 570, 63, 394, 445, 547, 591, 25, 435, 292, 239, 11, 415, 287, 236, 489, 259, 518, 122, 88, 194, 226, 26, 348, 249, 304, 516, 362, 442, 437, 556, 505, 221, 170, 390, 47, 98, 102, 97, 77, 281}, new int[]{295, 415, 568, 213, 161, 53, 558, 601, 419, 544, 420, 600, 504, 12, 306, 200, 49, 421, 528, 280, 377, 321, 324, 29, 329, 201, 521, 517, 407, 538, 336, 247, 301, 52, 338, 309, 555, 196, 489, 93, 74, 11, 256, 65, 437, 349, 116, 123, 452, 268, 159, 331, 310, 70, 360, 148, 484, 392, 552, 163, 374, 105, 470, 281, 562, 265, 61, 523, 461, 44, 387, 333, 39, 576, 513, 242, 100, 497, 455, 526, 522, 473, 529, 225, 64, 496, 198, 194, 469, 397, 221, 339, 205, 572, 486, 570, 288, 108, 468, 311, 446, 292, 91, 550, 253, 405, 13, 502, 6, 492, 590, 313, 9, 356, 466, 54, 577, 599, 69, 435, 476, 290, 527, 279, 463, 10, 109, 129, 191, 249, 166, 75, 71, 343, 263, 18, 171, 596, 371, 303, 442, 467, 206, 141, 167, 14, 436, 257, 145, 284, 115, 472, 399, 378, 269, 197, 412, 178, 457, 140, 294, 272, 277, 478, 45, 545, 425, 25, 391, 114, 113, 417, 556, 187, 208, 36, 515, 375, 450, 48, 326, 465, 411, 155, 585, 373, 344, 363, 162, 157, 557, 27, 16, 172, 519, 393, 24, 440, 252, 239, 318, 403, 445, 516, 358, 132, 357, 459, 58, 506, 102, 43, 494, 152, 520, 598, 471, 458, 444, 389, 259, 293, 183, 151, 498, 477, 302, 226, 138, 490, 80, 429, 97, 289, 317, 342, 353, 216, 38, 230, 176, 142, 537, 443, 394, 432, 170, 255, 133, 355, 150, 319, 63, 491, 406, 244, 433, 508, 441, 314, 237, 83, 546, 547, 110, 199, 246, 179, 30, 98, 92, 427, 431, 245, 448, 222, 362, 543, 578, 553, 422, 400, 548, 175, 86, 372, 189, 512, 120, 193, 7, 143, 190, 438, 224, 250, 5, 107, 181, 479, 88, 586, 59, 192, 365, 264, 561, 186, 414, 147, 401, 539, 62, 47, 495, 111, 85, 424, 238, 298, 229, 580, 514, 368, 291, 79, 236, 21, 348, 369, 15, 254, 583, 563, 136, 567, 188, 581, 160, 82, 345, 234, 588, 19, 503, 505, 144, 20, 594, 40, 227, 322, 540, 207, 95, 195, 408, 149, 481, 334, 296, 439, 464, 278, 487, 218, 328, 592, 37, 156, 351, 174, 582, 510, 219, 124, 94, 128, 413, 384, 28, 483, 453, 395, 214, 241, 346, 366, 168, 202, 232, 500, 119, 410, 33, 203, 51, 571, 559, 223, 55, 297, 402, 282, 388, 139, 89, 118, 122, 130, 325, 42, 507, 125, 404, 564, 488, 267, 418, 462, 595, 341, 231, 283, 426, 41, 220, 248, 146, 315, 560, 551, 287, 323, 274, 518, 67, 164, 511, 270, 316, 299, 32, 447, 501, 390, 449, 396, 90, 121, 153, 573, 305, 57, 416, 76, 211, 72, 579, 347, 460, 430, 22, 2, 184, 84, 381, 68, 474, 34, 103, 137, 262, 591, 217, 541, 165, 3, 386, 300, 73, 117, 370, 106, 575, 524, 127, 383, 525, 60, 134, 589, 482, 112, 8, 532, 493, 312, 243, 454, 584, 530, 258, 31, 379, 180, 456, 354, 56, 531, 96, 158, 212, 185, 574, 499, 535, 587, 81, 182, 215, 271, 554, 380, 286, 382, 361, 367, 542, 26, 50, 87, 260, 337, 4, 534, 423, 340, 104, 210, 475, 509, 533, 352, 46, 428, 66, 78, 335, 451, 308, 23, 327, 536, 307, 332, 398, 434, 235, 209, 385, 565, 359, 376, 364, 154, 320, 251, 569, 17, 233, 285, 275, 266, 99, 330, 126, 169, 261, 597, 101, 350, 409, 228, 549, 177, 593, 276, 204, 131, 135, 77, 304, 173, 240, 35, 480, 566, 485}));
    }

    public static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int mod = 1000000007;
        TreeSet<Integer> hSet = new TreeSet<>(Collections.reverseOrder());
        TreeSet<Integer> vSet = new TreeSet<>(Collections.reverseOrder());
        int[] hFences1 = new int[hFences.length + 2];
        int[] vFences1 = new int[vFences.length + 2];
        hFences1[0] = 1;
        hFences1[hFences1.length - 1] = m;
        vFences1[0] = 1;
        vFences1[vFences1.length - 1] = n;
        System.arraycopy(hFences, 0, hFences1, 1, hFences.length);
        System.arraycopy(vFences, 0, vFences1, 1, vFences.length);

        for (int i = 0; i < hFences1.length; i++) {
            for (int j = i + 1; j < hFences1.length; j++) {
                hSet.add(Math.abs(hFences1[i] - hFences1[j]));
            }
        }

        for (int i = 0; i < vFences1.length; i++) {
            for (int j = i + 1; j < vFences1.length; j++) {
                vSet.add(Math.abs(vFences1[i] - vFences1[j]));
            }
        }

        while (!hSet.isEmpty() && !vSet.isEmpty()) {
            if (Objects.equals(hSet.first(), vSet.first())) {
                return (int) ((long) hSet.first() * vSet.first() % mod);
            } else if (hSet.first() > vSet.first()) {
                hSet.pollFirst();
            } else {
                vSet.pollFirst();
            }
        }
        return -1;
    }
}
