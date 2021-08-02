package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/8/1 10:33 下午
 */
public class SearchA2DMatrixII {

    public boolean searchMatrixByForce(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[1].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrixByBinarySearchRowAndColumn(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            boolean rowVertical = binarySearchRowAndColumn(matrix,target,i,true);
            boolean columnVertical = binarySearchRowAndColumn(matrix,target,i,false);
            if (rowVertical||columnVertical){
                return true;
            }
        }
        return false;
    }

    private boolean binarySearchRowAndColumn(int[][] matrix, int target,
                                             int start, boolean vertical) {
        int low = start;
        int high = vertical ? matrix.length-1:matrix[0].length-1;

        while (low<=high){
            int mid = low+(high-low)/2;
            if (vertical){
                // search row
                if (matrix[mid][start]>target){
                    high = mid-1;
                } else if (matrix[mid][start]<target){
                    low = mid+1;
                } else {
                    return true;
                }
            } else {
                // search column
                if (matrix[start][mid]>target){
                    high = mid-1;
                } else if (matrix[start][mid]<target){
                    low = mid+1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrixByDivideMatrix(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        return searchRec(0,0,matrix[0].length-1,matrix.length-1,matrix,target);
    }

    private boolean searchRec(int leftColumn, int upRow, int rightColumn, int downRow,
                              int[][] matrix,int target){
        if (leftColumn>rightColumn||upRow>downRow){
            return false;
        } else if (target<matrix[upRow][leftColumn]||target>matrix[downRow][rightColumn]){
            return false;
        }
        int mid = leftColumn+(rightColumn-leftColumn)/2;
        int row = upRow;
        while (row<=downRow&&matrix[row][mid]<=target){
            if (target==matrix[row][mid]){
                return true;
            }
            row++;
        }
        // 左上换成 row: row, column: leftColumn 右下换成 row: dowRow column: mid-1, 或者
        // 左上换成 row: mid+1, column: upRow    右下换成: row: row-1 column: rightColumn
        return searchRec(leftColumn,row,mid-1,downRow,matrix,target)
                ||searchRec(mid+1,upRow,rightColumn,row-1,matrix,target);
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
        boolean res = new SearchA2DMatrixII().searchMatrixByForce(matrix, target);
        System.out.println(res);

        boolean res2 = new SearchA2DMatrixII().searchMatrixByBinarySearchRowAndColumn(matrix,target);
        System.out.println(res2);

        boolean res3 = new SearchA2DMatrixII().searchMatrixByDivideMatrix(matrix,target);
        System.out.println(res3);
    }
}
