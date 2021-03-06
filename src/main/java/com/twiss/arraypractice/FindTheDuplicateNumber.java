package com.twiss.arraypractice;

public class FindTheDuplicateNumber {

    public static int findDuplicateNumber(int[] arrays){

        int i = 0, j = arrays.length;
        while (i<j){
            int count = 0;
            int mid = i + (j-i)/2;
            for (int number:arrays){
                if (number<=mid){
                    count++;
                }
            }
            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (count>mid){
                // 重复元素位于区间 [left, mid]
                j = mid;
            }else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面
                // [mid + 1, right]
                i = mid + 1;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] arrays = {2, 4, 5, 2, 3, 1, 6, 7};
        int res = findDuplicateNumber(arrays);
        System.out.println(res);
    }
}
