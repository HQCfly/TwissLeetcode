package com.twiss.TianyiCloud;

import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/6/29 10:58 上午
 */
public class ArraySorted {

    public static void getSortedArray(int[] nums){
        if (nums==null||nums.length==0){
            return;
        }
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0, right = n-1;
        for (int i=0;i<n;i++){
            if ((nums[i]&1)==0){
                ans[left++] = nums[i];
            } else if ((nums[i]&1)==1) {
                ans[right--] = nums[i];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<left;i++){
            stringBuilder.append(ans[i]).append(",");
        }
        for (int i=n-1;i>right;i--){
            stringBuilder.append(ans[i]);
            if (i>right+1){
                stringBuilder.append(",");
            }
        }
        System.out.println(new String(stringBuilder));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            sc.nextLine();
            String[] nu = sc.nextLine().split(",");
            for (int i=0;i<n;i++){
                nums[i] = Integer.parseInt(nu[i]);
            }
            getSortedArray(nums);
        }
    }
}
