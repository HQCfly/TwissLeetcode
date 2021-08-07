package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/8/7 5:52 下午
 */
public class SetMatrixZeroes {

    public int[][] getZeroesMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < n; i++) {
            // 对首列出现0的做标记，保证后续修改能被记录
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            // 如果matrix[i][j]是0，则对最左位置置0，最上位置置0
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = n-1;i>=0;i--){
            for (int j=1;j<m;j++){
                // 如果最左位置0，或者最上位置0，则说明该行列有0存在，需要对此所有的元素置为0
                if (matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
            // 针对首列为true则对遍历到的行置0操作
            if (flagCol0){
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] res = new SetMatrixZeroes().getZeroesMatrix(matrix);
        System.out.println(res);
    }
}
