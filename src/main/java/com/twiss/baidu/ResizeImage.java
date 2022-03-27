package com.twiss.baidu;

import java.util.Scanner;

/**
 * 放大图像
 *
 * @Author: Twiss
 * @Date: 2022/3/27 9:37 下午
 */
public class ResizeImage {

    public void getImage(int[][] original, int k) {
        int n = original.length;
        int newLength = n * k;
        for (int i = 0; i < newLength; ++i) {
            for (int j = 0; j < newLength; ++j) {
                if (j == newLength - 1) {
                    System.out.print(original[i / k][j / k]);
                    System.out.println();
                } else {
                    System.out.print(original[i / k][j / k]+" ");
                }
            }
        }
    }

    /**
     * 2 2
     * input:
     * 1 0
     * 0 1
     * output:
     * 1 1 0 0
     * 1 1 0 0
     * 0 0 1 1
     * 0 0 1 1
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[][] images = new int[n][n];

        for (int i = 0; i < n; ++i) {
            String[] rowArrays = scanner.nextLine().split(" ");
            for (int j = 0; j < n; ++j) {
                images[i][j] = Integer.parseInt(rowArrays[j]);
            }
        }

        new ResizeImage().getImage(images, k);
    }
}
