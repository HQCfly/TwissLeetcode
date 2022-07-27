package com.twiss.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 最小花费cost
 * @Author: Twiss
 * @Date: 2022/7/27 5:24 下午
 */
public class MinCostByDp {

    /**
     * 将数组分成n个数组，每个数组的和尽量接近
     * @param numberList
     * @param arrNum
     * @return
     */
    public List<Integer> getAverageArr(List<Integer> numberList, int arrNum){
        List<Integer> avgArrays = new ArrayList<>();
        if (numberList.size()==0||numberList.size()<arrNum){
            return avgArrays;
        }
        // 1、计算平均值
        float sumValue = 0;
        List<Float> numberListFloat = new ArrayList<>();
        for (int num:numberList){
            numberListFloat.add((float)num);
            sumValue+=(float) num;
        }
        float meanValue = sumValue/(float)arrNum;
        // 2、倒叙排列
        numberListFloat.sort((o1, o2) -> {o2-o1});
        //按提交时间降序 --Lamdba表达式
        Collections.sort(numberListFloat, (a, b) -> b.compareTo(a));

        for (int i=0;i<arrNum;i++){
            List<Float> arr = new ArrayList<>();
            if (i==arrNum-1){
                // 最后徐一组，返回数组剩余所有数
                avgArrays.add(transFloatToIntList(numberListFloat));
                break;
            }

            // 如果最大的数,ax>=mean，这个数单独一个组
            if (numberListFloat.size()>0&&numberListFloat.get(0)>=meanValue){
                arr.add(numberListFloat.get(0));
                avgArrays.add(transFloatToIntList(arr));
                sumValue = sumValue-numberListFloat.get(0);

                // 重新计算剩下partition的平均值
                meanValue = sumValue/ (float) (arrNum-avgArrays.size());
            }else {
                // 否则寻找一组数组
                arr= getList(numberListFloat, meanValue, Math.pow(meanValue, 2));
                avgArrays.add(transFloatToIntList(arr));
            }
            for (int j=0;j<arr.size();j++){
                numberListFloat.remove(arr.get(j));
            }

        }
        return avgArrays;
    }

    private 

    public static void main(String[] args) {

    }
}
