package com.twiss.binaryindextree;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/7/9 5:02 下午
 */
public class RangeSumQuery2DMutable {

    private int[][] BITree2D;
    private int[][] matrix;

    public RangeSumQuery2DMutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        // 仍然以比 matrix 长，宽都要大1的 size 创建 BITree2D
        this.BITree2D = new int[matrix.length + 1][matrix[0].length + 1];
        // 在初始化 BITree2D 时需要，或者也可以单独写一个 init 函数
        // 但是这里为了实现 update() 函数的复用创建了该数组
        this.matrix = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                update(row, col, matrix[row][col]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int delta = val - matrix[row][col];
        matrix[row][col] = val;
        for (int i = row + 1; i < BITree2D.length; i += i & -i) {
            for (int j = col + 1; j < BITree2D[i].length; j += j & -j) {
                BITree2D[i][j] += delta;
            }
        }
    }

    // 画图或者想像一下即可明白：利用[(0,0) - (row2, col2)]的大矩形分别减去
    // 矩形[(0,0) - (row1, col2)] 和 矩形[(0,0) - (row2, col1)] 最后加上被重复减去的部分矩形 [(0,0) - (row1, col1)]
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2 + 1, col2 + 1) - getSum(row1, col2 + 1) - getSum(row2 + 1, col1) + getSum(row1, col1);
    }

    private int getSum(int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= i & -i) {
            for (int j = col; j > 0; j -= j & -j) {
                sum += BITree2D[i][j];
            }
        }
        return  sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        RangeSumQuery2DMutable rangeSumArr = new RangeSumQuery2DMutable(matrix);
        System.out.println("originTreeNode: "+ JSONObject.toJSONString(rangeSumArr.BITree2D));
        int resultSum = rangeSumArr.sumRegion(2,1,4,3);
        System.out.println("resultSum: "+resultSum);
        rangeSumArr.update(3,2,2);
        System.out.println("updateTreeNode: "+ JSONObject.toJSONString(rangeSumArr.BITree2D));
        int resultSum2 = rangeSumArr.sumRegion(2,1,4,3);
        System.out.println("resultSum2: "+resultSum2);
    }
}
