package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/8/3 10:04 下午
 */
public class SearchA2DMatrix {

    public boolean searchMatrixByTwiceBinarySearch(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    private int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public boolean binarySearchByOnceSearch(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int n = matrix.length, m = matrix[0].length;
        int low = 0,high = m*n-1;
        while (low<high){
            int mid = low+(high-low)/2;
            int element = matrix[mid/n][mid%m];

            if (element==target){
                return true;
            }else if (element<target){
                low = mid;
            } else {
                high = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 5;
        boolean res = new SearchA2DMatrix().searchMatrixByTwiceBinarySearch(matrix, target);
        System.out.println(res);
        boolean res2 = new SearchA2DMatrix().binarySearchByOnceSearch(matrix, target);
        System.out.println(res2);
    }
}
