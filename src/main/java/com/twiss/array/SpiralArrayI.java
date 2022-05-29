package com.twiss.array;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋数组I
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
public class SpiralArrayI {

    public List<Integer> getSpiral(int[][] matrix){
        List<Integer> order = new ArrayList<Integer>();
        int n = matrix.length;
        int left = 0, top = 0, right=n-1, bottom = n-1;
        while (left<=right&&top<=bottom){
            // 上层
            for (int col = left;col<=right;col++){
                order.add(matrix[top][col]);
            }
            // 右层
            for (int row = top+1;row<=bottom;row++){
                order.add(matrix[row][right]);
            }
            if (left<right&&top<bottom){
                // 下层
                for (int col2 = right-1;col2>=left;col2--){
                    order.add(matrix[bottom][col2]);
                }
                // 左层
                for (int row2 = bottom-1;row2>top;row2--){
                    order.add(matrix[row2][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        ans = new SpiralArrayI().getSpiral(matrix);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
