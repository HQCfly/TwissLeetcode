package com.twiss.binarysearch;

/**
 * 寻找旋转数组最小值
 * @Author: Twiss
 * @Date: 2021/7/16 4:09 下午
 */
public class FindMinimumSortedInRotatedArray {
    // 可重复旋转数组
    private int getMinimumNumber(int[] numbers) {
        int low = 0;
        int high = numbers.length-1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // 如果中间值大于high则表示，右半侧是小值排序。则需要从右边找
            if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        int[] numbers = {3,4,5,1,2};
        int res = new FindMinimumSortedInRotatedArray().getMinimumNumber(numbers);
        System.out.println(res);
    }
}
