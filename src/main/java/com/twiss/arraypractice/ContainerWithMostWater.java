package com.twiss.arraypractice;

public class ContainerWithMostWater {
    public static int maxArea(int[] array){
        int res = -1;
        int i = 0, j = array.length-1;
        while (i<j){
            res = Math.max(res,(j-i) * Math.min(array[i],array[j]));
            if (array[i]<array[j]){
                i++;
            }else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1,8,6,2,5,4,8,3,7};
        int res = maxArea(array);
        System.out.println(res);
    }
}
