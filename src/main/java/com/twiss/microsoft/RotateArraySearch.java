package com.twiss.microsoft;

/**
 * 旋转数组中寻找target
 *
 * @Author: Twiss
 * @Date: 2022/2/3 3:14 下午
 */
public class RotateArraySearch {

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                // 证明左半部分是升序排列，此时使用二分查找
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 证明右半部分是升序
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int res = new RotateArraySearch().search(nums,target);
        System.out.println(res);

        int[] nums2 = {4,5,6,7,0,1,2};
        int target2 = 3;
        int res2 = new RotateArraySearch().search(nums2,target2);
        System.out.println(res2);
    }
}