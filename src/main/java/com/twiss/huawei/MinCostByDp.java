package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 最小花费cost
 * @Author: Twiss
 * @Date: 2022/7/27 5:24 下午
 */
public class MinCostByDp {

    /**
     * https://www.codeleading.com/article/5751381134/
     * 将数组分成n个数组，每个数组的和尽量接近
     * @param input
     * @param k
     * @return
     */
    private static List<List<Integer>> fairDivision(int[] input, int k) {
        List<List<Integer>> resultList = new ArrayList<>(k);
        if (k > input.length || k < 0) {
            return resultList;
        } else if (k == input.length) {
            for (int c : input) {
                List<Integer> t = new ArrayList<>();
                t.add(c);
                resultList.add(t);
            }
            return resultList;
        }

        for (int i = 0; i < k; i++) {
            resultList.add(new ArrayList<>());
        }

        int[] sortedInput = input.clone();
        int inputLen = sortedInput.length;
        // 正序排列
        Arrays.sort(sortedInput);

        // 从最大的开始填充到结果中
        for (int i = 0; i < k; i++) {
            resultList.get(i).add(sortedInput[inputLen - 1 - i]);
        }
        // 从大到小遍历剩下的数字
        for (int i = inputLen - 1 - k; i >= 0; i--) {
            ArrayList<Integer> tempSum = new ArrayList<>(k);
            for (List<Integer> l : resultList) {
                tempSum.add(getSum(l) + sortedInput[i]);
            }
            int minIndex = findMinIndex(tempSum); // 找出结果最小的那个分组
            resultList.get(minIndex).add(sortedInput[i]); // 将当前数加入那个分组
        }

        return resultList;
    }

    /**
     * @return The index of the min member
     */
    private static int findMinIndex(ArrayList<Integer> list) {
        int res = 0;
        int t = Integer.MAX_VALUE;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index) < t) {
                t = list.get(index);
                res = index;
            }
        }
        return res;
    }

    private static void testAndPrint(int[] input, int k) {
        StringBuilder listArr = new StringBuilder();
        List<List<Integer>> result = fairDivision(input, k);
        int preSum = 0;
        int cost = 2;
        for (int i=0;i<result.size();i++) {
            List<Integer> tmp = result.get(i);
            listArr.append("(");
            int tmpSum=0;
            for (int j=0;j<tmp.size();j++){
                int ele = tmp.get(j);
                tmpSum+=ele;
                listArr.append(ele);
                if (j!=tmp.size()-1){
                    listArr.append(",");
                }
            }

            if (i!=0){
                if (preSum==tmpSum){
                    cost+=2;
                }else {
                    cost+=3;
                }
            }
            preSum = tmpSum;
            listArr.append(")");
            if (i!=result.size()-1){
                listArr.append(",");
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(cost).append(",").append(listArr);
        System.out.println(new String(ans));
    }


    /**
     * @return Sum of list members
     */
    private static int getSum(List<Integer> list) {
        int res = 0;
        for (int i : list) {
            res += i;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int group = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(JSONObject.toJSONString(arr));
        testAndPrint(arr, group);

    }
}
