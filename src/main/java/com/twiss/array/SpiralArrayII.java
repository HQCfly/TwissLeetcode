package com.twiss.array;

import com.alibaba.fastjson.JSONObject;

/**
 * 螺旋数组II
 * 按层遍历
 * left=0， right=n-1, top = 0, bottom = n-1;
 * 上层：从left~right遍历
 * 右层：从top+1~bottom遍历
 * left<right && top<bottom的情况下：
 *      底层：从right-1~left
 *      左层：bottom-1~top+1;
 * @Author: Twiss
 * @Date: 2022/5/29 1:42 下午
 */
public class SpiralArrayII {

    public int[][] getSpiral(int n){
        int[][] matrix = new int[n][n];
        int num = 1;
        int left = 0, top = 0, right=n-1, bottom = n-1;
        while (left<=right&&top<=bottom){
            // 上层
            for (int col = left;col<=right;col++){
                matrix[top][col] =  num;
                num++;
            }
            // 右层
            for (int row = top+1;row<=bottom;row++){
                matrix[row][right] = num;
                num++;
            }
            if (left<right&&top<bottom){
                // 下层
                for (int col2 = right-1;col2>=left;col2--){
                    matrix[bottom][col2] = num;
                    num++;
                }
                // 左层
                for (int row2 = bottom-1;row2>top;row2--){
                    matrix[row2][left] = num;
                    num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = new SpiralArrayII().getSpiral(n);
        System.out.println(JSONObject.toJSONString(matrix));
    }
}
