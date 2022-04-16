package com.twiss.zijie;

/**
 * 寻找第一个缺失正整数
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * @Author: Twiss
 * @Date: 2022/4/16 4:06 下午
 */
public class FindFirstMissPositive {

    public int getNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        // 先将负数边成n+1
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] <= 0) {
                arr[i] = n + 1;
            }
        }
        // 将小于n的数与num下标替换位置
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(arr[i]);
            if (num <= n) {
                arr[num - 1] = -Math.abs(arr[num - 1]);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public int getNumByReplace(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        for (int i = 0; i < n;++i){
            while (arr[i]>0&&arr[i]<=n&&arr[arr[i]-1]!=arr[i]){
                swap(arr,arr[i]-1,i);
            }
        }

        for (int i=0;i<n;++i){
            if (arr[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }

    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0};
        int ans = new FindFirstMissPositive().getNum(arr);
        System.out.println(ans);
        int[] arr2 = {3,4,-1,1};
        int ans2 = new FindFirstMissPositive().getNum(arr2);
        System.out.println(ans2);
    }
}
