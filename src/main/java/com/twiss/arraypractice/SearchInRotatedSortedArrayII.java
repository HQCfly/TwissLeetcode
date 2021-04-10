package com.twiss.arraypractice;

/**
 * @Author: Twiss
 * @Date: 2021/4/10 8:54 下午
 */
public class SearchInRotatedSortedArrayII {

    public static boolean getTargetIndex(int[] numbers, int target) {
        int right = numbers.length - 1;
        int left = 0;
        int mid = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (numbers[mid] == target) {
                return true;
            }

            if (numbers[mid] == numbers[left] && numbers[mid] == numbers[right]) {
                left ++;
                right --;
            } else if (numbers[mid] > numbers[right]) {
                if (numbers[left] <= target && target < numbers[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= numbers[right] && numbers[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        boolean res = getTargetIndex(numbers, target);
        System.out.println(res);
    }
}
