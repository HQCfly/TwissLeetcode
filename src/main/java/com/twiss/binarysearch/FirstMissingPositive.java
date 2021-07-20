package com.twiss.binarysearch;


/**
 * @Author: Twiss
 * @Date: 2021/7/20 1:44 下午
 */
public class FirstMissingPositive {

    private int getMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num < n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i]>0){
                return i+1;
            }
        }
        return n+1;
    }

    private int getMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i =0;i<n;i++){
            // 将nums[i] 换到属于本身自己的位置上
            while (nums[i]>0&&nums[i]<=n&&nums[i]!=nums[nums[i]-1]){
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i=0;i<n;i++){
            if (nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int res = new FirstMissingPositive().getMissingPositive(nums);
        System.out.println(res);
        int[] nums2 = {3, 4, -1, 1};
        int res2 = new FirstMissingPositive().getMissingPositive2(nums2);
        System.out.println(res2);
    }
}
