package com.twiss.binarysearch;

public class SearchInRotatedSortedArrayII {

    private boolean solved(int[] candidates, int target) {
        int right = candidates.length - 1;
        int left = 0;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (candidates[mid] == target) {
                return true;
            }

            // 针对 a[l]=a[mid]==a[r]情况  [3,1,2,3,3,3,3]
            if (candidates[left] == candidates[mid] && candidates[mid] == candidates[right]) {
                left++;
                right--;
            }

            // 左边是顺序
            if (candidates[left] <= candidates[mid]) {
                if (candidates[left] <= target && target < candidates[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (candidates[mid] < target && target <= candidates[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        boolean res = new SearchInRotatedSortedArrayII().solved(numbers, target);
        System.out.println("res: " + res);
    }
}
