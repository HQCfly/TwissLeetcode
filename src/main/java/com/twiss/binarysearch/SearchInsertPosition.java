package com.twiss.binarysearch;

/**
 *
 * @Author: Twiss
 * @Date: 2021/8/7 1:17 下午
 */
public class SearchInsertPosition {

    public int getIndexForTarget(int[] arrays,int target){
        int n = arrays.length;
        int left = 0, right = n-1, ans = n;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (target<=arrays[mid]){
                ans = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arrays = {1,3,5,6};
        int target = 5;
        int targetIndex = new SearchInsertPosition().getIndexForTarget(arrays,target);
        System.out.println(targetIndex);
    }

}
