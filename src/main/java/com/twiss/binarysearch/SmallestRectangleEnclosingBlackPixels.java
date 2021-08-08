package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/8/8 9:17 下午
 */
public class SmallestRectangleEnclosingBlackPixels {

    public int getSmallestRectangle(char[][] image, int x, int y){
        if (image == null || image.length == 0 || image[0].length == 0) return 0;
        int m = image.length, n = image[0].length;
        int left = searchColumn(image, 0, y, 0, m, false);
        int right = searchColumn(image, y + 1, n, 0, m, true);
        int top = searchRow(image, 0, x, left, right, false);
        int bottom = searchRow(image, x + 1, m, left, right, true);

        return (right - left) * (bottom - top);
    }

    private int searchRow(char[][] image, int i,int j,int left, int right, boolean isMax){
        while (i<j){
            int k = left, mid = i+(j-i)/2;
            // 从left到right 遍历是否是0，即找到该mid行第一个为1的列
            while (k<right&&image[mid][k]=='0'){
                k++;
            }
            // 此条件说明此次寻找的是最小的row坐标
            if (k<right&&!isMax||k>=right&&isMax){
                j = mid;
            }else {
                i = mid+1;
            }
        }
        return i;
    }

    private int searchColumn(char[][] image, int i,int j,int top, int bottom, boolean isMax){
        while (i<j){
            int k = top, mid = i+(j-i)/2;

            while (k<bottom&&image[k][mid]=='0'){
                k++;
            }
            // 此条件说明此次寻找的是最小的row坐标
            if (k<bottom&&!isMax||k>=bottom&&isMax){
                j = mid;
            }else {
                i = mid+1;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        char[][] image = {
                {'0','0','1','0'},
                {'0','1','1','0'},
                {'0','1','0','0'}
        };
        int x = 0, y = 2;
        int res = new SmallestRectangleEnclosingBlackPixels().getSmallestRectangle(image,x,y);
        System.out.println(res);
    }
}
