package com.twiss.arraypractice;

/**
 * @Author: Twiss
 * @Date: 2021/4/11 7:11 下午
 */
public class SearchInsertPosition {

    public static int getInsertPosition(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int n = numbers.length - 1;
        int right = n;
        int left = 0;
        int ans = 0;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 6};
        int target = 5;
        int res = getInsertPosition(numbers, target);
        System.out.println(res);
    }
}
