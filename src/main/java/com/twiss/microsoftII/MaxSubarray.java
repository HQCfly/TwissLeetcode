package com.twiss.microsoftII;

/**
 * 最大子序和
 *
 * @Author: Twiss
 * @Date: 2022/2/20 1:13 下午
 */
public class MaxSubarray {

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public int getSumByDp(int[] nums){
        int pre = 0, sum = Integer.MIN_VALUE;
        for (int num:nums){
            pre = Math.max(pre+num,num);
            sum = Math.max(sum,pre);
        }
        return sum;
    }

    public int getSumByDivide(int[] nums){
        if (nums==null){
            return 0;
        }
        return maxSumSubarray(nums,0,nums.length-1);
    }

    private int maxSumSubarray(int[] nums, int left,int right){
        if (left==right){
            return nums[left];
        }
        int mid = left+(right-left)/2;
        return maxThree(
                maxSumSubarray(nums,left,mid),
                maxSumSubarray(nums,mid+1,right),
                maxCrossingSum(nums,mid,left,right)
        );
    }

    private int maxCrossingSum(int[] nums,int mid,int left,int right){
        int sum = 0;
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        for (int i=mid;i>=left;i--){
            sum += nums[i];
            if (sum>leftSum){
                leftSum = sum;
            }
        }
        sum = 0;
        for (int i=mid+1;i<=right;++i){
            sum += nums[i];
            if (sum>rightSum){
                rightSum = sum;
            }
        }
        return leftSum+rightSum;
    }

    private int maxThree(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = new MaxSubarray().getSumByDivide(nums);
        System.out.println(ans);

        int[] nums2 = {-2,1,-3,4,-1,2,1,-5,4};
        int ans2 = new MaxSubarray().getSumByDp(nums2);
        System.out.println(ans2);
    }
}
