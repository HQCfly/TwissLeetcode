package com.twiss.greed;

/**
 * 加油站
 * 时间复杂度O(N)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/5/3 10:39 下午
 */
public class CompleteCircuit {

    /**
     * 1、如果sum为<0, return -1
     *
     * @param gas
     * @param cost
     * @return
     */
    public int  getIndex(int[] gas,int[] cost){
        int minSum = 0, sum=0;
        for (int i=0;i<gas.length;++i){
            sum += (gas[i]-cost[i]);
            minSum = Math.min(minSum,sum);
        }

        if (sum<0){
            return -1;
        }
        if (minSum>=0){
            return 0;
        }
        for (int i=gas.length-1;i>=0;i--){
            minSum+=(gas[i]-cost[i]);
            if (minSum>=0){
                return i;
            }
        }
        return -1;
    }

    public int getIndexByGreed(int[] gas,int[] cost){
        int currSum = 0, sum = 0;
        int index = 0;
        for (int i=0;i<gas.length;i++){
            currSum+=(gas[i]-cost[i]);
            sum+=(gas[i]-cost[i]);
            if (currSum<0){
                index = (i+1)%gas.length;
                currSum = 0;
            }
        }
        if (sum<0){
            return -1;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int index = new CompleteCircuit().getIndex(gas,cost);
        System.out.println(index);

        int index2 = new CompleteCircuit().getIndexByGreed(gas,cost);
        System.out.println(index2);
    }
}
