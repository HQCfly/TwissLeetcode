package com.twiss.binaryindextree;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/7/9 7:59 下午
 */
public class RangeSumQuery2DByBIT {

    int[] tree;
    int[] nums;
    int n;

    int lowBit(int x) {
        return x&(-x);
    }

    int query(int x){
        int ans = 0;
        for (int i=x;i>0;i-=lowBit(i)){
            ans+=tree[i];
        }
        return ans;
    }

    void add(int x,int u){
        for (int i =x;i<=n;i+=lowBit(i)){
            tree[i]+=u;
        }
    }

    public RangeSumQuery2DByBIT(int[] numbers){
        this.nums = numbers;
        n = numbers.length;
        tree = new int[n+1];
        for (int i =0;i<n;i++){
            add(i+1,nums[i]);
        }
    }

    public void update(int i, int val){
        add(i+1,val-nums[i]);
        nums[i] = val;
    }

    public int sumRange(int left,int right){
        return query(right+1)-query(left);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9,11};
        RangeSumQuery2DByBIT rangeSumArr = new RangeSumQuery2DByBIT(nums);
        System.out.println("originTreeNode: "+ JSONObject.toJSONString(nums));
        int resultSum =rangeSumArr.sumRange(0,2);
        System.out.println(resultSum);
        rangeSumArr.update(1,2);
        System.out.println("updateTreeNode: "+ JSONObject.toJSONString(nums));
    }

}
