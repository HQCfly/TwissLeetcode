package com.twiss.binarysearch;

public class SearchInRotatedSortedArrayII {

    private static int solved(int[] candidates, int target) {
        int right = candidates.length - 1;
        int left = 0;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (candidates[mid] == target) {
                return mid;
            }
            if (candidates[mid] > candidates[right]) {
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
        return -1;
    }

    private static int solved2(int[] candidates, int target) {
        int n = candidates.length - 1;
        return search(candidates, 0, n, target);
    }

    private static int search(int[] candidates, int lo, int hi, int target) {
        if (lo > hi) {
            return -1;
        }
        int m = lo + (hi - lo) / 2;
        if (candidates[m] == target) {
            return m;
        }
        if (candidates[lo] <= candidates[m]) {
            if (candidates[lo] <= target && target < candidates[m]) {
                return search(candidates, lo, m - 1, target);
            } else {
                return search(candidates, m + 1, hi, target);
            }
        } else {
            if (candidates[m] < target && target < candidates[hi]) {
                return search(candidates, m + 1, hi, target);
            } else {
                return search(candidates, lo, m - 1, target);
            }
        }

    }

    public static void main(String[] args) {
        int[] numbers = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        int res = solved(numbers, target);
        System.out.println("res: "+res);
        int res2 = solved2(numbers, target);
        System.out.println("res2: "+res2);
    }
}
