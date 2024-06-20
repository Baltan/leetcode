package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 3177. Find the Maximum Length of a Good Subsequence II
 *
 * @author baltan
 * @date 2024/6/19 16:26
 * @see MaximumLength3
 */
public class MaximumLength4 {
    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{97, 75, 77, 40, 74, 73, 57, 27, 88, 7, 93, 55, 48, 52, 13, 39, 18, 52, 27, 70, 48, 36, 28, 92, 90, 23, 76, 37, 19, 36, 49, 68, 24, 96, 53, 58, 55, 92, 90, 73, 29, 72, 100, 76, 33, 35, 26, 46, 10, 41, 73, 16, 23, 22, 37, 64, 31, 57, 70, 50, 34, 56, 27, 33, 60, 56, 87, 53, 17, 65, 3, 95, 6, 79, 9, 87, 49, 95, 57, 63, 11, 87, 39, 60, 55, 90, 7, 59, 96, 42, 36, 8, 100, 88, 14, 96, 73, 100, 30, 91, 71, 52, 63, 41, 36, 86, 32, 19, 55, 51, 28, 91, 13, 59, 44, 23, 39, 26, 2, 96, 66, 39, 30, 76, 89, 10, 80, 26, 55, 21, 29, 93, 93, 7, 38, 45, 78, 87, 27, 74, 99, 96, 5, 84, 33, 80, 65, 15, 86, 39, 52, 69, 13, 79, 8, 61, 59, 14, 12, 69, 78, 14, 13, 73, 39, 41, 71, 40, 90, 2, 69, 56, 13, 63, 9, 42, 84, 82, 11, 28, 61, 94, 17, 74, 27, 41, 22, 97, 27, 5, 38, 40, 10, 1, 20, 14, 68, 81, 46, 44, 61, 48, 17, 9, 21, 26, 42, 76, 41, 83, 79, 38, 47, 32, 79, 74, 7, 31, 31, 15, 74, 35, 11, 96, 50, 39, 10, 97, 52, 16, 55, 62, 55, 88, 12, 33, 5, 77, 69, 13, 11, 67, 100, 10, 51, 86, 2, 12, 93, 46, 68, 5, 69, 56, 8, 68, 100, 65, 38, 83, 3, 9, 47, 71, 85, 60, 82, 92, 24, 59, 22, 66, 23, 49, 64, 15, 62, 60, 26, 59, 88, 92, 94, 80, 98, 12, 35, 83, 50, 85, 71, 98, 4, 8, 19, 34, 63, 22, 59, 53, 27, 78, 9, 83, 75, 64, 23, 25, 91, 44, 20, 82, 66, 96, 3, 41, 54, 99, 66, 20, 61, 4, 6, 63, 19, 41, 40, 10, 53, 53, 4, 38, 24, 31, 69, 11, 89, 17, 43, 29, 14, 78, 47, 72, 82, 76, 15, 52, 56, 58, 88, 68, 98, 68, 52, 75, 98, 11, 4, 95, 94, 93, 9, 2, 15, 82, 63, 55, 49, 45, 33, 37, 91, 70, 65, 88, 43, 77, 26, 86, 53, 37, 57, 48, 73, 47, 48, 23, 71, 50, 40, 70, 23, 72, 54, 26, 76, 60, 51, 56, 62, 46, 46, 54, 94, 4, 47, 24, 41, 94, 57, 53, 55, 6, 63, 5, 63, 55, 22, 78, 48, 53, 19, 11, 57, 34, 30, 55, 19, 98, 54, 22, 94, 17, 88, 5, 42, 72, 21, 41, 20, 67, 57, 73, 30, 45, 55, 80, 92, 28, 70, 48, 99, 75, 3, 88, 43, 71, 29, 91, 39, 65, 61, 14, 65, 96, 3, 77, 37, 19, 27, 98, 97, 66, 40, 94, 73, 98, 98, 71, 39, 76, 79, 44, 49, 92, 53, 90, 47, 98, 72, 72, 69, 28, 95, 100, 76, 99, 52, 48, 79, 41, 30, 78, 70, 31, 37, 88, 49, 49, 4, 56, 9, 67, 100, 27, 57, 62, 89, 84, 98, 76, 91, 57, 59, 36, 84, 55, 77, 11, 18, 1, 40, 100, 63, 35, 11, 89, 5, 94, 5, 17, 81, 56, 33, 98, 33, 16, 87, 62, 87, 51, 5, 69, 89, 99, 44, 32, 73, 5, 100, 90, 95, 93, 79, 68, 16, 94, 22, 53, 99, 91, 99, 62, 73, 84, 73, 66, 66, 93, 89, 74, 94, 1, 90, 61, 93, 50, 64, 3, 44, 74, 83, 42, 58, 63, 38, 19, 50, 1, 76, 92, 80, 73, 98, 76, 36, 16, 26, 37, 54, 69, 54, 32, 75, 36, 51, 92, 30, 99, 64, 64, 55, 57, 59, 35, 19, 12, 87, 26, 99, 39, 24, 11, 57, 67, 36, 84, 2, 19, 27, 29, 97, 79, 15, 92, 73, 99, 54, 61, 71, 48, 76, 38, 41, 69, 60, 79, 37, 92, 100, 85, 99, 51, 47, 68, 61, 75, 63, 48, 46, 13, 14, 36, 45, 65, 32, 66, 55, 75, 91, 28, 45, 37, 82, 22, 64, 49, 24, 94, 45, 3, 32, 11, 51, 87, 62, 85, 96, 78, 74, 81, 22, 80, 76, 47, 37, 88, 99, 2, 16, 11, 60, 98, 90, 68, 36, 91, 15, 73, 41, 9, 64, 22, 48, 79, 89, 12, 65, 9, 24, 2, 11, 40, 5, 52, 25, 90, 27, 2, 27, 6, 29, 26, 62, 25, 54, 10, 90, 88, 23, 75, 1, 66, 81, 52, 54, 56, 93, 6, 49, 33, 48, 69, 61, 37, 71, 56, 86, 91, 37, 1, 16, 82, 69, 45, 28, 55, 90, 53, 3, 37, 48, 79, 71, 75, 58, 36, 18, 76, 54, 75, 44, 48, 57, 29, 51, 89, 55, 46, 64, 53, 71, 83, 8, 89, 59, 53, 15, 51, 94, 20, 8, 23, 2, 5, 92, 95, 37, 83, 71, 100, 39, 88, 43, 50, 3, 13, 24, 44, 24, 13, 9, 53, 58, 53, 41, 92, 17, 34, 1, 95, 25, 83, 34, 12, 15, 33, 80, 77, 54, 7, 39, 29, 9, 27, 52, 5, 29, 79, 47, 59, 16, 72, 30, 58, 39, 23, 66, 88, 35, 16, 44, 79, 64, 41, 17, 10, 90, 87, 25, 84, 6, 26, 2, 64, 58, 37, 3, 57, 81, 71, 48, 93, 16, 75, 22, 56, 64, 73, 61, 80, 11, 33, 15, 44, 33, 97, 15, 83, 78, 33, 62, 90, 95, 21, 76, 50, 77, 79, 23, 57, 66, 27, 96, 73, 88, 44, 54, 32, 91, 27, 80, 54, 19, 61, 27, 77, 41, 24, 28, 40, 72, 29, 41, 31, 1, 100, 56, 86, 91, 56, 12, 92, 8, 71, 61, 56, 53, 85, 54, 31, 55, 72, 30, 46, 67, 100, 93, 14, 53, 4, 1, 57, 57, 32, 87, 63, 11, 16, 47, 20, 67, 94, 64, 88, 11, 38, 82, 82, 91, 74, 84, 48, 30, 85, 31, 25, 24, 23, 71, 13, 65, 70, 91, 10, 74, 73, 76, 48, 62, 43, 23, 72, 26, 25, 50, 61, 28, 42, 88, 50, 89, 7, 91, 79, 39, 69, 41, 61, 2, 88, 99, 94, 14, 90, 95, 46, 58, 10, 25, 28, 14, 40, 51, 83, 12, 41, 54, 50, 25, 29, 14, 67, 7, 49, 34, 67, 5, 76, 90, 6, 58, 19, 85, 43, 38, 15, 96, 37, 18, 3, 51, 12, 87, 20, 48, 92, 70, 95, 92, 68, 55, 16, 6, 85, 92, 79, 85, 10, 97, 86, 82, 58, 79, 70, 88, 23, 96, 69, 80, 31, 81, 74, 14, 46, 17, 99, 71, 48, 9, 28, 45, 47, 47, 30, 93, 4, 100, 49, 32, 14, 47, 76, 19, 72, 82, 72, 73, 53, 89, 68, 7, 14, 30, 68, 81, 72, 23, 59, 69, 74, 56, 43, 58, 85, 44, 15, 37, 76, 74, 41, 53, 31, 88, 16, 34, 72, 7, 49, 30, 12, 46, 36, 54, 62, 71, 81, 42, 64, 23, 100, 18, 62, 32, 6, 61, 72, 58, 89, 18, 86, 4, 16, 99, 55, 37, 11, 51, 14, 53, 72, 26, 11, 81, 45, 62, 74, 67, 74, 87, 21, 8, 73, 78, 93, 50, 55, 5, 22, 12, 2, 95, 88, 39, 49, 5, 58, 53, 81, 26, 29, 86, 87, 70, 71, 74, 75, 23, 56, 86, 97, 66, 18, 79, 89, 27, 95, 96, 52, 69, 19, 90, 3, 21, 22, 84, 100, 54, 78, 22, 96, 97, 7, 80, 23, 64, 72, 94, 84, 18, 35, 9, 60, 77, 26, 59, 7, 61, 6, 61, 77, 3, 51, 22, 16, 19, 89, 35, 71, 85, 13, 4, 60, 43, 79, 74, 81, 39, 43, 21, 95, 89, 47, 33, 96, 88, 43, 94, 28, 38, 96, 27, 97, 25, 13, 3, 55, 87, 18, 80, 29, 97, 47, 68, 24, 19, 16, 24, 23, 21, 26, 44, 24, 32, 68, 52, 98, 49, 14, 12, 56, 74, 37, 92, 85, 36, 63, 65, 74, 81, 46, 58, 51, 14, 22, 71, 64, 79, 90, 90, 52, 46, 61, 88, 93, 79, 83, 64, 94, 89, 84, 4, 17, 17, 20, 81, 28, 76, 55, 96, 8, 7, 24, 86, 55, 76, 25, 94, 93, 83, 98, 74, 27, 50, 64, 87, 89, 53, 11, 45, 30, 71, 91, 69, 26, 30, 72, 52, 34, 24, 7, 2, 14, 59, 61, 81, 67, 31, 29, 83, 43, 57, 84, 85, 94, 17, 37, 17, 88, 27, 3, 23, 7, 31, 18, 3, 94, 5, 37, 29, 52, 17, 70, 65, 45, 3, 89, 33, 54, 52, 83, 30, 19, 40, 77, 52, 34, 39, 76, 25, 43, 78, 34, 30, 72, 56, 63, 43, 79, 96, 33, 77, 72, 68, 11, 94, 8, 95, 58, 42, 89, 55, 4, 71, 59, 30, 62, 22, 22, 23, 82, 89, 15, 70, 87, 51, 52, 46, 47, 53, 32, 88, 82, 48, 41, 53, 87, 99, 46, 82, 8, 42, 49, 2, 13, 92, 39, 49, 35, 17, 50, 27, 31, 22, 100, 28, 62, 82, 59, 46, 77, 52, 70, 19, 6, 30, 89, 65, 61, 48, 85, 1, 23, 40, 89, 81, 49, 40, 55, 22, 36, 48, 86, 84, 94, 76, 9, 78, 88, 16, 88, 5, 47, 88, 67, 96, 44, 10, 51, 51, 27, 66, 21, 89, 24, 24, 94, 33, 63, 98, 86, 48, 22, 8, 13, 35, 64, 13, 49, 53, 91, 23, 97, 76, 57, 51, 87, 74, 72, 24, 71, 49, 51, 64, 65, 40, 38, 83, 73, 12, 72, 35, 50, 49, 75, 49, 73, 24, 45, 1, 15, 67, 3, 91, 96, 43, 47, 86, 84, 86, 13, 14, 44, 51, 85, 7, 89, 93, 73, 16, 95, 87, 29, 86, 99, 54, 84, 67, 77, 50, 90, 30, 33, 77, 31, 33, 40, 44, 2, 27, 33, 60, 53, 11, 88, 82, 59, 82, 16, 66, 25, 29, 7, 21, 70, 30, 89, 89, 86, 5, 49, 14, 89, 47, 71, 5, 67, 64, 54, 4, 90, 37, 10, 45, 98, 47, 73, 72, 84, 60, 57, 95, 70, 7, 78, 88, 68, 23, 21, 93, 77, 70, 3, 42, 56, 43, 4, 83, 90, 92, 22, 27, 5, 57, 59, 82, 15, 24, 67, 1, 5, 75, 80, 68, 49, 6, 60, 100, 34, 80, 58, 7, 42, 25, 10, 7, 54, 53, 39, 86, 87, 99, 66, 53, 44, 60, 16, 54, 70, 80, 39, 95, 69, 77, 33, 90, 72, 34, 43, 28, 57, 28, 46, 43, 76, 60, 6, 61, 78, 38, 27, 31, 73, 29, 5, 97, 56, 37, 15, 18, 33, 28, 71, 40, 59, 92, 37, 76, 81, 20, 66, 78, 91, 90, 71, 8, 33, 2, 69, 73, 1, 69, 28, 98, 22, 48, 48, 74, 55, 54, 39, 38, 92, 95, 12, 22, 52, 81, 90, 57, 1, 100, 51, 65, 25, 82, 71, 56, 85, 46, 78, 6, 9, 88, 77, 99, 71, 39, 62, 62, 98, 54, 43, 49, 70, 85, 74, 50, 78, 59, 6, 74, 69, 50, 76, 35, 13, 9, 38, 83, 19, 29, 78, 41, 56, 80, 5, 24, 81, 25, 59, 16, 87, 27, 76, 52, 4, 69, 77, 14, 74, 33, 44, 70, 11, 75, 99, 52, 14, 76, 45, 12, 8, 83, 82, 4, 93, 59, 14, 52, 77, 68, 33, 26, 37, 40, 16, 24, 44, 77, 32, 26, 97, 5, 29, 30, 36, 74, 33, 93, 68, 22, 44, 50, 85, 6, 22, 98, 88, 92, 73, 93, 28, 36, 86, 92, 1, 29, 84, 4, 75, 86, 88, 65, 78, 5, 29, 42, 29, 90, 91, 100, 29, 23, 36, 21, 18, 94, 53, 81, 57, 61, 55, 41, 63, 46, 37, 100, 47, 38, 42, 9, 9, 22, 98, 25, 7, 75, 18, 1, 4, 67, 31, 47, 3, 44, 72, 57, 3, 33, 55, 8, 19, 52, 72, 96, 59, 93, 97, 75, 44, 47, 16, 74, 50, 76, 35, 24, 74, 77, 55, 9, 58, 19, 50, 75, 37, 62, 65, 54, 79, 47, 63, 61, 89, 53, 91, 87, 78, 5, 83, 55, 18, 52, 72, 49, 55, 86, 16, 30, 26, 92, 67, 62, 54, 53, 14, 40, 76, 66, 23, 5, 27, 6, 10, 57, 96, 75, 41, 20, 85, 57, 21, 77, 49, 67, 95, 56, 11, 72, 27, 20, 47, 25, 56, 14, 90, 21, 96, 26, 57, 51, 14, 84, 69, 23, 26, 54, 34, 42, 32, 17, 30, 20, 13, 42, 77, 12, 95, 99, 5, 71, 30, 86, 45, 58, 88, 50, 37, 63, 12, 83, 8, 13, 17, 17, 89, 85, 10, 49, 28, 60, 62, 2, 24, 19, 22, 99, 96, 18, 5, 42, 55, 59, 29, 33, 27, 78, 46, 51, 28, 23, 19, 48, 85, 23, 94, 16, 84, 1, 46, 52, 86, 55, 13, 43, 38, 62, 72, 42, 72, 100, 76, 88, 37, 97, 79, 5, 68, 91, 50, 27, 32, 97, 41, 42, 76, 54, 86, 87, 6, 51, 23, 11, 16, 10, 46, 78, 16, 34, 15, 17, 17, 78, 27, 56, 97, 58, 4, 88, 65, 30, 11, 67, 40, 6, 66, 7, 87, 39, 55, 64, 16, 26, 7, 84, 85, 74, 48, 79, 72, 31, 28, 6, 64, 26, 16, 4, 15, 15, 68, 29, 1, 52, 32, 80, 76, 40, 73, 86, 10, 12, 23, 60, 63, 72, 35, 55, 67, 75, 97, 18, 51, 97, 10, 58, 98, 64, 86, 84, 95, 81, 57, 11, 75, 89, 36, 20, 21, 74, 87, 53, 77, 56, 49, 68, 63, 88, 66, 35, 53, 34, 35, 61, 7, 59, 88, 89, 31, 72, 73, 41, 98, 1, 90, 66, 41, 41, 100, 99, 68, 93, 10, 8, 34, 13, 28, 11, 94, 97, 17, 30, 19, 34, 27, 59, 29, 6, 82, 37, 6, 22, 55, 36, 31, 36, 15, 33, 96, 94, 84, 79, 25, 46, 98, 46, 13, 15, 38, 22, 38, 81, 17, 82, 38, 84, 100, 85, 88, 3, 81, 81, 44, 17, 24, 21, 90, 96, 19, 80, 38, 100, 55, 42, 14, 12, 22, 76, 10, 5, 78, 6, 61, 31, 26, 51, 73, 22, 25, 58, 27, 70, 19, 76, 27, 18, 95, 31, 63, 83, 35, 1, 66, 94, 54, 42, 76, 46, 76, 25, 73, 12, 49, 47, 67, 59, 71, 64, 53, 94, 23, 6, 71, 11, 54, 68, 76, 36, 62, 37, 29, 36, 43, 64, 67, 34, 49, 76, 40, 94, 2, 75, 38, 29, 32, 31, 53, 47, 44, 11, 29, 77, 28, 91, 93, 4, 39, 57, 14, 68, 19, 98, 5, 71, 73, 13, 13, 42, 4, 33, 87, 81, 44, 94, 81, 55, 87, 36, 8, 70, 45, 31, 25, 45, 64, 26, 4, 17, 42, 14, 12, 41, 100, 40, 77, 28, 63, 26, 72, 6, 67, 67, 82, 43, 76, 3, 43, 71, 63, 61, 38, 59, 40, 89, 43, 39, 13, 74, 13, 98, 72, 17, 59, 51, 8, 41, 11, 52, 55, 93, 87, 97, 26, 46, 100, 50, 18, 14, 92, 81, 16, 2, 95, 59, 77, 24, 42, 50, 28, 6, 57, 51, 29, 96, 34, 27, 16, 77, 5, 64, 47, 65, 4, 93, 6, 79, 53, 78, 41, 7, 63, 78, 59, 11, 15, 40, 13, 51, 73, 34, 50, 100, 45, 40, 27, 29, 98, 91, 70, 42, 2, 46, 12, 39, 52, 48, 20, 15, 33, 54, 86, 92, 63, 76, 2, 86, 66, 86, 37, 8, 79, 46, 10, 17, 96, 21, 77, 24, 34, 16, 44, 30, 58, 99, 51, 66, 51, 97, 26, 69, 2, 31, 61, 18, 39, 100, 39, 75, 16, 34, 48, 11, 45, 42, 29, 56, 90, 64, 41, 45, 57, 39, 91, 41, 18, 76, 95, 78, 21, 71, 18, 56, 99, 24, 65, 36, 18, 33, 84, 96, 69, 73, 21, 30, 47, 45, 96, 25, 48, 47, 60, 84, 68, 62, 5, 15, 87, 81, 94, 66, 92, 40, 7, 76, 50, 85, 18, 32, 12, 84, 88, 19, 83, 17, 2, 65, 11, 90, 19, 75, 3, 56, 95, 86, 16, 87, 61, 59, 19, 67, 67, 39, 86, 62, 77, 22, 58, 49, 97, 15, 78, 96, 33, 13, 78, 44, 6, 78, 78, 52, 69, 43, 16, 81, 44, 3, 94, 78, 79, 9, 36, 53, 70, 77, 47, 92, 3, 82, 83, 63, 5, 14, 6, 71, 29, 6, 10, 76, 65, 42, 68, 33, 94, 31, 96, 55, 19, 71, 95, 22, 7, 48, 97, 63, 3, 27, 64, 99, 56, 34, 62, 47, 55, 46, 15, 37, 10, 14, 31, 31, 80, 1, 50, 59, 98, 56, 18, 40, 59, 83, 66, 25, 82, 63, 84, 23, 96, 22, 14, 68, 52, 72, 41, 51, 31, 17, 59, 36, 96, 85, 97, 89, 24, 44, 42, 75, 79, 81, 18, 16, 90, 87, 82, 7, 22, 77, 94, 74, 2, 42, 90, 15, 40, 46, 10, 96, 82, 26, 35, 92, 14, 62, 35, 48, 95, 60, 91, 64, 43, 65, 61, 63, 7, 73, 32, 74, 86, 66, 5, 46, 51, 46, 30, 18, 36, 80, 12, 85, 31, 55, 45, 59, 80, 62, 94, 6, 26, 97, 32, 77, 43, 71, 67, 76, 48, 66, 4, 31, 73, 50, 63, 51, 78, 93, 86, 33, 87, 97, 29, 3, 17, 9, 94, 76, 82, 31, 52, 28, 52, 58, 90, 9, 58, 77, 63, 91, 20, 97, 35, 63, 50, 18, 74, 26, 32, 97, 71, 96, 82, 95, 67, 66, 86, 93, 45, 46, 65, 4, 22, 25, 14, 82, 53, 7, 64, 100, 39, 65, 42, 15, 25, 13, 4, 53, 24, 69, 67, 2, 60, 18, 42, 88, 71, 62, 25, 65, 80, 96, 33, 26, 70, 52, 68, 26, 90, 38, 29, 30, 10, 36, 54, 93, 67, 8, 100, 55, 49, 62, 83, 54, 92, 11, 3, 36, 82, 73, 77, 18, 86, 73, 81, 87, 52, 8, 79, 37, 41, 98, 30, 31, 49, 85, 75, 30, 44, 79, 81, 14, 44, 13, 71, 82, 63, 44, 93, 90, 61, 5, 55, 50, 90, 39, 69, 34, 80, 98, 74, 7, 90, 40, 8, 38, 15, 40, 53, 31, 51, 32, 7, 61, 53, 62, 66, 61, 70, 92, 66, 33, 80, 31, 72, 16, 15, 84, 13, 79, 44, 48, 45, 72, 33, 59, 29, 12, 79, 45, 43, 20, 34, 76, 57, 10, 44, 91, 84, 54, 98, 86, 88, 28, 34, 25, 3, 49, 31, 62, 86, 19, 80, 48, 15, 25, 85, 68, 11, 89, 11, 41, 1, 45, 3, 89, 59, 9, 33, 63, 47, 37, 54, 19, 20, 78, 26, 38, 71, 50, 59, 60, 18, 71, 70, 43, 97, 77, 25, 62, 42, 15, 26, 40, 84, 92, 91, 16, 78, 85, 45, 21, 69, 96, 69, 67, 21, 56, 93, 52, 87, 27, 80, 1, 93, 86, 99, 65, 20, 70, 17, 21, 82, 91, 50, 7, 95, 19, 83, 79, 51, 70, 26, 71, 69, 39, 58, 92, 56, 6, 11, 74, 22, 30, 41, 77, 89, 30, 19, 93, 5, 48, 37, 81, 83, 74, 9, 44, 12, 35, 41, 14, 81, 73, 30, 17, 11, 63, 31, 100, 62, 35, 6, 21, 54, 52, 34, 74, 68, 83, 88, 36, 55, 15, 49, 68, 52, 86, 54, 73, 11, 55, 53, 8, 4, 32, 91, 56, 91, 60, 31, 83, 1, 91, 23, 76, 78, 82, 40, 4, 93, 33, 94, 69, 97, 33, 96, 14, 88, 18, 90, 13, 1, 26, 6, 99, 10, 8, 54, 44, 11, 65, 12, 28, 5, 15, 47, 75, 81, 19, 24, 43, 57, 92, 59, 76, 23, 43, 57, 56, 40, 57, 22, 32, 66, 76, 88, 78, 59, 47, 21, 70, 10, 76, 65, 67, 99, 14, 85, 39, 91, 40, 79, 44, 1, 69, 72, 10, 76, 57, 23, 12, 100, 7, 22, 66, 71, 67, 21, 66, 4, 74, 33, 46, 76, 31, 79, 20, 34, 49, 7, 100, 78, 10, 36, 45, 85, 97, 40, 29, 70, 10, 31, 33, 40, 28, 63, 89, 42, 72, 83, 70, 12, 77, 50, 68, 88, 13, 22, 64, 15, 70, 25, 22, 13, 88, 76, 90, 47, 7, 2, 32, 49, 48, 42, 97, 43, 8, 35, 27, 27, 65, 36, 71, 84, 36, 5, 35, 11, 40, 72, 12, 27, 92, 83, 52, 29, 40, 93, 66, 55, 9, 60, 55, 27, 25, 80, 95, 52, 3, 11, 51, 10, 67, 6, 27, 42, 91, 12, 17, 68, 84, 89, 78, 29, 60, 62, 93, 91, 67, 53, 51, 95, 86, 27, 55, 67, 34, 97, 5, 83, 47, 20, 59, 27, 49, 29, 88, 80, 75, 25, 85, 98, 1, 18, 86, 11, 1, 80, 47, 73, 21, 77, 67, 9, 39, 60, 19, 92, 7, 81, 62, 19, 11, 10, 50, 56, 77, 7, 31, 19, 39, 57, 94, 80, 13, 51, 27, 6, 21, 12, 4, 59, 73, 67, 91, 79, 86, 7, 26, 93, 1, 39, 21, 69, 79, 49, 85, 66, 34, 75, 51, 12, 88, 85, 9, 95, 19, 33, 16, 27, 96, 35, 89, 29, 56, 95, 84, 21, 94, 82, 46, 73, 54, 46, 50, 35, 25, 70, 36, 3, 42, 58, 4, 61, 18, 45, 38, 51, 62, 75, 47, 64, 8, 11, 29, 9, 50, 83, 67, 3, 11, 9, 79, 88, 13, 23, 22, 100, 81, 39, 65, 4, 44, 68, 95, 45, 76, 16, 98, 23, 71, 68, 35, 16, 39, 33, 84, 20, 19, 71, 34, 46, 78, 58, 77, 12, 34, 17, 59, 71, 76, 11, 75, 14, 63, 8, 28, 96, 68, 53, 98, 80, 40, 100, 20, 43, 25, 36, 66, 70, 69, 53, 22, 88, 3, 42, 32, 97, 63, 30, 31, 25, 39, 20, 90, 58, 79, 4, 47, 79, 58, 7, 62, 85, 96, 60, 100, 73, 57, 59, 16, 12, 83, 28, 28, 76, 9, 33, 5, 63, 82, 82, 59, 68, 28, 17, 49, 62, 18, 11, 38, 74, 20, 58, 16, 63, 4, 32, 56, 15, 84, 93, 15, 14, 77, 43, 5, 36, 36, 28, 90, 70, 59, 26, 3, 18, 92, 32, 33, 45, 61, 81, 100, 41, 62, 5, 22, 57, 66, 90, 93, 33, 83, 42, 16, 100, 93, 50, 26, 65, 100, 25, 15, 80, 78, 67, 67, 99, 85, 37, 22, 5, 97, 95, 95, 4, 10, 90, 65, 14, 6, 40, 13, 3, 66, 9, 72, 64, 25, 62, 61, 52, 77, 22, 36, 81, 11, 30, 77, 4, 45, 76, 98, 82, 87, 77, 21, 49, 37, 19, 7, 38, 62, 87, 67, 65, 85, 28, 11, 5, 28, 39, 29, 30, 54, 46, 17, 59, 66, 67, 90, 89, 94, 11, 55, 52, 59, 42, 97, 51, 34, 82, 46, 25, 51, 87, 52, 3, 15, 79, 100, 6, 13, 30, 69, 87, 50, 51, 16, 60, 88, 6, 54, 87, 54, 66, 17, 39, 98, 74, 17, 2, 6, 3, 86, 66, 86, 53, 11, 66, 52, 80, 62, 31, 39, 11, 1, 41, 62, 83, 50, 36, 72, 69, 67, 11, 15, 68, 96, 93, 64, 94, 43, 31, 10, 58, 3, 16, 53, 64, 23, 96, 1, 88, 88, 45, 69, 89, 48, 58, 68, 87, 69, 40, 92, 44, 18, 88, 81, 94, 95, 3, 17, 90, 35, 34, 9, 75, 26, 59, 26, 49, 90, 68, 96, 43, 83, 2, 23, 31, 98, 35, 50, 56, 72, 40, 93, 44, 65, 43, 37, 97, 46, 62, 84, 76, 14, 33, 6, 40, 100, 54, 35, 97, 68, 45, 46, 97, 81, 67, 75, 37, 71, 12, 22, 44, 99, 6, 48, 39, 85, 45, 100, 70, 97, 27, 56, 90, 98, 82, 43, 58, 2, 28, 65, 28, 72, 51, 71, 95, 68, 16, 35, 91, 94, 96, 65, 9, 73, 69, 26, 53, 31, 75, 19, 92, 59, 95, 30, 21, 5, 37, 48, 50, 76, 95, 90, 73, 83, 69, 65, 16, 47, 98, 71, 20, 8, 55, 74, 51, 95, 1, 33, 82, 32, 48, 98, 22, 86, 5, 20, 19, 33, 44, 67, 93, 96, 8, 79, 46, 6, 61, 94, 98, 90, 70, 3, 36, 78, 17, 26, 37, 47, 94, 79, 34, 63, 72, 93, 36, 18, 51, 2, 15, 23, 78, 47, 75, 75, 42, 44, 20, 21, 59, 2, 14, 47, 20, 82, 36, 82, 30, 16, 20, 17, 77, 4, 11, 4, 9, 12, 37, 72, 83, 94, 3, 78, 89, 59, 76, 95, 60, 41, 27, 8, 26, 71, 31, 32, 26, 92, 28, 76, 93, 27, 97, 35, 46, 63, 14, 38, 31, 59, 26, 36, 10, 55, 58, 83, 87, 89, 19, 53, 54, 70, 44, 92, 52, 91, 51, 2, 80, 47, 62, 96, 2, 54, 38, 17, 56, 81, 7, 54, 64, 23, 45, 28, 96, 28, 68, 90, 25, 30, 62, 18, 17, 95, 44, 22, 58, 55, 47, 90, 95, 17, 96, 97, 29, 22, 1, 4, 17, 99, 50, 47, 68, 8, 77, 18, 100, 89, 25, 6, 89, 28, 33, 38, 71, 76, 63, 60, 58, 94, 11, 18, 26, 20, 75, 55, 21, 5, 78, 77, 82, 64, 74, 72, 80, 40, 9, 12, 51, 47, 48, 44, 78, 31, 12, 44, 97, 81, 85, 82, 46, 91, 40, 61, 80, 92, 36, 38, 65, 82, 6, 30, 73, 68, 20, 35, 100, 23, 77, 44, 60, 42, 69, 37, 58, 7, 2, 62, 74, 26, 11, 76, 37, 75, 47, 52, 70, 33, 52, 68, 99, 34, 100, 15, 2, 20, 3, 97, 18, 66, 13, 46, 88, 36, 85, 58, 83, 74, 87, 72, 44, 73, 20, 36, 64, 43, 13, 75, 34, 48, 68, 6, 10, 95, 23, 5, 52, 45, 50, 74, 90, 3, 98, 7, 38, 38, 54, 5, 84, 96, 78, 78, 46, 92, 68, 33, 50, 23, 22, 76, 9, 22, 18, 75, 71, 10, 93, 37, 5, 99, 36, 27, 69, 37, 34, 43, 60, 2, 25, 88, 73, 11, 57, 99, 89, 44, 60, 45, 8, 50, 6, 90, 5, 73, 19, 55, 53, 28, 21, 27, 47, 26, 89, 41, 9, 71, 72, 59, 48, 54, 93, 47, 54, 82, 12, 80, 40, 92, 16, 59, 73, 44, 87, 97, 24, 60, 68, 66, 59, 12, 17, 85, 96, 98, 6, 17, 68, 64, 19, 40, 5, 48, 79, 26, 7, 6, 72, 47, 5, 46, 73, 87, 74, 100, 5, 80, 22, 37, 26, 80, 21, 31, 51, 74, 38, 90, 69, 51, 57, 50, 2, 12, 71, 13, 26, 99, 46, 41, 10, 4, 61, 13, 74, 11, 86, 15, 95, 34, 60, 47, 82, 42, 48, 40, 87, 34, 30, 11, 50, 68, 41, 13, 21, 73, 72, 41, 29, 57, 48, 87, 45, 97, 49, 88, 63, 70, 53, 73, 42, 80, 72, 96, 97, 14, 60, 72, 45, 12, 93, 78, 39, 9, 65, 81, 14, 82, 16, 91, 44, 36, 100, 74, 87, 5, 44, 98, 58, 13, 35, 77, 100, 20, 36, 5, 8, 14, 31, 35, 15, 20, 36, 62, 96, 39, 98, 39, 87, 91, 4, 83, 63, 3, 27, 87, 88, 74, 73, 67, 39, 80, 25, 70, 59, 13, 51, 29, 64, 44, 56, 26, 99, 20, 19, 7, 63, 95, 42, 37, 39, 7, 72, 10, 59, 70, 37, 92, 77, 26, 42, 63, 29, 11, 66, 82, 91, 4, 19, 40, 82, 16, 37, 28, 45, 78, 70, 77, 1, 30, 34, 76, 5, 99, 38, 31, 85, 28, 96, 76, 63, 69, 33, 31, 3, 14, 31, 4, 47, 3, 51, 79, 94, 38, 20, 60, 23, 50, 80, 23, 60, 10, 71, 93, 27, 34, 16, 11, 77, 79, 28, 70, 48, 64, 44, 68, 43, 99, 33, 80, 84, 73, 94, 95, 58, 72, 42, 99, 46, 69, 86, 81, 98, 40, 69, 48, 23, 19, 55, 29, 100, 37, 99, 79, 65, 3, 62, 74, 5, 48, 34, 52, 79, 22, 77, 14, 43, 60, 58, 24, 6, 9, 83, 48, 63, 25, 10, 75, 39, 58, 15, 77, 80, 56, 97, 86, 70, 23, 53, 22, 70, 59, 60, 33, 53, 83, 4, 48, 68, 81, 47, 34, 63, 46, 76, 76, 74, 73, 80, 57, 37, 4, 19, 85, 64, 32, 68, 13, 5, 67, 100, 71, 83, 73, 19, 33, 33, 67, 37, 79, 70, 64, 85, 50, 23, 37, 43, 72, 37, 98, 80, 83, 20, 73, 51, 28, 3, 78, 27, 23, 45, 3, 86, 14, 11, 7, 78, 85, 84, 99, 71, 40, 76, 38, 10, 74, 68, 60, 91, 35, 44, 43, 95, 80, 42, 20, 77, 44, 60, 76, 20, 95, 17, 77, 20, 51, 77, 65, 81, 89, 91, 69, 93, 39, 90, 18, 92, 51, 21, 23, 24, 83, 77, 32, 94, 65, 43, 56, 30, 46, 52, 51, 65, 21, 61, 43, 24, 16, 78, 17, 46, 5, 6, 86, 4, 65, 56, 15, 61, 48, 41, 37, 24, 73, 55, 13, 65, 45, 21, 39, 87, 45, 25, 59, 63, 20, 34, 58, 95, 72, 20, 60, 84, 84, 23, 12, 53, 63, 30, 53, 8, 39, 1, 21, 62, 59, 87, 28, 20, 23, 58, 85, 85, 21, 92, 37, 59, 75, 68, 27, 87, 6, 99, 33, 92, 89, 19, 91, 68, 26, 28, 98, 20, 63, 75, 43, 84, 66, 67, 34, 27, 59, 47, 56, 1, 53, 9, 84, 67, 35, 55, 51, 78, 37, 99, 59, 31, 58, 12, 42, 48, 9, 67, 32, 52, 52, 10, 33, 16, 31, 75, 37, 93, 7, 69, 100, 43, 94, 60, 52, 78, 52, 79, 42, 31, 36, 21, 67, 7, 28, 54, 14, 43, 80, 44, 69, 90, 41, 76, 45, 23}, 45));
        System.out.println(maximumLength(new int[]{29, 30, 30}, 0));
        System.out.println(maximumLength(new int[]{2}, 0));
        System.out.println(maximumLength(new int[]{1, 2, 1, 1, 3}, 2));
        System.out.println(maximumLength(new int[]{1, 2, 3, 4, 5, 1}, 0));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/find-the-maximum-length-of-a-good-subsequence-ii/solutions/2805263/dong-tai-gui-hua-you-hua-pythonjavacgo-b-jqn2/"></a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int maximumLength(int[] nums, int k) {
        /**
         * 数组nums中的数字num -> 以数字num结尾，包含[0,k]对不同相邻数字的子序列的最大长度
         */
        Map<Integer, int[]> map = new HashMap<>();
        SubsequenceCondition[] subsequenceConditions = new SubsequenceCondition[k + 1];
        Arrays.setAll(subsequenceConditions, i -> new SubsequenceCondition());

        for (int num : nums) {
            int[] subsequenceLengths = map.computeIfAbsent(num, i -> new int[k + 1]);
            /**
             * 如果选择数字num作为子序列的最后一个数字，则对于原来的以数字num结尾，包含i对不同相邻数字且长度为x的子序列而言，会相对应地变为
             * 以数字num结尾，包含i对不同相邻数字且长度为x+1的子序列
             */
            for (int i = k; i >= 0; i--) {
                subsequenceLengths[i]++;

                if (i > 0) {
                    int maxLength = subsequenceConditions[i - 1].maxSubsequenceLength;
                    int secondMaxLength = subsequenceConditions[i - 1].secondMaxSubsequenceLength;
                    int maxLengthNum = subsequenceConditions[i - 1].longestSubsequenceLastNum;
                    subsequenceLengths[i] = Math.max(subsequenceLengths[i], (num != maxLengthNum ? maxLength : secondMaxLength) + 1);
                }
                /**
                 * 以数字num结尾，包含i对不同相邻数字的子序列的最大长度
                 */
                int subsequenceLength = subsequenceLengths[i];
                /**
                 * 包含i对不同相邻数字的子序列的各种情况参数
                 */
                SubsequenceCondition subsequenceCondition = subsequenceConditions[i];
                /**
                 * 当前得到的以数字num结尾，包含i对不同相邻数字的子序列的最大长度大于此前已有的包含i对不同相邻数字的子序列的最大长度
                 */
                if (subsequenceLength > subsequenceCondition.maxSubsequenceLength) {
                    if (num != subsequenceCondition.longestSubsequenceLastNum) {
                        subsequenceCondition.longestSubsequenceLastNum = num;
                        subsequenceCondition.secondMaxSubsequenceLength = subsequenceCondition.maxSubsequenceLength;
                    }
                    subsequenceCondition.maxSubsequenceLength = subsequenceLength;
                    /**
                     * 当前得到的以数字num结尾，包含i对不同相邻数字的子序列的最大长度大于此前已有的包含i对不同相邻数字的子序列的第二大长度
                     */
                } else if (num != subsequenceCondition.longestSubsequenceLastNum && subsequenceLength > subsequenceCondition.secondMaxSubsequenceLength) {
                    subsequenceCondition.secondMaxSubsequenceLength = subsequenceLength;
                }
            }
        }
        return subsequenceConditions[k].maxSubsequenceLength;
    }

    /**
     * 包含指定数量不同相邻数字的子序列的各种情况参数
     */
    public static class SubsequenceCondition {
        /**
         * 可能的最大长度的子序列的最后一个数字
         */
        private int longestSubsequenceLastNum;
        /**
         * 可能的子序列的最大长度
         */
        private int maxSubsequenceLength;
        /**
         * 可能的子序列的第二大长度
         */
        private int secondMaxSubsequenceLength;
    }
}
