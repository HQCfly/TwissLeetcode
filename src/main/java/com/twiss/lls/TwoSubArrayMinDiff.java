package com.twiss.lls;

/**
 * 两堆数组和相差最小
 * 开一个数组：int[][]f=new int[length+1][sum/2+1]
 *
 * 状态方程：f[i][j]=Max(f[i-1][j-array[i]]+array[i],f[i-1][j])
 *
 * 解释：f[i][j]表示array中i个元素的和<=j，且是最接近j的元素集合。f[i-1][j-array[i]]表示array中i-1个元素的和最接近j-array[i]，所以f[i][j]应该是[i-1][j-array[i]]+array[i]和f[i-1][j]中最大的那个。
 *
 * @Author: Twiss
 * @Date: 2022/3/14 9:23 下午
 */
public class TwoSubArrayMinDiff {

    public int getDiff(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }

        int temp[][]=new int[arr.length+1][sum/2+1];//注意开辟数组的行数列数要多1,是从第1行第1列开始保存数据
        for(int i=0;i<arr.length;i++)
            for(int capacity=1;capacity<=sum/2;capacity++)
            {
                temp[i+1][capacity]=temp[i][capacity];
                if(arr[i]<=capacity && temp[i][capacity-arr[i]] +arr[i]>temp[i][capacity]){
                    temp[i+1][capacity]=temp[i][capacity-arr[i]]+arr[i];//可以放，且值比之前要大，则更新
                }
            }
        return Math.max(temp[arr.length][sum/2], sum-temp[arr.length][sum/2]);

    }

    public static void main(String[] args) {

    }
}
