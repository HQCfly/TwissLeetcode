package com.twiss.xiaohuang.cp1;

/**
 * @Author: Twiss
 * @Date: 2021/9/1 10:36 上午
 */
public class FindMaxElementOfAnArray {

    /**
     *
     * @param arrays
     * @return element
     */
    public int getMaxElement(int[] arrays){
        int max = arrays[0];
        for (int i=1;i<arrays.length;++i){
            int tmp = arrays[i];
            max = Math.max(max,tmp);
        }
        return max;
    }

    /**
     *
     * @param arrays
     * @return position
     */
    public int getMaxPosition(int[] arrays){
        int position = 0;
        for (int i=1;i<arrays.length;++i){
            if (arrays[i]>arrays[position]){
                position = i;
            }
        }
        return position;
    }

    public static void main(String[] args) {
        int[] arrays = {10,5,8,6,7,5};
        int res = new FindMaxElementOfAnArray().getMaxElement(arrays);
        System.out.println(res);

        int res2 = new FindMaxElementOfAnArray().getMaxPosition(arrays);
        System.out.println(res2);
    }
}
