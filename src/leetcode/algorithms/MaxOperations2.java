package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3040. Maximum Number of Operations With the Same Score II
 *
 * @author baltan
 * @date 2024/2/22 08:58
 */
public class MaxOperations2 {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000}));
        System.out.println(maxOperations(new int[]{266, 186, 419, 33, 112, 340, 67, 385, 149, 303, 412, 40, 275, 177, 202, 250, 200, 252, 19, 433, 157, 295, 55, 397, 172, 280, 425, 27, 122, 330, 247, 205, 409, 43, 277, 175, 322, 130, 79, 373, 169, 283, 376, 76, 324, 128, 410, 42, 381, 71, 145, 307, 114, 338, 71, 381, 180, 272, 102, 350, 304, 148, 16, 436, 34, 418, 296, 156, 411, 41, 159, 293, 448, 4, 406, 46, 349, 103, 375, 77, 221, 231, 362, 90, 31, 421, 31, 421, 409, 43, 210, 242, 229, 223, 282, 170, 128, 324, 190, 262, 396, 56, 85, 367, 8, 444, 194, 258, 384, 68, 80, 372, 210, 242, 447, 5, 73, 379, 90, 362, 160, 292, 260, 192, 399, 53, 336, 116, 363, 89, 40, 412, 79, 373, 176, 276, 27, 425, 375, 77, 91, 361, 111, 341, 361, 91, 198, 254, 331, 121, 152, 300, 213, 239, 135, 317, 446, 6, 331, 121, 110, 342, 145, 307, 366, 86, 393, 59, 361, 91, 434, 18, 372, 190, 186, 147, 401, 415, 652, 736, 116, 567, 609, 83, 616, 49, 497, 93, 441, 248, 230, 560, 295, 608, 671, 510, 421, 122, 598, 252, 93, 135, 186, 169, 160, 91, 253, 506, 724, 269, 239, 454, 75, 518, 397, 180, 531, 328, 128, 225, 47, 34, 106, 596, 512, 363, 143, 480, 556, 417, 152, 73, 187, 274, 171, 22, 346, 677, 409, 392, 3, 311, 304, 3, 215, 308, 723, 136, 199, 421, 415, 83, 366, 208, 306, 453, 204, 62, 424, 305, 35, 561, 128, 335, 336, 342, 158, 563, 95, 668, 276, 535, 38, 630, 20, 620, 446, 154, 112, 28, 27, 387, 431, 559, 716, 566, 576, 45, 11, 706, 318, 297, 23, 337, 550, 144, 466, 572, 132, 669, 399, 357, 143, 288, 388, 559, 693, 216, 537, 304, 650, 553, 168, 273, 512, 572, 250, 552, 157, 187, 381, 505, 78, 261, 505, 176, 619, 614, 103, 611, 235, 280, 72, 440, 301, 361, 536, 358, 136, 70, 246, 523, 148, 106, 574, 345, 399, 86, 40, 650, 601, 121, 264, 100, 231, 484, 285, 470, 566, 321, 200, 493, 564, 597, 694, 228, 730, 658, 158, 736, 249, 375, 500, 309, 185, 583, 168, 515, 530, 128, 478, 638, 214, 726, 18, 587, 507, 254, 152, 259, 635, 405, 304, 173, 639, 597, 277, 530, 389, 543, 182, 159, 108, 132, 43, 393, 503, 226, 535, 639, 124, 231, 403, 457, 594, 363, 739, 221, 331, 222, 45, 322, 307, 668, 171, 564, 514, 80, 478, 354, 609, 382, 39, 243, 376, 489, 97, 97, 575, 702, 578, 137, 673, 455, 508, 26, 306, 65, 483, 610, 107, 624, 323, 160, 331, 677, 214, 658, 92, 15, 599, 571, 397, 112, 81, 89, 273, 401, 497, 524, 225, 396, 41, 362, 535, 191, 527, 723, 740, 702, 571, 316, 498, 290, 33, 587, 378, 136, 70, 606, 79, 582, 212, 632, 545, 207, 721, 470, 419, 245, 644, 17, 533, 446, 318, 316, 559, 96, 112, 253, 546, 662, 160, 600, 538, 331, 350, 516, 99, 161, 578, 129, 620, 727, 324, 481, 191, 58, 345, 450, 48, 618, 298, 120, 714, 739, 486, 48, 104, 613, 393, 348, 361, 263, 681, 742, 405, 73, 193, 575, 490, 272, 492, 635, 337, 73, 254, 230, 552, 426, 631, 127, 123, 706, 265, 291, 256, 172, 591, 638, 582, 643, 561, 564, 93, 224, 573, 706, 719, 673, 257, 446, 125, 738, 47, 216, 185, 132, 298, 72, 570, 338, 396, 566, 224, 736, 399, 699, 83, 32, 16, 603, 511, 593, 183, 496, 162, 10, 530, 636, 316, 130, 678, 613, 120, 658, 133, 515, 454, 98, 356, 135, 370, 645, 741, 111, 167, 583, 168, 536, 620, 312, 146, 206, 664, 53, 90, 599, 679, 200, 590, 362, 350, 39, 1, 644, 376, 546, 470, 584, 107, 364, 552, 655, 154, 630, 443, 323, 246, 670, 694, 489, 42, 66, 585, 612, 588, 449, 234, 588, 589, 539, 714, 691, 581, 343, 214, 735, 609, 709, 45, 566, 499, 336, 141, 572, 89, 661, 210, 308, 124, 74, 466, 477, 640, 425, 184, 668, 372, 337, 485, 455, 583, 643, 568, 461, 697, 591, 515, 386, 433, 117, 715, 418, 717, 202, 679, 212, 446, 71, 237, 489, 324, 30, 212, 48, 533, 203, 286, 290, 658, 566, 42, 564, 547, 714, 438, 445, 372, 477, 642, 707, 514, 39, 493, 374, 451, 377, 512, 659, 632, 227, 441, 83, 240, 439, 553, 10, 346, 346, 539, 40, 462, 348, 704, 658, 209, 349, 86, 595, 553, 619, 718, 213, 473, 82, 506, 693, 350, 280, 206, 462, 457, 558, 676, 697, 548, 426, 59, 72, 442, 101, 251, 439, 296, 649, 337, 58, 322, 328, 673, 621, 224, 419, 194, 180, 289, 445, 606, 74, 436, 512, 269, 330, 400, 10, 606, 395, 253, 539, 629, 248, 322, 276, 680, 181, 445, 11, 545, 651, 515, 349, 92, 472, 101, 289, 673, 657, 129, 153, 627, 474, 273, 154, 291, 310, 379, 214, 640, 300, 668, 318, 525, 1, 742, 639, 598, 149, 220, 572, 482, 734, 232, 395, 219, 109, 343, 165, 661, 98, 680, 580, 669, 665, 580, 112, 243, 342, 477, 482, 186, 143, 704, 563, 4, 133, 583, 685, 401, 5, 33, 736, 404, 169, 574, 686, 91, 34, 217, 391, 452, 221, 422, 83, 578, 232, 741, 436, 444, 82, 22, 16, 428, 518, 705, 172, 188, 253, 594, 233, 270, 173, 717, 44, 239, 230, 140, 151, 564, 276, 3, 547, 41, 441, 186, 439, 667, 445, 710, 403, 589, 216, 425, 239, 256, 408, 171, 400, 26, 45, 306, 493, 173, 324, 125, 563, 260, 507, 550, 29, 583, 482, 206, 482, 206, 579, 686, 692, 243, 37, 691, 130, 88, 182, 264, 211, 208, 676, 310, 237, 599, 264, 563, 607, 89, 681, 76, 11, 38, 272, 460, 739, 299, 2, 474, 129, 260, 722, 584, 570, 81, 404, 283, 76, 549, 516, 298, 248, 628, 611, 462, 291, 705, 96, 49, 552, 469, 503, 180, 23, 70, 322, 34, 346, 493, 75, 730, 656, 99, 731, 431, 577, 369, 132, 640, 96, 100, 298, 632, 224, 72, 361, 5, 144, 402, 609, 566, 152, 63, 507, 433, 443, 276, 387, 172, 222, 63, 576, 488, 498, 120, 301, 569, 248, 720, 673, 590, 202, 358, 609, 447, 520, 571, 603, 468, 459, 99, 682, 87, 74, 693, 524, 505, 598, 165, 247, 737, 358, 8, 88, 470, 698, 602, 359, 597, 347, 35, 98, 526, 152, 167, 47, 373, 424, 310, 459, 579, 72, 150, 387, 94, 140, 451, 652, 231, 353, 109, 353, 357, 255, 620, 200, 84, 214, 500, 159, 230, 181, 126, 298, 484, 23, 484, 155, 99, 585, 430, 643, 350, 69, 447, 491, 613, 260, 540, 285, 271, 620, 131, 530, 339, 543, 237, 490, 443, 647, 30, 685, 161, 11, 423, 672, 183, 632, 185, 296, 323, 343, 177, 536, 473, 465, 742, 65, 73, 671, 699, 686, 559, 503, 370, 512, 312, 459, 193, 704, 160, 549, 524, 388, 689, 17, 611, 12, 310, 45, 416, 408, 169, 742, 194, 258, 426, 708, 660, 118, 328, 11, 372, 64, 105, 521, 440, 510, 508, 249, 620, 663, 87, 381, 569, 581, 687, 397, 151, 164, 520, 261, 471, 538, 224, 551, 406, 426, 376, 172, 650, 475, 163, 688, 159, 86, 365, 443, 441, 128, 214, 552, 43, 466, 272, 174, 268, 291, 206, 568, 219, 600, 463, 238, 367, 132, 719, 436, 591, 251, 365, 141, 232, 166, 41, 562, 126, 9, 194, 433, 43, 573, 131, 638, 594, 506, 482, 184, 74, 605, 659, 236, 657, 528, 574, 616, 651, 655, 376, 141, 600, 186, 451, 388, 399, 168, 396, 355, 322, 122, 519, 3, 434, 66, 387, 164, 499, 123, 139, 579, 77, 467, 445, 8, 236, 295, 717, 348, 736, 316, 16, 611, 139, 285, 717, 175, 157, 364, 341, 336, 424, 442, 8, 709, 495, 518, 713, 427, 197, 12, 698, 361, 34, 351, 376, 531, 460, 136, 192, 440, 135, 502, 157, 591, 218, 732, 675, 355, 617, 442, 243, 561, 564, 470, 575, 633, 469, 693, 718, 142, 498, 144, 388, 266, 459, 732, 596, 383, 37, 615, 693, 549, 592, 241, 441, 1, 208, 59, 277, 50, 315, 391, 106, 313, 397, 300, 257, 122, 342, 579, 585, 231, 550, 567, 100, 140, 53, 299, 720, 338, 204, 327, 563, 557, 550, 122, 631, 615, 341, 30, 620, 392, 237, 144, 363, 496, 633, 628, 268, 596, 357, 728, 464, 677, 701, 154, 539, 77, 644, 7, 51, 309, 388, 685, 695, 86, 202, 172, 675, 51, 501, 499, 381, 201, 594, 226, 202, 507, 628, 102, 461, 126, 169, 435, 557, 560, 328, 76, 151, 206, 431, 594, 567, 66, 565, 97, 553, 362, 553, 678, 640, 512, 468, 664, 682, 383, 233, 412, 595, 187, 376, 585, 68, 57, 709, 738, 481, 226, 227, 438, 712, 39, 41, 449, 10, 124, 163, 641, 736, 67, 125, 242, 231, 443, 627, 718, 646, 369, 322, 42, 366, 97, 247, 543, 468, 385, 233, 707, 422, 387, 311, 600, 525, 273, 231, 402, 701, 90, 166, 132, 303, 628, 131, 718, 224, 149, 540, 225, 413, 584, 412, 392, 61, 714, 251, 409, 481, 524, 289, 234, 346, 38, 222, 523, 41, 354, 491, 184, 417, 492, 224, 96, 138, 132, 621, 147, 385, 266, 476, 178, 309, 243, 720, 232, 416, 265, 154, 123, 249, 671, 717, 691, 151, 48, 430, 329, 403, 712, 565, 157, 430, 459, 640, 133, 522, 237, 139, 387, 571, 79, 369, 177, 680, 608, 679, 84, 356, 215, 553, 694, 103, 519, 413, 453, 161, 324, 342, 161, 296, 669, 201, 476, 690, 736, 608, 726, 674, 57, 439, 402, 699, 467, 237, 677, 463, 99, 504, 501, 146, 495, 460, 335, 332, 129, 512, 601, 28, 191, 627, 498, 699, 265, 391, 241, 293, 286, 636, 202, 718, 207, 571, 132, 443, 607, 78, 698, 152, 69, 122, 447, 450, 349, 444, 352, 102, 619, 614, 633, 77, 438, 205, 699, 42, 95, 334, 205, 257, 281, 166, 271, 501, 524, 79, 80, 552, 115, 452, 607, 159, 403, 57, 528, 452, 361, 478, 268, 105, 67, 210, 389, 95, 655, 247, 138, 670, 23, 657, 257, 347, 83, 211, 530, 525, 566, 56, 540, 601, 420, 71, 573, 98, 447, 67, 438, 305, 516, 350, 544, 568, 441, 275, 117, 176, 479, 308, 358, 280, 734, 435, 317, 62, 513, 12, 162, 192, 363, 458, 8, 264, 249, 320, 667, 142, 422, 14, 494, 170, 204, 553, 375, 385, 137, 585, 128, 308, 698, 587, 574, 487, 688, 387, 624, 444, 624, 646, 389, 654, 378, 566, 413, 133, 431, 723, 446, 545, 138, 102, 293}));
        System.out.println(maxOperations(new int[]{1, 1, 2, 3, 2, 2, 1, 3, 3}));
        System.out.println(maxOperations(new int[]{3, 2, 1, 2, 3, 4}));
        System.out.println(maxOperations(new int[]{3, 2, 6, 1, 4}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-ii/solutions/2643756/qu-jian-dp-de-tao-lu-pythonjavacgo-by-en-nynz/"></a>
     *
     * @param nums
     * @return
     */
    public static int maxOperations(int[] nums) {
        int result = 0;
        int length = nums.length;
        /**
         * memo[i][j]表示每次操作的分数都为指定的sum时，子数组nums[i……j]的最大操作次数
         */
        int[][] memo = initMemo(length);
        /**
         * 第一次操作删除数组nums最前面两个元素，则每次操作的分数为nums[0]+nums[1]
         */
        result = Math.max(result, dfs(nums, 0, length - 1, nums[0] + nums[1], memo));
        /**
         * memo[i][j]表示每次操作的分数都为指定的sum时，子数组nums[i……j]的最大操作次数
         */
        memo = initMemo(length);
        /**
         * 第一次操作删除数组nums最后面两个元素，则每次操作的分数为nums[length-2]+nums[length-1]
         */
        result = Math.max(result, dfs(nums, 0, length - 1, nums[length - 2] + nums[length - 1], memo));
        /**
         * memo[i][j]表示每次操作的分数都为指定的sum时，子数组nums[i……j]的最大操作次数
         */
        memo = initMemo(length);
        /**
         * 第一次操作删除数组nums第一个和最后一个元素，则每次操作的分数为nums[0]+nums[length-1]
         */
        result = Math.max(result, dfs(nums, 0, length - 1, nums[0] + nums[length - 1], memo));
        return result;
    }

    /**
     * 初始化记忆化备忘录
     *
     * @param length
     * @return
     */
    public static int[][] initMemo(int length) {
        int[][] memo = new int[length][length];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return memo;
    }

    /**
     * 递归计算每次操作的分数为sum时，子数组nums[start……end]的最大操作次数
     *
     * @param nums
     * @param start
     * @param end
     * @param sum
     * @param memo
     * @return
     */
    public static int dfs(int[] nums, int start, int end, int sum, int[][] memo) {
        /**
         * 子数组中剩余的元素个数不足2个，不能继续执行删除操作
         */
        if (start >= end) {
            return 0;
        }
        /**
         * 子数组中剩余的元素个数正好为2个，通过计算这两个元素的和来判断是否可以执行这次删除操作
         */
        if (end - start == 1) {
            return nums[start] + nums[end] == sum ? 1 : 0;
        }
        int result = 0;
        /**
         * 删除子数组nums[start……end]最前面两个元素
         */
        if (nums[start] + nums[start + 1] == sum) {
            if (memo[start + 2][end] == -1) {
                memo[start + 2][end] = dfs(nums, start + 2, end, sum, memo);
            }
            result = Math.max(result, 1 + memo[start + 2][end]);
        }
        /**
         * 删除子数组nums[start……end]最后面两个元素
         */
        if (nums[end - 1] + nums[end] == sum) {
            if (memo[start][end - 2] == -1) {
                memo[start][end - 2] = dfs(nums, start, end - 2, sum, memo);
            }
            result = Math.max(result, 1 + memo[start][end - 2]);
        }
        /**
         * 删除子数组nums[start……end]第一个和最后一个元素
         */
        if (nums[start] + nums[end] == sum) {
            if (memo[start + 1][end - 1] == -1) {
                memo[start + 1][end - 1] = dfs(nums, start + 1, end - 1, sum, memo);
            }
            result = Math.max(result, 1 + memo[start + 1][end - 1]);
        }
        return result;
    }
}