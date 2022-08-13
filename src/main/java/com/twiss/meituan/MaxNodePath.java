package com.twiss.meituan;

/**
 * 生活在树上（最大节点路径）
 * @Author: Twiss
 * @Date: 2022/8/13 9:11 下午
 */
public class MaxNodePath {

    private int n,ans;

    public int getMax(int[] nums){
        int sum =0;
        ans=Integer.MIN_VALUE;
        n = nums.length;
        dfs(nums,1,sum);
        return ans;
    }

    private void dfs(int[] nums,int k,int sum){
        if (k>n||k+1>n){
            return;
        }
        sum += nums[k];
        // 左节点
        dfs(nums,2*k,sum);
        ans = Math.max(ans,sum);
        dfs(nums,2*k+1,sum);
        sum -= nums[k];
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7};
        int ans = new MaxNodePath().getMax(nums);
        System.out.println(ans);
    }
}
