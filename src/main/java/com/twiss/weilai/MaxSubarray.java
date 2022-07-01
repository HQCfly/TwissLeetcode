package com.twiss.weilai;

import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/7/1 7:29 下午
 */
public class MaxSubarray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            String[] arr = sc.nextLine().split(" ");
            int[] nums = new int[n];
            int pre = 0, maxAns = 0;
            int idx = 0;
            for (int i=0;i<n;i++){
                nums[i] = Integer.parseInt(arr[i]);
                if (pre+nums[i]>nums[i]){
                    pre = pre+nums[i];
                    idx++;
                }else {
                    pre = nums[i];
                }
                if (pre>maxAns){
                    maxAns = pre;
                }

            }
            int ans = maxAns/idx;
            System.out.println(ans);
        }

    }
}
