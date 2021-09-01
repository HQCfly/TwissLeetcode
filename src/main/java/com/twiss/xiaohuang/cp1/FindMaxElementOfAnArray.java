package com.twiss.xiaohuang.cp1;

/**
 * @Author: Twiss
 * @Date: 2021/9/1 10:36 上午
 */
public class FindMaxElementOfAnArray {

    public int getMaxElement(int[] arrays){
        int max = arrays[0];
        for (int i=1;i<arrays.length;++i){
            int tmp = arrays[i];
            max = Math.max(max,tmp);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arrays = {10,5,8,6,7,5};
        int res = new FindMaxElementOfAnArray().getMaxElement(arrays);
        System.out.println(res);
    }
}
