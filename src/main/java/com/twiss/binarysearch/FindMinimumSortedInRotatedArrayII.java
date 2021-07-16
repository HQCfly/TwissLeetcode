package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/7/16 4:09 下午
 */
public class FindMinimumSortedInRotatedArrayII {
    // 可重复旋转数组
    private int getMinimumNumber(int[] numbers) {
        int low = 0;
        int high = numbers.length-1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // 如果中间值大于high则表示，右半侧是小值排序。则需要从右边找
            if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else if (numbers[mid] < numbers[high]) {
                high = mid;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        int[] numbers = {1,3,5};
        int res = new FindMinimumSortedInRotatedArrayII().getMinimumNumber(numbers);
        System.out.println(res);
    }
}
