package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @Author: Twiss
 * @Date: 2021/4/30 8:34 下午
 */
public class WiggleSort {

    public static int[] getWiggleSort(int[] number) {
        int[] tmp = number.clone();
        int n = number.length;
        Arrays.sort(tmp);
        for (int i = 1; i < number.length; i+=2) {
            number[i] = tmp[--n];
        }
        for (int i = 0; i < number.length; i+=2) {
            number[i] = tmp[--n];
        }
        return number;
    }

    public static int[] getWiggleSortByThreeWayPartition(int[] nums) {
        int len = nums.length;
        int mid = getMid(nums, 0, len - 1, len / 2);
        int i = 0;
        int j = 0;
        int n = len - 1;
        while(j <= n) {
            int index = index(j, len);
            if(nums[index] > mid) {
                swap(nums, index(j++, len), index(i++, len));
            } else if (nums[index] < mid) {
                swap(nums, index, index(n--, len));
            } else {
                j++;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    private static int index(int i, int len) {
        return (2*i + 1) % (len | 1);
    }

    private static int getMid(int[] nums, int l, int r, int rank) {
        int now = nums[l];
        int left = l;
        int right = r;
        while(left < right) {
            while(left < right && nums[right] >= now) {
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] <= now) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = now;
        if(left - l == rank) {
            return now;
        } else if (left - l < rank) {
            return getMid(nums, left + 1, r, rank - left + l - 1);
        } else {
            return getMid(nums, l, right - 1, rank);
        }
    }

    public static void main(String[] args) {
        int[] number = {3, 5, 2, 1, 6, 4};
        int[] res = getWiggleSort(number);
        System.out.println(JSONObject.toJSONString(res));
        int[] number2 = {3, 5, 2, 1, 6, 4};
        int[] res2 = getWiggleSortByThreeWayPartition(number2);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
