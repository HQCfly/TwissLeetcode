package com.twiss.zijie;

/**
 * 搜索旋转排序数组
 * 使用二分法做
 * 时间复杂度O(nlogn)
 * 空间复杂度O(1)
 *
 * @Author: Twiss
 * @Date: 2022/4/5 9:10 下午
 */
public class SearchRotateArrays {

    public int searchNum(int[] arrays, int target) {
        if (arrays == null || arrays.length == 0) {
            return -1;
        }
        if (arrays.length == 1) {
            return arrays[0] == target ? 0 : -1;
        }
        int left = 0, right = arrays.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arrays[mid] == target) {
                return mid;
            }
            if (arrays[left] <= arrays[mid]) {
                if (arrays[left] <= target && target < arrays[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arrays[mid] < target && target <= arrays[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrays = {4,5,6,7,0,1,2};
        int target = 0;
        int ans = new SearchRotateArrays().searchNum(arrays,target);
        System.out.println(ans);
    }
}
