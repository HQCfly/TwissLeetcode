package com.twiss.binarysearchtree;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: Twiss
 * @Date: 2021/8/11 10:43 上午
 */
public class CountOfRangeSum {

    private int countRangeSum(int[] num,int lower,int upper){
        long sum = 0;
        int n = num.length;
        long[] preSum = new long[n+1];
        // 前缀和数组，表示0到i的前缀和
        for (int i=0;i<n;i++){
            sum+=num[i];
            preSum[i+1]=sum;
        }
        System.out.println("preSum:"+JSONObject.toJSONString(preSum));
        // 将前缀和以及[preSum[j]-upper,preSum[j]-lower]顺序化
        Set<Long> allNums = new TreeSet<Long>();
        for (long x:preSum){
            allNums.add(x);
            allNums.add(x-lower);
            allNums.add(x-upper);
        }
        System.out.println("allNum:"+ JSONObject.toJSONString(allNums));
        // 哈希表离散化
        Map<Long,Integer> values = new HashMap<>();
        int idx = 0;
        for (long x:allNums){
            values.put(x,idx);
            idx++;
        }
        System.out.println("values:"+ JSONObject.toJSONString(values));
        int ret = 0;
        BIT bit = new BIT(values.size());
        for (int i=0;i<preSum.length;i++){
            // L:分别查询[0,preSum[j]-upper-1]区间的整数数量
            // R:分别查询[0,preSum[j]-lower]区间的整数数量
            // R-L
            int left = values.get(preSum[i]-upper), right = values.get(preSum[i]-lower);
            ret+=bit.query(right+1)- bit.query(left);
            // 构建下一个位置的树状数组
            bit.add(values.get(preSum[i])+1,1);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] num= {-2,5,-1};
        int lower = -2, upper=2;
        int res = new CountOfRangeSum().countRangeSum(num,lower,upper);
        System.out.println(res);
    }

}
class BIT{
    int[] tree;
    int n;

    public BIT(int n){
        this.n = n;
        this.tree = new int[n+1];
    }

    private int lowbit(int x){
        return x&-x;
    }

    // 查询前缀和的方法
    public int query(int x){
        int ans = 0;
        for (int i=x;i>0;i-=lowbit(i)){
            ans+=tree[i];
        }
        return ans;
    }

    // 在树状数组x位置添加值u
    public void add(int x,int u){
        for (int i = x;i<=n;i+=lowbit(i)){
            tree[i] += u;
        }
    }

}
