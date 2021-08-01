package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/8/1 10:33 下午
 */
public class SearchA2DMatrixII {

    public boolean searchMatrixByForce(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[1].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        boolean res = new SearchA2DMatrixII().searchMatrixByForce(matrix,target);
        System.out.println(res);
    }
}
